package clashsoft.mods.moredimensions.entity.boss;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.api.IMDMBoss;
import clashsoft.mods.moredimensions.chat.boss.BossChatData;
import clashsoft.mods.moredimensions.chat.boss.PlayerInputParser.EnumOutputAction;
import clashsoft.mods.moredimensions.common.MDMCommonProxy;
import cpw.mods.fml.common.network.FMLNetworkHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityLich extends EntitySkeleton implements IMDMBoss
{
	public static ResourceLocation	icon	= new ResourceLocation("paradiseofchaos/gui/bosschat/lichicon.png");
	
	public BossChatData				chatData;
	public String					lastAction;
	public String					bossName;
	
	public EntityPlayer				interactingPlayer;
	
	public EntityLich(World par1World)
	{
		super(par1World);
		this.chatData = new BossChatData();
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if (this.interactingPlayer == null)
			this.interactingPlayer = par1EntityPlayer;
		if (this.interactingPlayer == par1EntityPlayer)
		{
			FMLNetworkHandler.openGui(par1EntityPlayer, MoreDimensionsMod.instance, MDMCommonProxy.BOSS_CHAT_GUIID, this.worldObj, this.entityId, 0, 0);
			return true;
		}
		return false;
	}
	
	@Override
	public String getEntityName()
	{
		return (this.bossName != null && !this.bossName.isEmpty()) ? this.bossName : StatCollector.translateToLocal("entity.POCBossLich.name");
	}
	
	@Override
	public ResourceLocation getIcon()
	{
		return icon;
	}
	
	@Override
	public BossChatData getBossChatData()
	{
		return this.chatData;
	}
	
	@Override
	public void onPlayerInput(EnumOutputAction action, EntityPlayer player)
	{
		if (action == EnumOutputAction.CANCEL)
			this.interactingPlayer = null;
		
		if (this.lastAction == "intro1")
			if (action == EnumOutputAction.START_FIGHT)
				this.startBossFight(player);
	}
	
	@Override
	public void onChatOpened(EntityPlayer player)
	{
		this.lastAction = "intro1";
		this.chatData.addBossMessage("Greetings, " + player.username + ". What do you want from me?", true);
	}
	
	public void startBossFight(EntityPlayer player)
	{
		// TODO Boss Fight
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		this.chatData.writeToNBT(nbt);
		if (this.bossName != null && !this.bossName.isEmpty())
			nbt.setString("BossName", this.bossName);
		if (this.interactingPlayer != null)
		{
			nbt.setString("PlayerName", this.interactingPlayer.username);
			nbt.setInteger("PlayerEntityID", this.interactingPlayer.entityId);
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		
		this.chatData = new BossChatData();
		this.chatData.readFromNBT(nbt);
		
		if (nbt.hasKey("BossName"))
			this.bossName = nbt.getString("BossName");
		else
			this.bossName = "";
		
		this.interactingPlayer = this.worldObj.getPlayerEntityByName(nbt.getString("PlayerName"));
		if (this.interactingPlayer == null)
		{
			Entity e = this.worldObj.getEntityByID(nbt.getInteger("PlayerEntityID"));
			if (e instanceof EntityPlayer)
			{
				this.interactingPlayer = (EntityPlayer) e;
			}
		}
	}
	
	public boolean isStartingFight()
	{
		return false;
	}
}
