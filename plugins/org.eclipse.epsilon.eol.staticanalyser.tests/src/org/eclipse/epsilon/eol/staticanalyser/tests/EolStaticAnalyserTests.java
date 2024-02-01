package org.eclipse.epsilon.eol.staticanalyser.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.eol.staticanalyser.StaticModelFactory;
import org.eclipse.epsilon.eol.types.EolType;
import org.junit.Test;

public class EolStaticAnalyserTests {
	static int ident = 0;

	@Test
	public void testModelElementTypeVariableDeclaration() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClass;");
		assertValid(st.toString());
	}
	
	@Test
	public void testModelElementTypeVariableDeclarationError() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClss;");
		assertValidMessage(st.toString(), "Unknown type M!EClss");
	}
	
	@Test
	public void testModelElementTypeAssignment() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClass = new M!EClass;");
		assertValid(st.toString());
	}
	
	@Test
	public void testModelElementTypeAssignmentError() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClass = new M!EPackage;");
		assertValidMessage(st.toString(), "M!EPackage cannot be assigned to M!EClass");
	}
	
	@Test
	public void testModelElementTypePropertyAssignmentError() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClass = new M!EClass;");
		st.append("i.names = \"className\";");
		assertValidMessage(st.toString(), "Structural feature names not found in type EClass");
	}
	
	@Test
	public void testModelAliases() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M alias X driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:X!EClass = new X!EClass;");
		st.append("i.name = \"className\";");
		assertValid(st.toString());
	}
	
	@Test
	public void testTuplePropertyError() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var t:Tuple = new Tuple(name = \"bob\");");
		st.append("t.names.println();");
		assertValidMessage(st.toString(), "Tuple t does not have property names");
	}
	
	@Test
	public void testUseAfterDelete() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClass = new M!EClass;");
		st.append("delete i;");
		st.append("i.name = \"className\";");
		assertValidMessage(st.toString(), "Cannot access object i after deletion");
	}
	
	@Test
	public void testUseAfterStochasticDelete() throws Exception {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		StringBuffer st = new StringBuffer();
		st.append("model M driver EMF {nsuri=\"http://www.eclipse.org/emf/2002/Ecore\"};");
		st.append("var i:M!EClass = new M!EClass;");
		st.append("var r = new Native(\"java.util.Random\");");
		st.append("if (r.nextint(99) > 50){delete i;}");
		st.append("i.name = \"className\";");
		assertValidMessage(st.toString(), "Cannot access object i after deletion");
	}

	@Test
	public void testPrimitiveTypesVariableDeclaration() throws Exception {
		assertValid("var i : Integer; (/*Integer*/i).println();");
		assertValid("var b : Boolean; (/*Boolean*/b).println();");
		assertValid("var s : String; (/*String*/s).println();");
		assertValid("var r : Real; (/*Real*/r).println();");
	}

	@Test
	public void testPrimitiveTypesAssignmentExpression() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var i : Integer = 4;");
		st.append("var s : String = \"test\";");
		st.append("(/*Integer*/i) = 5;");
		st.append("var a : Any = true;");
		st.append("(/*Any*/ a) = (/*String*/s);");
		assertValid(st.toString());
	}

	@Test
	public void testCollectionTypesAssignmentExpression() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var col : Collection<Integer> = Collection{0..9};\n");
		st.append("var seq : Sequence<Integer> = Sequence{0..9};\n");
		st.append("var bg : Bag<Integer> = Bag{0..9};\n");
		st.append("(/*Collection<Integer>*/col) = (/*Bag<Integer>*/bg);\n");
		st.append("(/*Collection<Integer>*/col) = (/*Sequence<Integer>*/seq);\n");
		assertValid(st.toString());
	}

	@Test
	public void testPrimitiveTypesAssignmentExpressionErrorMessage() throws Exception {
		StringBuffer st = new StringBuffer();
		st.append("var i : Integer = 4;");
		st.append("var s : String = \"test\";");
		String expectedMessage = "String cannot be assigned to Integer";
		st.append("i = s;");
		assertValidMessage(st.toString(), expectedMessage);
	}

	public void assertValid(String eol) throws Exception {
		EolModule module = new EolModule();
		module.parse(eol);
		EolStaticAnalyser staticAnalyser = new EolStaticAnalyser(new StaticModelFactory());
		List<ModuleMarker> errors = staticAnalyser.validate(module);
		assert errors.size() == 0 : "Was expecting 0 errors but found " + errors.size();
		visit(module.getChildren());
	}

	public void assertValidMessage(String eol, String message) throws Exception {
		EolModule module = new EolModule();
		module.parse(eol);
		EolStaticAnalyser staticAnalyser = new EolStaticAnalyser(new StaticModelFactory());
		List<ModuleMarker> errors = staticAnalyser.validate(module);
		
		assert (errors.size() == 1): "unexpected number of errors (" + errors.size() + ") in eol module";
		assertEquals(message, errors.get(0).getMessage());
	}

	protected void visit(List<ModuleElement> elements) {
		for (ModuleElement element : elements) {
			if (!element.getComments().isEmpty()) {
				assertEquals(element.getComments().get(0).toString(), getResolvedType(element).toString());
			}
			visit(element.getChildren());
		}
	}

	protected EolType getResolvedType(ModuleElement element) {
		return (EolType) element.getData().get("resolvedType");
	}
	
	public void printTree(ModuleElement parent) {
		System.out.println("  ".repeat(ident) + parent.getClass().getSimpleName());
		ident += 1;
		for (ModuleElement m : parent.getChildren()) {
			printTree(m);
		}
		ident -= 1;
	}
}
