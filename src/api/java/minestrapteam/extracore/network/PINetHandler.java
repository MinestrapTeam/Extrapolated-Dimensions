package minestrapteam.extracore.network;

public class PINetHandler extends BaseNetHandler
{
	public PINetHandler()
	{
		super("PIAPI");
		
		this.registerPacket(EISlotPacket.class);
		this.registerPacket(EIPacket.class);
	}
}
