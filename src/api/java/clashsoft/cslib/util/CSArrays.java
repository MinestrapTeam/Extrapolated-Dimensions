package clashsoft.cslib.util;

import java.util.*;

/**
 * The class CSArrays.
 * <p>
 * This class adds several array utils.
 * 
 * @author Clashsoft
 */
public class CSArrays
{
	/**
	 * Creates a new Array List from the array
	 * 
	 * @see ArrayList
	 * @param array
	 *            the array
	 * @return an ArrayList
	 */
	@SafeVarargs
	public static <T> List<T> asList(T... array)
	{
		return Arrays.asList(array);
	}

	@SafeVarargs
	public static <T> Set<T> asSet(T... array)
	{
		final Set<T> set = new HashSet<>(array.length);
		Collections.addAll(set, array);
		return set;
	}
	
	/**
	 * Returns the first index of the {@code object} in the {@code array}
	 * 
	 * @param array
	 *            the array
	 * @param object
	 *            the object
	 * @return the first index of the object in the array
	 */
	public static <T> int indexOf(T[] array, T object)
	{
		return indexOf(array, 0, object);
	}
	
	/**
	 * Returns the first index after {@code start} of the {@code object} in the
	 * {@code array}
	 * 
	 * @param array
	 *            the array
	 * @param start
	 *            the index to start from
	 * @param object
	 *            the object
	 * @return the first index of the object in the array
	 */
	public static <T> int indexOf(T[] array, int start, T object)
	{
		for (int i = start; i < array.length; i++)
		{
			if (Objects.equals(object, array[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the last index of the {@code object} in the {@code array}
	 * 
	 * @param array
	 *            the array
	 * @param object
	 *            the object
	 * @return the last index of the object in the array
	 */
	public static <T> int lastIndexOf(T[] array, T object)
	{
		return lastIndexOf(array, array.length - 1, object);
	}
	
	/**
	 * Returns the last index before {@code start} of the {@code object} in the
	 * {@code array}
	 * 
	 * @param array
	 *            the array
	 * @param start
	 *            the index to start from
	 * @param object
	 *            the object
	 * @return the last index of the object in the array
	 */
	public static <T> int lastIndexOf(T[] array, int start, T object)
	{
		for (int i = start; i >= 0; i--)
		{
			if (Objects.equals(object, array[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Checks if {@code array} contains the {@code object}.
	 * 
	 * @param array
	 *            the array
	 * @param object
	 *            the object
	 * @return true, if the array contains the object
	 */
	public static <T> boolean contains(T[] array, T object)
	{
		return indexOf(array, object) != -1;
	}
}
