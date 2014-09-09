package minestrapteam.virtious.block;

import java.util.Random;

import clashsoft.cslib.minecraft.block.BlockCustomPlant;
import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.lib.VBlocks;
import minestrapteam.virtious.lib.VItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockVirtiousFlowers extends BlockCustomPlant
{
	public BlockVirtiousFlowers(String[] names, Object icons)
	{
		super(names, icons);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int par3)
	{
		if (metadata == 0)
		{
			return VItems.veer_seeds;
		}
		else if (metadata == 1)
		{
			return null;
		}
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		return 1;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float chance, int fortune)
	{
		super.dropBlockAsItemWithChance(world, x, y, z, metadata, chance, fortune);
		
		if (metadata == 0)
		{
			this.dropBlockAsItem(world, x, y, z, new ItemStack(VItems.veer_dye));
		}
	}
	
	@Override
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return block == VBlocks.virtian_grass || block == VBlocks.virtian_soil;
	}
}
