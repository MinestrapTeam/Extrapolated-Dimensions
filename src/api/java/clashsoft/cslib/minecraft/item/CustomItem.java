package clashsoft.cslib.minecraft.item;

import clashsoft.cslib.minecraft.client.icon.IIconSupplier;
import clashsoft.cslib.minecraft.client.icon.IconSupplier;
import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.util.CSString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.Arrays;
import java.util.List;

/**
 * The Class CustomItem.
 */
public class CustomItem extends Item
{
	public static final String FORCEHIDE = "%&";

	public String[]      names;
	public IIconSupplier iconSupplier;

	public CreativeTabs[] tabs;

	public boolean[] enabled;

	/**
	 * Instantiates a new custom item.
	 *
	 * @param names
	 * 	the names
	 * @param icons
	 * 	the icon names
	 * @param tabs
	 * 	the creative tabs
	 */
	public CustomItem(String[] names, Object icons, CreativeTabs[] tabs)
	{
		this.names = names;
		this.iconSupplier = IconSupplier.create(icons);
		this.tabs = tabs;
		this.enabled = new boolean[this.names.length];
		Arrays.fill(this.enabled, true);

		this.setHasSubtypes(names.length > 1);
	}

	public CustomItem(String name, String iconName)
	{
		this(new String[] { name }, iconName, null);
	}

	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		if (this.tabs == null)
		{
			this.tabs = new CreativeTabs[] { this.getCreativeTab() };
		}
		return this.tabs;
	}

	public CreativeTabs getCreativeTab(int metadata)
	{
		if (this.tabs == null)
		{
			return this.getCreativeTab();
		}
		return this.tabs[metadata % this.tabs.length];
	}

	/**
	 * Sets the <code>metadata</code> values to be shown in the creative inventory or not.
	 *
	 * @param metadata
	 * 	the metadata
	 *
	 * @return the custom item
	 */
	public CustomItem setMetadataEnabled(boolean enabled, int... metadata)
	{
		if (metadata != null)
		{
			for (int i : metadata)
			{
				this.enabled[i] = enabled;
			}
		}
		return this;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return getUnlocalizedName(this, this.names, stack);
	}

	public static String getUnlocalizedName(Item item, String[] names, ItemStack stack)
	{
		return item.getUnlocalizedName() + "." + names[stack.getItemDamage()];
	}

	@Override
	public IIcon getIconFromDamage(int damage)
	{
		return this.iconSupplier.getIcon(damage);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.iconSupplier.registerIcons(iconRegister);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		addInformation(this, stack, list);
	}

	public static void addInformation(Item item, ItemStack stack, List<String> list)
	{
		String key = item.getUnlocalizedName(stack) + ".desc";
		String desc = I18n.getString(key);
		if (desc != key && !desc.isEmpty())
		{
			list.addAll(CSString.lineList(desc));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List subItems)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			if (this.enabled[i] && (tab == null || tab == this.getCreativeTab(i)))
			{
				subItems.add(new ItemStack(this, 1, i));
			}
		}
	}
}
