package clashsoft.mods.moredimensions.common;

import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.block.heaven.BlockHeavenPortal;
import clashsoft.mods.moredimensions.entity.MDMEntityProperties;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class MDMPacketHandler implements IPacketHandler
{
	public void registerChannels()
	{
	}
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity)
	{
		if ("MDMEntProp".equals(packet.channel))
		{
			MDMEntityProperties.setByPacket((EntityLivingBase) playerEntity, packet);
		}
		else if ("MDMHeaven".equals(packet.channel) && playerEntity instanceof EntityPlayerMP)
		{
			BlockHeavenPortal.teleportPlayer((EntityPlayerMP) playerEntity);
		}
		else if ("MDMCapes".equals(packet.channel))
		{
			MoreDimensionsMod.proxy.setCape((EntityPlayer) playerEntity, packet);
		}
	}
}
