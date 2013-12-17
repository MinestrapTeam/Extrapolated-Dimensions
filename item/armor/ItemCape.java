package clashsoft.mods.moredimensions.item.armor;

import java.util.List;

import clashsoft.cslib.minecraft.item.ItemCustomArmor;
import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.api.ICape;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;

public class ItemCape extends ItemCustomArmor implements ICape
{
	public static Icon		slotIcon;
	
	public static String[]	capeNames	= { "cape_pro", "cape_blue", "cape_green", "cape_red", "cape_yellow", "cape_invisibility", "cape_minecon2011", "cape_minecon2012", "cape_minecon2013" };
	
	public Icon[]			icons;
	
	public ItemCape(int itemID)
	{
		super(itemID, EnumArmorMaterial.CLOTH, 0, ArmorTypes.CAPE);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[capeNames.length];
		for (int i = 0; i < capeNames.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon("moredimensions:" + capeNames[i]);
		}
		
		if (slotIcon == null)
		{
			slotIcon = iconRegister.registerIcon("moredimensions:armorslot_cape");
		}
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int pass)
	{
		return this.icons[stack.getItemDamage()];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item." + capeNames[stack.getItemDamage() % capeNames.length];
	}
	
	@Override
	public void getSubItems(int itemID, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < capeNames.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public void updateCape(EntityPlayer player, ItemStack stack)
	{
		if (!player.worldObj.isRemote)
		{
			int metadata = stack.getItemDamage();
			
			if (metadata == 5)
			{
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2, 0));
			}
			else
			{
				MoreDimensionsMod.proxy.setCape(player, capeNames[metadata]);
			}
		}
	}
}
