package minestrapteam.extracore.command;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.util.update.ECUpdate;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class CommandModUpdate extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "modupdates";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "/modupdates [view|update|updateall]";
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		if (!(sender instanceof EntityPlayerMP))
		{
			return;
		}
		
		if (args.length >= 1)
		{
			if ("update".equals(args[0]))
			{
				if (args.length >= 2)
				{
					String mod = args[1];
					ECUpdate.update((EntityPlayer) sender, mod);
				}
			}
			else if ("updateall".equals(args[0]))
			{
				ECUpdate.updateAll((EntityPlayer) sender);
			}
			else if ("view".equals(args[0]))
			{
				ExtraCore.getNetHandler().sendOpenMUScreen((EntityPlayerMP) sender);
			}
		}
		else
		{
			ExtraCore.getNetHandler().sendOpenMUScreen((EntityPlayerMP) sender);
		}
	}
	
	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args)
	{
		return getListOfStringsMatchingLastWord(args, "update", "updateall", "view");
	}
	
	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
}
