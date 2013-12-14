package clashsoft.mods.moredimensions.chat.boss;

public enum EnumBossChatUser
{
	PLAYER(0, 0xFFFFFF), BOSS(1, 0xFF0000), CUSTOM(-1, 0xFFFFFF);
	
	private int	color;
	private int	id;
	
	private EnumBossChatUser(int id, int color)
	{
		this.id = id;
		this.color = color;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public static EnumBossChatUser getBossChatUserFromID(int id)
	{
		for (EnumBossChatUser bcu : values())
		{
			if (bcu.id == id)
				return bcu;
		}
		return null;
	}
}