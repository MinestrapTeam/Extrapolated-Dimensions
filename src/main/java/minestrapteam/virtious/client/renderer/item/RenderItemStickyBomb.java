package minestrapteam.virtious.client.renderer.item;

import org.lwjgl.opengl.GL11;

import minestrapteam.virtious.client.renderer.entity.RenderStickyBomb;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderItemStickyBomb implements IItemRenderer
{
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		
		if (type == ItemRenderType.EQUIPPED)
		{
			GL11.glTranslatef(0.3F, 0.5F, 0F);
		}
		else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glTranslatef(0.75F, .5F, -0.3F);
		}
		else if (type == ItemRenderType.INVENTORY)
		{
			GL11.glDepthMask(false);
			GL11.glTranslatef(8F, 7.5F, 0F);
			GL11.glScalef(17F, 17F, 17F);
		}
		
		RenderStickyBomb.render();
		
		if (type == ItemRenderType.INVENTORY)
		{
			GL11.glDepthMask(true);
		}
		
		GL11.glPopMatrix();
	}
}
