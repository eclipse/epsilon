package org.eclipse.epsilon.common.dt.examples;


public class WebSvnFile {
	
	protected String url;
	protected WebSvnFolder parent = null;
	
	public WebSvnFile(String url, WebSvnFolder parent) {
		this.url = url;
		this.parent = parent;
	}
	
	public String getName() {
		return url.substring(url.lastIndexOf("/")+1);
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getRelativePath() {
		WebSvnFolder root = getParent();
		if (root == null) return "";
		while (root.getParent() != null) root = root.getParent();
		
		return url.substring(root.url.length());
	}

	public WebSvnFolder getParent() {
		return parent;
	}
}
