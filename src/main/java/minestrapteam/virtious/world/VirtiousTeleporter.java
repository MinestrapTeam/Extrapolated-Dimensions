package minestrapteam.virtious.world;

import java.util.Iterator;

import clashsoft.cslib.minecraft.world.CustomTeleporter;
import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldServer;

public class VirtiousTeleporter extends CustomTeleporter
{
	public VirtiousTeleporter(WorldServer worldServer)
	{
		super(worldServer);
	}
	
	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float par8)
	{
		if (this.world.provider.dimensionId != 1)
		{
			if (!this.placeInExistingPortal(entity, x, y, z, par8))
			{
				this.makePortal(entity);
				this.placeInExistingPortal(entity, x, y, z, par8);
			}
		}
		else
		{
			int i = MathHelper.floor_double(entity.posX);
			int j = MathHelper.floor_double(entity.posY) - 1;
			int k = MathHelper.floor_double(entity.posZ);
			
			entity.setLocationAndAngles(i, (double) j + 3, k, entity.rotationYaw, 0.0F);
			entity.motionX = entity.motionY = entity.motionZ = 0.0D;
		}
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float yaw)
	{
		short radius = 128;
		double d3 = -1.0D;
		int i = 0;
		int j = 0;
		int k = 0;
		int entityx = MathHelper.floor_double(entity.posX);
		int entityZ = MathHelper.floor_double(entity.posZ);
		long chunkIntPair = ChunkCoordIntPair.chunkXZ2Int(entityx, entityZ);
		boolean flag = true;
		double zSpawn;
		
		if (this.destinationCoordinateCache.containsItem(chunkIntPair))
		{
			PortalPosition VirtiousPortalPosition = (PortalPosition) this.destinationCoordinateCache.getValueByKey(chunkIntPair);
			d3 = 0.0D;
			i = VirtiousPortalPosition.posX;
			j = VirtiousPortalPosition.posY;
			k = VirtiousPortalPosition.posZ;
			VirtiousPortalPosition.lastUpdateTime = this.world.getTotalWorldTime();
			flag = false;
		}
		else
		{
			for (int x1 = entityx - radius; x1 <= entityx + radius; ++x1)
			{
				double d5 = x1 + 0.5D - entity.posX;
				
				for (int z1 = entityZ - radius; z1 <= entityZ + radius; ++z1)
				{
					double d6 = z1 + 0.5D - entity.posZ;
					
					for (int y1 = this.world.getActualHeight() - 1; y1 >= 0; --y1)
					{
						if (this.world.getBlock(x1, y1, z1) == VBlocks.virtious_portal)
						{
							zSpawn = y1 + 0.5D - entity.posY;
							double d7 = d5 * d5 + zSpawn * zSpawn + d6 * d6;
							
							if (d3 < 0.0D || d7 < d3)
							{
								d3 = d7;
								i = x1;
								j = y1;
								k = z1;
							}
						}
					}
				}
			}
		}
		
		if (d3 >= 0.0D)
		{
			if (flag)
			{
				this.destinationCoordinateCache.add(chunkIntPair, new PortalPosition(i, j, k, this.world.getTotalWorldTime()));
				this.destinationCoordinateKeys.add(Long.valueOf(chunkIntPair));
			}
			
			double xSpawn = i + 0.5D;
			double ySpawn = j + 0.5D;
			zSpawn = k + 0.5D;
			entity.motionX = entity.motionY = entity.motionZ = 0.0D;
			entity.setLocationAndAngles(xSpawn + 1, ySpawn + 1, zSpawn, entity.rotationYaw, entity.rotationPitch);
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean makePortal(Entity entity)
	{
		int checkRadius = 63;
		int i = MathHelper.floor_double(entity.posX);
		int k = MathHelper.floor_double(entity.posZ);
		
		int x, y, z;
		
		outer:
		while (true)
		{
			int rand1 = this.random.nextInt(checkRadius * 2);
			int rand2 = this.random.nextInt(checkRadius * 2);
			
			x = i + rand1 - checkRadius;
			z = k + rand2 - checkRadius;
			y = this.world.getHeightValue(x, z);
			
			Block block = this.world.getBlock(x, y - 1, z);
			if (block == VBlocks.virtian_grass || block == VBlocks.virtian_soil || block == Blocks.grass)
			{
				for (int x2 = x - 1; x2 <= x + 1; x2++)
				{
					for (int z2 = z - 1; z2 <= z + 1; z2++)
					{
						this.world.setBlock(x2, y, z2, Blocks.iron_block, 0, 2);
					}
					
				}
				
				this.world.setBlock(x, y + 1, z, VBlocks.virtious_portal, 0, 2);
				break;
			}
			else
			{
				continue outer;
			}
		}
		
		return true;
	}
	
	@Override
	public void removeStalePortalLocations(long time)
	{
		if (time % 100L == 0L)
		{
			Iterator iterator = this.destinationCoordinateKeys.iterator();
			long j = time - 600L;
			
			while (iterator.hasNext())
			{
				Long olong = (Long) iterator.next();
				PortalPosition VirtiousPortalPosition = (PortalPosition) this.destinationCoordinateCache.getValueByKey(olong.longValue());
				
				if (VirtiousPortalPosition == null || VirtiousPortalPosition.lastUpdateTime < j)
				{
					iterator.remove();
					this.destinationCoordinateCache.remove(olong.longValue());
				}
			}
		}
	}
}