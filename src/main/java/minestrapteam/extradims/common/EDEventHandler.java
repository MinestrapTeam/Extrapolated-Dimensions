package minestrapteam.extradims.common;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.world.TeleporterNoPortal;
import minestrapteam.extracore.inventory.ExtendedInventory;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import minestrapteam.extradims.api.ICape;
import minestrapteam.extradims.api.IMinableBlock;
import minestrapteam.extradims.curse.Curse;
import minestrapteam.extradims.entity.EDEntityProperties;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.lib.virtious.VBlocks;
import minestrapteam.extradims.lib.virtious.VItems;

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

public class EDEventHandler
{
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		ItemStack result = null;
		int x = event.target.blockX;
		int y = event.target.blockY;
		int z = event.target.blockZ;
		Block block = event.world.getBlock(x, y, z);
		int metadata = event.world.getBlockMetadata(x, y, z);
		
		if (block == VBlocks.virtious_acid && metadata == 0)
		{
			result = new ItemStack(VItems.acid_bucket);
		}
		
		if (result != null)
		{
			event.world.setBlockToAir(x, y, z);
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}
	
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
		EDEntityProperties.get(event.entityPlayer).addMeleeLevel(0.005F);
	}
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EDEntityProperties.get((EntityPlayer) event.source.getSourceOfDamage()).addSlayerLevel(0.01F);
		}
	}
	
	@SubscribeEvent
	public void onEntityHurt(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EDEntityProperties.get(event.entityLiving).addDefenceLevel(0.01F);
		}
	}
	
	@SubscribeEvent
	public void onArrowShot(ArrowLooseEvent event)
	{
		EDEntityProperties.get(event.entityPlayer).addRangedLevel(0.05F);
	}
	
	@SubscribeEvent
	public void onHoeUsed(UseHoeEvent event)
	{
		EDEntityProperties.get(event.entityPlayer).addFarmingLevel(0.001F);
	}
	
	@SubscribeEvent
	public void onItemTossed(ItemTossEvent event)
	{
		EDEntityProperties.get(event.player).addSharingLevel(0.001F);
	}
	
	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event)
	{
		if (event.harvester != null)
		{
			EDEntityProperties props = EDEntityProperties.get(event.harvester);
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
			EDEntityProperties props = EDEntityProperties.create((EntityLivingBase) event.entity);
			EDEntityProperties.set((EntityPlayer) event.entity, props);
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
				EDEntityProperties props = EDEntityProperties.get(player);
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
			
			if (player.dimension == WorldManager.AERIUS_ID && player.posY <= -64)
			{
				player.setPosition(player.posX, 256, player.posZ);
				server.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterNoPortal(server.worldServerForDimension(0)));
			}
			else if (player.dimension == 0 && player.posY > 256)
			{
				player.setPosition(player.posX, 0, player.posZ);
				server.getConfigurationManager().transferPlayerToDimension(player, WorldManager.AERIUS_ID, new TeleporterNoPortal(server.worldServerForDimension(WorldManager.AERIUS_ID)));
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
			ExtraCore.getNetHandler().sendCapePacket(player, "");
		}
		else if (stack.getItem() instanceof ICape)
		{
			((ICape) stack.getItem()).updateCape(player, stack);
		}
	}
}
