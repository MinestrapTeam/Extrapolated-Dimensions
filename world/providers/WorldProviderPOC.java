package clashsoft.mods.moredimensions.world.providers;

import clashsoft.mods.moredimensions.addons.MDMConfig;
import clashsoft.mods.moredimensions.world.chunkmanagers.WorldChunkManagerPOC;
import clashsoft.mods.moredimensions.world.providers.chunk.ChunkProviderPOC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderPOC extends WorldProvider
{
	private final float[]	colorsSunriseSunset	= new float[4];
	
	@Override
	public void registerWorldChunkManager()
	{
		this.dimensionId = MDMConfig.POC_DIMENSION_ID;
		this.worldChunkMgr = new WorldChunkManagerPOC();
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderPOC(this.worldObj, this.worldObj.getSeed(), false);
	}
	
	@Override
	public int getAverageGroundLevel()
	{
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2)
	{
		return false;
	}
	
	@Override
	public String getDimensionName()
	{
		return "Paradise Of Chaos";
	}
	
	public boolean renderStars()
	{
		return true;
	}
	
	public float getStarBrightness(World world, float f)
	{
		return 10.0F;
	}
	
	public boolean renderClouds()
	{
		return true;
	}
	
	public boolean renderVoidFog()
	{
		return false;
	}
	
	public boolean renderEndSky()
	{
		return false;
	}
	
	public float setSunSize()
	{
		return 10.0F;
	}
	
	public float setMoonSize()
	{
		return 8.0F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return true;
	}
	
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return 128.0F;
	}
	
	@SideOnly(Side.CLIENT)
	public String getSunTexture()
	{
		return "/Main:TwinSuns.png";
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}
	
	@Override
	public ChunkCoordinates getEntrancePortalLocation()
	{
		return new ChunkCoordinates(50, 5, 0);
	}
	
	@Override
	protected void generateLightBrightnessTable()
	{
		float f = 12.0F;
		for (int i = 0; i <= 15; i++)
		{
			float f1 = 12.0F - i / 15.0F;
			this.lightBrightnessTable[i] = ((1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		if ((this instanceof WorldProviderPOC))
		{
			return "Entering the Paradise of Chaos";
		}
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(float par1, float par2)
	{
		float f2 = 0.4F;
		float f3 = MathHelper.cos(par1 * 3.141593F * 2.0F) - 0.0F;
		float f4 = -0.0F;
		if ((f3 >= f4 - f2) && (f3 <= f4 + f2))
		{
			float f5 = (f3 - f4) / f2 * 0.5F + 0.5F;
			float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * 3.141593F)) * 0.99F;
			f6 *= f6;
			this.colorsSunriseSunset[0] = (f5 * 0.3F + 0.7F);
			this.colorsSunriseSunset[1] = (f5 * f5 * 0.7F + 0.2F);
			this.colorsSunriseSunset[2] = (f5 * f5 * 0.0F + 0.2F);
			this.colorsSunriseSunset[3] = f6;
			return this.colorsSunriseSunset;
		}
		return null;
	}
	
	@Override
	public float calculateCelestialAngle(long par1, float par3)
	{
		int j = (int) (par1 % 24000L);
		float f1 = (j + par3) / 24000.0F - 0.25F;
		if (f1 < 0.0F)
		{
			f1 += 1.0F;
		}
		if (f1 > 1.0F)
		{
			f1 -= 1.0F;
		}
		float f2 = f1;
		f1 = 1.0F - (float) ((Math.cos(f1 * 3.141592653589793D) + 1.0D) / 2.0D);
		f1 = f2 + (f1 - f2) / 3.0F;
		return f1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2)
	{
		int i = 10518688;
		float f2 = MathHelper.cos(par1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}
		if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}
		float f3 = (i >> 16 & 0xFF) / 255.0F;
		float f4 = (i >> 8 & 0xFF) / 255.0F;
		float f5 = (i & 0xFF) / 255.0F;
		f3 *= (f2 * 0.0F + 0.15F);
		f4 *= (f2 * 0.0F + 0.15F);
		f5 *= (f2 * 0.0F + 0.15F);
		return this.worldObj.getWorldVec3Pool().getVecFromPool(f3, f4, f5);
	}
}