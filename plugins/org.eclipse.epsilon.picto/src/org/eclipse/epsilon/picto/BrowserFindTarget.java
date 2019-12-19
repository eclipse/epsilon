package org.eclipse.epsilon.picto;

import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;

public class BrowserFindTarget implements IFindReplaceTarget {
	
	protected Browser browser;
	
	public BrowserFindTarget(Browser browser) {
		this.browser = browser;
	}
	
	@Override
	public void replaceSelection(String text) {}
	
	@Override
	public boolean isEditable() {
		return false;
	}
	
	@Override
	public String getSelectionText() {
		return "";
	}
	
	@Override
	public Point getSelection() {
		return new Point(0, 0);
	}
	
	@Override
	public int findAndSelect(int widgetOffset, String findString, boolean searchForward, boolean caseSensitive,
			boolean wholeWord) {
		browser.execute("window.find('"+findString+"',0,0,1,0,0)");
		return 1;
	}
	
	@Override
	public boolean canPerformFind() {
		return true;
	}

}
