package minestrapteam.extracore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extracore.api.BrewingAPI;
import minestrapteam.extracore.api.PlayerInventoryAPI;
import minestrapteam.extracore.block.BlockBrewingStand2;
import minestrapteam.extracore.block.ECBlocks;
import minestrapteam.extracore.block.ore.BlockOre2;
import minestrapteam.extracore.block.ore.BlockRedstoneOre2;
import minestrapteam.extracore.block.ore.OreBase;
import minestrapteam.extracore.command.CommandModUpdate;
import minestrapteam.extracore.command.CommandPotion;
import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extracore.crafting.ECCrafting;
import minestrapteam.extracore.crafting.loader.FurnaceRecipeLoader;
import minestrapteam.extracore.entity.ECEntities;
import minestrapteam.extracore.entity.EntityPotion2;
import minestrapteam.extracore.init.BaseMod;
import minestrapteam.extracore.inventory.ExtendedInventory;
import minestrapteam.extracore.item.ECItems;
import minestrapteam.extracore.item.ItemGlassBottle2;
import minestrapteam.extracore.item.ItemPotion2;
import minestrapteam.extracore.item.block.ItemCustomBlock;
import minestrapteam.extracore.item.stack.ECStacks;
import minestrapteam.extracore.item.stack.StackFactory;
import minestrapteam.extracore.network.ECNetHandler;
import minestrapteam.extracore.potion.PotionList;
import minestrapteam.extracore.potion.util.PotionDispenser;
import minestrapteam.extracore.proxy.ECEventHandler;
import minestrapteam.extracore.proxy.ECProxy;
import minestrapteam.extracore.tileentity.TileEntityBrewingStand2;
import minestrapteam.extracore.util.Log4JLogger;
import minestrapteam.extracore.util.logging.ECLog;
import minestrapteam.extracore.util.update.ECUpdate;
import minestrapteam.extracore.util.update.reader.SimpleUpdateReader;
import minestrapteam.extracore.util.update.updater.ModUpdater;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.io.File;
import java.util.Collections;

@Mod(modid = ExtraCore.MODID, name = ExtraCore.NAME, version = ExtraCore.VERSION)
public class ExtraCore extends BaseMod
{
	public static final String MODID   = "extracore";
	public static final String NAME    = "ExtraCore";
	public static final String ACRONYM = "ec";
	public static final String VERSION = "1.7.10-2.7.3";

	public static boolean workspaceMode;

	static
	{
		ECLog.logger = new Log4JLogger();

		File file = new File(".");
		String path = file.getAbsolutePath();
		if (path.endsWith("run/.") || path.endsWith("assets/."))
		{
			workspaceMode = true;
			ECLog.info("ExtraCore is now running in Dev Workspace mode.");
		}
	}

	@Instance(MODID)
	public static ExtraCore instance;

	public static ECProxy proxy = createProxy("minestrapteam.extracore.client.ECClientProxy",
	                                          "minestrapteam.extracore.proxy.ECProxy");

	public static CreativeTabs multiPotions;

	public static Block coalOre2        = new BlockOre2(OreBase.TYPE_OVERWORLD);
	public static Block ironOre2        = new BlockOre2(OreBase.TYPE_OVERWORLD);
	public static Block goldOre2        = new BlockOre2(OreBase.TYPE_OVERWORLD);
	public static Block diamondOre2     = new BlockOre2(OreBase.TYPE_OVERWORLD);
	public static Block emeraldOre2     = new BlockOre2(OreBase.TYPE_OVERWORLD);
	public static Block redstoneOre2    = new BlockRedstoneOre2(OreBase.TYPE_OVERWORLD, false);
	public static Block litRedstoneOre2 = new BlockRedstoneOre2(OreBase.TYPE_OVERWORLD, true);
	public static Block lapisOre2       = new BlockOre2(OreBase.TYPE_OVERWORLD);
	public static Block quartzOre2      = new BlockOre2(OreBase.TYPE_NETHER);

	public static Block brewingStand2     = new BlockBrewingStand2();
	public static Item  brewingStandItem2 = new ItemReed(brewingStand2);

	public static ItemPotion2      potion2      = new ItemPotion2();
	public static ItemGlassBottle2 glassBottle2 = new ItemGlassBottle2();

	public static boolean printUpdateNotes;
	public static boolean updateCheck;
	public static boolean autoUpdate;
	public static boolean enableMOTD;

	public ExtraCore()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.authors = Collections.singletonList("Clashsoft");
		this.hasConfig = true;
		this.netHandler = new ECNetHandler();
		this.eventHandler = new ECEventHandler();
		this.url = "https://github.com/MinestrapTeam/Extrapolated-Dimensions/wiki/ExtraCore";
		this.description = "The ExtraCore Library adds many useful Classes and APIs for modders to use.";
	}

	public static ECNetHandler getNetHandler()
	{
		return (ECNetHandler) instance.netHandler;
	}

	@Override
	public void readConfig()
	{
		printUpdateNotes = ECConfig.getBool("updates", "Print Update Notes", false);
		updateCheck = ECConfig.getBool("updates", "Update Check", "Disables update checks for ALL mods", true);
		if (!workspaceMode)
		{
			autoUpdate = ECConfig.getBool("updates", "Automatically Update", "Disables automatic updates", false);
		}
		enableMOTD = ECConfig.getBool("updates", "Enable MOTD", true);

		PlayerInventoryAPI.itemTooltip = ECConfig.getBool("tooltip", "Item Tooltip", PlayerInventoryAPI.itemTooltip);
		PlayerInventoryAPI.buffTooltip = ECConfig.getBool("tooltip", "Buff Tooltip", PlayerInventoryAPI.buffTooltip);
		PlayerInventoryAPI.playerTooltip = ECConfig
			                                   .getBool("tooltip", "Player Tooltip", PlayerInventoryAPI.playerTooltip);

		BrewingAPI.goodEffectColor1 = ECConfig.getString("colors", "Good Effect Color", BrewingAPI.goodEffectColor1);
		BrewingAPI.goodEffectColor2 = ECConfig
			                              .getString("colors", "Good Effect Glow Color", BrewingAPI.goodEffectColor2);
		BrewingAPI.badEffectColor1 = ECConfig.getString("colors", "Bad Effect Color", BrewingAPI.badEffectColor1);
		BrewingAPI.badEffectColor2 = ECConfig.getString("colors", "Bad Effect Glow Color", BrewingAPI.badEffectColor2);
		BrewingAPI.multiPotions = ECConfig.getBool("potions", "MultiPotions", BrewingAPI.multiPotions);
		BrewingAPI.advancedPotionInfo = ECConfig
			                                .getBool("potions", "Advanced Potion Info", BrewingAPI.advancedPotionInfo);
		BrewingAPI.showAllBaseTypes = ECConfig.getBool("potions", "Show All Base Potion Types",
		                                               BrewingAPI.showAllBaseTypes);
		BrewingAPI.defaultAwkwardBrewing = ECConfig.getBool("potions", "Default Awkward Brewing",
		                                                    BrewingAPI.defaultAwkwardBrewing);
		BrewingAPI.potionStackSize = ECConfig.getInt("potions", "PotionStackSize", BrewingAPI.potionStackSize);
	}

	@Override
	public void updateCheck()
	{
		final String url = "https://raw.githubusercontent.com/Clashsoft/Clashsoft-Lib/master/version.txt";
		ECUpdate.updateCheck(new ModUpdater(NAME, ACRONYM, VERSION, url, SimpleUpdateReader.instance));
	}

	@Override
	@EventHandler
	public void construct(FMLConstructionEvent event)
	{
		super.construct(event);

		ECCrafting.updateItemStacks();

		ECBlocks.replaceBlock(Blocks.coal_ore, coalOre2, new ItemCustomBlock(coalOre2));
		ECBlocks.replaceBlock(Blocks.iron_ore, ironOre2, new ItemCustomBlock(ironOre2));
		ECBlocks.replaceBlock(Blocks.gold_ore, goldOre2, new ItemCustomBlock(goldOre2));
		ECBlocks.replaceBlock(Blocks.diamond_ore, diamondOre2, new ItemCustomBlock(diamondOre2));
		ECBlocks.replaceBlock(Blocks.emerald_ore, emeraldOre2, new ItemCustomBlock(emeraldOre2));
		ECBlocks.replaceBlock(Blocks.redstone_ore, redstoneOre2, new ItemCustomBlock(redstoneOre2));
		ECBlocks.replaceBlock(Blocks.lit_redstone_ore, litRedstoneOre2);
		ECBlocks.replaceBlock(Blocks.lapis_ore, lapisOre2, new ItemCustomBlock(lapisOre2));
		ECBlocks.replaceBlock(Blocks.quartz_ore, quartzOre2, new ItemCustomBlock(quartzOre2));
	}

	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);

		coalOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreCoal")
		        .setBlockTextureName("extracore:coal_overlay");
		ironOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreIron")
		        .setBlockTextureName("extracore:iron_overlay");
		goldOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreGold")
		        .setBlockTextureName("extracore:gold_overlay");
		diamondOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreDiamond")
		           .setBlockTextureName("extracore:diamond_overlay");
		emeraldOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreEmerald")
		           .setBlockTextureName("extracore:emerald_overlay");
		redstoneOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston)
		            .setBlockName("oreRedstone").setBlockTextureName("extracore:redstone_overlay");
		litRedstoneOre2.setLightLevel(0.625F).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston)
		               .setBlockName("oreRedstone").setBlockTextureName("extracore:redstone_overlay");
		lapisOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreLapis")
		         .setBlockTextureName("extracore:lapis_overlay");
		quartzOre2.setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston)
		          .setBlockName("netherquartz").setBlockTextureName("extracore:quartz_overlay");

		brewingStand2.setBlockName("brewingStand").setHardness(0.5F).setLightLevel(0.125F);
		brewingStandItem2.setUnlocalizedName("brewingStand").setTextureName("brewing_stand")
		                 .setCreativeTab(CreativeTabs.tabBrewing);

		potion2.setUnlocalizedName("potion").setCreativeTab(CreativeTabs.tabBrewing);
		glassBottle2.setUnlocalizedName("glassBottle").setTextureName("potion_bottle_empty");

		ECCrafting.removeRecipe(new ItemStack(Items.brewing_stand));
		ECCrafting.removeRecipe(new ItemStack(Items.glass_bottle));

		ECBlocks.replaceBlock(Blocks.brewing_stand, brewingStand2);
		ECItems.replaceItem(Items.brewing_stand, brewingStandItem2);
		ECItems.replaceItem(Items.potionitem, potion2);
		ECItems.replaceItem(Items.glass_bottle, glassBottle2);

		ECCrafting.addRecipe(StackFactory.create(brewingStandItem2), " b ", "SSS", 'b', Items.blaze_rod, 'S',
		                     Blocks.cobblestone);
		ECCrafting.addRecipe(StackFactory.create(glassBottle2, 3), "G G", " G ", 'G', ECStacks.glass_block);

		ECEntities
			.registerProperties(new ECEntities.EntityProperties(ExtendedInventory.IDENTIFIER, ExtendedInventory.class)
			{
				@Override
				public boolean canApply(Entity entity)
				{
					return entity instanceof EntityPlayer;
				}

				@Override
				public IExtendedEntityProperties createProperties(Entity entity)
				{
					return new ExtendedInventory((EntityPlayer) entity);
				}
			});
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);

		FurnaceRecipeLoader.instance.load();

		PotionList.init();

		if (BrewingAPI.multiPotions)
		{
			multiPotions = new CreativeTabs("mixedpotions")
			{
				ItemStack stack;

				@Override
				public ItemStack getIconItemStack()
				{
					if (this.stack != null)
					{
						return this.stack;
					}
					return this.stack = PotionList.damageBoost.apply(new ItemStack(potion2, 0, 1));
				}

				@Override
				public Item getTabIconItem()
				{
					return null;
				}
			};
		}

		GameRegistry.registerTileEntity(TileEntityBrewingStand2.class, "BrewingStand2");
		ECEntities.replace(EntityPotion.class, EntityPotion2.class);

		BlockDispenser.dispenseBehaviorRegistry.putObject(potion2, new PotionDispenser());
	}

	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}

	@Mod.EventHandler
	public void serverStarted(@SuppressWarnings("UnusedParameters") FMLServerStartedEvent event)
	{
		ServerCommandManager manager = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();

		manager.registerCommand(new CommandModUpdate());
		manager.registerCommand(new CommandPotion());
	}
}
