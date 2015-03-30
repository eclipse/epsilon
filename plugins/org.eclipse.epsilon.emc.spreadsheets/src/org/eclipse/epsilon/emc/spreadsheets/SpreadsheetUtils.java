package org.eclipse.epsilon.emc.spreadsheets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * This class provides support methods.
 * 
 * @author Martins Francis
 */
public class SpreadsheetUtils
{
	public static void removeFirstChar(final StringBuilder sb)
	{
		if (sb.length() > 0)
		{
			sb.deleteCharAt(0);
		}
	}

	public static void removeFirst(final StringBuilder sb, final String leadingChars)
	{
		if (sb.toString().startsWith(leadingChars))
		{
			for (int i = 0; i < leadingChars.length(); i++)
			{
				SpreadsheetUtils.removeFirstChar(sb);
			}
		}
	}

	public static void removeLastChar(final StringBuilder sb)
	{
		if (sb.length() > 0)
		{
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void removeLast(final StringBuilder sb, final String trailingChars)
	{
		if (sb.toString().endsWith(trailingChars))
		{
			for (int i = 0; i < trailingChars.length(); i++)
			{
				SpreadsheetUtils.removeLastChar(sb);
			}
		}
	}

	public static String getValueConformingToDataType(final SpreadsheetColumn column, final String value)
	{
		if (column.getWorksheet().isDataTypeStrict())
		{
			return SpreadsheetDataType.castColumnValue(column.getDataType(), value).toString();
		}
		return value;
	}

	/**
	 * This method returns all SpreadsheetRow instances contained by the given object.
	 * 
	 * @param object
	 * @return list of SpreadsheetRow instances
	 */
	public static List<SpreadsheetRow> extractAllRowsFromObject(final Object object)
	{
		final List<SpreadsheetRow> rows = new ArrayList<SpreadsheetRow>();
		if (object instanceof SpreadsheetRow)
		{
			rows.add((SpreadsheetRow) object);
		}
		else if (object instanceof Collection<?>)
		{
			for (final Object o : (Collection<?>) object)
			{
				rows.addAll(SpreadsheetUtils.extractAllRowsFromObject(o));
			}
		}
		return rows;
	}

	/**
	 * This method extracts Map from the given collection - it assumes the first object contained by it is a Map. If the
	 * collection is empty or null then an empty Map is returned.
	 * 
	 * @param collection
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> extractMapFromCollection(final Collection<Object> collection)
	{
		Map<String, Object> extractedMap = new HashMap<String, Object>();
		if (CollectionUtils.isEmpty(collection))
		{
			return extractedMap;
		}
		else
		{
			final Object map = collection.iterator().next();
			if (map instanceof Map<?, ?>)
			{
				extractedMap = (Map<String, Object>) map;
			}
			else
			{
				throw new IllegalArgumentException("Expecting the only object to be a Map");
			}
		}
		return extractedMap;
	}

	/**
	 * This method creates a string representation of the given object. If it is an Iterable object then a delimiter
	 * separated string is created.
	 * 
	 * @param column
	 * @param inputValue
	 * @return string representation of the given object
	 */
	public static String convertObjectToString(final SpreadsheetColumn column, final Object inputValue)
	{
		if (inputValue instanceof Iterable)
		{
			return StringUtils.join((Iterable<?>) inputValue, column.getDelimiter());
		}
		else
		{
			return String.valueOf(inputValue);
		}
	}

	/**
	 * This method creates list representation of the given object.
	 * 
	 * @param column
	 * @param value
	 * @return list representation of the given object
	 */
	@SuppressWarnings("unchecked")
	public static List<String> convertObjectToList(final Object value)
	{
		final List<String> newValues = new ArrayList<String>();
		if (value instanceof Collection<?>)
		{
			newValues.addAll((Collection<String>) value);
		}
		else
		{
			newValues.add(String.valueOf(value));
		}
		return newValues;
	}

}
