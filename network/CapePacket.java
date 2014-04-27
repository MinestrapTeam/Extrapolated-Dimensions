package clashsoft.mods.moredimensions.network;

import clashsoft.cslib.minecraft.network.CSPacket;
import clashsoft.mods.moredimensions.MoreDimensionsMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class CapePacket extends CSPacket
{
	public String username;
	public String cape;
	
	public CapePacket()
	{
		
	}
	
	public CapePacket(EntityPlayer player, String name)
	{
		
	}
	
	@Override
	public void write(PacketBuffer buf)
	{
		buf.writeStringToBuffer(this.username);
	}
	
	@Override
	public void read(PacketBuffer buf)
	{
		this.username = buf.readStringFromBuffer(0xFFFF);
		this.cape = buf.readStringFromBuffer(0xFFFF);
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		EntityPlayer player1 = MoreDimensionsMod.proxy.findPlayer(this.username);
		MoreDimensionsMod.proxy.setCape(player1, this.cape);
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		MoreDimensionsMod.instance.netHandler.sendToAll(this);
	}
}
