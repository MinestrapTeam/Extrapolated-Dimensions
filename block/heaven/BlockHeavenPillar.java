package clashsoft.mods.moredimensions.block.heaven;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockHeavenPillar extends Block
{
	public Icon	topIcon;
	
	public BlockHeavenPillar(int blockID)
	{
		super(blockID, Material.rock);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("moredimensions:pillar_side");
		this.topIcon = iconRegister.registerIcon("moredimensions:pillar_top");
	}
	
	@Override
	public Icon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 ? this.topIcon : this.blockIcon;
	}
}
