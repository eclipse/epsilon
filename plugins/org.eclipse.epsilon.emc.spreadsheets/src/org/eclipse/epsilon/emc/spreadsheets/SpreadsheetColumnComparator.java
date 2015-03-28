package org.eclipse.epsilon.emc.spreadsheets;

import java.io.Serializable;
import java.util.Comparator;

/**
 * This class implements a comparator for SpreadsheetColumn objects, which are ordered by their indices in ascending
 * order.
 * 
 * @author Martins Francis
 */
public class SpreadsheetColumnComparator implements Comparator<SpreadsheetColumn>, Serializable
{
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(final SpreadsheetColumn c1, final SpreadsheetColumn c2)
	{
		if (c1.getWorksheet() != c2.getWorksheet())
		{
			return c1.getWorksheet().getName().compareTo(c2.getWorksheet().getName());
		}

		if (c1.getIndex() > c2.getIndex())
		{
			return 1;
		}
		else if (c1.getIndex() < c2.getIndex())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

}
