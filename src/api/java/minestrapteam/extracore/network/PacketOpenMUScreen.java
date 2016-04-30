package minestrapteam.extracore.network;

import minestrapteam.extracore.ExtraCore;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class PacketOpenMUScreen extends ECPacket
{
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
		ExtraCore.proxy.openMUScreen();
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
	}
}
