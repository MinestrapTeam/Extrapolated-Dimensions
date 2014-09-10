package minestrapteam.extradims.world;

import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.storage.WorldInfo;

public class WorldTypeTest extends WorldType
{
	public WorldTypeTest(String name)
	{
		super(name);
	}
	
	@Override
	public boolean showWorldInfoNotice()
	{
		return true;
	}
	
	@Override
	public WorldChunkManager getChunkManager(World world)
	{
		GameRules rules = world.getGameRules();
		WorldInfo info = world.getWorldInfo();
		
		rules.setOrCreateGameRule("keepInventory", "true");
		rules.setOrCreateGameRule("doDaylightCycle", "false");
		
		info.setWorldTime(6000L);
		info.setRainTime(Integer.MAX_VALUE);
		
		return super.getChunkManager(world);
	}
}
