package minestrapteam.extradims.item.armor;

import minestrapteam.extracore.item.ItemCustomArmor;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemGem extends ItemCustomArmor
{
	public ItemGem(ArmorMaterial material)
	{
		super(material, 0, ArmorTypes.CRYSTAL);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}
}
