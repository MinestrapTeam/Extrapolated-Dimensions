package clashsoft.mods.moredimensions.world.gen;

import java.util.Random;

import clashsoft.mods.moredimensions.addons.MDMBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class MDMGenTrees extends WorldGenTrees
{
	/** The minimum height of a generated tree. */
	private final int		minTreeHeight;
	
	/** True if this tree should grow Vines. */
	private final boolean	vinesGrow;
	
	private final int		woodId;
	private final int		leavesId;
	
	/** The metadata value of the wood to use in tree generation. */
	private final int		metaWood;
	
	/** The metadata value of the leaves to use in tree generation. */
	private final int		metaLeaves;
	
	public MDMGenTrees(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID)
	{
		this(blockUpdates, minTreeHeight, woodID, leavesID, 0, 0);
	}
	
	public MDMGenTrees(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID, int woodMetadata, int leavesMetadata)
	{
		this(blockUpdates, minTreeHeight, woodID, leavesID, woodMetadata, leavesMetadata, false);
	}
	
	public MDMGenTrees(boolean blockUpdates, int minTreeHeight, int woodID, int leavesID, int woodMetadata, int leavesMetadata, boolean vinesGrow)
	{
		super(blockUpdates);
		this.minTreeHeight = minTreeHeight;
		this.woodId = woodID;
		this.leavesId = leavesID;
		this.metaWood = woodMetadata;
		this.metaLeaves = leavesMetadata;
		this.vinesGrow = vinesGrow;
	}
	
	@Override
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		int var6 = par2Random.nextInt(3) + this.minTreeHeight;
		boolean var7 = true;
		
		if (par4 >= 1 && par4 + var6 + 1 <= 256)
		{
			int var8;
			byte var9;
			int var11;
			int var12;
			
			for (var8 = par4; var8 <= par4 + 1 + var6; ++var8)
			{
				var9 = 1;
				
				if (var8 == par4)
				{
					var9 = 0;
				}
				
				if (var8 >= par4 + 1 + var6 - 2)
				{
					var9 = 2;
				}
				
				for (int var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10)
				{
					for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11)
					{
						if (var8 >= 0 && var8 < 256)
						{
							var12 = par1World.getBlockId(var10, var8, var11);
							int var12_1 = par1World.getBlockMetadata(var10, var8, var11);
							
							Block block = Block.blocksList[var12];
							
							if (var12 != 0 && !block.isLeaves(par1World, var10, var8, var11) && var12 != Block.grass.blockID && var12 != Block.dirt.blockID && !(var12 == MDMBlocks.groundBlocks.blockID && var12_1 == 0) && var12 != MDMBlocks.heavenGrass.blockID && !block.isWood(par1World, var10, var8, var11))
							{
								var7 = false;
							}
						}
						else
						{
							var7 = false;
						}
					}
				}
			}
			
			if (!var7)
			{
				return false;
			}
			else
			{
				var8 = par1World.getBlockId(par3, par4 - 1, par5);
				int var8_1 = par1World.getBlockMetadata(par3, par4 - 1, par5);
				
				if ((var8 == Block.grass.blockID || var8 == Block.dirt.blockID || var8 == MDMBlocks.heavenGrass.blockID || (var8 == MDMBlocks.groundBlocks.blockID && var8_1 == 0)) && par4 < 256 - var6 - 1)
				{
					this.setBlock(par1World, par3, par4 - 1, par5, MDMBlocks.groundBlocks.blockID);
					var9 = 3;
					byte var18 = 0;
					int var13;
					int var14;
					int var15;
					
					for (var11 = par4 - var9 + var6; var11 <= par4 + var6; ++var11)
					{
						var12 = var11 - (par4 + var6);
						var13 = var18 + 1 - var12 / 2;
						
						for (var14 = par3 - var13; var14 <= par3 + var13; ++var14)
						{
							var15 = var14 - par3;
							
							for (int var16 = par5 - var13; var16 <= par5 + var13; ++var16)
							{
								int var17 = var16 - par5;
								
								Block block = Block.blocksList[par1World.getBlockId(var14, var11, var16)];
								
								if ((Math.abs(var15) != var13 || Math.abs(var17) != var13 || par2Random.nextInt(2) != 0 && var12 != 0) && (block == null || block.canBeReplacedByLeaves(par1World, var14, var11, var16)))
								{
									this.setBlockAndMetadata(par1World, var14, var11, var16, this.leavesId, this.metaLeaves);
								}
							}
						}
					}
					
					for (var11 = 0; var11 < var6; ++var11)
					{
						var12 = par1World.getBlockId(par3, par4 + var11, par5);
						
						Block block = Block.blocksList[var12];
						
						if (var12 == 0 || block == null || block.isLeaves(par1World, par3, par4 + var11, par5))
						{
							this.setBlockAndMetadata(par1World, par3, par4 + var11, par5, this.woodId, this.metaWood);
							
							if (this.vinesGrow && var11 > 0)
							{
								if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 - 1, par4 + var11, par5))
								{
									this.setBlockAndMetadata(par1World, par3 - 1, par4 + var11, par5, Block.vine.blockID, 8);
								}
								
								if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3 + 1, par4 + var11, par5))
								{
									this.setBlockAndMetadata(par1World, par3 + 1, par4 + var11, par5, Block.vine.blockID, 2);
								}
								
								if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + var11, par5 - 1))
								{
									this.setBlockAndMetadata(par1World, par3, par4 + var11, par5 - 1, Block.vine.blockID, 1);
								}
								
								if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(par3, par4 + var11, par5 + 1))
								{
									this.setBlockAndMetadata(par1World, par3, par4 + var11, par5 + 1, Block.vine.blockID, 4);
								}
							}
						}
					}
					
					if (this.vinesGrow)
					{
						for (var11 = par4 - 3 + var6; var11 <= par4 + var6; ++var11)
						{
							var12 = var11 - (par4 + var6);
							var13 = 2 - var12 / 2;
							
							for (var14 = par3 - var13; var14 <= par3 + var13; ++var14)
							{
								for (var15 = par5 - var13; var15 <= par5 + var13; ++var15)
								{
									Block block = Block.blocksList[par1World.getBlockId(var14, var11, var15)];
									if (block != null && block.isLeaves(par1World, var14, var11, var15))
									{
										if (par2Random.nextInt(4) == 0 && par1World.getBlockId(var14 - 1, var11, var15) == 0)
										{
											this.growVines(par1World, var14 - 1, var11, var15, 8);
										}
										
										if (par2Random.nextInt(4) == 0 && par1World.getBlockId(var14 + 1, var11, var15) == 0)
										{
											this.growVines(par1World, var14 + 1, var11, var15, 2);
										}
										
										if (par2Random.nextInt(4) == 0 && par1World.getBlockId(var14, var11, var15 - 1) == 0)
										{
											this.growVines(par1World, var14, var11, var15 - 1, 1);
										}
										
										if (par2Random.nextInt(4) == 0 && par1World.getBlockId(var14, var11, var15 + 1) == 0)
										{
											this.growVines(par1World, var14, var11, var15 + 1, 4);
										}
									}
								}
							}
						}
						
						if (par2Random.nextInt(5) == 0 && var6 > 5)
						{
							for (var11 = 0; var11 < 2; ++var11)
							{
								for (var12 = 0; var12 < 4; ++var12)
								{
									if (par2Random.nextInt(4 - var11) == 0)
									{
										var13 = par2Random.nextInt(3);
										this.setBlockAndMetadata(par1World, par3 + Direction.offsetX[Direction.directionToFacing[var12]], par4 + var6 - 5 + var11, par5 + Direction.offsetZ[Direction.directionToFacing[var12]], Block.cocoaPlant.blockID, var13 << 2 | var12);
									}
								}
							}
						}
					}
					
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Grows vines downward from the given block for a given length. Args:
	 * World, x, starty, z, vine-length
	 */
	private void growVines(World par1World, int par2, int par3, int par4, int par5)
	{
		this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
		int var6 = 4;
		
		while (true)
		{
			--par3;
			
			if (par1World.getBlockId(par2, par3, par4) != 0 || var6 <= 0)
			{
				return;
			}
			
			this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
			--var6;
		}
	}
}