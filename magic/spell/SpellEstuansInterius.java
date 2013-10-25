package clashsoft.mods.moredimensions.magic.spell;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;

public class SpellEstuansInterius extends Spell
{
	public SpellEstuansInterius(String name, int color)
	{
		super(name, color);
	}
	
	@Override
	public boolean onApplied(EntityLivingBase user, ItemStack stack, MovingObjectPosition target)
	{
		if (target != null)
		{
			if (target.typeOfHit == EnumMovingObjectType.ENTITY && target.entityHit instanceof EntityLiving)
			{
				((EntityLiving) target.entityHit).setDead();
				// Insert blood particle animation here
				return true;
			}
			else if (target.typeOfHit == EnumMovingObjectType.TILE)
			{
				user.worldObj.createExplosion(user, target.blockX, target.blockY, target.blockZ, 3F, true);
				return true;
			}
		}
		return false;
	}
	
}
