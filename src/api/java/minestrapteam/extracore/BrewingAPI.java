package minestrapteam.extracore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.extracore.block.BlockBrewingStand2;
import minestrapteam.extracore.block.ECBlocks;
import minestrapteam.extracore.command.CommandPotion;
import minestrapteam.extracore.config.ECConfig;
import minestrapteam.extracore.crafting.ECCrafting;
import minestrapteam.extracore.entity.ECEntities;
import minestrapteam.extracore.entity.EntityPotion2;
import minestrapteam.extracore.init.ClashsoftMod;
import minestrapteam.extracore.item.ECItems;
import minestrapteam.extracore.item.ItemGlassBottle2;
import minestrapteam.extracore.item.ItemPotion2;
import minestrapteam.extracore.item.stack.ECStacks;
import minestrapteam.extracore.item.stack.StackFactory;
import minestrapteam.extracore.network.BAPINetHandler;
import minestrapteam.extracore.potion.IPotionEffectHandler;
import minestrapteam.extracore.potion.IPotionList;
import minestrapteam.extracore.potion.PotionList;
import minestrapteam.extracore.potion.type.IPotionType;
import minestrapteam.extracore.potion.util.PotionDispenser;
import minestrapteam.extracore.proxy.BAPIProxy;
import minestrapteam.extracore.tileentity.TileEntityBrewingStand2;
import minestrapteam.extracore.util.logging.ECLog;
import minestrapteam.extracore.util.update.ECUpdate;
import minestrapteam.extracore.util.update.reader.SimpleUpdateReader;
import minestrapteam.extracore.util.update.updater.ModUpdater;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod(modid = BrewingAPI.MODID, name = BrewingAPI.NAME, version = BrewingAPI.VERSION, dependencies = BrewingAPI.DEPENDENCIES)
public class BrewingAPI extends ClashsoftMod
{
	public static final String		MODID					= "brewingapi";
	public static final String		NAME					= "Brewing API";
	public static final String		ACRONYM					= "bapi";
	public static final String		VERSION					= "1.7.10-3.0.2";
	public static final String		DEPENDENCIES			= ExtraCore.DEPENDENCY;
	
	@Instance(MODID)
	public static BrewingAPI		instance;
	
	public static BAPIProxy			proxy					= createProxy("BAPIClientProxy", "clashsoft.brewingapi.common.BAPIProxy");
	
	// API
	
	public static String			goodEffectColor1		= EnumChatFormatting.GRAY.toString();
	public static String			goodEffectColor2		= EnumChatFormatting.WHITE.toString();
	public static String			badEffectColor1			= EnumChatFormatting.RED.toString();
	public static String			badEffectColor2			= EnumChatFormatting.GOLD.toString();
	public static boolean			multiPotions			= false;
	public static boolean			advancedPotionInfo		= false;
	public static boolean			showAllBaseTypes		= false;
	public static boolean			defaultAwkwardBrewing	= false;
	public static int				potionStackSize			= 1;
	
	public static int				brewingStand2ID			= 11;
	
	public static CreativeTabs		potions;
	
	public static Block				brewingStand2;
	public static Item				brewingStandItem2;
	
	public static ItemPotion2		potion2;
	public static ItemGlassBottle2	glassBottle2;
	
	public BrewingAPI()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.hasConfig = true;
		this.netHandlerClass = BAPINetHandler.class;
		this.eventHandler = this;
		this.url = "https://github.com/Clashsoft/Brewing-API/wiki/";
		this.description = "Brewing API allows modders to modify the brewing system, add custom potions and potion recipes.";
	}
	
	@Override
	public void readConfig()
	{
		brewingStand2ID = ECConfig.getTileEntity("Brewing Stand", 11);
		
		goodEffectColor1 = ECConfig.getString("colors", "Good Effect Color", goodEffectColor1);
		goodEffectColor2 = ECConfig.getString("colors", "Good Effect Glow Color", goodEffectColor2);
		badEffectColor1 = ECConfig.getString("colors", "Bad Effect Color", badEffectColor1);
		badEffectColor2 = ECConfig.getString("colors", "Bad Effect Glow Color", badEffectColor2);
		multiPotions = ECConfig.getBool("potions", "MultiPotions", multiPotions);
		advancedPotionInfo = ECConfig.getBool("potions", "Advanced Potion Info", advancedPotionInfo);
		showAllBaseTypes = ECConfig.getBool("potions", "Show All Base Potion Types", showAllBaseTypes);
		defaultAwkwardBrewing = ECConfig.getBool("potions", "Default Awkward Brewing", defaultAwkwardBrewing);
		potionStackSize = ECConfig.getInt("potions", "PotionStackSize", potionStackSize);
	}
	
	@Override
	public void updateCheck()
	{
		final String url = "https://raw.githubusercontent.com/Clashsoft/Brewing-API/master/version.txt";
		ECUpdate.updateCheck(new ModUpdater(NAME, ACRONYM, VERSION, url, SimpleUpdateReader.instance));
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		brewingStand2 = new BlockBrewingStand2().setBlockName("brewingStand").setHardness(0.5F).setLightLevel(0.125F);
		brewingStandItem2 = new ItemReed(brewingStand2).setUnlocalizedName("brewingStand").setTextureName("brewing_stand").setCreativeTab(CreativeTabs.tabBrewing);
		potion2 = (ItemPotion2) new ItemPotion2().setUnlocalizedName("potion").setCreativeTab(CreativeTabs.tabBrewing);
		glassBottle2 = (ItemGlassBottle2) new ItemGlassBottle2().setUnlocalizedName("glassBottle").setTextureName("potion_bottle_empty");
		
		ECCrafting.removeRecipe(new ItemStack(Items.brewing_stand));
		ECCrafting.removeRecipe(new ItemStack(Items.glass_bottle));
		
		ECBlocks.replaceBlock(Blocks.brewing_stand, brewingStand2);
		ECItems.replaceItem(Items.brewing_stand, brewingStandItem2);
		ECItems.replaceItem(Items.potionitem, potion2);
		ECItems.replaceItem(Items.glass_bottle, glassBottle2);
		
		ECCrafting.addRecipe(StackFactory.create(brewingStandItem2), " b ", "SSS", 'b', Items.blaze_rod, 'S', Blocks.cobblestone);
		ECCrafting.addRecipe(StackFactory.create(glassBottle2, 3), "G G", " G ", 'G', ECStacks.glass_block);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		PotionList.init();
		
		if (multiPotions)
		{
			potions = new CreativeTabs("mixedpotions")
			{
				ItemStack	stack	= null;
				
				@Override
				public ItemStack getIconItemStack()
				{
					return this.stack == null ? this.stack = PotionList.damageBoost.apply(new ItemStack(BrewingAPI.potion2, 0, 1)) : this.stack;
				}
				
				@Override
				public Item getTabIconItem()
				{
					return null;
				}
			};
		}
		
		GameRegistry.registerTileEntity(TileEntityBrewingStand2.class, "BrewingStand2");
		ECEntities.replace("ThrownPotion", 16, EntityPotion2.class);

		BlockDispenser.dispenseBehaviorRegistry.putObject(potion2, new PotionDispenser());
	}

	@EventHandler
	public void serverStarted(FMLServerStartedEvent event)
	{
		ServerCommandManager manager = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();

		manager.registerCommand(new CommandPotion());
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	// API
	
	public static boolean						hasLoaded		= false;
	
	public static List<IPotionEffectHandler>	effectHandlers	= new ArrayList<IPotionEffectHandler>();
	
	public static IPotionType addPotionType(IPotionType potionType)
	{
		return potionType.register();
	}
	
	public static void setPotionList(IPotionList potionList)
	{
		PotionList.instance = potionList;
	}
	
	public static void registerEffectHandler(IPotionEffectHandler handler)
	{
		if (!effectHandlers.contains(handler))
		{
			ECLog.info("Effect handler \"" + handler + "\" registered");
			effectHandlers.add(handler);
		}
	}
	
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		if (living != null && !living.worldObj.isRemote)
		{
			Collection<PotionEffect> c = living.getActivePotionEffects();
			List<PotionEffect> potionEffects = new ArrayList(c);
			
			for (PotionEffect effect : potionEffects)
			{
				for (IPotionEffectHandler handler : effectHandlers)
				{
					if (handler.canHandle(effect))
					{
						handler.onPotionUpdate(living.deathTime, living, effect);
					}
				}
			}
		}
	}
}
