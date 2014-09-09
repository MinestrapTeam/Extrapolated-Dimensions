package minestrapteam.extradims.lib;

import clashsoft.cslib.minecraft.block.CSBlocks;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.extradims.block.alchemy.BlockAlchemyTable;
import minestrapteam.extradims.block.alchemy.BlockAlchemyTube;
import minestrapteam.extradims.item.alchemy.ItemAlchemyGuide;
import minestrapteam.extradims.item.alchemy.ItemElixir;
import minestrapteam.extradims.item.alchemy.ItemElixirBottle;

import net.minecraft.item.ItemStack;

public class Alchemy
{
	public static CustomCreativeTab	tabAlchemy	= new CustomCreativeTab("alchemy");
	
	// Items
	
	public static ItemAlchemyGuide	alchemyGuide;
	public static ItemElixir		elixir;
	public static ItemElixirBottle	elixirBottle;
	
	// Blocks
	
	public static BlockAlchemyTube	alchemyTube;
	public static BlockAlchemyTable	alchemyTable;
	
	public static void init()
	{
		// Items
		
		alchemyGuide = (ItemAlchemyGuide) new ItemAlchemyGuide().setTextureName(getTexture("alchemy_guide")).setCreativeTab(Alchemy.tabAlchemy);
		elixir = (ItemElixir) new ItemElixir().setCreativeTab(tabAlchemy);
		elixirBottle = (ItemElixirBottle) new ItemElixirBottle().setCreativeTab(tabAlchemy);
		
		// Blocks
		
		alchemyTube = (BlockAlchemyTube) new BlockAlchemyTube().setBlockTextureName(getTexture("alchemy_tube")).setCreativeTab(Alchemy.tabAlchemy);
		alchemyTable = (BlockAlchemyTable) new BlockAlchemyTable().setCreativeTab(Alchemy.tabAlchemy);
	}
	
	public static void load()
	{
		// Items
		
		CSItems.addItem(alchemyGuide, "alchemy_guide");
		CSItems.addItem(elixir, "elixir");
		CSItems.addItem(elixirBottle, "elixir_bottle");
		
		// Blocks
		
		CSBlocks.addBlock(alchemyTube, "alchemy_tube");
		CSBlocks.addBlock(alchemyTable, "alchemy_table");
		
		// Tab Icons
		
		tabAlchemy.setIconItemStack(new ItemStack(elixirBottle));
	}
	
	public static String getTexture(String name)
	{
		return "ed_alchemy:" + name;
	}
}
