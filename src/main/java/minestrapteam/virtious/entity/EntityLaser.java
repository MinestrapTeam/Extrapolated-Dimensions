package minestrapteam.virtious.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable
{
	private int	damage;
	
	public EntityLaser(World world)
	{
		super(world);
	}
	
	public EntityLaser(World world, EntityLivingBase living, int damage)
	{
		super(world, living);
		this.damage = damage;
	}
	
	public EntityLaser(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		if (mop.entityHit != null)
		{
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
			this.setDead();
		}
		else
		{
			Block block = this.worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ);
			if (block != Blocks.glass && block != Blocks.stained_glass && block != Blocks.glass_pane && block != Blocks.stained_glass_pane)
			{
				this.setDead();
			}
		}		
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setInteger("Damage", this.damage);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.damage = nbt.getInteger("Damage");
	}
}
