package minestrapteam.extradims.lib;

import minestrapteam.extracore.api.PlayerInventoryAPI;
import minestrapteam.extracore.api.SurvivalInventory;
import minestrapteam.extracore.inventory.ExtendedInventory;
import minestrapteam.extracore.inventory.IInventoryHandler;
import minestrapteam.extracore.inventory.ISlotList;
import minestrapteam.extracore.inventory.slot.SlotCustomArmor;
import minestrapteam.extracore.util.math.Point2i;
import minestrapteam.extradims.item.ArmorTypes;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;

public class InventoryHandler implements IInventoryHandler
{
	public static final IInventoryHandler INSTANCE = new InventoryHandler();

	private static IIcon[] icons = new IIcon[ArmorTypes.SLOT_NAMES.length - ArmorTypes.GOGGLES];

	public static int getSlotIndex(int armorType)
	{
		return 64 + armorType - ArmorTypes.GOGGLES;
	}

	public static void load()
	{
		PlayerInventoryAPI.addInventoryHandler(INSTANCE);
	}

	public static void loadIcons(IIconRegister iconRegister)
	{
		final int start = ArmorTypes.GOGGLES;
		for (int i = start; i < ArmorTypes.SLOT_NAMES.length; i++)
		{
			icons[i - start] = iconRegister.registerIcon("extradims:armorslot/" + ArmorTypes.SLOT_NAMES[i]);
		}
	}

	@Override
	public void pre(Point2i[] slots, EntityPlayer player, boolean creative)
	{
		if (!creative)
		{
			SurvivalInventory.compactCraftingGrid();
			SurvivalInventory.setPlayer(7, 7);
			SurvivalInventory.setArmor(62, 8);
		}
	}

	@Override
	public void addSlots(ISlotList list, EntityPlayer player, boolean creative)
	{
		final ExtendedInventory extendedInventory = ExtendedInventory.get(player);

		if (creative)
		{
			for (int i = 0; i < 8; i++)
			{
				list.addSlot(
					new SlotCustomArmor(player, extendedInventory, 64 + i, 45 + (i * 18), 24, ArmorTypes.GOGGLES + i,
					                    icons[i]));
			}
		}
		else
		{
			for (int i = 0; i < 8; i++)
			{
				list.addSlot(new SlotCustomArmor(player, extendedInventory, 64 + i, 80 + (i % 2) * 18, 8 + (i / 2 * 18),
				                                 ArmorTypes.GOGGLES + i, icons[i]));
			}
		}
	}

	@Override
	public void buttonPressed(GuiButton button, EntityPlayer player, boolean creative)
	{
	}
}
