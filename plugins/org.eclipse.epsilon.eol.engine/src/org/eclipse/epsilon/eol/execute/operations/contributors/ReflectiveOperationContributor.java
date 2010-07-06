package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.lang.reflect.Method;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class ReflectiveOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target != null;
	}
	
	@Override
	public ObjectMethod getObjectMethodFor(Object target, String name,
			Object[] parameters, IEolContext context) {
		Method method = ReflectionUtil.getMethodFor(target, name, parameters);
		if (method != null) {
			ObjectMethod objectMethod = new ObjectMethod();
			setTarget(target);
			objectMethod.setMethod(method);
			objectMethod.setObject(target);
			setContext(context);
			return objectMethod;
		}
		else {
			return null;
		}
	}

}
