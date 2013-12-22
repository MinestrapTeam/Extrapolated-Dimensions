package clashsoft.mods.moredimensions.client.sound;

import clashsoft.mods.moredimensions.addons.MDMWorld;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class MDMSoundHandler
{
	public static final MDMSoundHandler	instance	= new MDMSoundHandler();
	
	protected MDMSoundHandler()
	{
	}
	
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event)
	{
		event.manager.soundPoolMusic.addSound("moredimensions:sounds/music/heaven.ogg");
	}
	
	@ForgeSubscribe
	public void onBackgroundMusic(PlayBackgroundMusicEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null && player.dimension == MDMWorld.HEAVEN_ID)
		{
			event.result = event.manager.soundPoolMusic.getRandomSoundFromSoundPool("moredimensions:sounds.music.heaven");
		}
	}
}