package com.chaosdev.paradiseofchaos.entity.boss.chat;

public class PlayerInputParser
{
	public enum EnumOutputAction
	{
		// Regexes: % = starts with; & = contains; @ = ends with; ~ = contains
		// not; nothing = equals
		// Note: Always lower case.
		YES("%yes", "~no", "&sure", "&true", "&ok", "&yeah", "&alright"),
		NO("%no", "~yes", "&never", "&better not"),
		HELLO("%hello", "%hi", "%greetings", "%welcome"),
		CANCEL("&cancel", "%stop"),
		
		START_FIGHT("&fight", "i want to beat the crap out of you!"),
		
		UNABLE_TO_PARSE();
		
		private final String[]	regexes;
		
		private EnumOutputAction(String... par1Strings)
		{
			regexes = par1Strings;
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
				String removedRegexes = regex;
				removedRegexes.replace(CONTAINS, "");
				removedRegexes.replace(STARTS_WITH, "");
				removedRegexes.replace(ENDS_WITH, "");
				removedRegexes.replace(CONTAINS_NOT, "");
				removedRegexes = removedRegexes.toLowerCase();
				if (regex.contains(CONTAINS) && s.contains(removedRegexes)) // Contains
					return action;
				else if (regex.contains(CONTAINS_NOT) && !s.contains(removedRegexes)) // !Contains
					return action;
				else if (regex.contains(STARTS_WITH) && s.startsWith(removedRegexes)) // Starts
																						// With
					return action;
				else if (regex.contains(ENDS_WITH) && s.endsWith(removedRegexes)) // Ends
																					// With
					return action;
				else if (removedRegexes == regex.toLowerCase()) // Equals
					return action;
				
			}
		}
		return EnumOutputAction.UNABLE_TO_PARSE;
	}
}