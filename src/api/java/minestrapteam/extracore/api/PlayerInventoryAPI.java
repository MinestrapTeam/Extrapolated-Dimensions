package minestrapteam.extracore.api;

import minestrapteam.extracore.client.inventory.IInventoryObject;
import minestrapteam.extracore.inventory.IInventoryHandler;

public class PlayerInventoryAPI
{
	public static boolean playerTooltip           = true;
	public static boolean customSurvivalInventory = true;

	public static boolean customCreativeInventory = true;
	public static boolean itemTooltip             = false;
	public static boolean buffTooltip             = true;

	/**
	 * Sets the position of a slot in the both the survival and the creative player inventory.
	 *
	 * @param slotID
	 * 	the ID of the slot
	 * @param x
	 * 	the x position
	 * @param y
	 * 	the y position
	 */
	public static void setSlot(int slotID, int x, int y)
	{
		SurvivalInventory.setSlot(slotID, x, y);
		CreativeInventory.setSlot(slotID, x, y);
	}

	/**
	 * Registers a new {@link IInventoryHandler}.
	 *
	 * @param handler
	 * 	the inventory handler
	 */
	public static void addInventoryHandler(IInventoryHandler handler)
	{
		SurvivalInventory.addHandler(handler);
		CreativeInventory.addHandler(handler);
	}

	/**
	 * Adds a button to both the survival and the creative inventory.
	 *
	 * @param button
	 * 	the button
	 */
	public static void addButton(Object button)
	{
		SurvivalInventory.addButton(button);
		CreativeInventory.addButton(button);
	}

	/**
	 * Adds an {@link IInventoryObject} to both the survival and the creative inventory.
	 *
	 * @param object
	 * 	the object
	 */
	public static void addObject(IInventoryObject object)
	{
		SurvivalInventory.addObject(object);
		CreativeInventory.addObject(object);
	}
}
