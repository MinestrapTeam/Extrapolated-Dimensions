package minestrapteam.extradims.common;

import minestrapteam.extracore.proxy.BaseProxy;
import minestrapteam.extradims.inventory.ContainerDamnationTable;
import minestrapteam.extradims.tileentity.TileEntityDamnationTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EDProxy extends BaseProxy
{
	public static int	BOSS_CHAT_GUIID			= 20;
	public static int	TOME_GUIID				= 21;
	public static int	DAMNATION_TABLE_GUIID	= 22;
	public static int	ALCHEMY_TABLE_GUIID		= 23;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == DAMNATION_TABLE_GUIID)
		{
			return new ContainerDamnationTable(player.inventory, (TileEntityDamnationTable) world.getTileEntity(x, y, z));
		}
		else
		{
			return null;
		}
	}
}
