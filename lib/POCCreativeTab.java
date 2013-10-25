package clashsoft.mods.moredimensions.lib;

import clashsoft.mods.moredimensions.addons.MDMItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class POCCreativeTab extends CreativeTabs
{
	public POCCreativeTab(String label)
	{
		super(label);
		// this.setBackgroundImageName("pocbg.png");
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		if (this.equals(MDMItems.PoCTab))
		{
			return new ItemStack(MDMItems.Tome);
		}
		else
		{
			return new ItemStack(MDMItems.Elixir, 1, 23);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getBackgroundImageName()
	{
		// Minecraft.getMinecraft().renderEngine.bindTexture("/paradiseofchaos/gui/creative_inv/pocbg.png");
		return super.getBackgroundImageName();
	}
}
