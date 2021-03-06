package minestrapteam.extradims.item.aerius;

import minestrapteam.extracore.item.CustomItem;
import minestrapteam.extracore.util.I18n;
import minestrapteam.extradims.api.curse.ICurseIngredient;
import minestrapteam.extradims.curse.Curse;
import minestrapteam.extradims.entity.EDEntityProperties;
import minestrapteam.extradims.lib.aerius.Aerius;
import minestrapteam.extradims.lib.aerius.ABlocks;
import minestrapteam.extradims.lib.aerius.AItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.util.List;

public class ItemAeriusLoot extends CustomItem implements ICurseIngredient
{
	public ItemAeriusLoot(String[] names)
	{
		super(names, getIconNames(names), null);
	}

	private static String[] getIconNames(String[] names)
	{
		final String[] res = new String[names.length];
		for (int i = 0; i < names.length; i++)
		{
			res[i] = Aerius.TEXTURE_PREFIX + "loot/" + names[i];
		}
		return res;
	}

	@Override
	public boolean isCurseIngredient(ItemStack stack)
	{
		return stack.getItemDamage() == AItems.iceStick.getItemDamage();
	}

	@Override
	public Curse getCurse(ItemStack stack)
	{
		return Curse.test;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		final int metadata = stack.getItemDamage();
		return metadata == AItems.aerwand.getItemDamage() ? EnumRarity.rare : EnumRarity.common;
	}

	@Override
	public boolean hasEffect(ItemStack stack, int pass)
	{
		final int metadata = stack.getItemDamage();
		return metadata == AItems.aerwand.getItemDamage();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		final int metadata = stack.getItemDamage();
		if (metadata == AItems.aerwand.getItemDamage())
		{
			list.add(I18n.getString("item.aerius_loot.aerwand.desc"));
		}
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		final int metadata = stack.getItemDamage();
		if (metadata == AItems.aerwand.getItemDamage())
		{
			if (!world.isRemote && ABlocks.portal.generatePortal(world, x, y + 1, z))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		final int metadata = stack.getItemDamage();
		if (metadata == AItems.manaStar.getItemDamage())
		{
			// Mana Star Behaviour

			if (!player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}
			if (!world.isRemote)
			{
				EDEntityProperties.get(player).addMana(2.5F);
			}
			return stack;
		}

		if (metadata == AItems.lifeHeart.getItemDamage())
		{
			// Life Heart Behaviour

			if (!player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}

			world.playSoundAtEntity(player, "random.bow", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			if (!world.isRemote)
			{
				EDEntityProperties.get(player).addAdditionalHearts(1F);
			}
			return stack;
		}

		if (metadata == AItems.iceStick.getItemDamage())
		{
			if (!player.capabilities.isCreativeMode)
			{
				stack.stackSize--;
			}

			if (!world.isRemote)
			{
				return tryFreeze(this.getMovingObjectPositionFromPlayer(world, player, true), stack, world);
			}
		}

		return stack;
	}

	public static ItemStack tryFreeze(MovingObjectPosition mop, ItemStack stack, World world)
	{
		if (mop == null)
		{
			return stack;
		}

		if (mop.typeOfHit == MovingObjectType.BLOCK)
		{
			int x = mop.blockX;
			int y = mop.blockY;
			int z = mop.blockZ;

			if (world.getBlock(x, y, z).getMaterial() == Material.water && world.getBlockMetadata(x, y, z) == 0)
			{
				world.setBlock(x, y, z, Blocks.ice);
			}
		}

		return stack;
	}
}
