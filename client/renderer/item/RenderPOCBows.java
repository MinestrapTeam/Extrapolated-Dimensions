package clashsoft.mods.moredimensions.client.renderer.item;

import org.lwjgl.opengl.GL11;

import clashsoft.cslib.minecraft.client.CSFontRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderPOCBows implements IItemRenderer
{
	private RenderItem	itemRenderer	= new RenderItem();
	
	public RenderPOCBows()
	{
		super();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return type == ItemRenderType.INVENTORY;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if (item.getItem() instanceof ItemBow)
		{
			this.itemRenderer.renderItemIntoGUI(CSFontRenderer.getFontRenderer(), Minecraft.getMinecraft().renderEngine, item, 0, 0);
			
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			if (player != null)
			{
				int arrowCount = this.countArrows(player);
				
				String arrowCountDisplay = String.valueOf(arrowCount);
				int arrowCountColor = (arrowCount < 1 ? 0xFF0000 : 0xEEEEEE);
				int stringWidth = CSFontRenderer.getFontRenderer().getStringWidth(arrowCountDisplay);
				float scale = (16F / stringWidth) > 1F ? 1F : (16F / stringWidth);
				GL11.glScalef(scale, scale, 1F);
				CSFontRenderer.getFontRenderer().drawString(arrowCountDisplay, 0, 0, arrowCountColor, true);
			}
		}
	}
	
	public int countArrows(EntityPlayer player)
	{
		InventoryPlayer inv = player.inventory;
		int arrowCount = 0;
		
		for (int i = 0; i < inv.getSizeInventory(); i++)
		{
			ItemStack is = inv.getStackInSlot(i);
			if (is != null && is.getItem() == Items.arrow)
			{
				arrowCount += is.stackSize;
			}
		}
		return arrowCount;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}
}
