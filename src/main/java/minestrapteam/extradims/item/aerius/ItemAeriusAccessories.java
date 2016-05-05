package minestrapteam.extradims.item.aerius;

import minestrapteam.extradims.item.ArmorTypes;
import minestrapteam.extradims.lib.Aerius;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemAeriusAccessories extends Item
{
	public static final String[] ACCESSORY_NAMES = { "iron_bracelet", null, null, "gold_bracelet", "gold_ring",
		"gold_necklace", null, "diamond_ring", "diamond_necklace", null, "fire_ring", null };

	private static final String[] ICON_NAMES = { "armor/iron/iron_bracelet", null, null, "armor/gold/gold_bracelet",
		"armor/gold/gold_ring", "armor/gold/gold_necklace", null, "armor/diamond/diamond_ring",
		"armor/diamond/diamond_necklace", null, "loot/fire_ring", null };

	protected final IIcon[] icons = new IIcon[ACCESSORY_NAMES.length];

	public ItemAeriusAccessories()
	{
		this.setHasSubtypes(true);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		for (int i = 0; i < ICON_NAMES.length; i++)
		{
			final String iconName = ICON_NAMES[i];
			if (iconName != null)
			{
				this.icons[i] = iconRegister.registerIcon(Aerius.TEXTURE_PREFIX + iconName);
			}
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage)
	{
		return this.icons[damage];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item.aerius_accessories." + ACCESSORY_NAMES[stack.getItemDamage()];
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		switch (stack.getItemDamage() % 3)
		{
		case 0:
			return armorType == ArmorTypes.BRACELET;
		case 1:
			return armorType == ArmorTypes.RING;
		case 2:
			return armorType == ArmorTypes.NECKLACE;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < ACCESSORY_NAMES.length; i++)
		{
			if (ACCESSORY_NAMES[i] != null)
			{
				list.add(new ItemStack(this, 1, i));
			}
		}
	}
}
