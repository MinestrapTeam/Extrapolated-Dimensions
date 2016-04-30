package minestrapteam.extracore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import minestrapteam.extracore.block.ECBlocks;
import minestrapteam.extracore.block.ore.BlockOre2;
import minestrapteam.extracore.block.ore.BlockRedstoneOre2;
import minestrapteam.extracore.block.ore.OreBase;
import minestrapteam.extracore.cape.Capes;
import minestrapteam.extracore.command.CommandModUpdate;
import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extracore.crafting.ECCrafting;
import minestrapteam.extracore.crafting.loader.FurnaceRecipeLoader;
import minestrapteam.extracore.entity.ECEntities;
import minestrapteam.extracore.init.ClashsoftMod;
import minestrapteam.extracore.item.block.ItemCustomBlock;
import minestrapteam.extracore.network.ECNetHandler;
import minestrapteam.extracore.proxy.ECProxy;
import minestrapteam.extracore.util.Log4JLogger;
import minestrapteam.extracore.util.logging.ECLog;
import minestrapteam.extracore.util.update.ECUpdate;
import minestrapteam.extracore.util.update.reader.SimpleUpdateReader;
import minestrapteam.extracore.util.update.updater.ModUpdater;
import minestrapteam.extracore.world.gen.CustomCaveGen;
import net.minecraft.block.Block;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;

import java.io.File;

@Mod(modid = ExtraCore.MODID, name = ExtraCore.NAME, version = ExtraCore.VERSION)
public class ExtraCore extends ClashsoftMod
{
	public static final String	MODID			= "cslib";
	public static final String	NAME			= "Clashsoft Lib";
	public static final String	ACRONYM			= "cslib";
	public static final String	VERSION			= "1.7.10-2.7.3";
	public static final String	DEPENDENCY		= "required-after:" + MODID;
	
	public static boolean		workspaceMode;
	
	static
	{
		ECLog.logger = new Log4JLogger();
		
		File file = new File(".");
		String path = file.getAbsolutePath();
		if (path.endsWith("run/.") || path.endsWith("assets/."))
		{
			workspaceMode = true;
			ECLog.info("Clashsoft Lib is now running in Dev Workspace mode.");
		}
	}
	
	@Instance(MODID)
	public static ExtraCore instance;
	
	public static ECProxy proxy = createProxy("minestrapteam.extracore.client.ECClientProxy", "minestrapteam.extracore.proxy.ECProxy");
	
	public static Block			coalOre2		= new BlockOre2(OreBase.TYPE_OVERWORLD).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreCoal").setBlockTextureName("cslib:coal_overlay");
	public static Block			ironOre2		= new BlockOre2(OreBase.TYPE_OVERWORLD).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreIron").setBlockTextureName("cslib:iron_overlay");
	public static Block			goldOre2		= new BlockOre2(OreBase.TYPE_OVERWORLD).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreGold").setBlockTextureName("cslib:gold_overlay");
	public static Block			diamondOre2		= new BlockOre2(OreBase.TYPE_OVERWORLD).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreDiamond").setBlockTextureName("cslib:diamond_overlay");
	public static Block			emeraldOre2		= new BlockOre2(OreBase.TYPE_OVERWORLD).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreEmerald").setBlockTextureName("cslib:emerald_overlay");
	public static Block			redstoneOre2	= new BlockRedstoneOre2(OreBase.TYPE_OVERWORLD, false).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreRedstone").setBlockTextureName("cslib:redstone_overlay");
	public static Block			litRedstoneOre2	= new BlockRedstoneOre2(OreBase.TYPE_OVERWORLD, true).setLightLevel(0.625F).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreRedstone").setBlockTextureName("cslib:redstone_overlay");
	public static Block			lapisOre2		= new BlockOre2(OreBase.TYPE_OVERWORLD).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("oreLapis").setBlockTextureName("cslib:lapis_overlay");
	public static Block			quartzOre2		= new BlockOre2(OreBase.TYPE_NETHER).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundTypePiston).setBlockName("netherquartz").setBlockTextureName("cslib:quartz_overlay");
	
	public static boolean		printUpdateNotes;
	public static boolean		updateCheck;
	public static boolean		autoUpdate;
	public static boolean		enableMOTD;
	
	public ExtraCore()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.hasConfig = true;
		this.netHandler = new ECNetHandler();
		this.eventHandler = this;
		this.url = "https://github.com/Clashsoft/ExtraCore-Minecraft/wiki/";
		this.description = "Clashsoft's Minecraft Library adds many useful Classes and APIs for modders to use.";
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
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		FurnaceRecipeLoader.instance.load();
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	@EventHandler
	public void serverStarted(FMLServerStartedEvent event)
	{
		ServerCommandManager manager = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
		
		manager.registerCommand(new CommandModUpdate());
	}
	
	@SubscribeEvent
	public void entityJoined(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			Capes.updateCape(player);
		}
	}
	
	@SubscribeEvent
	public void entityConstructing(EntityConstructing event)
	{
		ECEntities.loadProperties(event.entity);
	}
	
	@SubscribeEvent
	public void playerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (proxy.isClient())
		{
			ECUpdate.notifyAll(event.player);
		}
	}
	
	@SubscribeEvent
	public void getModdedMapGen(InitMapGenEvent event)
	{
		if (event.type == EventType.CAVE)
		{
			event.newGen = new CustomCaveGen();
		}
	}
}
