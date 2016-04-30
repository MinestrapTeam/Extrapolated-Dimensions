package minestrapteam.extradims.lib.virtious;

import minestrapteam.extracore.item.ECItems;
import minestrapteam.extracore.item.ItemCustomBucket;
import minestrapteam.extracore.item.ItemCustomDoor;
import minestrapteam.extradims.item.virtious.*;
import minestrapteam.extradims.lib.Virtious;

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
	
	public static Item	pluthorium_sword;
	public static Item	pluthorium_shovel;
	public static Item	pluthorium_pickaxe;
	public static Item	pluthorium_axe;
	public static Item	pluthorium_hoe;
	
	public static Item	teleporter_wand;
	public static Item	amberwood_fishing_rod;
	public static Item	sticky_bomb;
	public static Item	laser_pistol;
	public static Item	laser_rifle;
	public static Item	acid_bucket;

	public static Item	cytoid_door;
	
	public static Item	burhaunch_cooked;
	public static Item	burhaunch_raw;
	public static Item	evulus_fish;
	public static Item	vois_food;
	public static Item	binnegan_fruit;
	public static Item	veer_seeds;
	public static Item	veer_dye;
	
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
		
		cytoid_door = new ItemCustomDoor(VBlocks.cytoid_door).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("cytoid_door"));
		
		burhaunch_cooked = new ItemFood(4, 0.4F, true).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("burhaunch_cooked"));
		burhaunch_raw = new ItemFood(9, 0.8F, true).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("burhaunch_raw"));
		evulus_fish = new ItemFood(5, 0.5F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("evulus_fish"));
		vois_food = new ItemFood(5, 0.25F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("vois_food"));
		binnegan_fruit = new ItemFood(3, 0.25F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("binnegan"));
		veer_seeds = new ItemReed(VBlocks.veer_crops).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("veer_seeds"));
		veer_dye = new ItemFood(1, 0.3F, false).setCreativeTab(Virtious.tabVirtiousItems).setTextureName(getTexture("veer"));
	}
	
	public static void load()
	{
		ECItems.addItem(brazeum_ingot, "brazeum_ingot");
		ECItems.addItem(aquieus_shard, "aquieus_shard");
		ECItems.addItem(pluthorium_gem, "pluthorium_gem");
		ECItems.addItem(illuminous_gem, "illuminous_gem");
		ECItems.addItem(tak, "tak");
		
		ECItems.addItem(virtianwood_sword, "virtianwood_sword");
		ECItems.addItem(virtianwood_shovel, "virtianwood_shovel");
		ECItems.addItem(virtianwood_pickaxe, "virtianwood_pickaxe");
		ECItems.addItem(virtianwood_axe, "virtianwood_axe");
		ECItems.addItem(virtianwood_hoe, "virtianwood_hoe");
		
		ECItems.addItem(amberwood_sword, "amberwood_sword");
		ECItems.addItem(amberwood_shovel, "amberwood_shovel");
		ECItems.addItem(amberwood_pickaxe, "amberwood_pickaxe");
		ECItems.addItem(amberwood_axe, "amberwood_axe");
		ECItems.addItem(amberwood_hoe, "amberwood_hoe");
		
		ECItems.addItem(virtianstone_sword, "virtianstone_sword");
		ECItems.addItem(virtianstone_shovel, "virtianstone_shovel");
		ECItems.addItem(virtianstone_pickaxe, "virtianstone_pickaxe");
		ECItems.addItem(virtianstone_axe, "virtianstone_axe");
		ECItems.addItem(virtianstone_hoe, "virtianstone_hoe");
		
		ECItems.addItem(deepstone_sword, "deepstone_sword");
		ECItems.addItem(deepstone_shovel, "deepstone_shovel");
		ECItems.addItem(deepstone_pickaxe, "deepstone_pickaxe");
		ECItems.addItem(deepstone_axe, "deepstone_axe");
		ECItems.addItem(deepstone_hoe, "deepstone_hoe");
		
		ECItems.addItem(brazeum_sword, "brazeum_sword");
		ECItems.addItem(brazeum_shovel, "brazeum_shovel");
		ECItems.addItem(brazeum_pickaxe, "brazeum_pickaxe");
		ECItems.addItem(brazeum_axe, "brazeum_axe");
		ECItems.addItem(brazeum_hoe, "brazeum_hoe");
		
		ECItems.addItem(aquieus_sword, "aquieus_sword");
		ECItems.addItem(aquieus_shovel, "aquieus_shovel");
		ECItems.addItem(aquieus_pickaxe, "aquieus_pickaxe");
		ECItems.addItem(aquieus_axe, "aquieus_axe");
		ECItems.addItem(aquieus_hoe, "aquieus_hoe");
		
		ECItems.addItem(pluthorium_sword, "pluthorium_sword");
		ECItems.addItem(pluthorium_shovel, "pluthorium_shovel");
		ECItems.addItem(pluthorium_pickaxe, "pluthorium_pickaxe");
		ECItems.addItem(pluthorium_axe, "pluthorium_axe");
		ECItems.addItem(pluthorium_hoe, "pluthorium_hoe");
		
		ECItems.addItem(teleporter_wand, "teleporter_wand");
		ECItems.addItem(amberwood_fishing_rod, "amberwood_fishing_rod");
		ECItems.addItem(sticky_bomb, "sticky_bomb");
		ECItems.addItem(laser_pistol, "laser_pistol");
		ECItems.addItem(laser_rifle, "laser_rifle");
		ECItems.addItem(acid_bucket, "acid_bucket");
		
		ECItems.addItem(cytoid_door, "cytoid_door_item");
		
		ECItems.addItem(burhaunch_cooked, "burhaunch_cooked");
		ECItems.addItem(burhaunch_raw, "burhaunch_raw");
		ECItems.addItem(evulus_fish, "evulus_fish");
		ECItems.addItem(vois_food, "vois_food");
		ECItems.addItem(binnegan_fruit, "binnegan_fruit");
		ECItems.addItem(veer_seeds, "veer_seeds");
		ECItems.addItem(veer_dye, "veer_dye");
	}
	
	public static String getTexture(String name)
	{
		return "virtious:" + name;
	}
}
