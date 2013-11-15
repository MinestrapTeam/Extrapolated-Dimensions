package clashsoft.mods.moredimensions.magic.spells;

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
		if (target != null && target.typeOfHit == EnumMovingObjectType.TILE)
		{
			user.worldObj.createExplosion(user, target.blockX, target.blockY, target.blockZ, 3F, true);
			return true;
		}
		return false;
	}
	
}
