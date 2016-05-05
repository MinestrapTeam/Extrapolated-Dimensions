package minestrapteam.extradims.lib.virtious;

import cpw.mods.fml.common.registry.EntityRegistry;
import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extracore.entity.ECEntities;
import minestrapteam.extracore.inventory.creativetab.CustomCreativeTab;
import minestrapteam.extracore.item.stack.StackFactory;
import minestrapteam.extradims.ExtraDimensions;
import minestrapteam.extradims.biome.virtious.*;
import minestrapteam.extradims.entity.EntityBurfalaunt;
import minestrapteam.extradims.entity.EntityLaser;
import minestrapteam.extradims.entity.EntityNative;
import minestrapteam.extradims.entity.EntityNativeSkeleton;
import minestrapteam.extradims.entity.item.EntityStickyBomb;
import minestrapteam.extradims.world.virtious.WorldProviderVirtious;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenAmberTree;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenDeepstone;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenMinable;
import minestrapteam.extradims.world.virtious.gen.VirtiousGenVirtianTree;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Random;

public class Virtious
{
	public static final String TEXTURE_DOMAIN = "virtious";
	public static final String TEXTURE_PREFIX = TEXTURE_DOMAIN + ":";

	public static CustomCreativeTab tabVirtiousBlocks = new CustomCreativeTab("virtious_blocks");
	public static CustomCreativeTab tabVirtiousItems  = new CustomCreativeTab("virtious_items");

	public static Fluid virtiousFluid = new Fluid("virtious_acid");

	// Dimension

	public static int VIRTIOUS_ID = 7;

	// Biomes

	public static BiomeGenBase biomeVirtious;
	public static BiomeGenBase biomeCanyon;
	public static BiomeGenBase biomeWhiskerfield;
	public static BiomeGenBase biomeVirtianMountain;
	public static BiomeGenBase biomeGravelBeach;
	public static BiomeGenBase biomeVirtiousOcean;

	public static BiomeGenBase[] virtiousBiomes;

	public static void init()
	{
		FluidRegistry.registerFluid(virtiousFluid);

		VIRTIOUS_ID = ECConfig.getDimension("Virtious", VIRTIOUS_ID);

		VBlocks.initBlocks();
		VItems.initItems();

		FluidContainerRegistry
			.registerFluidContainer(virtiousFluid, new ItemStack(VItems.acid_bucket), new ItemStack(Items.bucket));

		VItems.registerItems();
		VBlocks.registerBlocks();

		VRecipes.load();

		tabVirtiousBlocks.setIconItemStack(StackFactory.create(VBlocks.virtian_grass));
		tabVirtiousItems.setIconItemStack(StackFactory.create(VItems.binnegan_fruit));

		// Biomes

		biomeVirtious = new BiomeGenVirtious(ECConfig.getBiome("Virtious", 50)).setBiomeName("Virtious");
		biomeCanyon = new BiomeGenCanyon(ECConfig.getBiome("Canyon", 51)).setBiomeName("Virtious Canyon");
		biomeWhiskerfield = new BiomeGenWhiskerfield(ECConfig.getBiome("Whiskerfield", 52))
			                    .setBiomeName("Whiskerfield");
		biomeVirtianMountain = new BiomeGenVirtianMountains(ECConfig.getBiome("Virtian Mountains", 53))
			                       .setBiomeName("Virtian Mountains");
		biomeGravelBeach = new BiomeGenGravelBeach(ECConfig.getBiome("Gravel Beach", 54)).setBiomeName("Gravel Beach");
		biomeVirtiousOcean = new BiomeGenVirtiousOcean(ECConfig.getBiome("Virtious Ocean", 55))
			                     .setBiomeName("Virtious Ocean");

		virtiousBiomes = new BiomeGenBase[] { biomeVirtious, biomeCanyon, biomeWhiskerfield, biomeGravelBeach,
			biomeVirtiousOcean };

		// Dimension

		DimensionManager.registerProviderType(VIRTIOUS_ID, WorldProviderVirtious.class, true);
		DimensionManager.registerDimension(VIRTIOUS_ID, VIRTIOUS_ID);

		// Entities

		ECEntities.register("StickyBomb", 100, EntityStickyBomb.class);
		EntityRegistry
			.registerModEntity(EntityStickyBomb.class, "StickyBomb", 100, ExtraDimensions.instance, 10, 20, false);

		ECEntities.register("Laser", 101, EntityLaser.class);
		EntityRegistry.registerModEntity(EntityLaser.class, "Laser", 101, ExtraDimensions.instance, 10, 20, false);

		ECEntities.register("Burfalaunt", 102, EntityBurfalaunt.class, 0x110802, 0x3F1E06);
		ECEntities.register("NativeAlien", 103, EntityNative.class, 0x59563E, 0x2D3C21);
		ECEntities.register("NativeSkeleton", 104, EntityNativeSkeleton.class, 0x494949, 0xD8D8D8);
	}

	public static String getTexture(String name)
	{
		return TEXTURE_PREFIX + name;
	}

	public static void generateVirtious(World world, Random random, int chunkX, int chunkZ)
	{
		// Tak Ore
		for (int l = 0; l < 15; l++)
		{
			new VirtiousGenMinable(VBlocks.tak_ore, 9)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(64), chunkZ + random.nextInt(16));
		}

		// VIron
		for (int l = 0; l < 10; l++)
		{
			new VirtiousGenMinable(VBlocks.virtian_iron_ore, 8)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(63), chunkZ + random.nextInt(16));
		}

		// Brazeum
		for (int l = 0; l < 9; l++)
		{
			new VirtiousGenDeepstone(VBlocks.brazeum_ore, 8)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}

		// Aquieus
		for (int l = 0; l < 7; l++)
		{
			new VirtiousGenDeepstone(VBlocks.aquieus_ore, 6)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(32), chunkZ + random.nextInt(16));
		}

		// Pluthorium
		for (int l = 0; l < 2; l++)
		{
			new VirtiousGenDeepstone(VBlocks.pluthorium_ore, 6)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(16), chunkZ + random.nextInt(16));
		}

		// Illuminous
		for (int l = 0; l < 11; l++)
		{
			new VirtiousGenMinable(VBlocks.illuminous_ore, 7)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(64), chunkZ + random.nextInt(16));
		}

		// Deep Illuminous
		for (int l = 0; l < 11; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_illuminous_ore, 7)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(64), chunkZ + random.nextInt(16));
		}

		// Deep Tak
		for (int l = 0; l < 15; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_tak_ore, 9)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}

		// Deep Tak
		for (int l = 0; l < 10; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deep_iron_ore, 8)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}

		// Deep Tak
		for (int l = 0; l < 9; l++)
		{
			new VirtiousGenDeepstone(VBlocks.deepstone_mossy, 8)
				.generate(world, random, chunkX + random.nextInt(16), random.nextInt(40), chunkZ + random.nextInt(16));
		}

		VirtiousGenVirtianTree treeVirtian = new VirtiousGenVirtianTree(false);
		VirtiousGenAmberTree treeAmber = new VirtiousGenAmberTree(false);
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);

		if (biome instanceof BiomeGenVirtious)
		{

			int Xcoord = chunkX + random.nextInt(16);
			int Zcoord = chunkZ + random.nextInt(16);
			int i = world.getHeightValue(Xcoord, Zcoord);
			if (random.nextInt(2) == 1)
			{
				treeVirtian.generate(world, random, Xcoord, i, Zcoord);
			}
			else
			{
				treeAmber.generate(world, random, Xcoord, i, Zcoord);
			}
		}
	}
}
