package org.eclipse.epsilon.common.dt.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSvnFolder extends WebSvnFile {
	
	protected List<WebSvnFile> children = null;
	
	public static void main(String[] args) throws Exception {

		WebSvnFolder folder = new WebSvnFolder(
				"https://dev.eclipse.org/svnroot/modeling/org.eclipse.epsilon/trunk/examples/org.eclipse.epsilon.emc.contactsmodel/");
		
		for (WebSvnFile f : folder.getChildren()) {
			System.err.println(f.getRelativePath() + " - " + f.getClass().getSimpleName());
			if (f instanceof WebSvnFolder) {
				for (WebSvnFile f2 : ((WebSvnFolder)f).getChildren()) {
					System.err.println(">" + f2.getRelativePath() + " - " + f2.getClass().getSimpleName());
				}
			}
		}

	}
	
	public WebSvnFolder(String url, WebSvnFolder parent) {
		super(url, parent);
		if (!url.endsWith("/")) url += "/";		
	}
	
	public WebSvnFolder(String url) {
		super(url, null);
		if (!url.endsWith("/")) url += "/";
	}

	public List<WebSvnFile> getChildren() throws Exception {
		
		if (children == null) {
			
			children = new ArrayList<WebSvnFile>();
			List<String> childFileNames = getChildrenFileNames(url);
			
			for (String childFileName : childFileNames) {
				
				if (childFileName.startsWith("..") || childFileName.equals("/")) continue;
				
				if (childFileName.endsWith("/")) children.add(new WebSvnFolder(url + childFileName, this));
				else children.add(new WebSvnFile(url + childFileName, this));
			}
		}
		
		return children;
	}

	public String getName() {
		String temp = url.substring(0, url.length()-1);
		return temp.substring(temp.lastIndexOf("/")+1);
	}
	
	protected List<String> getChildrenFileNames(String url) throws Exception {
		ArrayList<String> childFileNames = new ArrayList<String>();
		String text = getText(url);
		Pattern links = Pattern.compile("href=\"(.*?)\"");
		Matcher matcher = links.matcher(text);
		while (matcher.find()) {
			childFileNames.add(matcher.group(1));
		}
		return childFileNames;
	}
	
	protected String getText(String url) throws Exception {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		StringBuilder response = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);

		in.close();

		return response.toString();
	}
}
