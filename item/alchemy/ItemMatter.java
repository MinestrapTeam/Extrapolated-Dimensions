package clashsoft.mods.moredimensions.item.alchemy;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;

public class ItemMatter extends Item
{
	public int[]	colorTable	= new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };
	
	public Icon[]	icons1;
	public Icon[]	icons2;
	
	public ItemMatter(int itemID)
	{
		super(itemID);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(EnumChatFormatting.ITALIC + I18n.getString("item.matter.desc"));
	}
	
	@Override
	public void getSubItems(int itemID, CreativeTabs creativeTab, List list)
	{
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int pass)
	{
		return pass == 0 ? icons1[getType1(stack.getItemDamage())] : icons2[getType2(stack.getItemDamage())];
	}
	
	@Override
	public int getColorFromItemStack(ItemStack stack, int pass)
	{
		return this.colorTable[this.getColor(stack.getItemDamage())];
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons1 = new Icon[4];
		this.icons2 = new Icon[4];
		
		for (int i = 0; i < 4; i++)
		{
			this.icons1[i] = iconRegister.registerIcon("moredimensions:matter_" + i + "_left");
			this.icons2[i] = iconRegister.registerIcon("moredimensions:matter_" + i + "_right");
		}
	}
	
	public int getDamage(int left, int right, int color)
	{
		return ((color & 15) << 4) | ((right & 3) << 2) | (left & 3 << 0);
	}
	
	public int getType1(int metadata)
	{
		return metadata & 3;
	}
	
	public int getType2(int metadata)
	{
		return (metadata >> 2) & 3;
	}
	
	public int getColor(int metadata)
	{
		return (metadata >> 4) & 15;
	}
}
