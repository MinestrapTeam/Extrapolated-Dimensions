package minestrapteam.virtious.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.virtious.entity.ai.EntityAIEatVirtiousGrass;
import minestrapteam.virtious.lib.VItems;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBurfalaunt extends EntityAnimal
{
	private int							burfalauntTimer;
	
	private EntityAIEatVirtiousGrass	aiEatGrass	= new EntityAIEatVirtiousGrass(this);
	
	public EntityBurfalaunt(World world)
	{
		super(world);
		this.setSize(0.9F, 1.3F);
		this.getNavigator().setAvoidsWater(true);
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(1, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(2, new EntityAITempt(this, 1.1D, VItems.veer_dye, false));
		this.tasks.addTask(3, new EntityAIFollowParent(this, 1.2D));
		this.tasks.addTask(4, this.aiEatGrass);
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void updateAITasks()
	{
		this.burfalauntTimer = this.aiEatGrass.eatGrassTick;
		super.updateAITasks();
	}
	
	@Override
	public void onLivingUpdate()
	{
		if (this.worldObj.isRemote)
		{
			this.burfalauntTimer = Math.max(0, this.burfalauntTimer - 1);
		}
		
		super.onLivingUpdate();
	}
	
	@SideOnly(Side.CLIENT)
	public float getHeadPitch(float partialTickTime)
	{
		if (this.burfalauntTimer > 4 && this.burfalauntTimer <= 36)
		{
			float f1 = (this.burfalauntTimer - 4 - partialTickTime) / 32.0F;
			return (float) Math.PI / 5F + (float) Math.PI * 7F / 100F * MathHelper.sin(f1 * 28.7F);
		}
		else
		{
			return this.burfalauntTimer > 0 ? (float) Math.PI / 5F : this.rotationPitch / (180F / (float) Math.PI);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public float getHeadYaw(float partialTickTime)
	{
		if (this.burfalauntTimer <= 0)
		{
			return 0F;
		}
		else if (this.burfalauntTimer >= 4 && this.burfalauntTimer <= 36)
		{
			return 1F;
		}
		else if (this.burfalauntTimer < 4)
		{
			return (this.burfalauntTimer - partialTickTime) / 4.0F;
		}
		return -(this.burfalauntTimer - 40 - partialTickTime) / 4.0F;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleHealthUpdate(byte health)
	{
		if (health == 10)
		{
			this.burfalauntTimer = 40;
		}
		else
		{
			super.handleHealthUpdate(health);
		}
	}
	
	@Override
	protected String getLivingSound()
	{
		return "virtious:burfalaunt_living";
	}
	
	@Override
	protected String getHurtSound()
	{
		return "virtious:burfalaunt_hurt";
	}
	
	@Override
	protected String getDeathSound()
	{
		return "virtious:burfalaunt_death";
	}
	
	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}
	
	@Override
	protected void dropEquipment(boolean player, int fortune)
	{
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + fortune);
		int k;
		
		for (k = 0; k < j; ++k)
		{
			this.dropItem(Items.leather, 1);
		}
		
		j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + fortune);
		
		for (k = 0; k < j; ++k)
		{
			if (this.isBurning())
			{
				this.dropItem(VItems.burhaunch_cooked, 1);
			}
			else
			{
				this.dropItem(VItems.burhaunch_raw, 1);
			}
		}
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return new EntityBurfalaunt(this.worldObj);
	}
}
