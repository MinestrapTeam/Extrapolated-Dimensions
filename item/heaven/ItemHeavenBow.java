package clashsoft.mods.moredimensions.item.heaven;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemHeavenBow extends ItemBow
{
	public ItemHeavenBow(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(MDMItems.tabHeavenTools);
	}
	
	/**
	 * Player, Render pass, and item usage sensitive version of getIconIndex.
	 * 
	 * @param stack
	 *            The item stack to get the icon for. (Usually this, and
	 *            usingItem will be the same if usingItem is not null)
	 * @param renderPass
	 *            The pass to get the icon for, 0 is default.
	 * @param player
	 *            The player holding the item
	 * @param usingItem
	 *            The item the player is actively using. Can be null if not
	 *            using anything.
	 * @param useRemaining
	 *            The ticks remaining for the active item.
	 * @return The icon index
	 */
	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		return this.getIcon(stack, renderPass);
	}
}
