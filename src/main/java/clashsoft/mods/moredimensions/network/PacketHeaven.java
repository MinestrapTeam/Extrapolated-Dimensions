package clashsoft.mods.moredimensions.network;

import clashsoft.cslib.minecraft.network.CSPacket;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class PacketHeaven extends CSPacket
{
	public PacketHeaven()
	{
	}
	
	@Override
	public void write(PacketBuffer buf)
	{
	}

	@Override
	public void read(PacketBuffer buf)
	{
	}

	@Override
	public void handleClient(EntityPlayer player)
	{
	}

	@Override
	public void handleServer(EntityPlayerMP player)
	{
	}
}
