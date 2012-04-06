package org.eclipse.epsilon.common.dt.editor;

import java.util.ArrayList;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;

public class AutoclosingPairManager implements IDocumentListener {

	protected ArrayList<AutoclosingPair> autoclosingPairs = null;
	protected IDocument document;
	
	public AutoclosingPairManager(IDocument document) {
		this.document = document;
		document.addDocumentListener(this);
	}
	
	public ArrayList<AutoclosingPair> getAutoclosingPairs() {
		if (autoclosingPairs == null) {
			autoclosingPairs = new ArrayList<AutoclosingPair>();
			autoclosingPairs.add(new AutoclosingPair("\"", "\""));
			autoclosingPairs.add(new AutoclosingPair("(", ")"));
			autoclosingPairs.add(new AutoclosingPair("{", "}"));
			autoclosingPairs.add(new AutoclosingPair("'", "'"));
		}
		return autoclosingPairs;
	}

	boolean auto = false;

	public void documentAboutToBeChanged(DocumentEvent event) {
		
		if (auto) return;
		
		boolean skip = false;
		try {
			
			String before = "";
			String after = "";
			try {
				before = event.getDocument().get(event.fOffset - 1, 1);
				after = event.getDocument().get(event.fOffset, 1);
			}
			catch (BadLocationException ex) {}
			
			if (event.getText().isEmpty()) {
				before = event.getDocument().get(event.fOffset, 1);
				after = event.getDocument().get(event.fOffset + 1, 1);
				for (AutoclosingPair pair : getAutoclosingPairs()) {
					if (pair.getLeft().equals(before) && pair.getRight().equals(after)) {
						auto = true;
						event.fDocument.replace(event.fOffset, 1, "");
						event.fLength = 1;
						auto = false;
					}
				}
				
			}
			else if (event.getText().length() == 1){
				for (AutoclosingPair pair : getAutoclosingPairs()) {	
					if (event.fText.equalsIgnoreCase(pair.getRight())
							&& before.equalsIgnoreCase(pair.getLeft())
							&& after.equalsIgnoreCase(pair.getRight())) {
						skip = true;
						auto = true;
						event.fDocument.replace(event.fOffset, 1, "");
						auto = false;
					}
	
					if (!skip && event.fText.equalsIgnoreCase(pair.getLeft()) && after.trim().length() == 0) {
						
						if (pair.getLeft() == pair.getRight()) {
							if (!autoInsert(pair.getLeft(), event)) continue;
						}
						
						auto = true;
						event.fDocument.replace(event.fOffset, 0, pair.getRight());
						auto = false;
					}
				}
			}
		} catch (Exception e) {}
	}
	
	protected boolean autoInsert(String s, DocumentEvent event) {
		try {
			int offset = event.getOffset();
			int lineNumber = event.getDocument().getLineOfOffset(offset);
			int lineOffset = event.getDocument().getLineOffset(lineNumber);
			int length = event.getDocument().getLineLength(lineNumber);
			boolean autoInsert = true;
			for (int i=lineOffset;i<lineOffset + length - 1;i++) {
				if (s.equals(event.getDocument().get(i, 1))) {
					autoInsert = !autoInsert;
				}
			}
			return autoInsert;
		}
		catch (BadLocationException ex) {}
		return true;
	}
	
	public void documentChanged(DocumentEvent event) {
		
	}

}
