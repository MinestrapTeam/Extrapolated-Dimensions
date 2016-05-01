package minestrapteam.extradims.item.armor;

import minestrapteam.extracore.item.ItemCustomArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemGloves extends ItemCustomArmor
{
	public ItemGloves(ArmorMaterial material, int renderIndex)
	{
		super(material, renderIndex, ArmorTypes.GLOVES);
	}
	
	@Override
	public int getDamageReductionAmount(ArmorMaterial material)
	{
		return material.getDamageReductionAmount(ArmorTypes.BOOTS);
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot)
	{
		return null;
	}
}
