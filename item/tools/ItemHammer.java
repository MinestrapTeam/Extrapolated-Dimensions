package clashsoft.mods.moredimensions.item.tools;

import java.util.Set;

import clashsoft.cslib.collections.CSCollections;
import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemHammer extends ItemTool
{
	public static final Set	blocksEffectiveAgainst	= CSCollections.createSet(Blocks.bookshelf, Blocks.brewing_stand, Blocks.cauldron, Blocks.chest, Blocks.trapped_chest, Blocks.daylight_detector, Blocks.dispenser, Blocks.iron_door, Blocks.wooden_door, Blocks.dropper, Blocks.enchanting_table, Blocks.ender_chest, Blocks.fence, Blocks.fence_gate, Blocks.iron_bars, Blocks.glass, Blocks.glowstone, Blocks.hopper, Blocks.jukebox, Blocks.ladder, Blocks.lever, Blocks.mob_spawner, Blocks.noteblock, Blocks.nether_brick_fence, Blocks.piston, Blocks.sticky_piston, Blocks.piston_extension, Blocks.piston_head, Blocks.light_weighted_pressure_plate, Blocks.heavy_weighted_pressure_plate, Blocks.wooden_pressure_plate, Blocks.stone_pressure_plate, Blocks.rail, Blocks.activator_rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.redstone_lamp, Blocks.lit_redstone_lamp, Blocks.wall_sign, Blocks.standing_sign, Blocks.skull, Blocks.stone_button, Blocks.trapdoor, Blocks.tripwire_hook, Blocks.vine, Blocks.web, Blocks.wooden_button, Blocks.crafting_table);
	
	public ItemHammer(float weaponDamage, ToolMaterial material)
	{
		super(weaponDamage, material, blocksEffectiveAgainst);
		this.setCreativeTab(MDMItems.tabTools);
	}
	
	public ItemHammer(ToolMaterial material)
	{
		this(4.5F, material);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		Material mat = block.getMaterial();
		if (mat == Material.glass || mat == Material.piston || mat == Material.redstoneLight || mat == Material.vine || mat == Material.web)
		{
			return this.efficiencyOnProperMaterial;
		}
		return super.getDigSpeed(stack, block, metadata);
	}
	
	public static class ItemWarhammer extends ItemHammer
	{
		public ItemWarhammer(ToolMaterial material)
		{
			super(material);
		}
	}
}
