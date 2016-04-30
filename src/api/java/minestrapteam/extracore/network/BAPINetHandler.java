package minestrapteam.extracore.network;

public class BAPINetHandler extends BaseNetHandler
{
	public BAPINetHandler()
	{
		super("BAPI");
		this.registerPacket(PacketSplashEffect.class);
	}
}
