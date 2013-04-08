package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;

public class MultilineDamagerRepairer extends DefaultDamagerRepairer {

	public MultilineDamagerRepairer(ITokenScanner scanner, TextAttribute defaultTextAttribute) {
		super(scanner, defaultTextAttribute);
	}
	
	public MultilineDamagerRepairer(ITokenScanner scanner) {
		super(scanner);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.presentation.IPresentationDamager#getDamageRegion(org.eclipse.jface.text.ITypedRegion, org.eclipse.jface.text.DocumentEvent, boolean)
	 */
	public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent e, boolean documentPartitioningChanged) {
		return partition;
	}

	/**
	 * Configures the scanner's default return token. This is the text attribute
	 * which is returned when none is returned by the current token.
	 */
	public void setDefaultTextAttribute(TextAttribute defaultTextAttribute) {
		fDefaultTextAttribute= defaultTextAttribute;
	}
}