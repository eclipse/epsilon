package org.eclipse.epsilon.eunit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.internal.eunit.util.Pair;

public interface IEUnitModule extends IEolModule {

	void runSuite(EUnitTest node) throws EolRuntimeException;

	EUnitTest getSuiteRoot() throws EolRuntimeException;

	boolean isAnnotatedAs(Operation operation, String annotation);

	List<Pair<Operation, String>> getDataVariableNames();

	ArrayList<Operation> getSuiteTeardowns();

	ArrayList<Operation> getSuiteSetups();

	ArrayList<Operation> getTeardowns();

	ArrayList<Operation> getSetups();

	ArrayList<Operation> getInlineModelOperations();

	ArrayList<Operation> getTests();

	String getQualifiedName();

	void setPackage(String packageName);

	String getPackage();

	File getReportDirectory();

	void setReportDirectory(File reportFile);

	void setSelectedOperations(List<?> attribute) throws EolRuntimeException;

	List<?> getSelectedOperations();

	boolean removeTestListener(EUnitTestListener listener);

	boolean addTestListener(EUnitTestListener listener);

	String getClassName();

}
