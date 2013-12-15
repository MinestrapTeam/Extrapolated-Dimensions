package clashsoft.mods.moredimensions.block.poc;

import java.util.Iterator;

import clashsoft.mods.moredimensions.dreams.DreamHelper;

import net.minecraft.block.BlockBed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BlockPOCDreamBed extends BlockBed
{
	public BlockPOCDreamBed(int blockID)
	{
		super(blockID);
		this.disableStats();
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			int i1 = world.getBlockMetadata(x, y, z);
			
			if (!isBlockHeadOfBed(i1))
			{
				int j1 = getDirection(i1);
				x += footBlockToHeadBlockMap[j1][0];
				z += footBlockToHeadBlockMap[j1][1];
				
				if (world.getBlockId(x, y, z) != this.blockID)
				{
					return true;
				}
				
				i1 = world.getBlockMetadata(x, y, z);
			}
			
			if (world.provider.canRespawnHere() && world.getBiomeGenForCoords(x, z) != BiomeGenBase.hell)
			{
				if (isBedOccupied(i1))
				{
					EntityPlayer entityplayer1 = null;
					Iterator iterator = world.playerEntities.iterator();
					
					while (iterator.hasNext())
					{
						EntityPlayer entityplayer2 = (EntityPlayer) iterator.next();
						
						if (entityplayer2.isPlayerSleeping())
						{
							ChunkCoordinates chunkcoordinates = entityplayer2.playerLocation;
							
							if (chunkcoordinates.posX == x && chunkcoordinates.posY == y && chunkcoordinates.posZ == z)
							{
								entityplayer1 = entityplayer2;
							}
						}
					}
					
					if (entityplayer1 != null)
					{
						player.addChatMessage("tile.bed.occupied");
						return true;
					}
					
					setBedOccupied(world, x, y, z, false);
				}
				
				EnumStatus enumstatus = player.sleepInBedAt(x, y, z);
				
				if (enumstatus == EnumStatus.OK)
				{
					setBedOccupied(world, x, y, z, true);
					DreamHelper.onPlayerStartedSleeping(player, x, y, z, world.getWorldTime());
					return true;
				}
				else
				{
					if (enumstatus == EnumStatus.NOT_POSSIBLE_NOW)
					{
						player.addChatMessage("tile.bed.noSleep");
					}
					else if (enumstatus == EnumStatus.NOT_SAFE)
					{
						player.addChatMessage("tile.bed.notSafe");
					}
					
					return true;
				}
			}
			else
			{
				double d0 = x + 0.5D;
				double d1 = y + 0.5D;
				double d2 = z + 0.5D;
				world.setBlockToAir(x, y, z);
				int k1 = getDirection(i1);
				x += footBlockToHeadBlockMap[k1][0];
				z += footBlockToHeadBlockMap[k1][1];
				
				if (world.getBlockId(x, y, z) == this.blockID)
				{
					world.setBlockToAir(x, y, z);
					d0 = (d0 + x + 0.5D) / 2.0D;
					d1 = (d1 + y + 0.5D) / 2.0D;
					d2 = (d2 + z + 0.5D) / 2.0D;
				}
				
				world.newExplosion((Entity) null, x + 0.5F, y + 0.5F, z + 0.5F, 5.0F, true, true);
				return true;
			}
		}
	}
	
}
