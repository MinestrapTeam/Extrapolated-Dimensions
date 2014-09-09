package minestrapteam.virtious.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNativeSkeleton extends RenderLiving
{
	private static final ResourceLocation	texture	= new ResourceLocation("virtious", "textures/models/native_skeleton.png");
	
	public RenderNativeSkeleton(ModelBase modelBase, float size)
	{
		super(modelBase, size);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
