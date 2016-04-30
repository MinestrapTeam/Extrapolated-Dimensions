package clashsoft.cslib.minecraft.client.icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public interface IIconSupplier
{
	void registerIcons(IIconRegister iconRegister);
	
	IIcon getIcon(int metadata);
	
	IIcon getIcon(int metadata, int side);
}
