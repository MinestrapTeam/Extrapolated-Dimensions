package minestrapteam.extradims.item.virtious;

import java.util.List;

import minestrapteam.extracore.util.I18n;
import minestrapteam.extracore.world.TeleporterNoPortal;
import minestrapteam.extradims.lib.WorldManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTeleporter extends Item
{
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && (player instanceof EntityPlayerMP))
		{
			EntityPlayerMP playermp = (EntityPlayerMP) player;
			
			if (player.dimension == WorldManager.VIRTIOUS_ID)
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0, new TeleporterNoPortal(playermp.mcServer.worldServerForDimension(0)));
			}
			else
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, WorldManager.VIRTIOUS_ID, new TeleporterNoPortal(playermp.mcServer.worldServerForDimension(WorldManager.VIRTIOUS_ID)));
			}
		}
		
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.getString("item.teleporter_wand.desc"));
	}
}
