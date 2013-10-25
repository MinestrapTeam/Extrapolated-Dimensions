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
	
	public BlockPOCDreamBed(int par1)
	{
		super(par1);
		this.disableStats();
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			int i1 = par1World.getBlockMetadata(par2, par3, par4);
			
			if (!isBlockHeadOfBed(i1))
			{
				int j1 = getDirection(i1);
				par2 += footBlockToHeadBlockMap[j1][0];
				par4 += footBlockToHeadBlockMap[j1][1];
				
				if (par1World.getBlockId(par2, par3, par4) != this.blockID)
				{
					return true;
				}
				
				i1 = par1World.getBlockMetadata(par2, par3, par4);
			}
			
			if (par1World.provider.canRespawnHere() && par1World.getBiomeGenForCoords(par2, par4) != BiomeGenBase.hell)
			{
				if (isBedOccupied(i1))
				{
					EntityPlayer entityplayer1 = null;
					Iterator iterator = par1World.playerEntities.iterator();
					
					while (iterator.hasNext())
					{
						EntityPlayer entityplayer2 = (EntityPlayer) iterator.next();
						
						if (entityplayer2.isPlayerSleeping())
						{
							ChunkCoordinates chunkcoordinates = entityplayer2.playerLocation;
							
							if (chunkcoordinates.posX == par2 && chunkcoordinates.posY == par3 && chunkcoordinates.posZ == par4)
							{
								entityplayer1 = entityplayer2;
							}
						}
					}
					
					if (entityplayer1 != null)
					{
						par5EntityPlayer.addChatMessage("tile.bed.occupied");
						return true;
					}
					
					setBedOccupied(par1World, par2, par3, par4, false);
				}
				
				EnumStatus enumstatus = par5EntityPlayer.sleepInBedAt(par2, par3, par4);
				
				if (enumstatus == EnumStatus.OK)
				{
					setBedOccupied(par1World, par2, par3, par4, true);
					DreamHelper.onPlayerStartedSleeping(par5EntityPlayer, par2, par3, par4, par1World.getWorldTime());
					return true;
				}
				else
				{
					if (enumstatus == EnumStatus.NOT_POSSIBLE_NOW)
					{
						par5EntityPlayer.addChatMessage("tile.bed.noSleep");
					}
					else if (enumstatus == EnumStatus.NOT_SAFE)
					{
						par5EntityPlayer.addChatMessage("tile.bed.notSafe");
					}
					
					return true;
				}
			}
			else
			{
				double d0 = par2 + 0.5D;
				double d1 = par3 + 0.5D;
				double d2 = par4 + 0.5D;
				par1World.setBlockToAir(par2, par3, par4);
				int k1 = getDirection(i1);
				par2 += footBlockToHeadBlockMap[k1][0];
				par4 += footBlockToHeadBlockMap[k1][1];
				
				if (par1World.getBlockId(par2, par3, par4) == this.blockID)
				{
					par1World.setBlockToAir(par2, par3, par4);
					d0 = (d0 + par2 + 0.5D) / 2.0D;
					d1 = (d1 + par3 + 0.5D) / 2.0D;
					d2 = (d2 + par4 + 0.5D) / 2.0D;
				}
				
				par1World.newExplosion((Entity) null, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, 5.0F, true, true);
				return true;
			}
		}
	}
	
}
