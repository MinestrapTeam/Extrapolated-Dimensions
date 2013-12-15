package clashsoft.mods.moredimensions.item.heaven;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.util.CSRandom;
import clashsoft.mods.moredimensions.addons.MDMItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ItemHeavenSoul extends Item
{
	public static Random			rand		= new Random();
	
	public static final String[]	soulNames	= new String[] { "Blood", "Fire", CSRandom.getNextRandomName(rand, 6, 7), "Lightning", "Grass", CSRandom.getNextRandomName(rand, 6, 7), "Animals", "Forest", "Sky", "Water", "Night", "Darkness", CSRandom.getNextRandomName(rand, 6, 7), "Myth", "Flowers", "Light" };
	public static final String[]	soulDesc	= new String[] { "Pretty Bloody", "Hot as the sun", (soulNames[2] + ", the Boss"), "High Voltage", "Green", (soulNames[5] + ", the Boss"), "Wild", "Naturally silent", "Blue without clouds", "Fresh", "Contains Moon and Stars", "Dark and evil", (soulNames[12] + ", the Boss"), "Mythic", "Grassy", "Glowing" };
	
	public Icon[]					icons		= new Icon[16];
	
	public ItemHeavenSoul(int itemID)
	{
		super(itemID);
		this.setMaxStackSize(1);
		this.setCreativeTab(MDMItems.tabHeavenItems);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		switch (stack.getItemDamage())
		{
			case 0: // Blood
				return false;
			case 1: // Fire
				int var11 = world.getBlockId(x, y + 1, z);
				
				if (var11 == 0)
				{
					world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					world.setBlock(x, y + 1, z, Block.fire.blockID);
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
				if (world.getBlockId(x, y, z) == Block.dirt.blockID)
				{
					world.setBlock(x, y, z, Block.grass.blockID);
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
				world.setBlock(x, y + 1, z, Block.waterStill.blockID);
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
				int flower = rand.nextInt(1) + Block.plantYellow.blockID;
				world.setBlock(x, y + 1, z, flower);
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
	
	/**
	 * Attempts to grow a sapling into a tree
	 */
	public void growTree(World world, int x, int y, int z, Random random)
	{
		int var6 = world.getBlockMetadata(x, y, z) & 3;
		Object var7 = null;
		int var8 = 0;
		int var9 = 0;
		boolean var10 = false;
		var7 = new WorldGenTrees(true);
		((WorldGenerator) var7).generate(world, random, x, y, z);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		for (int i = 0; i < 16; i++)
		{
			this.icons[i] = iconRegister.registerIcon("moredimensions:soul_" + (i + 1));
		}
	}
	
	/**
	 * Gets an icon index based on an item's damage value
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int metadata)
	{
		if (metadata < this.icons.length)
		{
			return this.icons[metadata];
		}
		return this.icons[15];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (stack.getItemDamage() < soulDesc.length)
		{
			list.add(soulDesc[stack.getItemDamage()]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
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
	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	public void getSubItems(int itemID, CreativeTabs creativeTab, List list)
	{
		for (int var4 = 0; var4 < 16; ++var4)
		{
			list.add(new ItemStack(itemID, 1, var4));
		}
	}
}
