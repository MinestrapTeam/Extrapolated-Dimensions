package minestrapteam.extracore.network;

import minestrapteam.extracore.ExtraCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

public class CapePacket extends ECPacket
{
	public String username;
	public String cape;

	public CapePacket()
	{
	}

	public CapePacket(EntityPlayer player, String cape)
	{
		this.username = player.getName();
		this.cape = cape;
	}

	@Override
	public void write(PacketBuffer buf)
	{
		buf.writeString(this.username);
		buf.writeString(this.cape);
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
		EntityPlayer player1 = ExtraCore.proxy.findPlayer(player.worldObj, this.username);
		ExtraCore.proxy.setCape(player1, this.cape);
	}

	@Override
	public void handleServer(EntityPlayerMP player)
	{
	}
}
