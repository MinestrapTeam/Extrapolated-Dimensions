package clashsoft.mods.moredimensions.item.tools;

import clashsoft.mods.moredimensions.addons.MDMItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemHammer extends ItemTool
{
	public static final Block[]	blocksEffectiveAgainst	= new Block[] { Block.bookShelf, Block.brewingStand, Block.cauldron, Block.chest, Block.chestTrapped, Block.daylightSensor, Block.dispenser, Block.doorIron, Block.doorWood, Block.dropper, Block.enchantmentTable, Block.enderChest, Block.fence, Block.fenceGate, Block.fenceIron, Block.glass, Block.glowStone, Block.hopperBlock, Block.jukebox, Block.ladder, Block.lever, Block.mobSpawner, Block.music, Block.netherFence, Block.pistonBase, Block.pistonExtension, Block.pistonMoving, Block.pistonStickyBase, Block.pressurePlateGold, Block.pressurePlateIron, Block.pressurePlatePlanks, Block.pressurePlateStone, Block.rail, Block.railActivator, Block.railDetector, Block.railPowered, Block.redstoneLampActive, Block.redstoneLampIdle, Block.signPost, Block.signWall, Block.skull, Block.stoneButton, Block.trapdoor, Block.tripWireSource, Block.vine, Block.web, Block.woodenButton, Block.workbench };
	
	public ItemHammer(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, 4.5F, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(MDMItems.tabTools);
	}
	
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		Material material = par2Block.blockMaterial;
		return (material == Material.glass || material == Material.piston || material == Material.redstoneLight || material == Material.vine || material == Material.web) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}
	
	public static class ItemWarhammer extends ItemHammer
	{
		public ItemWarhammer(int par1, EnumToolMaterial par2EnumToolMaterial)
		{
			super(par1, par2EnumToolMaterial);
			this.damageVsEntity = 5F + par2EnumToolMaterial.getDamageVsEntity();
		}
	}
}
