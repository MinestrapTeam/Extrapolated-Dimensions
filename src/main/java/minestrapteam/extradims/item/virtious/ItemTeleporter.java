package minestrapteam.extradims.item.virtious;

import minestrapteam.extracore.util.I18n;
import minestrapteam.extracore.world.TeleporterNoPortal;
import minestrapteam.extradims.lib.virtious.Virtious;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemTeleporter extends Item
{
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (!player.isSneaking() || !(player instanceof EntityPlayerMP))
		{
			return stack;
		}

		final EntityPlayerMP playermp = (EntityPlayerMP) player;
		final int target;
		if (player.dimension == Virtious.VIRTIOUS_ID)
		{
			target = 0;
		}
		else
		{
			target = Virtious.VIRTIOUS_ID;
		}

		final TeleporterNoPortal teleporter = new TeleporterNoPortal(playermp.mcServer.worldServerForDimension(target));
		playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, target, teleporter);

		return stack;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.getString("item.teleporter_wand.desc"));
	}
}
