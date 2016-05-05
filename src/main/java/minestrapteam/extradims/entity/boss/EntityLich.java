package minestrapteam.extradims.entity.boss;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import minestrapteam.extradims.ExtraDimensions;
import minestrapteam.extradims.common.EDProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityLich extends EntitySkeleton
{
	public String bossName;

	public EntityPlayer interactingPlayer;

	public EntityLich(World world)
	{
		super(world);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if (this.interactingPlayer == null)
		{
			this.interactingPlayer = player;
		}
		if (this.interactingPlayer == player)
		{
			FMLNetworkHandler
				.openGui(player, ExtraDimensions.instance, EDProxy.BOSS_CHAT_GUIID, this.worldObj, this.getEntityId(),
				         0, 0);
			return true;
		}
		return false;
	}

	@Override
	public String getCustomNameTag()
	{
		return (this.bossName != null && !this.bossName.isEmpty()) ?
			       this.bossName :
			       StatCollector.translateToLocal("entity.AeriusLich.name");
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		if (this.bossName != null && !this.bossName.isEmpty())
		{
			nbt.setString("BossName", this.bossName);
		}
		if (this.interactingPlayer != null)
		{
			nbt.setString("PlayerName", this.interactingPlayer.getDisplayName());
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);

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
