package clashsoft.mods.moredimensions.cape;

import net.minecraft.util.ResourceLocation;

public class LocalCape extends Cape
{
	public LocalCape(String name, String location)
	{
		super(name);
		this.location = new ResourceLocation(location);
	}
	
}
