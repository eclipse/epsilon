package org.eclipse.epsilon.emc.spreadsheets;

/**
 * This class enlists the names of the tags and attributes expected to be used in ORM Metadata specifications.
 * 
 * @author Martins Francis
 */
public class ORMConstants extends SpreadsheetConstants
{
	public static final String ORM_WORKSHEET = "worksheet";
	public static final String ORM_COLUMN = "column";
	public static final String ORM_REFERENCE = "reference";

	public static final String ORM_WORKSHEET_NAME = "name";
	public static final String ORM_WORKSHEET_ALIAS = "alias";
	public static final String ORM_WORKSHEET_DTSTRICT = "dataTypeStrict";
	public static final String ORM_WORKSHEET_CREATE = "createOnLoad";

	public static final String ORM_COLUMN_INDEX = "index";
	public static final String ORM_COLUMN_NAME = "name";
	public static final String ORM_COLUMN_ALIAS = "alias";
	public static final String ORM_COLUMN_DATA_TYPE = "dataType";
	public static final String ORM_COLUMN_MANY = "many";
	public static final String ORM_COLUMN_DELIMITER = "delimiter";

	public static final String ORM_REFERENCE_SOURCE = "source";
	public static final String ORM_REFERENCE_TARGET = "target";
	public static final String ORM_REFERENCE_MANY = "many";
	public static final String ORM_REFERENCE_CASCADE = "cascadeUpdates";
	public static final String ORM_REFERENCE_SEPARATOR = "->";
}
