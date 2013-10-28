package clashsoft.mods.moredimensions.item.armor;

import clashsoft.mods.moredimensions.client.model.ModelGloves;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
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
	
	public ModelBiped		modelGloves;
	public ModelRenderer	bipedRightGlove;
	public ModelRenderer	bipedLeftGlove;
	
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
		if (armorSlot == ArmorTypes.GLOVE)
		{
			if (modelGloves == null)
				modelGloves = new ModelGloves();
			
			return modelGloves;
		}
		return null;
	}
}
