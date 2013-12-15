package clashsoft.mods.moredimensions.block.poc;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.block.ICustomBlock;
import clashsoft.mods.moredimensions.addons.MDMBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockPOCHerb extends BlockFlower implements IPlantable, ICustomBlock
{
	public String[]	names;
	public String[]	texturenames;
	public Icon[]	icons;
	
	public BlockPOCHerb(int blockID, String[] names, String[] texturenames)
	{
		super(blockID, Material.plants);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.names = names;
		this.texturenames = texturenames;
		this.icons = new Icon[texturenames.length];
	}
	
	@Override
	public Icon getIcon(int side, int metadata)
	{
		return this.icons[metadata];
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		for (int i = 0; i < this.texturenames.length; i++)
			this.icons[i] = iconRegister.registerIcon(this.texturenames[i]);
	}
	
	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}
	
	/**
	 * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of blockID passed in. Args: blockID
	 */
	protected boolean canThisGrowOnThisBlockID(int blockID)
	{
		return blockID == Block.grass.blockID || blockID == Block.dirt.blockID || blockID == Block.tilledField.blockID || blockID == MDMBlocks.pocDirtBlocks.blockID;
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are their own) Args: x, y, z, neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID)
	{
		super.onNeighborBlockChange(world, x, y, z, neighborBlockID);
		this.checkFlowerChange(world, x, y, z);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkFlowerChange(world, x, y, z);
	}
	
	/**
	 * Can this block stay at this position. Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		Block soil = blocksList[world.getBlockId(x, y - 1, z)];
		return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) && (soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return 1;
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return Plains;
	}
	
	@Override
	public int getPlantID(World world, int x, int y, int z)
	{
		return this.blockID;
	}
	
	@Override
	public int getPlantMetadata(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public void addNames()
	{
		for (int i = 0; i < this.names.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(this, 1, i), this.names[i]);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
	}
}
