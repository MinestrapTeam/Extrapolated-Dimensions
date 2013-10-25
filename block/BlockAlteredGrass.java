package clashsoft.mods.moredimensions.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockAlteredGrass extends Block
{
	public BlockAlteredGrass(int par1, Material par2Material)
	{
		super(par1, Material.ground);
	}
	
	private final Icon[]	textures	= new Icon[2];
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.textures[0] = reg.registerIcon("AlteredGrassBottom");
		this.textures[1] = reg.registerIcon("AlteredGrassTop");
		this.blockIcon = reg.registerIcon("AlteredGrassSides");
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (side == 0)
			return this.textures[0];
		
		else if (side == 1)
			return this.textures[1];
		
		else
			return this.blockIcon;
	}
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		return true;
	}
	
	// public void updateIcons(IconRegister iconRegister) {
	// blockIcon = iconRegister.registerIcon("main:AlteredGrass");
	// }
}
