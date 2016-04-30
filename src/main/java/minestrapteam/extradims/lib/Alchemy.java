package minestrapteam.extradims.lib;

import minestrapteam.extracore.block.ECBlocks;
import minestrapteam.extracore.inventory.creativetab.CustomCreativeTab;
import minestrapteam.extracore.item.ECItems;
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
		
		ECItems.addItem(alchemyGuide, "alchemy_guide");
		ECItems.addItem(elixir, "elixir");
		ECItems.addItem(elixirBottle, "elixir_bottle");
		
		// Blocks
		
		ECBlocks.addBlock(alchemyTube, "alchemy_tube");
		ECBlocks.addBlock(alchemyTable, "alchemy_table");
		
		// Tab Icons
		
		tabAlchemy.setIconItemStack(new ItemStack(elixirBottle));
	}
	
	public static String getTexture(String name)
	{
		return "ed_alchemy:" + name;
	}
}
