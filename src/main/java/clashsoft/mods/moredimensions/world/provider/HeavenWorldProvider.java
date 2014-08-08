package clashsoft.mods.moredimensions.world.provider;

import clashsoft.cslib.minecraft.world.CustomWorldProvider;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.mods.moredimensions.world.chunk_manager.HeavenChunkManager;
import clashsoft.mods.moredimensions.world.chunk_provider.ChunkProviderHeaven;

import net.minecraft.entity.Entity;
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
	public Vec3 getFogColor(float f, float f1)
	{
		return Vec3.createVectorHelper(0F, 0.75F, 1F);
	}
	
	@Override
	public float[] calcSunriseSunsetColors(float f, float f1)
	{
		this.colorsSunriseSunset[0] = 0F;
		this.colorsSunriseSunset[1] = 0.75F;
		this.colorsSunriseSunset[2] = 1F;
		this.colorsSunriseSunset[3] = 0.5F;
		return this.colorsSunriseSunset;
	}
	
	@Override
	public Vec3 getSkyColor(Entity entity, float partialTicks)
	{
		return Vec3.createVectorHelper(0F, 0.75F, 1F);
	}
}