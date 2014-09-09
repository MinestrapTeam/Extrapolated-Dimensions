package minestrapteam.virtious.entity.ai;

import minestrapteam.virtious.lib.VBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAIEatVirtiousGrass extends EntityAIEatGrass
{
	private EntityLiving	theEntity;
	private World			theWorld;
	
	/** A decrementing tick used for the sheep's head offset and animation. */
	public int				eatGrassTick;
	
	public EntityAIEatVirtiousGrass(EntityLiving entity)
	{
		super(entity);
		this.theEntity = entity;
		this.theWorld = entity.worldObj;
		this.setMutexBits(7);
	}
	
	@Override
	public boolean shouldExecute()
	{
		if (this.theEntity.getRNG().nextInt(this.theEntity.isChild() ? 50 : 1000) != 0)
		{
			return false;
		}
		
		int x = MathHelper.floor_double(this.theEntity.posX);
		int y = MathHelper.floor_double(this.theEntity.posY);
		int z = MathHelper.floor_double(this.theEntity.posZ);
		Block block = this.theWorld.getBlock(x, y, z);
		return block == VBlocks.virtian_grass || block == VBlocks.virtious_flowers;
	}
	
	@Override
	public void updateTask()
	{
		this.eatGrassTick = Math.max(0, this.eatGrassTick - 1);
		
		if (this.eatGrassTick == 4)
		{
			int x = MathHelper.floor_double(this.theEntity.posX);
			int y = MathHelper.floor_double(this.theEntity.posY);
			int z = MathHelper.floor_double(this.theEntity.posZ);
			
			if (this.theWorld.getBlock(x, y, z) == VBlocks.virtious_flowers)
			{
				this.theWorld.func_147480_a(x, y, z, false);
				this.theEntity.eatGrassBonus();
			}
			else if (this.theWorld.getBlock(x, y - 1, z) == VBlocks.virtian_grass)
			{
				this.theWorld.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(VBlocks.virtian_grass));
				this.theWorld.setBlock(x, y - 1, z, VBlocks.virtian_soil, 0, 2);
				this.theEntity.eatGrassBonus();
			}
		}
	}
}
