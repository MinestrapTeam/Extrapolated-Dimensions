package minestrapteam.extradims.lib.aerius;

import net.minecraft.item.ItemStack;

import static minestrapteam.extracore.crafting.ECCrafting.*;

public class ARecipes
{
	public static void addRecipes()
	{
		registerOre(ABlocks.logBlocks, "logWood");
		registerOre(ABlocks.logBlocks2, "logWood");
		registerOre(ABlocks.plankBlocks, "plankWood");
		registerOre(ABlocks.aerock, "stone");
		registerOre(ABlocks.jungleAerock, "stone");
		registerOre(ABlocks.cobbledAerock, "cobblestone");
		registerOre(AItems.stickItems, "stickWood");
		registerOre(AItems.stickItems, "stickAerius");

		addSwordRecipe(new ItemStack(AItems.proSword), AItems.proAlloy, "stickAerius");
		addPickaxeRecipe(new ItemStack(AItems.proPickaxe), AItems.proAlloy, "stickAerius");
		addAxeRecipe(new ItemStack(AItems.proAxe), AItems.proAlloy, "stickAerius");
		addShovelRecipe(new ItemStack(AItems.proShovel), AItems.proAlloy, "stickAerius");
		addHoeRecipe(new ItemStack(AItems.proHoe), AItems.proAlloy, "stickAerius");
		addHelmetRecipe(new ItemStack(AItems.proHelmet), AItems.proAlloy);
		addChestplateRecipe(new ItemStack(AItems.proChestplate), AItems.proAlloy);
		addLeggingsRecipe(new ItemStack(AItems.proLeggings), AItems.proAlloy);
		addBootsRecipe(new ItemStack(AItems.proBoots), AItems.proAlloy);
		addGlovesRecipe(new ItemStack(AItems.proGloves), AItems.proAlloy);

		addPlanks(ABlocks.skybarkPlanks, ABlocks.skybarkLog);
		addPlanks(ABlocks.darkSkybarkPlanks, ABlocks.darkSkybarkLog);
		addPlanks(ABlocks.cloudrootPlanks, ABlocks.cloudrootLog);
		addPlanks(ABlocks.goldWoodPlanks, ABlocks.goldWoodLog);
		addPlanks(ABlocks.magicOakPlanks, ABlocks.magicOakLog);
		addPlanks(ABlocks.willowPlanks, ABlocks.willowLog);

		addStick(AItems.skybarkStick, ABlocks.skybarkPlanks);
		addStick(AItems.darkSkybarkStick, ABlocks.darkSkybarkPlanks);
		addStick(AItems.cloudrootStick, ABlocks.cloudrootPlanks);
		addStick(AItems.goldWoodStick, ABlocks.goldWoodPlanks);
		addStick(AItems.magicOakStick, ABlocks.magicOakPlanks);
		addStick(AItems.willowStick, ABlocks.willowPlanks);

		addFurnaceRecipe(ABlocks.whiteGoldOre, AItems.whiteGoldIngot, 0.2F);
		addFurnaceRecipe(ABlocks.holiumOre, AItems.holiumIngot, 2F);

		addStorageBlock(AItems.luminiteChunk, ABlocks.luminiteBlock, 3);
		addStorageBlock(AItems.whiteGoldIngot, ABlocks.whiteGoldBlock, 3);
		addStorageBlock(AItems.holiumIngot, ABlocks.holiumBlock, 3);
		addStorageBlock(AItems.condaiusDust, ABlocks.condaiusBlock, 3);
		addStorageBlock(AItems.proAlloy, ABlocks.proAlloyBlock, 3);
	}
}
