package clashsoft.mods.moredimensions;

import java.util.Random;

import clashsoft.clashsoftapi.util.CSUpdate;
import clashsoft.mods.moredimensions.addons.*;
import clashsoft.mods.moredimensions.common.CommonProxy;
import clashsoft.mods.moredimensions.lib.POCEvents;
import clashsoft.mods.moredimensions.lib.POCPacketHandler;
import clashsoft.mods.moredimensions.world.gen.HeavenGenBuildings;
import clashsoft.mods.moredimensions.world.gen.WorldGenTreesMoreDimensions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "MoreDimensionsMod", name = "More Dimensions Mod", version = MoreDimensionsMod.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreDimensionsMod
{
	public static final int			REVISION	= 0;
	public static final String		VERSION		= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance("MoreDimensionsMod")
	public static MoreDimensionsMod	instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moredimensions.client.ClientProxy", serverSide = "clashsoft.mods.moredimensions.common.CommonProxy")
	public static CommonProxy		proxy;
	
	public static POCPacketHandler	packetHandler;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MDMConfig.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		MinecraftForge.EVENT_BUS.register(new POCEvents());
		
		packetHandler = new POCPacketHandler();
		packetHandler.registerChannels();
		
		MDMObjects.load();
		MDMEntitys.load();
		MDMRecipes.load();
		MDMWorld.load();
		MDMLocalizations.load();
		
		proxy.registerRenderers();
		proxy.registerEntityRenderers();
		proxy.registerClientEvents();
		proxy.postRegisterRenderers();
	}
	
	public static void generateHeaven(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenTreesMoreDimensions(true, 6, MDMBlocks.heavenLog.blockID, MDMBlocks.heavenLeaves.blockID, 0, 0, false)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
		for (int i = 0; i < 5; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new HeavenGenBuildings().new HeavenGenBuilding1()).generate(world, rand, randPosX, randPosZ, randPosY);
		}
	}
}