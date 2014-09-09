package minestrapteam.virtious.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBurfalaunt extends RenderLiving
{
	private static final ResourceLocation	TEXTURE_BURFALAUNT	= new ResourceLocation("virtious:textures/models/burfalaunt.png");
	
	public RenderBurfalaunt(ModelBase modelBase, float size)
	{
		super(modelBase, size);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return TEXTURE_BURFALAUNT;
	}
}
