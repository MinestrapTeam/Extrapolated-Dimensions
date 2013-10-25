package clashsoft.mods.moredimensions.item.poc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import clashsoft.mods.moredimensions.entity.MDMEntityProperties;
import clashsoft.mods.moredimensions.magic.StaffData;
import clashsoft.mods.moredimensions.magic.StaffType;
import clashsoft.mods.moredimensions.magic.spells.Spell;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemStaff extends Item
{
	public Map<String, Icon>	icons	= new HashMap<String, Icon>();
	
	public ItemStaff(int par1)
	{
		super(par1);
		this.setHasSubtypes(true);
		this.setFull3D();
		this.setMaxStackSize(1);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		for (StaffType st : StaffType.staffTypes)
		{
			if (st != null)
			{
				if (st.isChargeable())
				{
					for (int i = 0; i < st.getCharges(); i++)
					{
						icons.put(st.getTextureName(i), par1IconRegister.registerIcon(st.getTextureName(i)));
					}
				}
				else
				{
					icons.put(st.getTextureName(0), par1IconRegister.registerIcon(st.getTextureName(0)));
				}
			}
		}
	}
	
	@Override
	public Icon getIcon(ItemStack par1ItemStack, int pass)
	{
		StaffType st = StaffData.getStaffData(par1ItemStack).getStaffType();
		if (st != null)
			return icons.get(st.getTextureName(0));
		return itemIcon;
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (usingItem != null)
		{
			StaffType st = StaffData.getStaffData(stack).getStaffType();
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			if (st != null && st.isChargeable())
			{
				for (int i = 0; i < st.getCharges(); i++)
				{
					int var1 = (st.getCharges() - i) * 10;
					if (k >= var1 && k < st.getCharges() * 10)
					{
						return icons.get(st.getTextureName(st.getCharges() - i));
					}
				}
				if (k > st.getCharges() * 10)
					return icons.get(st.getTextureName(st.getCharges() - 1));
				else if (k < st.getCharges())
					return icons.get(st.getTextureName(0));
			}
			return this.getIcon(usingItem, renderPass);
		}
		else
			return getIcon(stack, renderPass);
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return StaffData.getStaffData(par1ItemStack).isRare();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		StaffData sd = StaffData.getStaffData(par1ItemStack);
		MDMEntityProperties props = MDMEntityProperties.getEntityProperties(par3EntityPlayer);
		
		if (!sd.getStaffType().isChargeable())
			for (Spell s : sd.getSpells())
				if (props.getMana() - s.getMana() >= 0F && s.onApplied(par3EntityPlayer, par1ItemStack, null))
					props.addMana(-s.getMana());
		else
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		StaffData sd = StaffData.getStaffData(par1ItemStack);
		MDMEntityProperties props = MDMEntityProperties.getEntityProperties(par3EntityPlayer);
		
		if (sd.getStaffType().isChargeable())
		{
			for (Spell s : sd.getSpells())
				if (props.getMana() - s.getMana() >= 0F && s.onApplied(par3EntityPlayer, par1ItemStack, null))
					props.addMana(-s.getMana());
		}
	}
	
	@Override
	public int getMaxDamage(ItemStack par1ItemStack)
	{
		return StaffData.getStaffData(par1ItemStack).getStaffType().getMaxDamage();
	}
	
	@Override
	public int getDamage(ItemStack stack)
	{
		return StaffData.getStaffData(stack).getDamage();
	}
	
	@Override
	public void setDamage(ItemStack stack, int damage)
	{
		StaffData.getStaffData(stack).setDamage(damage).addDataToItemStack(stack);
	}
	
	@Override
	public int getDisplayDamage(ItemStack stack)
	{
		return getDamage(stack);
	}
	
	@Override
	public boolean isDamaged(ItemStack stack)
	{
		return getDamage(stack) > 0;
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		StaffData sd = StaffData.getStaffData(par1ItemStack);
		if (sd != null)
		{
			if (sd.getStaffType() != null)
			{
				return (sd.isRare() ? EnumChatFormatting.DARK_AQUA : "") + sd.getStaffType().getName();
			}
		}
		return "Staff";
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		StaffData sd = StaffData.getStaffData(par1ItemStack);
		for (Spell spell : sd.getSpells())
		{
			if (spell != null)
				par3List.add(spell.getName());
		}
		if (sd.isRare())
		{
			par3List.add(EnumChatFormatting.ITALIC + "Found at: " + sd.getFoundAt());
		}
		else
		{
			par3List.add(EnumChatFormatting.ITALIC + "Crafted");
		}
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (StaffType st : StaffType.staffTypes)
		{
			if (st != null)
			{
				LinkedList<Spell> var1 = new LinkedList<Spell>();
				var1.add(st.getSpell());
				par3List.add(new StaffData(var1, st, true, 0, "Creative Tab").addDataToItemStack(new ItemStack(this, 1, 0)));
			}
		}
	}
}
