package minestrapteam.extradims.item.armor;

import clashsoft.cslib.minecraft.item.ItemCustomArmor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGloves extends ItemCustomArmor
{
	public static IIcon	slotIcon;
	
	public ItemGloves(ArmorMaterial material, int renderIndex)
	{
		super(material, renderIndex, ArmorTypes.GLOVE);
	}
	
	@Override
	public int getDamageReductionAmount(ArmorMaterial material)
	{
		return material.getDamageReductionAmount(ArmorTypes.BOOTS);
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		super.registerIcons(iconRegister);
		if (slotIcon == null)
			slotIcon = iconRegister.registerIcon("mdm_main:armorslot_gloves");
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot)
	{
		return null;
	}
}
