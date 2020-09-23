/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.spreadsheets.google;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.spreadsheets.ISpreadsheetMetadata;
import org.eclipse.epsilon.emc.spreadsheets.ISpreadsheetMetadata.SpreadsheetWorksheetMetadata;
import org.eclipse.epsilon.emc.spreadsheets.MetadataXMLParser;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetModel;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetRow;
import org.eclipse.epsilon.emc.spreadsheets.SpreadsheetWorksheet;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.models.Model;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class GSModel extends SpreadsheetModel {
	
	/*
	 * Public identifiers used for receiving parameters from Epsilon Development
	 * Tools
	 */
	public static final String SPREADSHEET_NAME = "SPREADSHEET_NAME";
	public static final String GOOGLE_USERNAME = "GOOGLE_USERNAME";
	public static final String GOOGLE_PASSWORD = "GOOGLE_PASSWORD";
	public static final String CONFIGURATION_FILE = "CONFIGURATION_FILE";

	private String spreadsheetName;
	private String username;
	private String password;
	private File configurationFile;
	private SpreadsheetService spreadsheetService;
	private SpreadsheetEntry spreadsheetEntry;
	private Document configurationDoc;

	/*
	 * The following fields are relevant for the Searchable Model implementation
	 * (operators and connectives that are supported by Google - but not necessarily
	 * by the AST)
	 */
	@SuppressWarnings("unused")
	private static final List<String> OPERATORS = new ArrayList<>(Arrays.asList("=", "==", "<>", "<", "<=", ">", ">="));
	@SuppressWarnings("unused")
	private static final List<String> CONNECTIVES = new ArrayList<>(Arrays.asList("and", "or"));
	@SuppressWarnings("unused")
	private static final String FIND_FORMAT_EXCEPTION_MESSAGE = "Invalid search query format";

	public GSModel() {
		super();
		this.spreadsheetName = null;
		this.spreadsheetService = null;
		this.spreadsheetEntry = null;
		this.username = null;
		this.password = null;
		this.configurationFile = null;
		this.configurationDoc = null;
	}

	public static void main(String[] args) throws Exception {
		final GSModel model = new GSModel();
		if (args.length == 5) {
			model.setUsername(args[0]);
			model.setPassword(args[1]);
			model.setSpreadsheetName(args[2]);
			model.setConfigurationFile(args[3]);
			model.setName(args[4]);
		}
		model.load();

		System.out.println("*** Executing EOL Code...");
		final EolModule module = new EolModule();
		// module.parse("new Room();");
		// module.parse("new Person(Map{'age'='27'});");
		// module.parse("Room.all.println();");
		// module.parse("delete Sheet6.all;");
		// module.parse("var enid = GS.find(p:Person | p.name='Enid'); enid.println();
		// delete enid;");
		module.parse("Room.all.println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}

	public void setSpreadsheetName(final String name) {
		if (StringUtil.isEmpty(name)) {
			throw new IllegalArgumentException("Spreadsheet name may not be blank");
		}
		this.spreadsheetName = name;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setConfigurationFile(final String configurationFilePath)
		throws ParserConfigurationException, SAXException, IOException {
		if (!StringUtil.isEmpty(configurationFilePath)) {
			this.configurationFile = new File(configurationFilePath);
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			this.configurationDoc = documentBuilder.parse(this.configurationFile);
		}
	}

	public ListFeed getWorksheetListFeed(final URL listFeedUrl) throws IOException, ServiceException {
		return this.spreadsheetService.getFeed(listFeedUrl, ListFeed.class);
	}

	public CellFeed getWorksheetCellFeed(final URL cellFeedUrl) throws IOException, ServiceException {
		return this.spreadsheetService.getFeed(cellFeedUrl, CellFeed.class);
	}

	public WorksheetEntry insertWorksheet(final WorksheetEntry worksheetEntry) throws IOException, ServiceException {
		WorksheetEntry we = this.spreadsheetService.insert(this.spreadsheetEntry.getWorksheetFeedUrl(), worksheetEntry);
		this.spreadsheetEntry = this.spreadsheetEntry.getSelf();
		return we;
	}

	public ListEntry insertRow(final WorksheetEntry worksheetEntry, final ListEntry row)
		throws IOException, ServiceException {
		URL url = worksheetEntry.getListFeedUrl();
		ListEntry le = this.spreadsheetService.insert(url, row);
		return le;
	}

	/**
	 * This method loads the model using arguments provided through Epsilon
	 * Development Tools.
	 * 
	 * @see {@link Model#load(StringProperties, IRelativePathResolver)}
	 */
	@Override
	public void load(final StringProperties properties, final IRelativePathResolver resolver)
		throws EolModelLoadingException {
		super.load(properties, resolver);
		try {
			this.setSpreadsheetName(properties.getProperty(GSModel.SPREADSHEET_NAME));
			this.setUsername(properties.getProperty(GSModel.GOOGLE_USERNAME));
			this.setPassword(properties.getProperty(GSModel.GOOGLE_PASSWORD));
			final String configurationFilePath = properties.getProperty(GSModel.CONFIGURATION_FILE);
			if (!StringUtil.isEmpty(configurationFilePath)) {
				this.setConfigurationFile(resolver.resolve(configurationFilePath));
			}
		}
		catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
		super.load();
	}

	@Override
	protected void loadSpreadsheet() throws Exception {
		this.spreadsheetService = new SpreadsheetService("EpsilonGSModel_" + this.name);
		this.spreadsheetService.setUserCredentials(this.username, this.password);

		final URL spreadsheetFeedUrl = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
		final SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(spreadsheetFeedUrl);
		spreadsheetQuery.setTitleQuery(this.spreadsheetName);
		spreadsheetQuery.setTitleExact(true);
		final SpreadsheetFeed feed = spreadsheetService.getFeed(spreadsheetQuery, SpreadsheetFeed.class);
		this.loadFirstSpreadsheet(feed);
	}

	private void loadFirstSpreadsheet(final SpreadsheetFeed feed) throws Exception {
		final List<SpreadsheetEntry> spreadsheets = feed.getEntries();
		if (spreadsheets == null || spreadsheets.isEmpty()) {
			throw new IllegalArgumentException("Could not find spreadsheet with name '" + this.spreadsheetName + "'");
		}
		this.spreadsheetEntry = spreadsheets.get(0);

		this.loadWorksheets();
	}

	private void loadWorksheets() throws Exception {
		final List<WorksheetEntry> worksheetEntries = this.spreadsheetEntry.getWorksheets();
		for (final WorksheetEntry worksheetEntry : worksheetEntries) {
			final GSWorksheet worksheet = new GSWorksheet(this, worksheetEntry, true);
			this.addWorksheet(worksheet);
		}
	}

	@Override
	protected ISpreadsheetMetadata getSpreadsheetMetadata() {
		return new MetadataXMLParser(this.configurationDoc);
	}

	@Override
	protected boolean isMetadataConfigurationDefined() {
		return this.configurationFile != null && this.configurationDoc != null;
	}

	@Override
	protected SpreadsheetWorksheet createWorksheet(final SpreadsheetWorksheetMetadata metadata) throws Exception {
		final WorksheetEntry worksheetEntry = new WorksheetEntry();
		worksheetEntry.setTitle(new PlainTextConstruct(metadata.getName()));
		worksheetEntry.setColCount(GSConstants.DEFAULT_WORKSHEET_COLS);
		worksheetEntry.setRowCount(GSConstants.DEFAULT_WORKSHEET_ROWS);
		return new GSWorksheet(this, worksheetEntry, false);
	}

	@Override
	public void deleteWorksheet(final SpreadsheetWorksheet worksheet) {
		try {
			((GSWorksheet) worksheet).delete();
			super.worksheets.remove(worksheet);
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to delete " + worksheet + ": " + e.getMessage());
		}
	}

	@Override
	public Collection<SpreadsheetRow> find(Variable iterator, ModuleElement ast, IEolContext context)
		throws EolRuntimeException {
		throw new UnsupportedOperationException();
	}

	/*
	 * @Override public Collection<SpreadsheetRow> find(final Variable iterator,
	 * final ModuleElement ast, final IEolContext context) throws
	 * EolRuntimeException { try { final GSWorksheet worksheet = (GSWorksheet)
	 * this.getWorksheetByType(iterator.getType().getName());
	 * this.verifyWorksheetExists(worksheet);
	 * 
	 * final List<SpreadsheetRow> rows = new ArrayList<SpreadsheetRow>();
	 * 
	 * final String searchURI = this.getSearchURI(worksheet, iterator, ast,
	 * context); final URL searchURL = new URI(searchURI).toURL();
	 * 
	 * final ListFeed listFeed = this.spreadsheetService.getFeed(searchURL,
	 * ListFeed.class); // This is slow for (final ListEntry row :
	 * listFeed.getEntries()) { rows.add(new GSRow(worksheet, row)); } return rows;
	 * } catch (Exception e) { if
	 * (e.getMessage().equals(GSModel.FIND_FORMAT_EXCEPTION_MESSAGE)) { throw new
	 * EolRuntimeException("Query needs to be in form find(w:Worksheet | w.column = <value>)"
	 * ); } else { throw new EolRuntimeException(e.getMessage()); } } }
	 * 
	 * private void verifyWorksheetExists(final GSWorksheet worksheet) throws
	 * EolRuntimeException { if (worksheet == null) { throw new
	 * EolRuntimeException("Worksheet not found"); }
	 * worksheet.createInSpreadsheet(); }
	 * 
	 * private String getSearchURI(final GSWorksheet worksheet, final Variable
	 * iterator, final AST ast, final IEolContext context) throws Exception { final
	 * StringBuffer searchURI = new StringBuffer();
	 * searchURI.append(worksheet.getListFeedURL().toString());
	 * searchURI.append("?sq=");
	 * 
	 * String searchExpression = ""; if
	 * (GSModel.CONNECTIVES.contains(ast.getText())) { searchExpression =
	 * this.recursiveFind(iterator, ast, context, ast.getText()); } else {
	 * searchExpression = this.recursiveFind(iterator, ast, context, ""); }
	 * LOGGER.debug("Search expression: '" + searchExpression + "'");
	 * searchURI.append(URLEncoder.encode(searchExpression, "UTF-8"));
	 * 
	 * return searchURI.toString(); }
	 * 
	 * private String recursiveFind(final Variable iterator, final AST ast, final
	 * IEolContext context, final String parentOperator) throws Exception { if (ast
	 * == null) { return ""; }
	 * 
	 * final boolean astParentIsConnector =
	 * GSModel.CONNECTIVES.contains(ast.getText()); final boolean
	 * astParentIsOperator = GSModel.OPERATORS.contains(ast.getText()) &&
	 * ast.getType() == EolParser.OPERATOR && ast.getChildCount() == 2; if
	 * (astParentIsConnector) { final String valueOnLeft =
	 * this.recursiveFind(iterator, ast.getFirstChild(), context, ast.getText());
	 * final String valueOnRight = this.recursiveFind(iterator,
	 * ast.getNextSibling(), context, ast.getText());
	 * 
	 * StringBuilder expression = new StringBuilder(valueOnLeft); if
	 * (!StringUtil.isEmpty(valueOnRight)) { expression = new StringBuilder("(" +
	 * valueOnLeft + ") " + parentOperator + " (" + valueOnRight + ")"); } return
	 * expression.toString(); } else if (astParentIsOperator) { final String
	 * valueOnLeft = this.getValueOnLeft(iterator, ast, context, parentOperator);
	 * final String valueOnRight = this.recursiveFind(iterator,
	 * ast.getNextSibling(), context, "");
	 * 
	 * StringBuilder expression = new StringBuilder(valueOnLeft); if
	 * (!StringUtil.isEmpty(valueOnRight)) { expression = new StringBuilder("(" +
	 * valueOnLeft + " " + parentOperator + " " + valueOnRight + ")"); } return
	 * expression.toString(); } else { throw new
	 * EolRuntimeException(GSModel.FIND_FORMAT_EXCEPTION_MESSAGE); } }
	 * 
	 * private String getValueOnLeft(final Variable iterator, final AST ast, final
	 * IEolContext context, final String parentOperator) throws EolRuntimeException
	 * { final AST pointAst = ast.getFirstChild(); final boolean
	 * propertyOfTypeIsReferenced = pointAst != null && pointAst.getType() ==
	 * EolParser.POINT; if (propertyOfTypeIsReferenced) { final boolean
	 * typeIdentifiersMatch =
	 * pointAst.getFirstChild().getText().equals(iterator.getName()); if
	 * (typeIdentifiersMatch) { final SpreadsheetWorksheet worksheet =
	 * this.getWorksheetByType(iterator.getType().getName()); final String
	 * columnIdentifier = pointAst.getFirstChild().getNextSibling().getText(); final
	 * SpreadsheetColumn column = worksheet.getColumn(columnIdentifier); if (column
	 * == null) { final String message = "Column " + columnIdentifier +
	 * " not found in " + worksheet.getName(); throw new
	 * EolRuntimeException(message); }
	 * 
	 * final GSColumn gsColumn = (GSColumn) column; String value =
	 * context.getExecutorFactory().executeAST(pointAst.getNextSibling(), context) +
	 * ""; if (column.getDataType() == SpreadsheetDataType.STRING) { value = "\"" +
	 * value + "\""; } return gsColumn.getGoogleColumnId() + " " + ast.getText() +
	 * " " + value; } else { throw new
	 * EolRuntimeException(GSModel.FIND_FORMAT_EXCEPTION_MESSAGE); }
	 * 
	 * } else { throw new
	 * EolRuntimeException(GSModel.FIND_FORMAT_EXCEPTION_MESSAGE); } }
	 */

}
