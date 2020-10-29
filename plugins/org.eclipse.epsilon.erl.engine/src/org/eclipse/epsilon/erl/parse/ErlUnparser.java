package org.eclipse.epsilon.erl.parse;

import org.eclipse.epsilon.eol.parse.EolUnparser;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.dom.IErlVisitor;
import org.eclipse.epsilon.erl.dom.NamedStatementBlockRule;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;

public abstract class ErlUnparser extends EolUnparser implements IErlVisitor {
	
	public String unparse(ErlModule module) {
		return super.unparse(module);
	}
	
	@Override
	protected void unparseMain() {
		((ErlModule) module).getDeclaredPre().forEach(p -> {p.accept(this); newline();});
		unparseRules();
		((ErlModule) module).getDeclaredPost().forEach(p -> {p.accept(this); newline();});
	}
	
	protected abstract void unparseRules();
	
	@Override
	public void visit(Post post) {
		unparsePreAndPost("post", post);
	}

	@Override
	public void visit(Pre pre) {
		unparsePreAndPost("pre", pre);
	}
	
	protected void unparsePreAndPost(String label, NamedStatementBlockRule preOrPost) {
		unparseAnnotations(preOrPost);
		buffer.append(label + " ");
		if (preOrPost.getName() != null) buffer.append(preOrPost.getName() + " ");
		preOrPost.getBody().accept(this);
	}
	
}
