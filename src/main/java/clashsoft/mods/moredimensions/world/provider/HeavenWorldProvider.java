package clashsoft.mods.moredimensions.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.chunk_manager.HeavenChunkManager;
import clashsoft.mods.moredimensions.world.chunk_provider.ChunkProviderHeaven;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.chunk.IChunkProvider;

public class HeavenWorldProvider extends CustomWorldProvider
{
	public HeavenWorldProvider()
	{
		super(MDMWorld.HEAVEN_ID);
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new HeavenChunkManager(this.getSeed(), this.terrainType);
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderHeaven(this.worldObj, this.worldObj.getSeed());
	}
	
	@Override
	public String getDimensionName()
	{
		return "Heaven";
	}
	
	@Override
	public String getSaveFolder()
	{
		return "HEAVEN";
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
		this.colorsSunriseSunset[0] = 0F * f;
		this.colorsSunriseSunset[1] = 0.75F * f;
		this.colorsSunriseSunset[2] = 1F * f;
		this.colorsSunriseSunset[3] = 0.5F;
		return this.colorsSunriseSunset;
	}
	
	@Override
	public Vec3 getSkyColor(Entity entity, float partialTickTime)
	{
		float celestialAngle = this.worldObj.getCelestialAngle(partialTickTime);
        return this.getFogColor(celestialAngle, partialTickTime);
	}
}