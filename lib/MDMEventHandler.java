package clashsoft.mods.moredimensions.lib;

import clashsoft.mods.moredimensions.addons.MDMBlocks;
import clashsoft.mods.moredimensions.api.IMinableBlock;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class MDMEventHandler
{
	/** Used to make the sapling grow the tree **/
	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event)
	{
		if (event.world.getBlockId(event.X, event.Y, event.Z) == MDMBlocks.MagicOakSapling.blockID)
		{
			MDMBlocks.MagicOakSapling.growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}
	
	@ForgeSubscribe
	public void onEntityAttacked(AttackEntityEvent event)
	{
		MDMEntityProperties.getEntityProperties(event.entityPlayer).addMeleeLevel(0.005F);
	}
	
	@ForgeSubscribe
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.source.getSourceOfDamage() instanceof EntityPlayer)
			MDMEntityProperties.getEntityProperties((EntityPlayer) event.source.getSourceOfDamage()).addSlayerLevel(0.01F);
	}
	
	@ForgeSubscribe
	public void onEntityHurt(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
			MDMEntityProperties.getEntityProperties(event.entityLiving).addDefenceLevel(0.01F);
	}
	
	@ForgeSubscribe
	public void onArrowShot(ArrowLooseEvent event)
	{
		MDMEntityProperties.getEntityProperties(event.entityPlayer).addRangedLevel(0.05F);
	}
	
	@ForgeSubscribe
	public void onHoeUsed(UseHoeEvent event)
	{
		MDMEntityProperties.getEntityProperties(event.entityPlayer).addFarmingLevel(0.001F);
	}
	
	@ForgeSubscribe
	public void onItemTossed(ItemTossEvent event)
	{
		MDMEntityProperties.getEntityProperties(event.player).addSharingLevel(0.001F);
	}
	
	@ForgeSubscribe
	public void onBlockHarvested(HarvestDropsEvent event)
	{
		if (event.harvester != null)
		{
			MDMEntityProperties props = MDMEntityProperties.getEntityProperties(event.harvester);
			Block block = event.block;
			
			if (block == Block.stone)
				props.addMiningLevel(0.001F);
			else if (block == Block.dirt || block == Block.grass || block == Block.gravel || block == Block.sand)
				props.addDiggingLevel(0.001F);
			else if (block== Block.wood)
				props.addWoodCuttingLevel(0.01F);
			else if (block instanceof BlockCrops)
				props.addFarmingLevel(0.05F);
			else if (block instanceof BlockOre)
			{
				if (block == Block.oreCoal)
					props.addMiningLevel(0.005F);
				else if (block == Block.oreLapis)
					props.addMiningLevel(0.007F);
				else if (block == Block.oreEmerald)
					props.addMiningLevel(0.012F);
				else if (block == Block.oreDiamond)
					props.addMiningLevel(0.01F);
				else if (block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
					props.addMiningLevel(0.008F);
				else
					props.addMiningLevel(0.005F);
			}
			else if (block instanceof BlockMobSpawner)
				props.addMiningLevel(0.05F);
			else if (block instanceof IMinableBlock)
				props.addMiningLevel(((IMinableBlock)block).getMiningValue(event.blockMetadata));
		}
	}
	
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event)
	{
	}
	
	@ForgeSubscribe
	public void entityConstructing(EntityConstructing event)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && event.entity instanceof EntityPlayer)
		{
			MDMEntityProperties props = MDMEntityProperties.create((EntityLivingBase) event.entity);
			MDMEntityProperties.setEntityProperties((EntityPlayer) event.entity, props);
		}
	}
	
	@ForgeSubscribe
	public void entityJoinWorld(EntityJoinWorldEvent event)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			MDMEntityProperties props = MDMEntityProperties.getEntityProperties(player);
			props.sync(player);
		}
	}
}