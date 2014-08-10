package minestrapteam.extradims.entity.boss;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.extradims.ExtraDimensions;
import minestrapteam.extradims.api.IChatEntity;
import minestrapteam.extradims.chat.boss.BossChatData;
import minestrapteam.extradims.chat.boss.PlayerInputParser.EnumOutputAction;
import minestrapteam.extradims.common.EDProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityLich extends EntitySkeleton implements IChatEntity
{
	public static ResourceLocation	icon	= new ResourceLocation("paradiseofchaos/gui/bosschat/lichicon.png");
	
	public BossChatData				chatData;
	public String					lastAction;
	public String					bossName;
	
	public EntityPlayer				interactingPlayer;
	
	public EntityLich(World world)
	{
		super(world);
		this.chatData = new BossChatData();
	}
	
	@Override
	public String getDisplayName()
	{
		return this.bossName;
	}
	
	@Override
	public boolean interact(EntityPlayer player)
	{
		if (this.interactingPlayer == null) {
			this.interactingPlayer = player;}
		if (this.interactingPlayer == player)
		{
			FMLNetworkHandler.openGui(player, ExtraDimensions.instance, EDProxy.BOSS_CHAT_GUIID, this.worldObj, this.getEntityId(), 0, 0);
			return true;
		}
		return false;
	}
	
	@Override
	public String getCustomNameTag()
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
		if (action == EnumOutputAction.CANCEL) {
			this.interactingPlayer = null;}
		
		if (this.lastAction == "intro1") {
			if (action == EnumOutputAction.START_FIGHT) {
				this.startBossFight(player);}}
	}
	
	@Override
	public void onChatOpened(EntityPlayer player)
	{
		this.lastAction = "intro1";
		this.chatData.addBossMessage("Greetings, " + player.getDisplayName() + ". What do you want from me?", true);
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
			nbt.setString("PlayerName", this.interactingPlayer.getDisplayName());
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
