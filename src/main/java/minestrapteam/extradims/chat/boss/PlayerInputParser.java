package minestrapteam.extradims.chat.boss;

public class PlayerInputParser
{
	public enum EnumOutputAction
	{
		// Regexes: % = starts with; & = contains; @ = ends with; ~ = contains
		// not; nothing = equals
		// Note: Always lower case.
		YES("%yes", "~no", "&sure", "&true", "&ok", "&yeah", "&alright"), NO("%no", "~yes", "&never", "&better not"), HELLO("%hello", "%hi", "%greetings", "%welcome"), CANCEL("&cancel", "%stop"),
		
		START_FIGHT("&fight", "i want to beat the crap out of you!"),
		
		UNABLE_TO_PARSE();
		
		private final String[]	regexes;
		
		private EnumOutputAction(String... regexes)
		{
			this.regexes = regexes;
		}
	}
	
	public static String	CONTAINS		= "&";
	public static String	STARTS_WITH		= "%";
	public static String	ENDS_WITH		= "@";
	public static String	CONTAINS_NOT	= "~";
	
	public static EnumOutputAction parseInput(String input)
	{
		String s = input.toLowerCase();
		for (EnumOutputAction action : EnumOutputAction.values())
		{
			for (String regex : action.regexes)
			{
				String regex1 = regex;
				regex1.replace(CONTAINS, "");
				regex1.replace(STARTS_WITH, "");
				regex1.replace(ENDS_WITH, "");
				regex1.replace(CONTAINS_NOT, "");
				
				if (regex.contains(CONTAINS) && s.contains(regex1)) // Contains
					return action;
				else if (regex.contains(CONTAINS_NOT) && !s.contains(regex1)) // !Contains
					return action;
				else if (regex.contains(STARTS_WITH) && s.startsWith(regex1)) // Starts
																				// With
					return action;
				else if (regex.contains(ENDS_WITH) && s.endsWith(regex1)) // Ends
																			// With
					return action;
				else if (regex1.equals(regex.toLowerCase())) // Equals
					return action;
				
			}
		}
		return EnumOutputAction.UNABLE_TO_PARSE;
	}
}