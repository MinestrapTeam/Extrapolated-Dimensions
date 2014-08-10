package minestrapteam.extradims.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityHeavenPortalFX extends EntityFX
{
	private float	portalParticleScale;
	private double	portalPosX;
	private double	portalPosY;
	private double	portalPosZ;
	
	public EntityHeavenPortalFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		super(world, x, y, z, motionX, motionY, motionZ);
		
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
		this.portalPosX = this.posX = x;
		this.portalPosY = this.posY = y;
		this.portalPosZ = this.posZ = z;
		this.portalParticleScale = this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
		this.particleRed = 0F;
		this.particleGreen = 0.9F;
		this.particleBlue = 0.8F;
		this.particleMaxAge = (int) (Math.random() * 10.0D) + 40;
		this.noClip = true;
		this.setParticleTextureIndex((int) (Math.random() * 8.0D));
	}
	
	@Override
	public void renderParticle(Tessellator tessellator, float x, float y, float z, float x1, float y1, float z1)
	{
		float scaledAge = (this.particleAge + x) / this.particleMaxAge;
		scaledAge = 1.0F - scaledAge;
		scaledAge *= scaledAge;
		scaledAge = 1.0F - scaledAge;
		this.particleScale = this.portalParticleScale * scaledAge;
		super.renderParticle(tessellator, x, y, z, x1, y1, z1);
	}
	
	@Override
	public int getBrightnessForRender(float scalar)
	{
		int superBrightness = super.getBrightnessForRender(scalar);
		float scaledAge = (float) this.particleAge / (float) this.particleMaxAge;
		scaledAge = scaledAge * scaledAge * scaledAge;
		int var1 = superBrightness & 255;
		int var2 = superBrightness >> 16 & 255;
		var2 += (int) (scaledAge * 15.0F * 16.0F);
		
		if (var2 > 240)
		{
			var2 = 240;
		}
		
		return var1 | var2 << 16;
	}
	
	@Override
	public float getBrightness(float scalar)
	{
		float superBrightness = super.getBrightness(scalar);
		float scaledAge = (float) this.particleAge / (float) this.particleMaxAge;
		scaledAge = scaledAge * scaledAge * scaledAge * scaledAge;
		return superBrightness * (1.0F - scaledAge) + scaledAge;
	}
	
	@Override
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		float scaledAge = (float) this.particleAge / (float) this.particleMaxAge;
		float scaledAge2 = scaledAge;
		scaledAge = -scaledAge + scaledAge * scaledAge * 2.0F;
		scaledAge = 1.0F - scaledAge;
		this.posX = this.portalPosX + this.motionX * scaledAge;
		this.posY = this.portalPosY + this.motionY * scaledAge + (1.0F - scaledAge2);
		this.posZ = this.portalPosZ + this.motionZ * scaledAge;
		
		if (this.particleAge++ >= this.particleMaxAge)
		{
			this.setDead();
		}
	}
}
