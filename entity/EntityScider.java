package clashsoft.mods.moredimensions.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityScider extends EntityMob
{
	public EntityScider(World world)
	{
		super(world);
	}
	
	public EntityScider(World world, double x, double y, double z)
	{
		super(world);
		this.posX = x;
		this.newPosX = this.posX;
		this.posY = y;
		this.newPosY = this.posY;
		this.posZ = z;
		this.newPosZ = this.posZ;
		this.setSize(1.4F, 0.9F);
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if (!this.worldObj.isRemote)
		{
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}
	
	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	@Override
	public double getMountedYOffset()
	{
		return this.height * 0.75D - 0.5D;
	}
	
	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for sciders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking (Animals, Sciders at day, peaceful PigZombies).
	 */
	@Override
	protected Entity findPlayerToAttack()
	{
		float var1 = this.getBrightness(1.0F);
		
		if (var1 < 0.5F)
		{
			double var2 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return "mob.scider";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.scider";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.sciderdeath";
	}
	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity entity, float damage)
	{
		float var3 = this.getBrightness(1.0F);
		
		if (var3 > 0.5F && this.rand.nextInt(100) == 0)
		{
			this.entityToAttack = null;
		}
		else
		{
			if (damage > 2.0F && damage < 6.0F && this.rand.nextInt(10) == 0)
			{
				if (this.onGround)
				{
					double var4 = entity.posX - this.posX;
					double var6 = entity.posZ - this.posZ;
					float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
					this.motionX = var4 / var8 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
					this.motionZ = var6 / var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
					this.motionY = 0.4000000059604645D;
				}
			}
			else
			{
				super.attackEntity(entity, damage);
			}
		}
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId()
	{
		return Item.silk.itemID;
	}
	
	/**
	 * Drop 0-2 items of this living's type
	 */
	@Override
	protected void dropFewItems(boolean hitByPlayer, int looting)
	{
		super.dropFewItems(hitByPlayer, looting);
		
		if (hitByPlayer && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + looting) > 0))
		{
			this.dropItem(Item.spiderEye.itemID, 1);
		}
	}
	
	/**
	 * returns true if this entity is by a ladder, false otherwise
	 */
	@Override
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}
	
	/**
	 * Sets the Entity inside a web block.
	 */
	@Override
	public void setInWeb()
	{
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * How large the scider should be scaled.
	 */
	public float sciderScaleAmount()
	{
		return 1.0F;
	}
	
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect)
	{
		return potionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(potionEffect);
	}
	
	/**
	 * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using setBesideClimableBlock.
	 */
	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
	
	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if flag is true or 0x00 if it is false.
	 */
	public void setBesideClimbableBlock(boolean flag)
	{
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);
		
		if (flag)
		{
			var2 = (byte) (var2 | 1);
		}
		else
		{
			var2 &= -2;
		}
		
		this.dataWatcher.updateObject(16, Byte.valueOf(var2));
	}
}
