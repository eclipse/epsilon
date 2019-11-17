package org.eclipse.epsilon.picto;

public class StringContentPromise implements ContentPromise {

	protected String content;

	public StringContentPromise(String content) {
		super();
		this.content = content;
	}

	@Override
	public String getContent() throws Exception {
		return content;
	}
}