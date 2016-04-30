package minestrapteam.extradims.block.virtious;

import java.util.Random;

import minestrapteam.extracore.block.BlockCustomPortalBase;
import minestrapteam.extradims.lib.WorldManager;
import minestrapteam.extradims.world.virtious.TeleporterVirtious;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockVirtiousPortal extends BlockCustomPortalBase
{
	public BlockVirtiousPortal(String iconName)
	{
		super(iconName, WorldManager.VIRTIOUS_ID);
	}
	
	@Override
	public Teleporter createTeleporter(WorldServer world)
	{
		return new TeleporterVirtious(world);
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		for (int i = 0; i < 32; ++i)
		{
			double x1 = random.nextFloat();
			double y1 = random.nextFloat();
			double z1 = random.nextFloat();
			
			world.spawnParticle("smoke", x + x1, y + y1, z + z1, 0D, 0.0625D, 0D);
		}
	}
}
