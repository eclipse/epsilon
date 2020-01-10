package org.eclipse.epsilon.egl;

import java.net.URI;
import java.util.Collection;

import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.eol.IEolModule;

public interface IEglModule extends IEolModule {

	@Override
	default IEglContext getContext() {
		return (IEglContext) ((IEglModule)this).getContext();
	}

	EglTemplateFactory getFactory();

	void setFactory(EglTemplateFactory factory);

	EglTemplate getCurrentTemplate();

	boolean parse(String code, URI uri) throws Exception;

	void reset();

	void setDefaultFormatters(Collection<Formatter> defaultFormatters);
}
