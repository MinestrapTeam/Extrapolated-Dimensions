package clashsoft.mods.moredimensions.common;

import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketSendPlayerToHeaven extends Packet250CustomPayload
{
	public PacketSendPlayerToHeaven()
	{
		super("MDMHeaven", new byte[] {});
	}
}
