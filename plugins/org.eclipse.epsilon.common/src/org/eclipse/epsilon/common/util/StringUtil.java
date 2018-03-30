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
package org.eclipse.epsilon.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StringUtil {
	
	public static Collection<String> split(String str, String delimiter) {
		if (str == null) return Collections.emptyList();
		
		ArrayList<String> parts = new ArrayList<>();
		
		for (String p : str.split(delimiter)) {
			parts.add(p.trim());
		}
		
		return parts;
	}
	
	public static boolean isEmpty(String str)  {
		return str == null || str.trim().isEmpty();
	}
	
	public static Object print(Object o) {
		return o;
	}
	
	public static String firstToUpper(String str) {
		String result = str.substring(1, str.length());
		result = str.substring(0,1).toUpperCase() + result;
		return result;
	}
	
	public static String firstToLower(String str) {
		String result = str.substring(1, str.length());
		result = str.substring(0,1).toLowerCase() + result;
		return result;
	}
	
	public static boolean areEqual(String s1, String s2) {
		return toString(s1).equalsIgnoreCase(toString(s2));
	}
	
	public static String toString(Object o) {
		if (o != null){
			return o.toString();
		}
		else {
			return "";
		}
	}
	
	public static String toString(Object o, String default_) {
		if (o != null) {
			return o.toString();
		}
		else {
			return default_;
		}
	}
	
	public static boolean isOneOf(String target, String...candidates) {
		for (String candidate : candidates) {
			if (candidate.equals(target)) return true;
		}
		return false;
	}
	
	public static String escapeHtml(String string) {
		if (string == null) return "";
	    StringBuffer sb = new StringBuffer(string.length());
	    // true if last char was blank
	    boolean lastWasBlankChar = false;
	    int len = string.length();
	    char c;

	    for (int i = 0; i < len; i++) {
	        c = string.charAt(i);
	        if (c == ' ') {
	            // blank gets extra work,
	            // this solves the problem you get if you replace all
	            // blanks with &nbsp;, if you do that you loss 
	            // word breaking
	            if (lastWasBlankChar) {
	                lastWasBlankChar = false;
	                sb.append("&nbsp;");
	                }
	            else {
	                lastWasBlankChar = true;
	                sb.append(' ');
	                }
	            }
	        else {
	            lastWasBlankChar = false;
	            //
	            // HTML Special Chars
	            if (c == '"')
	                sb.append("&quot;");
	            else if (c == '&')
	                sb.append("&amp;");
	            else if (c == '<')
	                sb.append("&lt;");
	            else if (c == '>')
	                sb.append("&gt;");
	            else if (c == '\n')
	                // Handle Newline
	                sb.append("&lt;br/&gt;");
	            else {
	                int ci = 0xffff & c;
	                if (ci < 160) {
	                    // nothing special only 7 Bit
	                    sb.append(c);
	                }
	                else {
	                    // Not 7 Bit use the unicode system
	                    sb.append("&#");
	                    sb.append(ci);
	                    sb.append(';');
	                }
	            }
	        }
	    }
	    return sb.toString();
	}

	public static String reverse(String text) {
		return new StringBuilder(text).reverse().toString();
	}

	public static String concat(String separator, Object[] items) {
		final StringBuffer sbuf = new StringBuffer();
		boolean first = true;
		for (Object o : items) {
			if (first) {
				first = false;
			} else {
				sbuf.append(separator);
			}
			sbuf.append(o + "");
		}
		return sbuf.toString();
	}
	
	public static String stripHashCodes(Object obj) {
		if (obj != null) {
			return obj.toString().replaceAll("@([0-9a-fA-F]{1,8})", "");
		}
		return null;
	}
}
