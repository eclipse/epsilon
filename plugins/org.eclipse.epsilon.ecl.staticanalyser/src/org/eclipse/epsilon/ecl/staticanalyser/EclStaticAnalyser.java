package org.eclipse.epsilon.ecl.staticanalyser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.dom.IEclVisitor;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;

public class EclStaticAnalyser extends EolStaticAnalyser implements IEclVisitor {

	@Override
	public void visit(Post post) {
		if (post != null)
			post.getBody().accept(this);
		
	}

	@Override
	public void visit(Pre pre) {
		if (pre != null)
			pre.getBody().accept(this);
		
	}

	@Override
	public void visit(MatchRule matchRule) {
		matchRule.getLeftParameter().accept(this);
		matchRule.getRightParameter().accept(this);
		if (matchRule.getGuardBlock() != null)
			visit(matchRule.getGuardBlock());
		
		if (matchRule.getDoBlock() != null)
			visit(matchRule.getDoBlock());
		
		if (matchRule.getCompareBlock() != null)
			visit(matchRule.getCompareBlock());
		
		if (matchRule.getLeftDomainBlock() != null)
			visit(matchRule.getLeftDomainBlock());
		
		if (matchRule.getRightDomainBlock() != null)
			visit(matchRule.getRightDomainBlock());
		
	}
	
	public void visit(ExecutableBlock<?> ex) {
		if(ex != null) {
			if(ex.getBody() instanceof StatementBlock) {
				StatementBlock guardBody = ((StatementBlock) ex.getBody());
				guardBody.accept(this);
			}
			else
				((Expression)ex.getBody()).accept(this);
		}
	}

	@Override
	public List<ModuleMarker> validate(IModule imodule) {

		errors = new ArrayList<>();
		if (!(imodule instanceof EclModule))
			return null;
		EclModule etlModule = (EclModule) imodule;
		this.module = etlModule;

		super.preValidate(etlModule);
		for (Pre pre : etlModule.getDeclaredPre()) {
			pre.accept(this);
		}

		super.mainValidate(etlModule);
		for (MatchRule tr : etlModule.getMatchRules()) {
			this.getContext().getFrameStack().enterLocal(FrameType.UNPROTECTED, tr);
			tr.accept(this);
			this.getContext().getFrameStack().leaveLocal(tr);

		}

		for (Post post : etlModule.getDeclaredPost()) {
			post.accept(this);
		}

		super.postValidate(etlModule);

		this.module.getData().put("staticAnalyser", this);

		return errors;
	}

}
