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
package org.eclipse.epsilon.dt.exeed.modelink;

import java.lang.reflect.Method;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class CTabFolderUtil {

	public static void setTabItemIndex(CTabFolder folder, CTabItem item,
			int index) {
		try {
			destroyItem(folder, item);
			createItem(folder, item, index);
		} catch (Exception ex) {
			LogUtil.log(ex);
		}
	}

	public static void destroyItem(CTabFolder folder, CTabItem item)
			throws Exception {
		Method method = CTabFolder.class.getDeclaredMethod("destroyItem",
				new Class[] { CTabItem.class });
		method.setAccessible(true);
		method.invoke(folder, new Object[] { item });
	}

	public static void createItem(CTabFolder folder, CTabItem item, int index)
			throws Exception {
		Method method = CTabFolder.class.getDeclaredMethod("createItem",
				new Class[] { CTabItem.class, int.class });
		method.setAccessible(true);
		method.invoke(folder, new Object[] { item, index });
	}

	public static void addDndSupport(final CTabFolder folder, final TabOrderChangeListener orderChangeListener) {

		Listener listener = new Listener() {
			boolean drag = false;

			boolean exitDrag = false;

			CTabItem dragItem;

			public void handleEvent(Event e) {
				Point p = new Point(e.x, e.y);
				if (e.type == SWT.DragDetect) {
					p = folder.toControl(Display.getCurrent()
							.getCursorLocation()); // see bug 43251
				}
				switch (e.type) {
				case SWT.DragDetect: {
					CTabItem item = folder.getItem(p);
					if (item == null)
						return;
					drag = true;
					exitDrag = false;
					dragItem = item;
					break;
				}
				case SWT.MouseEnter:
					if (exitDrag) {
						exitDrag = false;
						drag = e.button != 0;
					}
					break;
				case SWT.MouseExit:
					if (drag) {
						folder.setInsertMark(null, false);
						exitDrag = true;
						drag = false;
					}
					break;
				case SWT.MouseUp: {
					if (!drag)
						return;
					folder.setInsertMark(null, false);
					CTabItem item = folder.getItem(new Point(p.x, 1));
					if (item != null) {
						//Rectangle rect = item.getBounds();
						//boolean after = p.x > rect.x + rect.width / 2;
						int index = folder.indexOf(item);
						// index = after ? index + 1 : index -1;
						//if (!after) {
						//	index --;
						//}
						index = Math.max(0, index);

						CTabFolderUtil.setTabItemIndex(folder, dragItem, index);
						folder.setSelection(index);
						orderChangeListener.tabOrderChanged();
						
					}
					drag = false;
					exitDrag = false;
					dragItem = null;
					break;
				}
				case SWT.MouseMove: {
					if (!drag)
						return;
					CTabItem item = folder.getItem(new Point(p.x, 2));
					if (item == null) {
						folder.setInsertMark(null, false);
						return;
					}
					Rectangle rect = item.getBounds();
					boolean after = p.x > rect.x + rect.width / 2;
					folder.setInsertMark(item, after);
					break;
				}
				}
			}
		};
		folder.addListener(SWT.DragDetect, listener);
		folder.addListener(SWT.MouseUp, listener);
		folder.addListener(SWT.MouseMove, listener);
		folder.addListener(SWT.MouseExit, listener);
		folder.addListener(SWT.MouseEnter, listener);
	}
	
	public interface TabOrderChangeListener {	
		public void tabOrderChanged();
	}
	
}
