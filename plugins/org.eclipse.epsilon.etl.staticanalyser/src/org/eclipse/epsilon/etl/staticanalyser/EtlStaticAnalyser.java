package org.eclipse.epsilon.etl.staticanalyser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.etl.dom.IEtlVisitor;
import org.eclipse.epsilon.etl.dom.TransformationRule;

public class EtlStaticAnalyser extends EolStaticAnalyser implements IEtlVisitor {

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
	public void visit(TransformationRule transformationRule) {
		transformationRule.getSourceParameter().accept(this);
		transformationRule.getTargetParameters().forEach(t -> t.accept(this));
		ExecutableBlock<Boolean> guard =transformationRule.getGuard();
		if(guard != null) {
			if(guard.getBody() instanceof StatementBlock) {
				StatementBlock guardBody = ((StatementBlock) guard.getBody());
				guardBody.accept(this);
			}
			else
				((Expression)guard.getBody()).accept(this);
		}
		ExecutableBlock<Void> rule =transformationRule.getBody();
		if(rule != null) {
		StatementBlock ruleBody = (StatementBlock) rule.getBody();
		ruleBody.accept(this);
		}
	}

	@Override
	public List<ModuleMarker> validate(IModule imodule) {

		errors = new ArrayList<>();
		if (!(imodule instanceof EtlModule))
			return null;
			EtlModule etlModule = (EtlModule) imodule;
			this.module = etlModule;
			
			super.preValidate(etlModule);
			for (Pre pre : etlModule.getDeclaredPre()) {
				pre.accept(this);
			}

			super.mainValidate(etlModule);
			for (TransformationRule tr : etlModule.getTransformationRules()) {
				this.getContext().getFrameStack().enterLocal(FrameType.UNPROTECTED, tr, new Variable("self", EolPrimitiveType.String));
				tr.accept(this);
				this.getContext().getFrameStack().leaveLocal(tr);
				
			}
			
			for (Post post : etlModule.getDeclaredPost()) {
				post.accept(this);
			}
			
			super.postValidate(etlModule);

			return errors;
		}

}
