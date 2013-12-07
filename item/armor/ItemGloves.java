package clashsoft.mods.moredimensions.item.armor;

import clashsoft.cslib.minecraft.item.ItemCustomArmor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemGloves extends ItemCustomArmor
{
	public static Icon		slotIcon;
	
	public ItemGloves(int itemID, EnumArmorMaterial material, int renderIndex)
	{
		super(itemID, material, renderIndex, ArmorTypes.GLOVE);
	}
	
	@Override
	public int getDamageReductionAmount(EnumArmorMaterial material)
	{
		return material.getDamageReductionAmount(ArmorTypes.BOOTS);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		super.registerIcons(iconRegister);
		if (slotIcon == null)
			slotIcon = iconRegister.registerIcon("armorslot_gloves");
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot)
	{
		return null;
	}
}
