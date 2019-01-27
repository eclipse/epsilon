/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.prettyprinting;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PrettyPrinterManager {
	
	protected ArrayList<PrettyPrinter> prettyPrinters = new ArrayList<>();
	protected DefaultPrettyPrinter defaultPrettyPrinter;
	//protected EolPrettyPrinter eolPrettyPrinter;
	//protected IEolContext context;
	
	public PrettyPrinterManager(){
		defaultPrettyPrinter = new DefaultPrettyPrinter(this);
		//eolPrettyPrinter = new EolPrettyPrinter(context);
		//prettyPrinters.add(new EmfPrettyPrinter());
		//prettyPrinters.add(new MofPrettyPrinter());
		prettyPrinters.add(defaultPrettyPrinter);
	}
	
	public List<PrettyPrinter> getPrettyPrinters(){
		return prettyPrinters;
	}
	
	public void addPrettyPrinter(PrettyPrinter prettyPrinter) {
		prettyPrinters.add(0, prettyPrinter);
	}
	
	/**
	 * Returns a pretty printer for o
	 * @param o
	 * @return A pretty printer for o
	 * @deprecated External clients should use print(Object object) instead
	 */
	public PrettyPrinter getPrettyPrinterFor(Object o) {
		
		//if (eolPrettyPrinter.appliesTo(o)) return eolPrettyPrinter;
		
		try {
			ListIterator<PrettyPrinter> li = prettyPrinters.listIterator();
			while (li.hasNext()) {
				PrettyPrinter prettyPrinter = li.next();
				if (prettyPrinter.appliesTo(o)) {
					return prettyPrinter;
				}
			}
		}
		catch (Throwable t) {
			return defaultPrettyPrinter;
		}
		
		return null;
	}
	
	public String print(Object object) {
		try {
			return getPrettyPrinterFor(object).print(object);
		}
		catch (Exception ex) {
			return defaultPrettyPrinter.print(object);
		}
	}
	
	/*
	public static String print(Object o){
		PrettyPrinterManager ppm = new PrettyPrinterManager();
		return ppm.toString(o);
	}
	*/
	
	public String toString(Object o){
		return print(o);
	}
	
}
