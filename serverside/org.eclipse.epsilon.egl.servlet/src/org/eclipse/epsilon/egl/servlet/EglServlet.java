/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/
package org.eclipse.epsilon.egl.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.servlet.JspServlet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelResourceFactory;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * TODO: Dispose models, Register Ecore and load by M2 uri
 * @author dkolovos
 *
 */
public class EglServlet extends HttpServlet {
	
	protected static ModelManager modelManager = new ModelManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		modelManager.setServletContext(this.getServletContext());
		
		String localPath = null;
		if (req.getContextPath().trim().isEmpty()) {
			localPath = req.getRequestURI().substring(1);
		}
		else {
			localPath = req.getRequestURI().substring(req.getRequestURI().indexOf('/',1)+1);
		}
		
		EglModule module = new EglModule();
		try {
			try {
				if (this.getServletContext().getResourceAsStream(localPath) == null) {
					resp.sendError(404, req.getRequestURI());
					return;
				}
				//module.parse(this.getServletContext().getResource(localPath).toURI());
				module.parse(new File(this.getServletContext().getRealPath(localPath)));
			} catch (Exception e) {
				req.setAttribute("javax.servlet.error.exception", e);
				resp.sendError(500);
				return;
			}
			
			if (module.getParseProblems().size() > 0) {
				String message = "Syntax error(s) in ";
				for (ParseProblem problem : module.getParseProblems()) {
					message += problem.toString() + "\n";
				}
				resp.sendError(500, message);
				return;
			}
			
			modelManager.setCurrentModelRepository(module.getContext().getModelRepository());
			
			FrameStack frameStack = module.getContext().getFrameStack();
			
			// Create built-in variables
			frameStack.put(Variable.createReadOnlyVariable("modelManager", modelManager));
			
			// Create JSP-like built-in variables
			frameStack.put(Variable.createReadOnlyVariable("request", req));
			frameStack.put(Variable.createReadOnlyVariable("response", resp));
			frameStack.put(Variable.createReadOnlyVariable("config", getServletConfig()));
			frameStack.put(Variable.createReadOnlyVariable("application", getServletContext()));
			frameStack.put(Variable.createReadOnlyVariable("session", req.getSession()));
			
			String result = module.execute();
			resp.getWriter().println(result);
		} catch (Exception e) {
			req.setAttribute("javax.servlet.error.exception", e);
			resp.sendError(500);
		} finally {
			try {
				module.getContext().dispose();
			}
			catch (Exception ex) {
				// We can only do so much...
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
}
