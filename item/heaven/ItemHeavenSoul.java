package clashsoft.mods.moredimensions.item.heaven;

import java.util.List;
import java.util.Random;

import clashsoft.clashsoftapi.util.CSRandom;
import clashsoft.mods.moredimensions.item.ItemMDM;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ItemHeavenSoul extends ItemMDM
{
	public static Random			rand		= new Random();
	
	public static final String[]	soulNames	= new String[] { "Blood", "Fire", CSRandom.getNextRandomName(rand, 6, 7), "Lightning", "Grass", CSRandom.getNextRandomName(rand, 6, 7), "Animals", "Forest", "Sky", "Water", "Night", "Darkness", CSRandom.getNextRandomName(rand, 6, 7), "Myth", "Flowers", "Light" };
	
	public static final String[]	soulDesc	= new String[] { "Pretty Bloody", "Hot as the sun", (soulNames[2] + ", the Boss"), "High Voltage", "Green", (soulNames[5] + ", the Boss"), "Wild", "Naturally silent", "Blue without clouds", "Fresh", "Moon and Stars inside", "Dark and evil", (soulNames[12] + ", the Boss"), "Mythic", "Likes grass", "Glowing" };
	
	public Icon[]					icons		= new Icon[16];
	
	public ItemHeavenSoul(int par1)
	{
		super(par1, CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}
	
	public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		switch (par1ItemStack.getItemDamage())
		{
		case 0: // Blood
			return false;
		case 1: // Fire
			int var11 = par3World.getBlockId(par4, par5 + 1, par6);
			
			if (var11 == 0)
			{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5 + 1, par6, Block.fire.blockID);
			}
			
			par1ItemStack.stackSize--;
			return true;
		case 2: // Boss 1
			return false;
		case 3: // Lightning
			par3World.spawnEntityInWorld(new EntityLightningBolt(par3World, par4, par5, par6));
			par1ItemStack.stackSize--;
			return true;
		case 4: // Grass
			if (par3World.getBlockId(par4, par5, par6) == Block.dirt.blockID)
			{
				par3World.setBlock(par4, par5, par6, Block.grass.blockID);
				par1ItemStack.stackSize--;
				return true;
			}
		case 5: // Boss 2
			return false;
		case 6: // Animals
			EntityPig var2 = new EntityPig(par3World);
			var2.setLocationAndAngles(par4 - 0.25F, par5 + 1, par6 - 0.25F, rand.nextInt(), rand.nextInt());
			par3World.spawnEntityInWorld(var2);
			par1ItemStack.stackSize--;
			return true;
		case 7: // Forest
			growTree(par3World, par4, par5 + 1, par6, rand);
			par1ItemStack.stackSize--;
			return true;
		case 8: // Sky
			par3World.setRainStrength(1);
			par1ItemStack.stackSize--;
			return true;
		case 9: // Water
			par3World.setBlock(par4, par5 + 1, par6, Block.waterStill.blockID);
			par1ItemStack.stackSize--;
			return true;
		case 10: // Night
			par3World.setWorldTime(16000);
			par1ItemStack.stackSize--;
			return true;
		case 11: // Darkness
			return false;
		case 12: // Boss 3
			return false;
		case 13: // Myth
			return false;
		case 14: // Flower
			int flower = rand.nextInt(1) + Block.plantYellow.blockID;
			par3World.setBlock(par4, par5 + 1, par6, flower);
			par1ItemStack.stackSize--;
			return true;
		case 15: // Light
			par3World.setWorldTime(0);
			par1ItemStack.stackSize--;
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Attempts to grow a sapling into a tree
	 */
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
		Object var7 = null;
		int var8 = 0;
		int var9 = 0;
		boolean var10 = false;
		var7 = new WorldGenTrees(true);
		((WorldGenerator) var7).generate(par1World, par5Random, par2, par3, par4);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		for (int i = 0; i < 16; i++)
		{
			icons[i] = par1IconRegister.registerIcon("soul_" + (i + 1));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public Icon getIconFromDamage(int par1)
	{
		if (par1 < icons.length)
		{
			return icons[par1];
		}
		return icons[15];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.getItemDamage() < soulDesc.length)
		{
			par3List.add(soulDesc[par1ItemStack.getItemDamage()]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.rare;
	}
	
	@Override
	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 16; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}
