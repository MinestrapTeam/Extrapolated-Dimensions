package minestrapteam.extracore.block;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface ICustomBlock
{
	String[]	DEFAULT_NAMES	= new String[] { null };
	
	String getUnlocalizedName(ItemStack stack);
	
	void addInformation(ItemStack stack, EntityPlayer player, List<String> list);
}
