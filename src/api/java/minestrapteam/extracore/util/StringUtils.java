package minestrapteam.extracore.util;

import minestrapteam.extracore.util.logging.ECLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The Class StringUtils.
 * <p>
 * This class adds several string tools.
 *
 * @author Clashsoft
 * @see String
 * @see StringBuilder
 * @see StringBuffer
 */
public class StringUtils
{
	private static final String[] ROMANCODE = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[]    BINEQUAL  = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static final String[] fastRomanCache = { "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
		"XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX" };

	public static String format(String format, Object... args)
	{
		return String.format(format, args);
	}

	public static String identifier(String string)
	{
		int len = string.length();
		StringBuilder result = new StringBuilder(len);

		for (int i = 0; i < len; i++)
		{
			char c = string.charAt(i);

			if (Character.isWhitespace(c))
			{
				c = '_';
			}
			else
			{
				c = Character.toLowerCase(c);
			}

			result.append(c);
		}

		return result.toString();
	}

	/**
	 * Converts a number to a roman number.
	 *
	 * @param number
	 * 	the number
	 *
	 * @return the roman number
	 */
	public static String convertToRoman(int number)
	{
		if (number < 0)
		{
			return "-" + convertToRoman(-number);
		}
		else if (number < fastRomanCache.length)
		{
			return fastRomanCache[number];
		}
		else if (number >= 4000)
		{
			ECLog.error("Exception while converting to Roman: Value outside roman numeral range.");
			return String.valueOf(number);
		}

		StringBuilder roman = new StringBuilder();

		for (int i = 0; i < ROMANCODE.length; i++)
		{
			while (number >= BINEQUAL[i])
			{
				number -= BINEQUAL[i];
				roman.append(ROMANCODE[i]);
			}
		}
		return roman.toString();
	}

	public static List<String> getWords(String string, boolean spacesOnly)
	{
		List<String> words = new ArrayList<>();
		StringBuilder temp = new StringBuilder(10);

		for (int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			temp.append(c);
			if (isSpace(c) || !spacesOnly && !isLetter(c))
			{
				words.add(temp.toString());
				temp.delete(0, temp.length());
			}
		}

		if (temp.length() > 0)
		{
			words.add(temp.toString());
		}

		return words;
	}

	/**
	 * Wraps a string to make multiple lines with a maximum length. It doesn't cut words
	 *
	 * @param string
	 * 	the string
	 * @param maxLineLength
	 * 	the max line length
	 *
	 * @return the string
	 */
	public static List<String> cutString(String string, int maxLineLength)
	{
		List<String> words = getWords(string, false);
		StringBuilder temp = new StringBuilder(10);
		List<String> lines = new ArrayList<>();

		for (String word : words)
		{
			if (temp.length() + word.length() >= maxLineLength)
			{
				lines.add(temp.toString());
				temp.delete(0, temp.length());
			}
			temp.append(word);
		}
		if (temp.length() > 0)
		{
			lines.add(temp.toString());
		}

		return lines;
	}

	/**
	 * Makes a line array for rendering.
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the string[]
	 */
	public static String[] lineArray(String string)
	{
		if (string == null)
		{
			return new String[0];
		}
		return string.split("\n");
	}

	public static List<String> lineList(String string)
	{
		if (string == null)
		{
			return (List<String>) Collections.EMPTY_LIST;
		}
		return Arrays.asList(lineArray(string));
	}

	/**
	 * Returns the acronym of a string.
	 * <p>
	 * Example:<br> {@code getAcronym("Hello World")} returns "HW"; {@code getAcronym("Half-Life 3")} returns "HL3"
	 *
	 * @param string
	 * 	the string
	 *
	 * @return the initials
	 */
	public static String getAcronym(String string)
	{
		StringBuilder builder = new StringBuilder(string.length() >> 2);
		String[] strings = string.split("\\p{Punct}");
		for (String s : strings)
		{
			char c = s.charAt(0);
			builder.append(c);
		}
		return builder.toString();
	}

	/**
	 * Concats all Strings in {@code array} with the {@code postfix}
	 *
	 * @param array
	 * 	the array
	 * @param postfix
	 * 	the postfix
	 *
	 * @return the new array
	 */
	public static String[] postfixAll(String[] array, String prefix, String postfix)
	{
		final String[] ret = new String[array.length];
		for (int i = 0; i < ret.length; i++)
		{
			ret[i] = array[i] + postfix;
		}
		return ret;
	}

	/**
	 * Concats all Strings in {@code array} with the {@code prefix}
	 *
	 * @param array
	 * 	the array
	 * @param prefix
	 * 	the prefix
	 *
	 * @return the new array
	 */
	public static String[] prefixAll(String[] array, String prefix)
	{
		final String[] ret = new String[array.length];
		for (int i = 0; i < ret.length; i++)
		{
			ret[i] = prefix + array[i];
		}
		return ret;
	}

	/**
	 * Concats all Strings in {@code array} with the {@code prefix} and the {@code postfix}
	 *
	 * @param array
	 * 	the array
	 * @param prefix
	 * 	the prefix
	 * @param postfix
	 * 	the postfix
	 *
	 * @return the new array
	 */
	public static String[] concatAll(String[] array, String prefix, String postfix)
	{
		final String[] ret = new String[array.length];
		for (int i = 0; i < array.length; i++)
		{
			ret[i] = prefix + array[i] + postfix;
		}
		return ret;
	}

	public static boolean isNumber(char c)
	{
		return c >= '0' && c <= '9';
	}

	public static boolean isLetter(char c)
	{
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	public static boolean isSpace(char c)
	{
		return c == ' ' || c == '\t' || c == '\n' || c == '\r';
	}
}
