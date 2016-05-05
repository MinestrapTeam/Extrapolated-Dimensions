package minestrapteam.extracore.item;

import minestrapteam.extracore.util.Constants;
import minestrapteam.extracore.util.ReflectionUtils;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCustomArmor extends ItemArmor
{
	private String armorDomain;
	private String armorTexture;

	public ItemCustomArmor(ArmorMaterial material, String armorDomain, String armorTexture, int armorType)
	{
		super(material, 1, armorType & 3);
		this.armorDomain = armorDomain;
		this.armorTexture = armorTexture;

		ReflectionUtils.setField(Constants.FIELD_ItemArmor_armorType, this, armorType);
		ReflectionUtils
			.setField(Constants.FIELD_ItemArmor_damageReduction, this, this.getDamageReductionAmount(material));
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
	}

	public int getDamageReductionAmount(ArmorMaterial material)
	{
		return material.getDamageReductionAmount(this.armorType & 3);
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == this.armorType;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (type != null)
		{
			return this.armorDomain + ":textures/models/armor/" + this.armorTexture + type + ".png";
		}
		return this.armorDomain + ":textures/models/armor/" + this.armorTexture + "_layer_" + (slot == 2 ? 1 : 2)  + ".png";
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (this.armorType < 4)
		{
			return super.onItemRightClick(stack, world, player);
		}
		return stack;
	}
}
