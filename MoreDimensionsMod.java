package clashsoft.mods.moredimensions;

import java.util.Random;

import clashsoft.clashsoftapi.util.CSUpdate;
import clashsoft.mods.moredimensions.addons.MDMHeaven;
import clashsoft.mods.moredimensions.common.CommonProxy;
import clashsoft.mods.moredimensions.world.WorldProviderHeaven;
import clashsoft.mods.moredimensions.world.gen.HeavenGenBuildings;
import clashsoft.mods.moredimensions.world.gen.WorldGenTreesMoreDimensions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

@Mod(modid = "MoreDimensionsMod", name = "More Dimensions Mod", version = MoreDimensionsMod.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreDimensionsMod
{
	public static final int			REVISION		= 0;
	public static final String		VERSION			= CSUpdate.CURRENT_VERSION + "-" + REVISION;
	
	@Instance("MoreDimensionsMod")
	public static MoreDimensionsMod	instance;
	
	@SidedProxy(clientSide = "clashsoft.mods.moredimensions.client.ClientProxy", serverSide = "clashsoft.mods.moredimensions.common.CommonProxy")
	public static CommonProxy		proxy;
	
	public static int				HEAVEN_ID		= DimensionManager.getNextFreeDimId();
	
	public static int				HEAVEN_BIOME_ID	= 30;
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		MDMHeaven.load();
		
		DimensionManager.registerProviderType(HEAVEN_ID, WorldProviderHeaven.class, true);
		DimensionManager.registerDimension(HEAVEN_ID, HEAVEN_ID);
		DimensionManager.createProviderFor(HEAVEN_ID);
	}
	
	public MoreDimensionsMod()
	{	
	}
	
	public static void generateHeaven(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(250);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenTreesMoreDimensions(true, 6, MDMHeaven.heavenLog.blockID, MDMHeaven.heavenLeaves.blockID, 0, 0, false)).generate(world, rand, randPosX, randPosY, randPosZ);
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