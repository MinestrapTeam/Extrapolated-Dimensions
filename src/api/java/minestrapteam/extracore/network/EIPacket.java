package minestrapteam.extracore.network;

import minestrapteam.extracore.inventory.ExtendedInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class EIPacket extends ECPacket
{
	public ItemStack[]	stacks;
	
	public EIPacket()
	{
	}
	
	public EIPacket(ExtendedInventory inventory)
	{
		this.stacks = inventory.itemStacks;
	}
	
	@Override
	public void write(PacketBuffer buf) throws IOException
	{
		int len = this.stacks.length;
		buf.writeInt(len);
		for (ItemStack stack : this.stacks)
		{
			writeItemStack(buf, stack);
		}
	}
	
	@Override
	public void read(PacketBuffer buf) throws IOException
	{
		int len = buf.readInt();
		this.stacks = new ItemStack[len];
		
		for (int i = 0; i < len; i++)
		{
			this.stacks[i] = readItemStack(buf);
		}
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		ExtendedInventory ei = ExtendedInventory.get(player);
		ei.itemStacks = this.stacks;
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		ExtendedInventory ei = ExtendedInventory.get(player);
		ei.itemStacks = this.stacks;
	}
}
