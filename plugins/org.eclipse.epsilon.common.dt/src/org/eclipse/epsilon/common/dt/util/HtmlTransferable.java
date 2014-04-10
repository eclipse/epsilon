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
package org.eclipse.epsilon.common.dt.util;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class HtmlTransferable implements Transferable {
        private DataFlavor _htmlDataFlavor;
        private String _htmlText;

        public HtmlTransferable(String htmlText) {
            _htmlText = htmlText;
            try {
				_htmlDataFlavor = new DataFlavor("text/html") {
					@Override
					public Class<?> getRepresentationClass() {
						return String.class;
					}
				};
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{_htmlDataFlavor};
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return "text/html".equalsIgnoreCase(flavor.getMimeType());
        }

        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
        {
            //InputStream stringStream = new ByteArrayInputStream(_htmlText.getBytes("utf-8"));
            //return stringStream;
        	return _htmlText;
        }
    }
