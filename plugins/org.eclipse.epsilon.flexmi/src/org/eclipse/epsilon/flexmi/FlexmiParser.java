package org.eclipse.epsilon.flexmi;

import java.io.InputStream;

import org.eclipse.epsilon.flexmi.xml.FlexmiXmlParser.Handler;
import org.w3c.dom.Document;

public interface FlexmiParser {
	
	public void parse(FlexmiResource resource, InputStream inputStream, Handler handler) throws FlexmiParseException;
	
	public Document parse(InputStream inputStream) throws Exception;
	
	public FlexmiFlavour getFlavour();
	
}
