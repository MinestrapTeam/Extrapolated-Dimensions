package clashsoft.mods.moredimensions.item.poc;

import java.util.*;

import clashsoft.mods.moredimensions.entity.MDMEntityProperties;
import clashsoft.mods.moredimensions.magic.StaffData;
import clashsoft.mods.moredimensions.magic.StaffType;
import clashsoft.mods.moredimensions.magic.spells.Spell;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemStaff extends Item
{
	public Map<String, Icon>	icons	= new HashMap<String, Icon>();
	
	public ItemStaff(int itemID)
	{
		super(itemID);
		this.setHasSubtypes(true);
		this.setFull3D();
		this.setMaxStackSize(1);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		for (StaffType st : StaffType.staffTypes)
		{
			if (st != null)
			{
				if (st.isChargeable())
				{
					for (int i = 0; i < st.getCharges(); i++)
					{
						this.icons.put(st.getTextureName(i), iconRegister.registerIcon(st.getTextureName(i)));
					}
				}
				else
				{
					this.icons.put(st.getTextureName(0), iconRegister.registerIcon(st.getTextureName(0)));
				}
			}
		}
	}
	
	@Override
	public Icon getIconIndex(ItemStack stack)
	{
		StaffType st = StaffData.getStaffData(stack).getStaffType();
		if (st != null)
			return this.icons.get(st.getTextureName(0));
		return this.itemIcon;
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
						return this.icons.get(st.getTextureName(st.getCharges() - i));
					}
				}
				if (k > st.getCharges() * 10)
					return this.icons.get(st.getTextureName(st.getCharges() - 1));
				else if (k < st.getCharges())
					return this.icons.get(st.getTextureName(0));
			}
			return this.getIconIndex(usingItem);
		}
		else
			return this.getIconIndex(stack);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return StaffData.getStaffData(stack).isRare();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return this.useStaff(stack, player, null);
	}
	
	public ItemStack useStaff(ItemStack stack, EntityPlayer player, MovingObjectPosition object)
	{
		StaffData sd = StaffData.getStaffData(stack);
		MDMEntityProperties props = MDMEntityProperties.getEntityProperties(player);
		
		if (!sd.getStaffType().isChargeable())
		{
			for (Spell s : sd.getSpells())
				if (props.getMana() - s.getMana() >= 0F && s.onApplied(player, stack, object))
					props.addMana(-s.getMana());
		}
		else
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity)
	{
		this.useStaff(stack, player, new MovingObjectPosition(entity));
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		this.useStaff(stack, player, this.getMovingObjectPositionFromPlayer(world, player, true));
		return true;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int useDuration)
	{
		StaffData sd = StaffData.getStaffData(stack);
		MDMEntityProperties props = MDMEntityProperties.getEntityProperties(player);
		
		if (sd.getStaffType().isChargeable())
		{
			for (Spell s : sd.getSpells())
				if (props.getMana() - s.getMana() >= 0F && s.onApplied(player, stack, null))
					props.addMana(-s.getMana());
		}
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		return StaffData.getStaffData(stack).getStaffType().getMaxDamage();
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
		return this.getDamage(stack);
	}
	
	@Override
	public boolean isDamaged(ItemStack stack)
	{
		return this.getDamage(stack) > 0;
	}
	
	@Override
	public String getItemDisplayName(ItemStack stack)
	{
		StaffData sd = StaffData.getStaffData(stack);
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
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		StaffData sd = StaffData.getStaffData(stack);
		for (Spell spell : sd.getSpells())
		{
			if (spell != null)
				list.add(spell.getName());
		}
		if (sd.isRare())
		{
			list.add(EnumChatFormatting.ITALIC + "Found at: " + sd.getFoundAt());
		}
		else
		{
			list.add(EnumChatFormatting.ITALIC + "Crafted");
		}
	}
	
	@Override
	public void getSubItems(int itemID, CreativeTabs creativeTab, List list)
	{
		for (StaffType st : StaffType.staffTypes)
		{
			if (st != null)
			{
				List<Spell> spells = new ArrayList<Spell>();
				spells.add(st.getSpell());
				list.add(new StaffData(spells, st, true, 0, "Creative Tab").addDataToItemStack(new ItemStack(this, 1, 0)));
			}
		}
	}
}
