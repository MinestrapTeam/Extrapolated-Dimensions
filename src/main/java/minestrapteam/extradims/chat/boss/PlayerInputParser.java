package minestrapteam.extradims.chat.boss;

public class PlayerInputParser
{
	public enum EnumOutputAction
	{
		YES(".*\byes\b.*", ".*\bsure\b.*", ".*\bok\b.*", ".*\byeah\b.*", ".*\balright\b.*"),
		NO(".*\bno\b.*", ".*\bnever\b.*", ".*\bbetter not\b.*"),
		HELLO(".*\bhello", ".*\bhi\b.*", ".*\bgreetings\b.*", ".*\bwelcome\b.*"),
		CANCEL(".*\bcancel\b.*", ".*\bstop\b.*"),
		START_FIGHT(".*\bfight\b.*"),
		UNABLE_TO_PARSE;

		private final String[] regexes;

		EnumOutputAction(String... regexes)
		{
			this.regexes = regexes;
		}

		public boolean matches(String input)
		{
			for (String regex : this.regexes)
			{
				if (input.matches(regex))
				{
					return true;
				}
			}
			return false;
		}
	}

	public static EnumOutputAction parseInput(String input)
	{
		String lowerCase = input.toLowerCase();
		for (EnumOutputAction action : EnumOutputAction.values())
		{
			if (action.matches(lowerCase))
			{
				return action;
			}
		}
		return EnumOutputAction.UNABLE_TO_PARSE;
	}
}
