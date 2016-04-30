package minestrapteam.extracore.entity;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.item.ItemPotion2;
import minestrapteam.extracore.potion.type.IPotionType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityPotion2 extends EntityPotion
{
	public EntityPotion2(World world)
	{
		super(world);
	}

	public EntityPotion2(World world, EntityLivingBase thrower, ItemStack stack)
	{
		super(world, thrower, stack);
		this.setPotion(stack);
	}

	public EntityPotion2(World world, double x, double y, double z, ItemStack stack)
	{
		super(world, x, y, z, stack);
		this.setPotion(stack);
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.05F;
	}

	@Override
	protected float func_70182_d()
	{
		return 0.5F;
	}

	@Override
	protected float func_70183_g()
	{
		return -20.0F;
	}

	public void setPotion(ItemStack stack)
	{
		this.getDataWatcher().updateObject(10, stack);
		this.getDataWatcher().setObjectWatched(10);
	}

	public ItemStack getPotion()
	{
		return this.getDataWatcher().getWatchableObjectItemStack(10);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingObjectPosition)
	{
		if (this.worldObj.isRemote)
		{
			return;
		}

		ItemStack potion = this.getPotion();
		List<IPotionType> types = ((ItemPotion2) potion.getItem()).getPotionTypes(potion);

		if (types != null && !types.isEmpty())
		{
			AxisAlignedBB aabb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
			List<EntityLivingBase> entities = (List<EntityLivingBase>) this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, aabb);

			for (EntityLivingBase living : entities)
			{
				final double distance = this.getDistanceSqToEntity(living);
				if (distance < 16.0D)
				{
					double d1 = 1.0D - Math.sqrt(distance) / 4.0D;

					if (living == movingObjectPosition.entityHit)
					{
						d1 = 1.0D;
					}

					for (IPotionType type : types)
					{
						type.apply(this.getThrower(), living, d1);
					}
				}
			}
		}

		ExtraCore.proxy.playSplashEffect(this.worldObj, this.posX, this.posY, this.posZ, potion);
		this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.glass", 1.0F,
		                              this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		this.setDead();
	}

	@Override
	protected void entityInit()
	{
		this.getDataWatcher().addObjectByDataType(10, 5);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		ItemStack potion = this.getPotion();
		if (potion != null)
		{
			nbt.setTag("Item", potion.writeToNBT(new NBTTagCompound()));
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);

		NBTTagCompound nbttagcompound1 = nbt.getCompoundTag("Item");
		this.setPotion(ItemStack.loadItemStackFromNBT(nbttagcompound1));

		ItemStack item = this.getDataWatcher().getWatchableObjectItemStack(10);

		if (item == null || item.stackSize <= 0)
		{
			this.setDead();
		}
	}
}
