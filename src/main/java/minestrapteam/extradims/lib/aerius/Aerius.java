package minestrapteam.extradims.lib.aerius;

import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extradims.biome.aerius.*;
import minestrapteam.extradims.lib.aerius.ABlocks;
import minestrapteam.extradims.lib.aerius.AInventory;
import minestrapteam.extradims.lib.aerius.AItems;
import minestrapteam.extradims.lib.aerius.ARecipes;
import minestrapteam.extradims.world.aerius.WorldProviderAerius;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class Aerius
{
	public static final String TEXTURE_DOMAIN = "ed_aerius";
	public static final String TEXTURE_PREFIX = TEXTURE_DOMAIN + ":";

	public static int AERIUS_ID = 8;

	public static BiomeGenBase biomeAerius;
	public static BiomeGenBase biomeAerianForest;
	public static BiomeGenBase biomeAerianJungle;
	public static BiomeGenBase biomeHallow;
	public static BiomeGenBase biomeCorruption;

	public static BiomeGenBase[] aeriusBiomes;

	public static void init()
	{
		AItems.initItems();
		ABlocks.initBlocks();

		AItems.registerItems();
		ABlocks.registerBlocks();

		AItems.initStacks();
		ABlocks.initStacks();

		ARecipes.addRecipes();

		ABlocks.leafBlocks.setSaplingStacks(ABlocks.skybarkSapling, ABlocks.darkSkybarkSapling)
		                  .setAppleStacks(new ItemStack(AItems.aerianApple), null, null, null);
		ABlocks.leafBlocks2.setSaplingStacks(ABlocks.cloudrootSapling, ABlocks.goldWoodSapling, ABlocks.magicOakSapling,
		                                     ABlocks.willowSapling);

		AInventory.load();

		// World and Dimension Management

		AERIUS_ID = ECConfig.getDimension("Aerius", AERIUS_ID);
		DimensionManager.registerProviderType(AERIUS_ID, WorldProviderAerius.class, true);
		DimensionManager.registerDimension(AERIUS_ID, AERIUS_ID);

		biomeAerius = new BiomeAerius(ECConfig.getBiome("Aerius", 60)).setBiomeName("Aerius");
		biomeAerianForest = new BiomeAeriusForest(ECConfig.getBiome("Aerian Forest", 61)).setBiomeName("Aerian Forest");
		biomeAerianJungle = new BiomeAeriusJungle(ECConfig.getBiome("Aerian Jungle", 62)).setBiomeName("Aerian Jungle");
		biomeHallow = new BiomeHallow(ECConfig.getBiome("Hallow", 63)).setBiomeName("Hallow");
		biomeCorruption = new BiomeCorruption(ECConfig.getBiome("Corruption", 64)).setBiomeName("Corruption");

		aeriusBiomes = new BiomeGenBase[] { biomeAerius, biomeAerianForest, biomeAerianJungle, biomeHallow,
			biomeCorruption };
	}

	public static String getTexture(String name)
	{
		return TEXTURE_PREFIX + name;
	}
}
