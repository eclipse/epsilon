/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.launching;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
 
/**
 * Create an instance of this class in any of your plugin classes.
 * 
 * Use it as follows ...
 * 
 * ConsoleDisplayMgr.getDefault().println("Some error msg", ConsoleDisplayMgr.MSG_ERROR);
 * ...
 * ...
 * ConsoleDisplayMgr.getDefault().clear();
 * ...  
 */
public class EolConsoleManager
{
	private static EolConsoleManager fDefault = null;
	private String fTitle = null;
	private MessageConsole fMessageConsole = null;
	
	public static final int MSG_INFORMATION = 1;
	public static final int MSG_ERROR = 2;
	public static final int MSG_WARNING = 3;
		
	public EolConsoleManager(String messageTitle)
	{		
		fDefault = this;
		fTitle = messageTitle;
	}
	
	public static EolConsoleManager getDefault() {
		return fDefault;
	}	
		
	public void println(String msg, int msgKind)
	{		
		
		System.out.println("Println");
		
		if( msg == null ) return;
		
		/* if console-view in Java-perspective is not active, then show it and
		 * then display the message in the console attached to it */		
		if( !displayConsoleView() )
		{
			/*If an exception occurs while displaying in the console, then just diplay atleast the same in a message-box */
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", msg);
			return;
		}
		
		/* display message on console */
		try {
		getNewMessageConsoleStream(msgKind).println(msg);
		}catch(Throwable ex){
			ex.printStackTrace(System.out);
		}
	}
	
	public void clear()
	{	
		/*
		getMessageConsole().get
		IDocument document = getMessageConsole().getDocument();
		if (document != null) {
			document.set("");
		}*/			
	}	
		
	private boolean displayConsoleView()
	{
		try
		{
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if( activeWorkbenchWindow != null )
			{
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				if( activePage != null )
					activePage.showView(IConsoleConstants.ID_CONSOLE_VIEW, null, IWorkbenchPage.VIEW_VISIBLE);
			}
			
		} catch (PartInitException partEx) {	
			partEx.printStackTrace(System.out);
			return false;
		}
		
		return true;
	}
	
	private MessageConsoleStream getNewMessageConsoleStream(int msgKind)
	{		
		int swtColorId = SWT.COLOR_DARK_GREEN;
		
		switch (msgKind)
		{
			case MSG_INFORMATION:
				swtColorId = SWT.COLOR_DARK_GREEN;				
				break;
			case MSG_ERROR:
				swtColorId = SWT.COLOR_DARK_MAGENTA;
				break;
			case MSG_WARNING:
				swtColorId = SWT.COLOR_DARK_BLUE;
				break;
			default:				
		}	
		
		MessageConsoleStream msgConsoleStream = getMessageConsole().newMessageStream();		
		msgConsoleStream.setColor(Display.getCurrent().getSystemColor(swtColorId));
		return msgConsoleStream;
	}
	
	private MessageConsole getMessageConsole()
	{
		if( fMessageConsole == null )
			createMessageConsoleStream(fTitle);	
		
		return fMessageConsole;
	}
		
	private void createMessageConsoleStream(String title)
	{	
		fMessageConsole = new MessageConsole(title, null); 
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ fMessageConsole });
	}	
}
