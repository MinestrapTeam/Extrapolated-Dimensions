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
	
	public static int	Tome_ID					= 10001;
	public static int	Staves_ID				= 10002;
	public static int	ManaStar_ID				= 10003;
	public static int	LifeHeart_ID			= 10004;
	public static int	ShannaraSword_ID		= 10005;
	public static int	MagicShovel_ID			= 10006;
	public static int	MagicPickaxe_ID			= 10007;
	public static int	MagicAxe_ID				= 10008;
	public static int	MagicHoe_ID				= 10009;
	public static int	Elixir_ID				= 10010;
	public static int	ElixirBottle_ID			= 10011;
	
	public static int	ChaosStone_ID			= 180;
	public static int	AlteredDirt_ID			= 181;
	public static int	AlteredGrass_ID			= 182;
	public static int	Safflower_ID			= 1003;
	public static int	MagicOakLog_ID			= 1004;
	public static int	MagicOakLeaves_ID		= 1005;
	public static int	MagicOakSapling_ID		= 1006;
	public static int	PortalFrame_ID			= 1007;
	public static int	Portal_ID				= 1008;
	public static int	AlchemyTube_ID			= 1009;
	public static int	Ores1_ID				= 1010;
	public static int	Ores2_ID				= 1011;
	public static int	WillowLog_ID			= 1028;
	public static int	WillowLeaves_ID			= 1029;
	public static int	WillowSapling_ID		= 1030;
	
	public static void loadConfig(File configFile)
	{
		Configuration config = new Configuration(configFile);
		config.load();
		
		POC_DIMENSION_ID = config.get("Dimension IDs", "Paradise of Chaos Dimension ID", 4).getInt();
		DREAMS_DIMENSION_ID = config.get("Dimension IDs", "Dream Dimension ID", 5).getInt();
		NIGHTMARES_DIMENSION_ID = config.get("Dimension IDs", "Nightmare Dimension ID", 6).getInt();
		
		Tome_ID = config.getItem("Tome ID", 10001).getInt();
		Staves_ID = config.getItem("Staves ID", 10002).getInt();
		ManaStar_ID = config.getItem("Mana Star ID", 10003).getInt();
		ShannaraSword_ID = config.getItem("Shannara Sword ID", 10005).getInt();
		Elixir_ID = config.getItem("Elixir ID", 10010).getInt();
		ElixirBottle_ID = config.getItem("Elixir Bottle ID", 10011).getInt();
		
		// ChaosStone_ID = config.getBlock("ChaosStone ID", 180).getInt();
		// AlteredDirt_ID = config.getBlock("Altered Dirt ID", 181).getInt();
		// AlteredGrass_ID = config.getBlock("Altered Grass ID", 182).getInt();
		Safflower_ID = config.getBlock("Saf Flower ID", 1003).getInt();
		MagicOakLog_ID = config.getBlock("Magic Oak Log ID", 1004).getInt();
		MagicOakLeaves_ID = config.getBlock("Magic Oak Leaves ID", 1005).getInt();
		MagicOakSapling_ID = config.getBlock("Magic Oak Sapling ID", 1006).getInt();
		Ores1_ID = config.getBlock("Ores ID", 1010).getInt();
		Ores2_ID = config.getBlock("Ores 2 ID", 1011).getInt();
		WillowLog_ID = config.getBlock("Willow Log ID", 1028).getInt();
		WillowLeaves_ID = config.getBlock("WillowLeaves_ID", 1029).getInt();
		WillowSapling_ID = config.getBlock("WillowSapling_ID", 1030).getInt();
		
		config.save();
	}
}
