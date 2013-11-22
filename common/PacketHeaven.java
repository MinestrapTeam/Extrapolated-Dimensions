package clashsoft.mods.moredimensions.common;

import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketHeaven extends Packet250CustomPayload
{
	public PacketHeaven()
	{
		super("MDMHeaven", new byte[] {});
	}
}
