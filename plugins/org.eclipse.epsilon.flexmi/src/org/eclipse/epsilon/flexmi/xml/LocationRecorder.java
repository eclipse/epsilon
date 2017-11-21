package org.eclipse.epsilon.flexmi.xml;

import java.util.Stack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.XMLFilterImpl;

public class LocationRecorder extends XMLFilterImpl {

	protected Locator locator;
	protected Stack<Locator> locatorStack = new Stack<Locator>();
	protected UserDataHandler dataHandler = new LocationDataHandler();
	protected Stack<Node> nodeStack = new Stack<Node>();

	LocationRecorder(XMLReader xmlReader, Document dom) {
		super(xmlReader);

		((EventTarget) dom).addEventListener("DOMNodeInserted",
				new EventListener() {

					@Override
					public void handleEvent(Event e) {
						EventTarget target = ((MutationEvent) e).getTarget();
						if (target instanceof Element || target instanceof ProcessingInstruction) {
							nodeStack.push((Node) target);
						}
					}
				}, true);
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		super.setDocumentLocator(locator);
		this.locator = locator;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		super.startElement(uri, localName, qName, atts);

		locatorStack.push(new LocatorImpl(locator));
	}
	
	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		super.processingInstruction(target, data);
		
		Location location = new Location(locator.getLineNumber(),
				locator.getColumnNumber(), locator.getLineNumber(),
				locator.getColumnNumber());

		nodeStack.pop().setUserData(Location.ID,
				location, dataHandler);
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		super.endElement(uri, localName, qName);

		if (locatorStack.size() > 0) {
			Locator startLocator = locatorStack.pop();

			Location location = new Location(startLocator.getLineNumber(),
					startLocator.getColumnNumber(), locator.getLineNumber(),
					locator.getColumnNumber());

			nodeStack.pop().setUserData(Location.ID,
					location, dataHandler);
		}
	}

	private class LocationDataHandler implements UserDataHandler {

		@Override
		public void handle(short operation, String key, Object data, Node src,
				Node dst) {

			if (src != null && dst != null) {
				Location locatonData = (Location) src
						.getUserData(Location.ID);
				if (locatonData != null) {
					dst.setUserData(Location.ID,
							locatonData, dataHandler);
				}
			}
		}
	}
}