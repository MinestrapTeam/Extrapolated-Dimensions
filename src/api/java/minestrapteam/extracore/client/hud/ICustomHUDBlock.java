package minestrapteam.extracore.client.hud;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ICustomHUDBlock
{
	ItemStack getDisplayStack(int metadata, World world, int x, int y, int z);
	
	void addInformation(int metadata, World world, int x, int y, int z, List<String> list);
}
