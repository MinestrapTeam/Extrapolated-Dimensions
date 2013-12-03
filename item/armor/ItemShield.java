package clashsoft.mods.moredimensions.item.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemShield extends ItemArmor
{
	public static Icon		slotIcon;
	
	public boolean render = true;
	
	public ItemShield(int par1, EnumArmorMaterial material, int renderIndex)
	{
		this(par1, material, renderIndex, true);
	}
	
	public ItemShield(int par1, EnumArmorMaterial material, int renderIndex, boolean render)
	{
		super(par1, material, renderIndex, 0);
		this.render = render;
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		slotIcon = par1IconRegister.registerIcon("armorslot_shield");
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == ArmorTypes.SHIELD;
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		if (this.render)
			return null;
		else
			return null;
	}
}
