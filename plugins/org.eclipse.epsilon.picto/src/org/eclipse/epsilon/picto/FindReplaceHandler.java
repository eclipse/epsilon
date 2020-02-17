/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.util.ListResourceBundle;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.commands.ActionHandler;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.FindReplaceAction;

public class FindReplaceHandler extends org.eclipse.core.commands.AbstractHandler {

	@SuppressWarnings("deprecation")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {

			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			FindReplaceAction findReplaceAction = new FindReplaceAction(new ListResourceBundle() {
				@Override
				protected Object[][] getContents() {
					return new Object[][] {};
				}
			}, null, part);
			ActionHandler actionHandler = new ActionHandler(findReplaceAction);

			return actionHandler.execute(event);
		} catch (Exception e) {
			throw new ExecutionException("Could not execute command!", e);
		}
	}

}
