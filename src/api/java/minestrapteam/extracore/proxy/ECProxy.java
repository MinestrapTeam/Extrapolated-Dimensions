package minestrapteam.extracore.proxy;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.inventory.ContainerInventory;
import minestrapteam.extracore.item.ItemPotion2;
import minestrapteam.extracore.network.PacketSplashEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.util.List;
import java.util.UUID;

public class ECProxy extends BaseProxy
{
	public static final int GUI_SURVIVAL_ID = 0;
	public static final int GUI_CREATIVE_ID = 1;
	public static final int GUI_BREWING_ID  = 11;

	public static int MULTI_RENDER_ID;
	public static int BLOCK2D_RENDER_ID;
	public static int CUSTOMBUSH_RENDER_ID;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GUI_SURVIVAL_ID || ID == GUI_CREATIVE_ID)
		{
			return this.replaceInventory(player);
		}
		return null;
	}

	public ContainerInventory replaceInventory(EntityPlayer player)
	{
		if (player.inventoryContainer instanceof ContainerInventory)
		{
			return (ContainerInventory) player.inventoryContainer;
		}

		ContainerInventory container = new ContainerInventory(player.inventory, player);
		player.inventoryContainer = player.openContainer = container;
		return container;
	}

	public void clearCape(EntityPlayer player)
	{
		this.setCape(player, "no_cape");
	}

	public void updateCape(EntityPlayer player)
	{
		this.setCape(player, "default_cape");
	}

	public void setCape(EntityPlayer player, String capeName)
	{
		ExtraCore.getNetHandler().sendCapePacket(player, capeName);
	}

	public void playSplashEffect(World world, double x, double y, double z, ItemStack stack)
	{
		if (stack != null && stack.getItem() instanceof ItemPotion2)
		{
			ItemPotion2 item = (ItemPotion2) stack.getItem();
			int color = item.getLiquidColor(stack);
			boolean isInstant = item.isEffectInstant(stack);
			this.playSplashEffect(world, x, y, z, color, isInstant);
		}
	}

	public void playSplashEffect(World world, double x, double y, double z, int color, boolean isInstant)
	{
		if (!world.isRemote)
		{
			ExtraCore.instance.netHandler.sendToAll(new PacketSplashEffect(x, y, z, color, isInstant));
		}
	}

	public void openMUScreen()
	{
	}

	public void openGUI(Object gui)
	{
	}

	public void registerRenderers()
	{
	}

	public World getClientWorld()
	{
		return null;
	}

	public EntityPlayer getClientPlayer()
	{
		return null;
	}

	public EntityPlayer findPlayer(String username)
	{
		for (World world : DimensionManager.getWorlds())
		{
			EntityPlayer player = this.findPlayer(world, username);
			if (player != null)
			{
				return player;
			}
		}
		return null;
	}

	public EntityPlayer findPlayer(World world, String username)
	{
		List<EntityPlayer> players = world.playerEntities;
		EntityPlayer player = null;
		for (int i = 0; i < players.size(); i++)
		{
			player = players.get(i);
			if (player.getCommandSenderName().equals(username))
			{
				return player;
			}
		}
		return null;
	}

	public EntityPlayer findPlayer(UUID uuid)
	{
		for (World world : DimensionManager.getWorlds())
		{
			EntityPlayer player = this.findPlayer(world, uuid);
			if (player != null)
			{
				return player;
			}
		}
		return null;
	}

	public EntityPlayer findPlayer(World world, UUID uuid)
	{
		List<EntityPlayer> players = world.playerEntities;
		EntityPlayer player = null;
		for (int i = 0; i < players.size(); i++)
		{
			player = players.get(i);
			if (player.getUniqueID().equals(uuid))
			{
				return player;
			}
		}
		return null;
	}

	public boolean isMinecraftClassName(String clazz)
	{
		return false;
	}
}
