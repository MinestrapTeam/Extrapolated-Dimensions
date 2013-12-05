package clashsoft.mods.moredimensions.item.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemGloves extends ItemArmor
{
	public static Icon		slotIcon;
	
	public ItemGloves(int par1, EnumArmorMaterial material, int renderIndex)
	{
		super(par1, material, renderIndex, 0);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		slotIcon = par1IconRegister.registerIcon("armorslot_gloves");
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == ArmorTypes.GLOVE;
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		return null;
	}
}
