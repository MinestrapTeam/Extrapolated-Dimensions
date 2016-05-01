package minestrapteam.extradims.item.armor;

import minestrapteam.extracore.item.ItemCustomArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemShield extends ItemCustomArmor
{
	public boolean		render	= true;
	
	public ItemShield(ArmorMaterial material, int renderIndex)
	{
		this(material, renderIndex, true);
	}
	
	public ItemShield(ArmorMaterial material, int renderIndex, boolean render)
	{
		super(material, renderIndex, ArmorTypes.SHIELD);
		this.render = render;
	}
	
	@Override
	public int getDamageReductionAmount(ArmorMaterial material)
	{
		return material.getDamageReductionAmount(ArmorTypes.LEGGINGS);
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
