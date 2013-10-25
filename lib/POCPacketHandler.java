package clashsoft.mods.moredimensions.lib;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class POCPacketHandler implements IPacketHandler
{
	public void registerChannels()
	{
		NetworkRegistry.instance().registerChannel(this, POCEntityProperties.CHANNEL);
	}
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity)
	{
		if (POCEntityProperties.CHANNEL.equals(packet.channel))
			POCEntityProperties.setByPacket((EntityLivingBase) playerEntity, packet);
	}	
}
