package minestrapteam.extracore.cape;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import minestrapteam.extracore.util.Constants;
import minestrapteam.extracore.util.ReflectionUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public abstract class Cape
{
	protected String           name;
	protected ResourceLocation location;

	public Cape(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return this.name;
	}

	public ResourceLocation getLocation()
	{
		return this.location;
	}

	public void loadTexture(AbstractClientPlayer player)
	{
		NetworkPlayerInfo playerInfo = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(player.getUniqueID());

		Map<MinecraftProfileTexture.Type, ResourceLocation> map = ReflectionUtils.getValue(
			Constants.FIELD_NetworkPlayerInfo_playerTextures, playerInfo);
		assert map != null;

		map.put(MinecraftProfileTexture.Type.CAPE, this.getLocation());
	}

	public boolean isTextureLoaded(AbstractClientPlayer player)
	{
		ResourceLocation location = player.getLocationCape();
		return location == this.getLocation();
	}

	public void setName(String name)
	{
		this.name = name;
		this.location = new ResourceLocation("capes/" + name);
	}
}
