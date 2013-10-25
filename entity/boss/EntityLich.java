package clashsoft.mods.moredimensions.entity.boss;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.common.CommonProxy;
import clashsoft.mods.moredimensions.entity.boss.chat.BossChatData;
import clashsoft.mods.moredimensions.entity.boss.chat.PlayerInputParser.EnumOutputAction;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityLich extends EntityLiving implements IPOCBoss
{
	public static ResourceLocation	icon	= new ResourceLocation("paradiseofchaos/gui/bosschat/lichicon.png");
	
	public BossChatData				chatData;
	public String					lastAction;
	public String					bossName;
	
	public EntityPlayer				interactingPlayer;
	
	public EntityLich(World par1World)
	{
		super(par1World);
		chatData = new BossChatData();
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if (interactingPlayer == null)
			interactingPlayer = par1EntityPlayer;
		if (interactingPlayer == par1EntityPlayer)
		{
			FMLNetworkHandler.openGui(par1EntityPlayer, MoreDimensionsMod.instance, CommonProxy.BOSS_CHAT_GUIID, this.worldObj, this.entityId, 0, 0);
			return true;
		}
		return false;
	}
	
	@Override
	public String getDisplayName()
	{
		return (bossName != null && bossName != "") ? bossName : StatCollector.translateToLocal("entity.POCBossLich.name");
	}
	
	@Override
	public ResourceLocation getIcon()
	{
		return icon;
	}
	
	@Override
	public BossChatData getBossChatData()
	{
		return chatData;
	}
	
	@Override
	public void sendParsedPlayerInput(EnumOutputAction action, EntityPlayer player)
	{
		if (action == EnumOutputAction.CANCEL)
			interactingPlayer = null;
		
		if (lastAction == "ASK_WHAT_PLAYER_WANTS")
			if (action == EnumOutputAction.START_FIGHT)
				this.startBossFight(player);
	}
	
	@Override
	public void onChatOpened(EntityPlayer player)
	{
		this.lastAction = "ASK_WHAT_PLAYER_WANTS";
		chatData.addBossMessage("Greetings, " + player.username + ". What do you want from me?", true);
	}
	
	public void startBossFight(EntityPlayer player)
	{
		// TODO Boss Fight
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		chatData.writeToNBT(nbt);
		if (this.bossName != null && this.bossName != "" && !bossName.isEmpty())
			nbt.setString("BossName", this.bossName);
		if (this.interactingPlayer != null)
		{
			nbt.setString("PlayerName", interactingPlayer.username);
			nbt.setInteger("PlayerEntityID", interactingPlayer.entityId);
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		chatData = BossChatData.readFromNBT(nbt);
		if (nbt.hasKey("BossName"))
			this.bossName = nbt.getString("BossName");
		else
			this.bossName = "";
		this.interactingPlayer = this.worldObj.getPlayerEntityByName(nbt.getString("PlayerName"));
		if (interactingPlayer == null)
		{
			Entity e = this.worldObj.getEntityByID(nbt.getInteger("PlayerEntityID"));
			if (e instanceof EntityPlayer)
			{
				interactingPlayer = (EntityPlayer) e;
			}
		}
	}
	
	public boolean isStartingFight()
	{
		return false;
	}
}
