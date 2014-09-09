package minestrapteam.extradims.lib;

import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.entity.CSEntities;
import minestrapteam.extradims.entity.EntityBurfalaunt;
import minestrapteam.extradims.entity.EntityLaser;
import minestrapteam.extradims.entity.EntityNative;
import minestrapteam.extradims.entity.EntityNativeSkeleton;
import minestrapteam.extradims.entity.item.EntityStickyBomb;
import minestrapteam.extradims.lib.virtious.VBlocks;
import minestrapteam.extradims.lib.virtious.VItems;
import minestrapteam.extradims.lib.virtious.VRecipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class Virtious
{
	public static CustomCreativeTab	tabVirtiousBlocks	= new CustomCreativeTab("virtious_items");
	public static CustomCreativeTab	tabVirtiousItems	= new CustomCreativeTab("virtious_blocks");
	
	public static Fluid				virtiousFluid		= new Fluid("Virtian Acid");
	
	public static void init()
	{
		VBlocks.init();
		VItems.init();
	}
	
	public static void load()
	{
		FluidRegistry.registerFluid(virtiousFluid);
		FluidContainerRegistry.registerFluidContainer(virtiousFluid, new ItemStack(VItems.acid_bucket), new ItemStack(Items.bucket));
		
		VBlocks.load();
		VItems.load();
		
		VRecipes.load();
		
		// Entities
		
		CSEntities.register("StickyBomb", 100, EntityStickyBomb.class);
		CSEntities.register("Laser", 101, EntityLaser.class);
		CSEntities.register("Burfalaunt", 102, EntityBurfalaunt.class, 0x110802, 0x3F1E06);
		CSEntities.register("NativeAlien", 103, EntityNative.class, 0x59563E, 0x2D3C21);
		CSEntities.register("NativeSkeleton", 104, EntityNativeSkeleton.class, 0x494949, 0xD8D8D8);
	}
	
	public static String getTexture(String name)
	{
		return "virtious:" + name;
	}
}
