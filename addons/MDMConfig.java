package clashsoft.mods.moredimensions.addons;

import java.io.File;

import clashsoft.clashsoftapi.util.addons.Addon;

import net.minecraftforge.common.Configuration;

@Addon(modName = "MoreDimensionsMod", addonName = "Config")
public class MDMConfig
{
	public static int	POC_DIMENSION_ID		= 4;
	public static int	DREAMS_DIMENSION_ID		= 5;
	public static int	NIGHTMARES_DIMENSION_ID	= 6;
	
	public static int	tomeID					= 10001;
	public static int	stavesID				= 10002;
	public static int	manaStarID				= 10003;
	public static int	lifeHeartID			= 10004;
	public static int	shannaraSwordID		= 10005;
	public static int	magicShovelID			= 10006;
	public static int	magicPickaxeID			= 10007;
	public static int	magicAxeID				= 10008;
	public static int	magicHoeID				= 10009;
	public static int	elixirID				= 10010;
	public static int	elixirBottleID			= 10011;
	
	public static int	chaosStoneID			= 180;
	public static int	alteredDirtID			= 181;
	public static int	alteredGrassID			= 182;
	public static int	Safflower_ID			= 1003;
	public static int	MagicOakLog_ID			= 1004;
	public static int	MagicOakLeaves_ID		= 1005;
	public static int	magicOakSaplingID		= 1006;
	public static int	portalFrameID			= 1007;
	public static int	portalID				= 1008;
	public static int	alchemyTubeID			= 1009;
	public static int	ores1ID				= 1010;
	public static int	ores2ID				= 1011;
	public static int	willowLogID			= 1028;
	public static int	willowLeavesID			= 1029;
	public static int	willowSaplingID		= 1030;
	
	public static void loadConfig(File configFile)
	{
		Configuration config = new Configuration(configFile);
		config.load();
		
		POC_DIMENSION_ID = config.get("Dimension IDs", "Paradise of Chaos Dimension ID", 4).getInt();
		DREAMS_DIMENSION_ID = config.get("Dimension IDs", "Dream Dimension ID", 5).getInt();
		NIGHTMARES_DIMENSION_ID = config.get("Dimension IDs", "Nightmare Dimension ID", 6).getInt();
		
		tomeID = config.getItem("Tome ID", 10001).getInt();
		stavesID = config.getItem("Staves ID", 10002).getInt();
		manaStarID = config.getItem("Mana Star ID", 10003).getInt();
		shannaraSwordID = config.getItem("Shannara Sword ID", 10005).getInt();
		elixirID = config.getItem("Elixir ID", 10010).getInt();
		elixirBottleID = config.getItem("Elixir Bottle ID", 10011).getInt();
		
		// ChaosStone_ID = config.getBlock("ChaosStone ID", 180).getInt();
		// AlteredDirt_ID = config.getBlock("Altered Dirt ID", 181).getInt();
		// AlteredGrass_ID = config.getBlock("Altered Grass ID", 182).getInt();
		Safflower_ID = config.getBlock("Saf Flower ID", 1003).getInt();
		MagicOakLog_ID = config.getBlock("Magic Oak Log ID", 1004).getInt();
		MagicOakLeaves_ID = config.getBlock("Magic Oak Leaves ID", 1005).getInt();
		magicOakSaplingID = config.getBlock("Magic Oak Sapling ID", 1006).getInt();
		ores1ID = config.getBlock("Ores ID", 1010).getInt();
		ores2ID = config.getBlock("Ores 2 ID", 1011).getInt();
		willowLogID = config.getBlock("Willow Log ID", 1028).getInt();
		willowLeavesID = config.getBlock("WillowLeaves_ID", 1029).getInt();
		willowSaplingID = config.getBlock("WillowSapling_ID", 1030).getInt();
		
		config.save();
	}
}
