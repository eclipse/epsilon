package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.compatibility.StringCompatibilityOperationContributor;

public class OperationContributorRegistry extends ArrayList<OperationContributor>{
	
	public OperationContributorRegistry() {
		add(new StringCompatibilityOperationContributor());
		add(new ReflectiveOperationContributor());
		add(new WrapperOperationContributor());
		add(new StringOperationContributor());
		add(new IntegerOperationContributor());
		add(new NumberOperationContributor());
		add(new BooleanOperationContributor());
		add(new ArrayOperationContributor());
		add(new CollectionOperationContributor());
		add(new ScalarOperationContributor());
		add(new AnyOperationContributor());
	}
	
	public ObjectMethod getContributedMethod(Object o, String name, Object[] parameters, IEolContext context) {
		for (OperationContributor c : this) {
			if (c.contributesTo(o)) {
				ObjectMethod objectMethod = c.getObjectMethodFor(o, name, parameters, context);
				if (objectMethod != null) return objectMethod;
			}
		}
		return null;
	}
	
}
