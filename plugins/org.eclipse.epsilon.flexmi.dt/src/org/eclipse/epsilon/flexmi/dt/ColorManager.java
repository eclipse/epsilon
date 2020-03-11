/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.dt;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ColorManager {

	RGB XML_COMMENT = new RGB(128, 0, 0);
	RGB PROC_INSTR = new RGB(128, 128, 128);
	RGB STRING = new RGB(0, 128, 0);
	RGB DEFAULT = new RGB(0, 0, 0);
	RGB TAG = new RGB(0, 0, 128);

	RGB XML_COMMENT_DARK = new RGB(118, 167, 37);
	RGB PROC_INSTR_DARK = new RGB(255, 255, 255);
	RGB STRING_DARK = new RGB(243, 191, 0);
	RGB TAG_DARK = new RGB(115, 148, 255);
	RGB DEFAULT_DARK = new RGB(255, 255, 255);

	protected Color commentColor;
	protected Color procInstrColor;
	protected Color stringColor;
	protected Color defaultColor;
	protected Color tagColor;

	public void initialiseColors() {
		if (EclipseUtil.isDarkThemeEnabled()) {
			commentColor = new Color(Display.getCurrent(), XML_COMMENT_DARK);
			procInstrColor = new Color(Display.getCurrent(), PROC_INSTR_DARK);
			stringColor = new Color(Display.getCurrent(), STRING_DARK);
			defaultColor = new Color(Display.getCurrent(), DEFAULT_DARK);
			tagColor = new Color(Display.getCurrent(), TAG_DARK);
		} else {
			commentColor = new Color(Display.getCurrent(), XML_COMMENT);
			procInstrColor = new Color(Display.getCurrent(), PROC_INSTR);
			stringColor = new Color(Display.getCurrent(), STRING);
			defaultColor = new Color(Display.getCurrent(), DEFAULT);
			tagColor = new Color(Display.getCurrent(), TAG);
		}
	}

	public Color getCommentColor() {
		return commentColor;
	}

	public Color getProcInstrColor() {
		return procInstrColor;
	}

	public Color getStringColor() {
		return stringColor;
	}

	public Color getDefaultColor() {
		return defaultColor;
	}

	public Color getTagColor() {
		return tagColor;
	}
}
