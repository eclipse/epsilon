package org.eclipse.epsilon.flexmi;

import java.io.InputStream;

import org.eclipse.epsilon.flexmi.xml.FlexmiXmlParser.Handler;

public interface FlexmiParser {
	
	public void parse(FlexmiResource resource, InputStream inputStream, Handler handler) throws Exception;
	
}
