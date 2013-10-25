package clashsoft.mods.moredimensions.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagicOakLog extends BlockLog
{
	public static final String[]	woodType	= new String[] { "MagicOak" };
	@SideOnly(Side.CLIENT)
	private Icon					iconLogTop;
	
	public BlockMagicOakLog(int par1)
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundWoodFootstep);
		this.setHardness(2.0F);
	}
	
	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	{
		int j1 = par9 & 3;
		byte b0 = 0;
		switch (par5)
		{
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}
		return j1 | b0;
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.iconLogTop : (k == 4 && (par1 == 5 || par1 == 4) ? this.iconLogTop : (k == 8 && (par1 == 2 || par1 == 3) ? this.iconLogTop : this.blockIcon));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/** Register Icons for this block used in method above **/
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("MagicOakLogSides");
		this.iconLogTop = par1IconRegister.registerIcon("MagicOakLogTop");
	}
	
	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(this, 1, 0));
	}
}