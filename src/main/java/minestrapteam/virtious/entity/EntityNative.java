package minestrapteam.virtious.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityNative extends EntityAgeable implements INpc
{
	private int		jumpDelay;
	
	public EntityNative(World world)
	{
		super(world);
		
		this.jumpDelay = this.rand.nextInt(20) + 10;
		
		this.setSize(0.5F, 1.3F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveIndoors(this));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 0.6D));
		this.tasks.addTask(4, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(4, new EntityAIWatchClosest2(this, EntityNative.class, 5.0F, 0.02F));
		this.tasks.addTask(4, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.5D);
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void updateEntityActionState()
	{
		this.despawnEntity();
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		
		if (entityplayer != null)
		{
			this.faceEntity(entityplayer, 10.0F, 20.0F);
		}
		
		if (this.onGround && this.jumpDelay-- <= 0)
		{
			this.jumpDelay = this.getJumpDelay();
			
			if (entityplayer != null)
			{
				this.jumpDelay /= 3;
			}
			
			this.isJumping = true;
			
			this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
			this.moveForward = 1F;
		}
		else
		{
			this.isJumping = false;
			
			if (this.onGround)
			{
				this.moveStrafing = this.moveForward = 0.0F;
			}
		}
	}
	
	protected int getJumpDelay()
	{
		return this.rand.nextInt(20) + 10;
	}
	
	@Override
	protected boolean canDespawn()
	{
		return false;
	}
	
	@Override
	protected String getHurtSound()
	{
		return "mob.villager.hit";
	}
	
	@Override
	protected String getDeathSound()
	{
		return "mob.villager.death";
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}
}
