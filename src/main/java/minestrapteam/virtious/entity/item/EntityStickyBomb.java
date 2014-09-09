package minestrapteam.virtious.entity.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityStickyBomb extends Entity
{
	public boolean	activated;
	public int		fuse	= 30;
	
	public EntityStickyBomb(World world)
	{
		super(world);
		this.setSize(0.5F, 0.5F);
		this.height = 1F;
	}
	
	public EntityStickyBomb(World world, double i, double j, double k)
	{
		this(world);
		this.setPosition(i, j, k);
	}
	
	public EntityStickyBomb(World world, double i, double j, double k, EntityPlayer owner)
	{
		this(world);
		this.setPosition(i, j, k);
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		
		int x = MathHelper.floor_double(this.posX);
		int y = MathHelper.floor_double(this.posY);
		int z = MathHelper.floor_double(this.posZ);
		boolean flag = (int) this.prevPosX != x || (int) this.prevPosY != y || (int) this.prevPosZ != z;
		Block block = this.worldObj.getBlock(x, y, z);
		
		if (flag || this.ticksExisted % 25 == 0)
		{
			if (block.getMaterial() == Material.lava)
			{
				this.motionY = 0.2D;
				this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F;
				this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F;
			}
		}
		
		float f = 0.98F;
		
		if (this.onGround)
		{
			f = 0.588F;
			this.motionY *= -0.5D;
		}
		
		this.motionX *= f;
		this.motionY *= 0.98D;
		this.motionZ *= f;
		
		if (this.activated)
		{
			if (this.fuse-- < 1)
			{
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, true);
				this.setDead();
			}
		}
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode)
		{
			this.activated = true;
			this.playSound("random.fuse", 1.0F, 0.5F);
		}
	}
	
	@Override
	public boolean canAttackWithItem()
	{
		return true;
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt)
	{
		this.fuse = nbt.getShort("Fuse");
		this.activated = nbt.getBoolean("Activated");
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt)
	{
		nbt.setShort("Fuse", (short) this.fuse);
		nbt.setBoolean("Activated", this.activated);
		
	}
	
	@Override
	protected void entityInit()
	{
	}
}
