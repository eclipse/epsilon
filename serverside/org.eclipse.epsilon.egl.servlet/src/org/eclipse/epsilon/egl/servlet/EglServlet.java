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
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.Variable;

/**
 * TODO: Dispose models, Register Ecore and load by M2 uri
 * @author dkolovos
 *
 */
public class EglServlet extends HttpServlet {
	
	protected static ModelManager modelManager = new ModelManager();
	protected static CacheFacade caching = new CacheFacade();

	
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
		
		String identifier = localPath;
		
		for (Entry<String, String[]> entry : (Set<Entry<String, String[]>>)req.getParameterMap().entrySet()) {
			identifier += entry.getKey();
			identifier += "=";
			identifier += entry.getValue()[0];
		}
				
		if (caching.pageCache.isCached(identifier)) {
			resp.setContentType("text/html");
			resp.getWriter().println(caching.pageCache.retrieve(identifier));
			
		} else {
			Profiler.INSTANCE.reset();
			EglTemplateFactory factory = new EglTemplateFactory();
			EglTemplate template;
			
			try {
				try {
					if (this.getServletContext().getResourceAsStream(localPath) == null) {
						resp.sendError(404, req.getRequestURI());
						return;
					}
					//module.parse(this.getServletContext().getResource(localPath).toURI());
					final File file = new File(this.getServletContext().getRealPath(localPath));
					template = factory.load(file);
					
				} catch (Exception e) {
					req.setAttribute("javax.servlet.error.exception", e);
					resp.sendError(500);
					return;
				}
				
				if (template.getParseProblems().size() > 0) {
					String message = "Syntax error(s) in ";
					for (ParseProblem problem : template.getParseProblems()) {
						message += problem.toString() + "\n";
					}
					resp.sendError(500, message);
					return;
				}
				
				modelManager.setCurrentModelRepository(factory.getContext().getModelRepository());
				
				FrameStack frameStack = factory.getContext().getFrameStack();
				
				// Create built-in variables
				frameStack.put(Variable.createReadOnlyVariable("modelManager", modelManager));
				frameStack.put(Variable.createReadOnlyVariable("cache", caching));
				
				// Create JSP-like built-in variables
				frameStack.put(Variable.createReadOnlyVariable("request", req));
				frameStack.put(Variable.createReadOnlyVariable("response", resp));
				frameStack.put(Variable.createReadOnlyVariable("config", getServletConfig()));
				frameStack.put(Variable.createReadOnlyVariable("application", getServletContext()));
				frameStack.put(Variable.createReadOnlyVariable("session", req.getSession()));
				
				String result = template.process();
				
				resp.setContentType("text/html");
				resp.getWriter().println(result);

				caching.pageCache.cache(identifier, result);
				
			} catch (Exception e) {
				req.setAttribute("javax.servlet.error.exception", e);
				resp.sendError(500);
			} finally {
				try {
					factory.getContext().dispose();
				}
				catch (Exception ex) {
					// We can only do so much...
				}
			}
			
			for (String targetName : Profiler.INSTANCE.getTargetNames()) {
				System.out.println(targetName + " (" + Profiler.INSTANCE.getExecutionCount(targetName) + ") " + Profiler.INSTANCE.getTotalTime(targetName, false) + " / " + Profiler.INSTANCE.getTotalTime(targetName, true));
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
}
