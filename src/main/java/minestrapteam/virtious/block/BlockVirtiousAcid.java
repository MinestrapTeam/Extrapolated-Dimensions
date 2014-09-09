package minestrapteam.virtious.block;

import minestrapteam.virtious.Virtious;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockVirtiousAcid extends BlockFluidClassic
{
	protected IIcon	flowingIcon;
	
	public BlockVirtiousAcid()
	{
		super(Virtious.virtiousFluid, Material.water);
		Virtious.virtiousFluid.setBlock(this);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("virtious:virtious_acid_still");
		this.flowingIcon = iconRegister.registerIcon("virtious:virtious_acid_flowing");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return metadata == 0 ? this.blockIcon : this.flowingIcon;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase mob = (EntityLivingBase) entity;
			mob.addPotionEffect(new PotionEffect(Potion.poison.getId(), 30, 3, false));
		}
	}
}
