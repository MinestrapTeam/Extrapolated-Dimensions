package minestrapteam.extradims.item.aerius;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.item.CustomItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class ItemAeriusSoul extends Item
{
	public static Random			rand		= new Random();
	
	public static final String[]	soulNames	= new String[] {
			"blood",
			"fire",
			"boss1",
			"lightning",
			"grass",
			"boss2",
			"animals",
			"forest",
			"sky",
			"water",
			"night",
			"darkness",
			"boss3",
			"myth",
			"flowers",
			"light"							};
	
	public ItemAeriusSoul()
	{
		super();
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return CustomItem.getUnlocalizedName(this, soulNames, stack);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		switch (stack.getItemDamage())
		{
			case 0: // Blood
				return false;
			case 1: // Fire
				if (world.isAirBlock(x, y, z))
				{
					world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					world.setBlock(x, y + 1, z, Blocks.fire);
				}
				stack.stackSize--;
				return true;
			case 2: // Boss 1
				return false;
			case 3: // Lightning
				world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
				stack.stackSize--;
				return true;
			case 4: // Grass
				if (world.getBlock(x, y, z) == Blocks.dirt)
				{
					world.setBlock(x, y, z, Blocks.grass);
					stack.stackSize--;
					return true;
				}
			case 5: // Boss 2
				return false;
			case 6: // Animals
				EntityPig var2 = new EntityPig(world);
				var2.setLocationAndAngles(x - 0.25F, y + 1, z - 0.25F, rand.nextInt(), rand.nextInt());
				world.spawnEntityInWorld(var2);
				stack.stackSize--;
				return true;
			case 7: // Forest
				this.growTree(world, x, y + 1, z, rand);
				stack.stackSize--;
				return true;
			case 8: // Sky
				world.setRainStrength(1);
				stack.stackSize--;
				return true;
			case 9: // Water
				world.setBlock(x, y + 1, z, Blocks.water);
				stack.stackSize--;
				return true;
			case 10: // Night
				world.setWorldTime(16000);
				stack.stackSize--;
				return true;
			case 11: // Darkness
				return false;
			case 12: // Boss 3
				return false;
			case 13: // Myth
				return false;
			case 14: // Flower
				world.setBlock(x, y + 1, z, Blocks.yellow_flower);
				stack.stackSize--;
				return true;
			case 15: // Light
				world.setWorldTime(0);
				stack.stackSize--;
				return true;
			default:
				return false;
		}
	}
	
	public void growTree(World world, int x, int y, int z, Random random)
	{
		new WorldGenTrees(true).generate(world, random, x, y, z);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 16; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
}
