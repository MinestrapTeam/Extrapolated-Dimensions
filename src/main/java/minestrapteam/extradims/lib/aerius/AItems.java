package minestrapteam.extradims.lib.aerius;

import minestrapteam.extracore.item.*;
import minestrapteam.extracore.util.StringUtils;
import minestrapteam.extradims.item.ArmorTypes;
import minestrapteam.extradims.item.aerius.*;
import net.minecraft.item.*;

import static minestrapteam.extradims.lib.aerius.AInventory.*;
import static minestrapteam.extradims.lib.aerius.Aerius.*;
import static net.minecraftforge.common.util.EnumHelper.addArmorMaterial;
import static net.minecraftforge.common.util.EnumHelper.addToolMaterial;

public class AItems
{
	// Tool and Armor Materials

	//	public static Item.ToolMaterial toolHeavenWood  = addToolMaterial("HEAVENWOOD", 0, 64, 1F, 1F, 14);
	//	public static Item.ToolMaterial toolHeavenStone = addToolMaterial("HEAVENSTONE", 1, 64, 2F, 2, 12);
	public static Item.ToolMaterial toolPro  = addToolMaterial("PRO", 3, 4096, 10F, 10F, 10);
	public static Item.ToolMaterial toolFire = addToolMaterial("FIRE", 2, 416, 3.5F, 4F, 8);
	//	public static Item.ToolMaterial toolWillow      = addToolMaterial("WILLOW", 0, 100, 1.2F, 1.5F, 16);
	//	public static Item.ToolMaterial toolGoldwood    = Item.ToolMaterial.GOLD;

	public static ItemArmor.ArmorMaterial armorPro = addArmorMaterial("PRO", 512, new int[] { 7, 18, 14, 7 }, 10);

	// ----- Items -----

	public static CustomItem      stickItems;
	public static CustomItem      materialItems;
	public static ItemAeriusLoot  lootItems;
	public static ItemAeriusSeeds seedItems;
	public static ItemFood        aerianApple;
	public static ItemAeriusSoul  soul;

	// Weapons
	public static ItemFireSword fireSword;
	public static ItemSword     proSword;

	// Tools
	public static ItemIceHammer iceHammer;
	public static ItemPickaxe   proPickaxe;
	public static ItemSpade     proShovel;
	public static ItemAxe       proAxe;
	public static ItemHoe       proHoe;

	// Accessories
	public static ItemCustomArmor       proHelmet;
	public static ItemCustomArmor       proChestplate;
	public static ItemCustomArmor       proLeggings;
	public static ItemCustomArmor       proBoots;
	public static ItemCustomArmor       proGloves;
	public static ItemCape              capes;
	public static ItemAeriusAccessories accessories;
	public static ItemGem               lifeGem;
	public static ItemGem               manaGem;
	public static ItemGem               amnethiteParagonGem;

	// ----- Item Stacks -----

	public static ItemStack skybarkStick;
	public static ItemStack darkSkybarkStick;
	public static ItemStack cloudrootStick;
	public static ItemStack goldWoodStick;
	public static ItemStack magicOakStick;
	public static ItemStack willowStick;
	public static ItemStack iceStick;
	public static ItemStack manaStar;
	public static ItemStack lifeHeart;
	public static ItemStack aerwand;
	public static ItemStack luminiteChunk;
	public static ItemStack whiteGoldIngot;
	public static ItemStack condaiusDust;
	public static ItemStack holiumIngot;
	public static ItemStack proAlloy;

	public static void initItems()
	{
		String[] woodTypes = { "skybark", "dark_skybark", "cloudroot", "gold_wood", "magic_oak", "willow" };

		// Items

		stickItems = new CustomItem(woodTypes,
		                            StringUtils.concatAll(woodTypes, TEXTURE_PREFIX + "materials/", "_stick"), null);

		final String[] materialNames = { "luminite", "copper_ingot", "white_gold_ingot", "holium_ingot",
			"condaius_dust", "amnethite_gem", "obsidian_ingot", "pro_ingot" };
		materialItems = new CustomItem(materialNames,
		                               StringUtils.concatAll(materialNames, TEXTURE_PREFIX + "minerals/", ""), null);

		lootItems = new ItemAeriusLoot(new String[] { "ice_stick", "gold_ball", "life_heart", "mana_star", "aerwand",
			"etherical_stone", "bottle_light", "hephaestos_flame", "chains" });

		aerianApple = (ItemFood) new ItemFood(2, 0, false).setTextureName(getTexture("food/aerian_apple"))
		                                                  .setCreativeTab(tabAeriusItems);

		soul = (ItemAeriusSoul) new ItemAeriusSoul().setCreativeTab(tabAeriusItems);

		String[] seeds = new String[] { "aerian_grass", "mud_grass", "corrupted_grass", "hallowed_grass",
			"mushroom_grass" };
		seedItems = new ItemAeriusSeeds(seeds, StringUtils.concatAll(seeds, "ed_aerius:food/", "_seeds"));

		// Weapons

		proSword = (ItemSword) new ItemSword(toolPro).setTextureName(getTexture("weapons/pro/pro_sword"))
		                                             .setCreativeTab(tabAeriusTools);
		fireSword = (ItemFireSword) new ItemFireSword(toolFire).setTextureName(getTexture("weapons/fire_sword"))
		                                                       .setCreativeTab(tabAeriusTools);

		// Tools

		iceHammer = (ItemIceHammer) new ItemIceHammer().setTextureName(getTexture("tools/ice_hammer"))
		                                               .setCreativeTab(tabAeriusTools);
		proPickaxe = (ItemPickaxe) new ItemCustomPickaxe(toolPro).setTextureName(getTexture("tools/pro/pro_pickaxe"))
		                                                         .setCreativeTab(tabAeriusTools);
		proShovel = (ItemSpade) new ItemSpade(toolPro).setTextureName(getTexture("tools/pro/pro_shovel"))
		                                              .setCreativeTab(tabAeriusTools);
		proAxe = (ItemAxe) new ItemCustomAxe(toolPro).setTextureName(getTexture("tools/pro/pro_axe"))
		                                             .setCreativeTab(tabAeriusTools);
		proHoe = (ItemHoe) new ItemHoe(toolPro).setTextureName(getTexture("tools/pro/pro_hoe"))
		                                       .setCreativeTab(tabAeriusTools);

		// Accessories

		proHelmet = (ItemCustomArmor) new ItemCustomArmor(armorPro, TEXTURE_DOMAIN, "pro", ArmorTypes.HELMET)
			                              .setTextureName(getTexture("armor/pro/pro_helmet"))
			                              .setCreativeTab(tabAeriusEquipment);
		proChestplate = (ItemCustomArmor) new ItemCustomArmor(armorPro, TEXTURE_DOMAIN, "pro", ArmorTypes.CHESTPLATE)
			                                  .setTextureName(getTexture("armor/pro/pro_chestplate"))
			                                  .setCreativeTab(tabAeriusEquipment);
		proLeggings = (ItemCustomArmor) new ItemCustomArmor(armorPro, TEXTURE_DOMAIN, "pro", ArmorTypes.LEGGINGS)
			                                .setTextureName(getTexture("armor/pro/pro_leggings"))
			                                .setCreativeTab(tabAeriusEquipment);
		proBoots = (ItemCustomArmor) new ItemCustomArmor(armorPro, TEXTURE_DOMAIN, "pro", ArmorTypes.BOOTS)
			                             .setTextureName(getTexture("armor/pro/pro_boots"))
			                             .setCreativeTab(tabAeriusEquipment);
		proGloves = (ItemCustomArmor) new ItemCustomArmor(armorPro, TEXTURE_DOMAIN, "pro", ArmorTypes.GLOVES)
			                              .setTextureName(getTexture("armor/pro/pro_gloves"))
			                              .setCreativeTab(tabAeriusEquipment);

		capes = (ItemCape) new ItemCape().setUnlocalizedName("cape").setCreativeTab(tabAeriusEquipment);
		accessories = (ItemAeriusAccessories) new ItemAeriusAccessories().setCreativeTab(tabAeriusEquipment);
		lifeGem = (ItemGem) new ItemGem(ItemArmor.ArmorMaterial.DIAMOND).setTextureName(getTexture("loot/life_gem"))
		                                                                .setCreativeTab(tabAeriusEquipment);
		manaGem = (ItemGem) new ItemGem(ItemArmor.ArmorMaterial.DIAMOND).setTextureName(getTexture("loot/mana_gem"))
		                                                                .setCreativeTab(tabAeriusEquipment);
		amnethiteParagonGem = (ItemGem) new ItemGem(ItemArmor.ArmorMaterial.DIAMOND)
			                                .setTextureName(getTexture("loot/amnethite_paragon_gem"))
			                                .setCreativeTab(tabAeriusEquipment);
	}

	public static void registerItems()
	{
		materialItems.setCreativeTab(tabAeriusItems);
		lootItems.setCreativeTab(tabAeriusItems);
		stickItems.setCreativeTab(tabAeriusItems);
		seedItems.setCreativeTab(tabAeriusItems);

		ECItems.addItem(stickItems, "aerius_sticks");
		ECItems.addItem(materialItems, "aerius_materials");
		ECItems.addItem(seedItems, "aerius_seeds");
		ECItems.addItem(lootItems, "aerius_loot");
		ECItems.addItem(aerianApple, "aerian_apple");

		ECItems.addItem(proSword, "pro_sword");
		ECItems.addItem(proPickaxe, "pro_pickaxe");
		ECItems.addItem(proShovel, "pro_shovel");
		ECItems.addItem(proAxe, "pro_axe");
		ECItems.addItem(proHoe, "pro_hoe");
		ECItems.addItem(fireSword, "fire_sword");
		ECItems.addItem(iceHammer, "ice_hammer");

		ECItems.addItem(proHelmet, "pro_helmet");
		ECItems.addItem(proChestplate, "pro_chestplate");
		ECItems.addItem(proLeggings, "pro_leggings");
		ECItems.addItem(proBoots, "pro_boots");
		ECItems.addItem(proGloves, "pro_gloves");

		ECItems.addItem(capes, "cape");
		ECItems.addItem(accessories, "aerius_accessories");
		ECItems.addItem(lifeGem, "life_gem");
		ECItems.addItem(manaGem, "mana_gem");
		ECItems.addItem(amnethiteParagonGem, "amnethite_paragon_gem");
	}

	public static void initStacks()
	{
		skybarkStick = new ItemStack(stickItems, 1, 0);
		darkSkybarkStick = new ItemStack(stickItems, 1, 1);
		cloudrootStick = new ItemStack(stickItems, 1, 2);
		goldWoodStick = new ItemStack(stickItems, 1, 3);
		magicOakStick = new ItemStack(stickItems, 1, 4);
		willowStick = new ItemStack(stickItems, 1, 5);

		luminiteChunk = new ItemStack(materialItems, 1, 0);
		whiteGoldIngot = new ItemStack(materialItems, 1, 2);
		holiumIngot = new ItemStack(materialItems, 1, 3);
		condaiusDust = new ItemStack(materialItems, 1, 4);
		proAlloy = new ItemStack(materialItems, 1, 7);

		iceStick = new ItemStack(lootItems, 1, 0);
		lifeHeart = new ItemStack(lootItems, 1, 2);
		manaStar = new ItemStack(lootItems, 1, 3);
		aerwand = new ItemStack(lootItems, 1, 4);
	}
}
