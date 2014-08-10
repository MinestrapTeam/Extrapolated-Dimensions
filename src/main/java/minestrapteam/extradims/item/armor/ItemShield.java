package minestrapteam.extradims.item.armor;

import clashsoft.cslib.minecraft.item.ItemCustomArmor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemShield extends ItemCustomArmor
{
	public static IIcon	slotIcon;
	
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
	public void registerIcons(IIconRegister iconRegister)
	{
		super.registerIcons(iconRegister);
		if (slotIcon == null)
			slotIcon = iconRegister.registerIcon("mdm_main:armorslot_shield");
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
