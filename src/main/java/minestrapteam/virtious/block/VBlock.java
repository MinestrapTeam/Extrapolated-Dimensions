package minestrapteam.virtious.block;

import java.util.Random;

import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.lib.VBlocks;
import minestrapteam.virtious.lib.VItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class VBlock extends Block
{
	public VBlock(Material material)
	{
		super(material);
		this.setCreativeTab(Virtious.tabVirtiousBlocks);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == VBlocks.virtianstone)
		{
			return Item.getItemFromBlock(VBlocks.virtianstone_cobbled);
		}
		else if (this == VBlocks.aquieus_ore)
		{
			return VItems.aquieus_shard;
		}
		else if (this == VBlocks.tak_ore)
		{
			return VItems.tak;
		}
		else if (this == VBlocks.pluthorium_ore)
		{
			return VItems.pluthorium_gem;
		}
		else if (this == VBlocks.deep_tak_ore)
		{
			return VItems.tak;
		}
		else if (this == VBlocks.illuminous_ore)
		{
			return VItems.illuminous_gem;
		}
		else if (this == VBlocks.deep_illuminous_ore)
		{
			return VItems.illuminous_gem;
		}
		
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		if (this == VBlocks.aquieus_ore)
		{
			return 2 + random.nextInt(3);
		}
		else if (this == VBlocks.illuminous_ore)
		{
			return 2 + random.nextInt(3);
		}
		else if (this == VBlocks.deep_illuminous_ore)
		{
			return 2 + random.nextInt(3);
		}
		return 1;
	}
}
