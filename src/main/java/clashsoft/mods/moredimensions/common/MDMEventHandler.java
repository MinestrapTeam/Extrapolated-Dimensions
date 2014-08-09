package clashsoft.mods.moredimensions.common;

import clashsoft.cslib.minecraft.CSLib;
import clashsoft.cslib.minecraft.world.TeleporterNoPortal;
import clashsoft.mods.moredimensions.api.ICape;
import clashsoft.mods.moredimensions.api.IMinableBlock;
import clashsoft.mods.moredimensions.curse.Curse;
import clashsoft.mods.moredimensions.entity.MDMEntityProperties;
import clashsoft.mods.moredimensions.lib.MDMWorld;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class MDMEventHandler
{
	public int	playerCounter	= 0;
	
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		Block block = event.world.getBlock(event.x, event.y, event.z);
		if (block instanceof IGrowable && block.getClass() != BlockSapling.class)
		{
			((IGrowable) block).func_149853_b(event.world, event.world.rand, event.x, event.y, event.z);
		}
	}
	
	@SubscribeEvent
	public void onEntityAttacked(AttackEntityEvent event)
	{
		MDMEntityProperties.get(event.entityPlayer).addMeleeLevel(0.005F);
	}
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			MDMEntityProperties.get((EntityPlayer) event.source.getSourceOfDamage()).addSlayerLevel(0.01F);
		}
	}
	
	@SubscribeEvent
	public void onEntityHurt(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			MDMEntityProperties.get(event.entityLiving).addDefenceLevel(0.01F);
		}
	}
	
	@SubscribeEvent
	public void onArrowShot(ArrowLooseEvent event)
	{
		MDMEntityProperties.get(event.entityPlayer).addRangedLevel(0.05F);
	}
	
	@SubscribeEvent
	public void onHoeUsed(UseHoeEvent event)
	{
		MDMEntityProperties.get(event.entityPlayer).addFarmingLevel(0.001F);
	}
	
	@SubscribeEvent
	public void onItemTossed(ItemTossEvent event)
	{
		MDMEntityProperties.get(event.player).addSharingLevel(0.001F);
	}
	
	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event)
	{
		if (event.harvester != null)
		{
			MDMEntityProperties props = MDMEntityProperties.get(event.harvester);
			Block block = event.block;
			Material material = block.getMaterial();
			
			if (material == Material.ground)
			{
				props.addDiggingLevel(0.001F);
			}
			else if (material == Material.wood)
			{
				props.addWoodCuttingLevel(0.01F);
			}
			else if (block instanceof BlockCrops)
			{
				props.addFarmingLevel(0.05F);
			}
			else if (block instanceof BlockOre)
			{
				if (block == Blocks.coal_ore)
				{
					props.addMiningLevel(0.005F);
				}
				else if (block == Blocks.lapis_ore)
				{
					props.addMiningLevel(0.007F);
				}
				else if (block == Blocks.emerald_ore)
				{
					props.addMiningLevel(0.012F);
				}
				else if (block == Blocks.diamond_ore)
				{
					props.addMiningLevel(0.01F);
				}
				else if (block == Blocks.redstone_ore || block == Blocks.lit_redstone_ore)
				{
					props.addMiningLevel(0.008F);
				}
				else
				{
					props.addMiningLevel(0.005F);
				}
			}
			else if (material == Material.rock)
			{
				props.addMiningLevel(0.001F);
			}
			else if (block instanceof BlockMobSpawner)
			{
				props.addMiningLevel(0.05F);
			}
			else if (block instanceof IMinableBlock)
			{
				props.addMiningLevel(((IMinableBlock) block).getMiningValue(event.blockMetadata));
			}
		}
	}
	
	@SubscribeEvent
	public void entityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote)
		{
			MDMEntityProperties props = MDMEntityProperties.create((EntityLivingBase) event.entity);
			MDMEntityProperties.set((EntityPlayer) event.entity, props);
		}
	}
	
	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			if (!event.world.isRemote)
			{
				EntityPlayer player = (EntityPlayer) event.entity;
				MDMEntityProperties props = MDMEntityProperties.get(player);
				props.sync(player);
			}
		}
	}
	
	@SubscribeEvent
	public void getItemTooltip(ItemTooltipEvent event)
	{
		Curse.addTooltip(event.itemStack, event.toolTip);
		
		if (event.itemStack.stackSize <= 0)
		{
			event.toolTip.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "0 Stack Size!");
		}
	}
	
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) event.entity;
			this.updatePlayerHeight(player);
			this.updatePlayerCapes(player);
		}
	}
	
	public void updatePlayerHeight(EntityPlayerMP player)
	{
		try
		{
			MinecraftServer server = player.mcServer;
			
			if (player.dimension == MDMWorld.HEAVEN_ID && player.posY <= -64)
			{
				player.setPosition(player.posX, 256, player.posZ);
				server.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterNoPortal(server.worldServerForDimension(0)));
			}
			else if (player.dimension == 0 && player.posY > 256)
			{
				player.setPosition(player.posX, 0, player.posZ);
				server.getConfigurationManager().transferPlayerToDimension(player, MDMWorld.HEAVEN_ID, new TeleporterNoPortal(server.worldServerForDimension(MDMWorld.HEAVEN_ID)));
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void updatePlayerCapes(EntityPlayerMP player)
	{
		ExtendedInventory extendedInventory = ExtendedInventory.get(player);
		ItemStack stack = extendedInventory.getStackInSlot(66);
		
		if (stack == null)
		{
			CSLib.getNetHandler().sendCapePacket(player, "");
		}
		else if (stack.getItem() instanceof ICape)
		{
			((ICape) stack.getItem()).updateCape(player, stack);
		}
	}
}