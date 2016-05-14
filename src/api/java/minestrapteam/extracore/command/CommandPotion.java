package minestrapteam.extracore.command;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.potion.type.IPotionType;
import minestrapteam.extracore.potion.type.PotionType;
import net.minecraft.command.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class CommandPotion extends CommandBase
{
	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public String getCommandName()
	{
		return "potion";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "commands.potion.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (args.length == 0 || !"give".equals(args[0]) && !"add".equals(args[0]) && !"remove".equals(args[0]))
		{
			throw new CommandNotFoundException("commands.potion.subCommand", args[0]);
		}

		int index = 1;
		Potion potion = getPotion(args[index]);

		if (potion == null)
		{
			ICommandSender sender1 = getPlayer(server, sender, args[index]);
			if (sender1 != null)
			{
				sender = sender1;
			}

			index++;
			potion = getPotion(args[index]);
			if (potion == null)
			{
				throw new NumberInvalidException("commands.potion.effect.notFound", args[index]);
			}
		}

		String name = sender.getName();
		EntityPlayer player = getCommandSenderAsPlayer(sender);

		int duration = 600;
		int amplifier = 0;
		boolean splash = false;

		if (potion.isInstant())
		{
			duration = 1;
		}
		else if (args.length >= index + 1)
		{
			duration = parseInt(args[index + 1], 0, 1000000) * 20;
		}

		if (args.length >= index + 2)
		{
			amplifier = parseInt(args[index + 2], 1, 256) - 1;
		}
		if (args.length >= index + 3)
		{
			splash = Boolean.parseBoolean(args[index + 3]);
		}

		PotionEffect potioneffect = new PotionEffect(potion, duration, amplifier);
		IPotionType potionType = PotionType.getFromEffect(potioneffect);

		if ("give".equals(args[0]))
		{
			ItemStack stack = new ItemStack(ExtraCore.potion2, 1, splash ? 2 : 1);
			potionType.apply(stack);

			EntityItem entityitem = player.dropItem(stack, false);
			entityitem.setNoPickupDelay();

			if (splash)
			{
				notifyCommandListener(sender, this, "commands.potion.give.splash.success", potioneffect.getEffectName(),
				                      potion, duration, amplifier, name);
			}
			else
			{
				notifyCommandListener(sender, this, "commands.potion.give.success", potioneffect.getEffectName(),
				                      potion, duration, amplifier, name);
			}
		}
		else if ("add".equals(args[0]))
		{
			ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
			potionType.apply(stack);

			notifyCommandListener(sender, this, "command.potion.add.success", potioneffect.getEffectName(), potion,
			                      duration, amplifier, name);
		}
		else if ("remove".equals(args[0]))
		{
			ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
			potionType.remove(stack);

			notifyCommandListener(sender, this, "command.potion.remove.success", potioneffect.getEffectName(), potion,
			                      duration, amplifier, name);
		}
	}

	private static Potion getPotion(String arg)
	{
		return Potion.getPotionFromResourceLocation(arg);
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index)
	{
		return index == 1;
	}

	@Override
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos)
	{
		if (args.length == 1)
		{
			return getListOfStringsMatchingLastWord(args, "give", "add", "remove");
		}
		else if (args.length == 2)
		{
			return getListOfStringsMatchingLastWord(args, server.getAllUsernames());
		}
		else if (args.length == 3)
		{
			return getListOfStringsMatchingLastWord(args, Potion.REGISTRY.getKeys());
		}
		return super.getTabCompletionOptions(server, sender, args, pos);
	}
}
