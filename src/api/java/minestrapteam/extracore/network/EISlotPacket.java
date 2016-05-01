package minestrapteam.extracore.network;

import minestrapteam.extracore.inventory.ExtendedInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class EISlotPacket extends ECPacket
{
	public int			slot;
	public ItemStack	stack;
	
	public EISlotPacket()
	{
	}
	
	public EISlotPacket(ExtendedInventory ei, int slot)
	{
		this.slot = slot;
		this.stack = ei.getStackInSlot(slot);
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		buf.writeInt(this.slot);
		writeItemStack(buf, this.stack);
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		this.slot = buf.readInt();
		this.stack = readItemStack(buf);
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		ExtendedInventory inventory = ExtendedInventory.get(player);
		inventory.itemStacks[this.slot] = this.stack;
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		this.handleClient(player);
	}
}
