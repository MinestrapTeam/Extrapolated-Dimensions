package minestrapteam.extracore.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.IOException;

public class PacketSendTileEntity extends ECPacket
{
	private World world;
	private int   x;
	private int   y;
	private int   z;

	private NBTTagCompound data;

	public PacketSendTileEntity()
	{
	}

	public PacketSendTileEntity(World world, int x, int y, int z, NBTTagCompound data)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
	}

	@Override
	public void write(PacketBuffer buf)
	{
		writeWorld(buf, this.world);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);

		buf.writeNBTTagCompoundToBuffer(this.data);
	}

	@Override
	public void read(PacketBuffer buf)
	{
		this.world = readWorld(buf);
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();

		try
		{
			this.data = buf.readNBTTagCompoundFromBuffer();
		}
		catch (IOException ignored)
		{
		}
	}

	@Override
	public void handleClient(EntityPlayer player)
	{
		TileEntity tileEntity = player.worldObj.getTileEntity(new BlockPos(this.x, this.y, this.z));
		if (tileEntity != null)
		{
			tileEntity.readFromNBT(this.data);
		}
	}

	@Override
	public void handleServer(EntityPlayerMP player)
	{
	}
}
