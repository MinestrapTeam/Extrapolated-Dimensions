package clashsoft.mods.moredimensions.curse;

import net.minecraft.item.*;

public enum EnumCurseType
{
	all, armor, armor_feet, armor_legs, armor_torso, armor_head, weapon, digger, bow;
	
	/**
	 * Return true if the item passed can be enchanted by a enchantment of this type.
	 */
	public boolean canCurseItem(Item item)
	{
		if (this == all)
		{
			return true;
		}
		else if (item instanceof ItemArmor)
		{
			if (this == armor)
			{
				return true;
			}
			else
			{
				ItemArmor itemarmor = (ItemArmor) item;
				return itemarmor.armorType == 0 ? this == armor_head : (itemarmor.armorType == 2 ? this == armor_legs : (itemarmor.armorType == 1 ? this == armor_torso : (itemarmor.armorType == 3 ? this == armor_feet : false)));
			}
		}
		else
		{
			return item instanceof ItemSword ? this == weapon : (item instanceof ItemTool ? this == digger : (item instanceof ItemBow ? this == bow : false));
		}
	}
}
