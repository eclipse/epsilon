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
package org.eclipse.epsilon.eol.execute.prettyprinting;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class PrettyPrinterManager {
	
	protected ArrayList prettyPrinters = new ArrayList();
	protected DefaultPrettyPrinter defaultPrettyPrinter;
	//protected EolPrettyPrinter eolPrettyPrinter;
	//protected IEolContext context;
	
	public PrettyPrinterManager(IEolContext context){
		defaultPrettyPrinter = new DefaultPrettyPrinter(this);
		//eolPrettyPrinter = new EolPrettyPrinter(context);
		//prettyPrinters.add(new EmfPrettyPrinter());
		//prettyPrinters.add(new MofPrettyPrinter());
		prettyPrinters.add(defaultPrettyPrinter);
	}
	
	public List getPrettyPrinters(){
		return prettyPrinters;
	}
	
	public void addPrettyPrinter(PrettyPrinter prettyPrinter) {
		prettyPrinters.add(0, prettyPrinter);
	}
	
	public PrettyPrinter getPrettyPrinterFor(Object o){
		
		//if (eolPrettyPrinter.appliesTo(o)) return eolPrettyPrinter;
		
		try {
			ListIterator li = prettyPrinters.listIterator();
			while (li.hasNext()){
				PrettyPrinter prettyPrinter = (PrettyPrinter) li.next();
				if (prettyPrinter.appliesTo(o)){
					return prettyPrinter;
				}
			}
		}
		catch (Throwable t){
			return defaultPrettyPrinter;
		}
		
		return null;
	}
	
	/*
	public static String print(Object o){
		PrettyPrinterManager ppm = new PrettyPrinterManager();
		return ppm.toString(o);
	}
	*/
	
	public String toString(Object o){
		PrettyPrinter prettyPrinter = getPrettyPrinterFor(o);
		return prettyPrinter.print(o);
	}
	
}
