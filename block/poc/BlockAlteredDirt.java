package clashsoft.mods.moredimensions.block.poc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockAlteredDirt extends Block
{
	public BlockAlteredDirt(int par1, Material par2Material)
	{
		super(par1, Material.ground);
	}
	
	public void updateIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("main:AlteredDirt");
	}
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		return true;
	}
	
	/**
	 * CLASHSOFT: This code makes blocks use their unlocalized name as icon name
	 */
	@Override
	public Block setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		super.setTextureName(name);
		return this;
	}
}
