package minestrapteam.extradims.world.aerius;

import minestrapteam.extracore.world.CustomWorldProvider;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderAerius extends CustomWorldProvider
{
	public WorldProviderAerius()
	{
		super(WorldManager.AERIUS_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new ChunkManagerAerius(this.getSeed(), this.terrainType);
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderAerius(this.worldObj, this.worldObj.getSeed());
	}
	
	@Override
	public String getDimensionName()
	{
		return "Aerius";
	}
	
	@Override
	public String getSaveFolder()
	{
		return "AERIUS";
	}
	
	@Override
	public float getCloudHeight()
	{
		return 32F;
	}
	
	@Override
	public Vec3 getFogColor(float celestialAngle, float partialTickTime)
	{
		float f = MathHelper.cos(celestialAngle * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f < 0.0F)
        {
            f = 0.0F;
        }

        if (f > 1.0F)
        {
            f = 1.0F;
        }
		
		return Vec3.createVectorHelper(0F * f, 0.75F * f, 1F * f);
	}
	
	@Override
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTickTime)
	{
		float f = MathHelper.cos(celestialAngle * (float)Math.PI * 2.0F) * 2.0F + 0.5F;
		if (f >= -0.4F && f <= 0.4F)
		{
			this.colorsSunriseSunset[0] = 0F * f;
			this.colorsSunriseSunset[1] = 0.75F * f;
			this.colorsSunriseSunset[2] = 1F * f;
			this.colorsSunriseSunset[3] = 1F;
			return this.colorsSunriseSunset;
		}
		return null;
	}
	
	@Override
	public Vec3 getSkyColor(Entity entity, float partialTickTime)
	{
		float celestialAngle = this.worldObj.getCelestialAngle(partialTickTime);
        return this.getFogColor(celestialAngle, partialTickTime);
	}
}
