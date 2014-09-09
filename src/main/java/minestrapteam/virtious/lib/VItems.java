package minestrapteam.virtious.lib;

import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.ItemCustomBucket;
import clashsoft.cslib.minecraft.item.ItemCustomDoor;
import minestrapteam.virtious.Virtious;
import minestrapteam.virtious.item.*;

import net.minecraft.item.*;

public class VItems
{
	public static Item	brazeum_ingot;
	public static Item	aquieus_shard;
	public static Item	pluthorium_gem;
	public static Item	illuminous_gem;
	public static Item	tak;
	
	public static Item	virtianwood_sword;
	public static Item	virtianwood_shovel;
	public static Item	virtianwood_pickaxe;
	public static Item	virtianwood_axe;
	public static Item	virtianwood_hoe;
	
	public static Item	amberwood_sword;
	public static Item	amberwood_shovel;
	public static Item	amberwood_pickaxe;
	public static Item	amberwood_axe;
	public static Item	amberwood_hoe;
	
	public static Item	virtianstone_sword;
	public static Item	virtianstone_shovel;
	public static Item	virtianstone_pickaxe;
	public static Item	virtianstone_axe;
	public static Item	virtianstone_hoe;
	
	public static Item	deepstone_sword;
	public static Item	deepstone_shovel;
	public static Item	deepstone_pickaxe;
	public static Item	deepstone_axe;
	public static Item	deepstone_hoe;
	
	public static Item	brazeum_sword;
	public static Item	brazeum_shovel;
	public static Item	brazeum_pickaxe;
	public static Item	brazeum_axe;
	public static Item	brazeum_hoe;
	
	public static Item	aquieus_sword;
	public static Item	aquieus_shovel;
	public static Item	aquieus_pickaxe;
	public static Item	aquieus_axe;
	public static Item	aquieus_hoe;
	
	public static Item	pluthorium_pickaxe;
	public static Item	pluthorium_axe;
	public static Item	pluthorium_shovel;
	public static Item	pluthorium_hoe;
	public static Item	pluthorium_sword;
	
	public static Item	teleporter_wand;
	public static Item	amberwood_fishing_rod;
	public static Item	sticky_bomb;
	public static Item laser_pistol;
	public static Item	laser_rifle;
	public static Item	acid_bucket;
	
	public static Item	burhaunch_cooked;
	public static Item	burhaunch_raw;
	public static Item	evulus_fish;
	public static Item	vois_food;
	public static Item	binnegan_fruit;
	public static Item	veer_seeds;
	public static Item	veer_dye;
	
	public static Item	cytoid_door;
	
	public static void init()
	{
		brazeum_ingot = new Item().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("brazeum_ingot"));
		aquieus_shard = new Item().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("aquieus_shard"));
		pluthorium_gem = new Item().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("pluthorium_gem"));
		illuminous_gem = new Item().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("illuminous_gem"));
		tak = new Item().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("tak"));
		
		virtianwood_sword = new ItemSword(VToolMaterials.VIRTIANWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianwood_sword"));
		virtianwood_shovel = new VItemShovel(VToolMaterials.VIRTIANWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianwood_shovel"));
		virtianwood_pickaxe = new VItemPickaxe(VToolMaterials.VIRTIANWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianwood_pickaxe"));
		virtianwood_axe = new VItemAxe(VToolMaterials.VIRTIANWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianwood_axe"));
		virtianwood_hoe = new ItemHoe(VToolMaterials.VIRTIANWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianwood_hoe"));
		
		amberwood_sword = new ItemSword(VToolMaterials.AMBERWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("amberwood_sword"));
		amberwood_shovel = new VItemShovel(VToolMaterials.AMBERWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("amberwood_shovel"));
		amberwood_pickaxe = new VItemPickaxe(VToolMaterials.AMBERWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("amberwood_pickaxe"));
		amberwood_axe = new VItemAxe(VToolMaterials.AMBERWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("amberwood_axe"));
		amberwood_hoe = new ItemHoe(VToolMaterials.AMBERWOOD).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("amberwood_hoe"));
		
		virtianstone_sword = new ItemSword(VToolMaterials.VIRTIANSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianstone_sword"));
		virtianstone_shovel = new VItemShovel(VToolMaterials.VIRTIANSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianstone_shovel"));
		virtianstone_pickaxe = new VItemPickaxe(VToolMaterials.VIRTIANSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianstone_pickaxe"));
		virtianstone_axe = new VItemAxe(VToolMaterials.VIRTIANSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianstone_axe"));
		virtianstone_hoe = new ItemHoe(VToolMaterials.VIRTIANSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("virtianstone_hoe"));
		
		deepstone_sword = new ItemSword(VToolMaterials.DEEPSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("deepstone_sword"));
		deepstone_shovel = new VItemShovel(VToolMaterials.DEEPSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("deepstone_shovel"));
		deepstone_pickaxe = new VItemPickaxe(VToolMaterials.DEEPSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("deepstone_pickaxe"));
		deepstone_axe = new VItemAxe(VToolMaterials.DEEPSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("deepstone_axe"));
		deepstone_hoe = new ItemHoe(VToolMaterials.DEEPSTONE).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("deepstone_hoe"));
		
		brazeum_sword = new ItemSword(VToolMaterials.BRAZEUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("brazeum_sword"));
		brazeum_shovel = new VItemShovel(VToolMaterials.BRAZEUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("brazeum_shovel"));
		brazeum_pickaxe = new VItemPickaxe(VToolMaterials.BRAZEUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("brazeum_pickaxe"));
		brazeum_axe = new VItemAxe(VToolMaterials.BRAZEUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("brazeum_axe"));
		brazeum_hoe = new ItemHoe(VToolMaterials.BRAZEUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("brazeum_hoe"));
		
		aquieus_sword = new ItemSword(VToolMaterials.AQUIEUS).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("aquieus_sword"));
		aquieus_shovel = new VItemShovel(VToolMaterials.AQUIEUS).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("aquieus_shovel"));
		aquieus_pickaxe = new VItemPickaxe(VToolMaterials.AQUIEUS).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("aquieus_pickaxe"));
		aquieus_axe = new VItemAxe(VToolMaterials.AQUIEUS).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("aquieus_axe"));
		aquieus_hoe = new ItemHoe(VToolMaterials.AQUIEUS).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("aquieus_hoe"));
		
		pluthorium_sword = new ItemSword(VToolMaterials.AQUIEUS).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("pluthorium_sword"));
		pluthorium_shovel = new VItemShovel(VToolMaterials.PLUTHORIUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("pluthorium_shovel"));
		pluthorium_pickaxe = new VItemPickaxe(VToolMaterials.PLUTHORIUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("pluthorium_pickaxe"));
		pluthorium_axe = new VItemAxe(VToolMaterials.PLUTHORIUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("pluthorium_axe"));
		pluthorium_hoe = new ItemHoe(VToolMaterials.PLUTHORIUM).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("pluthorium_hoe"));
		
		teleporter_wand = new ItemTeleporter().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("teleporter_wand"));
		amberwood_fishing_rod = new ItemFishingRod().setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("amberwood_rod"));
		sticky_bomb = new ItemStickyBomb().setCreativeTab(Virtious.tabVirtiousItems);
		laser_pistol = new ItemGun(2000, 4, 2, "").setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("laser_pistol"));
		laser_rifle = new ItemGun(3000, 2, 1, "").setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("laser_rifle"));
		acid_bucket = new ItemCustomBucket(VBlocks.virtious_acid).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("acid_bucket"));
		
		burhaunch_cooked = new ItemFood(4, 0.4F, true).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("burhaunch_cooked"));
		burhaunch_raw = new ItemFood(9, 0.8F, true).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("burhaunch_raw"));
		evulus_fish = new ItemFood(5, 0.5F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("evulus_fish"));
		vois_food = new ItemFood(5, 0.25F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("vois_food"));
		binnegan_fruit = new ItemFood(3, 0.25F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("binnegan"));
		veer_seeds = new ItemReed(VBlocks.veer_crops).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("veer_seeds"));
		veer_dye = new ItemFood(1, 0.3F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("veer"));
		
		cytoid_door = new ItemCustomDoor(VBlocks.cytoid_door).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("cytoid_door"));
	}
	
	public static void load()
	{
		CSItems.addItem(brazeum_ingot, "brazeum_ingot");
		CSItems.addItem(aquieus_shard, "aquieus_shard");
		CSItems.addItem(pluthorium_gem, "pluthorium_gem");
		CSItems.addItem(illuminous_gem, "illuminous_gem");
		CSItems.addItem(tak, "tak");
		
		CSItems.addItem(virtianwood_sword, "virtianwood_sword");
		CSItems.addItem(virtianwood_shovel, "virtianwood_shovel");
		CSItems.addItem(virtianwood_pickaxe, "virtianwood_pickaxe");
		CSItems.addItem(virtianwood_axe, "virtianwood_axe");
		CSItems.addItem(virtianwood_hoe, "virtianwood_hoe");
		
		CSItems.addItem(amberwood_sword, "amberwood_sword");
		CSItems.addItem(amberwood_shovel, "amberwood_shovel");
		CSItems.addItem(amberwood_pickaxe, "amberwood_pickaxe");
		CSItems.addItem(amberwood_axe, "amberwood_axe");
		CSItems.addItem(amberwood_hoe, "amberwood_hoe");
		
		CSItems.addItem(virtianstone_sword, "virtianstone_sword");
		CSItems.addItem(virtianstone_shovel, "virtianstone_shovel");
		CSItems.addItem(virtianstone_pickaxe, "virtianstone_pickaxe");
		CSItems.addItem(virtianstone_axe, "virtianstone_axe");
		CSItems.addItem(virtianstone_hoe, "virtianstone_hoe");
		
		CSItems.addItem(deepstone_sword, "deepstone_sword");
		CSItems.addItem(deepstone_shovel, "deepstone_shovel");
		CSItems.addItem(deepstone_pickaxe, "deepstone_pickaxe");
		CSItems.addItem(deepstone_axe, "deepstone_axe");
		CSItems.addItem(deepstone_hoe, "deepstone_hoe");
		
		CSItems.addItem(brazeum_sword, "brazeum_sword");
		CSItems.addItem(brazeum_shovel, "brazeum_shovel");
		CSItems.addItem(brazeum_pickaxe, "brazeum_pickaxe");
		CSItems.addItem(brazeum_axe, "brazeum_axe");
		CSItems.addItem(brazeum_hoe, "brazeum_hoe");
		
		CSItems.addItem(aquieus_sword, "aquieus_sword");
		CSItems.addItem(aquieus_shovel, "aquieus_shovel");
		CSItems.addItem(aquieus_pickaxe, "aquieus_pickaxe");
		CSItems.addItem(aquieus_axe, "aquieus_axe");
		CSItems.addItem(aquieus_hoe, "aquieus_hoe");
		
		CSItems.addItem(pluthorium_pickaxe, "pluthorium_pickaxe");
		CSItems.addItem(pluthorium_axe, "pluthorium_axe");
		CSItems.addItem(pluthorium_shovel, "pluthorium_shovel");
		CSItems.addItem(pluthorium_hoe, "pluthorium_hoe");
		CSItems.addItem(pluthorium_sword, "pluthorium_sword");
		
		CSItems.addItem(teleporter_wand, "teleporter_wand");
		CSItems.addItem(amberwood_fishing_rod, "amberwood_fishing_rod");
		CSItems.addItem(sticky_bomb, "sticky_bomb");
		CSItems.addItem(laser_pistol, "laser_pistol");
		CSItems.addItem(laser_rifle, "laser_rifle");
		CSItems.addItem(acid_bucket, "acid_bucket");
		
		CSItems.addItem(burhaunch_cooked, "burhaunch_cooked");
		CSItems.addItem(burhaunch_raw, "burhaunch_raw");
		CSItems.addItem(evulus_fish, "evulus_fish");
		CSItems.addItem(vois_food, "vois_food");
		CSItems.addItem(binnegan_fruit, "binnegan_fruit");
		CSItems.addItem(veer_seeds, "veer_seeds");
		CSItems.addItem(veer_dye, "veer_dye");
		
		CSItems.addItem(cytoid_door, "cytoid_door_item");
	}
	
	public static String getTexture(String name)
	{
		return "virtious:" + name;
	}
}
