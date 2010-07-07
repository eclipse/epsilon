package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.compatibility.StringCompatibilityOperationContributor;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class OperationContributorRegistry extends ArrayList<OperationContributor>{
	
	public OperationContributorRegistry() {
		add(new StringCompatibilityOperationContributor());
		add(new ReflectiveOperationContributor());
		add(new StringOperationContributor());
		add(new NumberOperationContributor());
		add(new BooleanOperationContributor());
		add(new CollectionOperationContributor());
		add(new ScalarOperationContributor());
		add(new AnyOperationContributor());
	}
	
	public ObjectMethod getContributedMethod(Object o, String name, Object[] parameters, IEolContext context) {
		for (OperationContributor c : this) {
			if (c.contributesTo(o)) {
				ObjectMethod objectMethod = c.getObjectMethodFor(o, name, parameters, context);
				if (objectMethod != null) return objectMethod;
//				Method method = ReflectionUtil.getMethodFor(c, name, parameters);
//				if (method != null) {
//					objectMethod = new ObjectMethod();
//					c.setTarget(o);
//					objectMethod.setMethod(method);
//					objectMethod.setObject(c);
//					c.setContext(context);
//					return objectMethod;
//				}
			}
		}
		return null;
	}
	
}
