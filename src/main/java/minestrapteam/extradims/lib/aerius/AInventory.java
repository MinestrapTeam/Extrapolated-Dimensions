package minestrapteam.extradims.lib.aerius;

import minestrapteam.extracore.api.PlayerInventoryAPI;
import minestrapteam.extracore.api.SurvivalInventory;
import minestrapteam.extracore.inventory.ExtendedInventory;
import minestrapteam.extracore.inventory.IInventoryHandler;
import minestrapteam.extracore.inventory.ISlotList;
import minestrapteam.extracore.inventory.creativetab.CustomCreativeTab;
import minestrapteam.extracore.inventory.slot.SlotCustomArmor;
import minestrapteam.extracore.util.math.Point2i;
import minestrapteam.extradims.item.ArmorTypes;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class AInventory implements IInventoryHandler
{
	public static final IInventoryHandler INSTANCE = new AInventory();

	// Creative Tabs

	public static CustomCreativeTab tabAeriusBlocks    = new CustomCreativeTab("aerius_blocks");
	public static CustomCreativeTab tabAeriusItems     = new CustomCreativeTab("aerius_items");
	public static CustomCreativeTab tabAeriusTools     = new CustomCreativeTab("aerius_tools");
	public static CustomCreativeTab tabAeriusEquipment = new CustomCreativeTab("aerius_equipment");

	// Armor Slot Icons

	private static IIcon[] icons = new IIcon[ArmorTypes.SLOT_NAMES.length - ArmorTypes.GOGGLES];

	public static void load()
	{
		PlayerInventoryAPI.addInventoryHandler(INSTANCE);
		setTabIcons();
	}

	private static void setTabIcons()
	{
		tabAeriusBlocks.setIconItemStack(ABlocks.aerianGrass);
		tabAeriusItems.setIconItemStack(AItems.condaiusDust);
		tabAeriusTools.setIconItemStack(new ItemStack(AItems.iceHammer));
		tabAeriusEquipment.setIconItemStack(new ItemStack(AItems.accessories, 1, 7)); // Diamond Ring
	}

	public static void loadIcons(IIconRegister iconRegister)
	{
		final int start = ArmorTypes.GOGGLES;
		for (int i = start; i < ArmorTypes.SLOT_NAMES.length; i++)
		{
			icons[i - start] = iconRegister.registerIcon("ed_aerius:armorslot/" + ArmorTypes.SLOT_NAMES[i]);
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

	public static int getSlotIndex(int armorType)
	{
		return 64 + armorType - ArmorTypes.GOGGLES;
	}
}
