package clashsoft.mods.moredimensions.item.armor;

import clashsoft.cslib.minecraft.item.ItemCustomArmor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemShield extends ItemCustomArmor
{
	public static Icon	slotIcon;
	
	public boolean		render	= true;
	
	public ItemShield(int itemID, EnumArmorMaterial material, int renderIndex)
	{
		this(itemID, material, renderIndex, true);
	}
	
	public ItemShield(int itemID, EnumArmorMaterial material, int renderIndex, boolean render)
	{
		super(itemID, material, renderIndex, ArmorTypes.SHIELD);
		this.render = render;
	}
	
	@Override
	public int getDamageReductionAmount(EnumArmorMaterial material)
	{
		return material.getDamageReductionAmount(ArmorTypes.LEGGINGS);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		super.registerIcons(iconRegister);
		if (slotIcon == null)
			slotIcon = iconRegister.registerIcon("moredimensions:armorslot_shield");
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot)
	{
		if (this.render)
			return null;
		else
			return null;
	}
}
