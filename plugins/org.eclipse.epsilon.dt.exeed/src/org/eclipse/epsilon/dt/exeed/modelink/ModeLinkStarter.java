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
package org.eclipse.epsilon.dt.exeed.modelink;

import java.util.ListIterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.epsilon.dt.exeed.modelink.ModeLinkInnerEditorInput.Position;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ModeLinkStarter extends EditorPart {

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		startModeLinkEditor();
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {

		// startModeLinkEditor();
		/*
		 * Thread thread = new Thread(new Runnable(){
		 * 
		 * public void run() { try { //Thread.currentThread().sleep(50);
		 * 
		 *  } catch (InterruptedException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } }
		 * 
		 * });
		 * 
		 * thread.start();
		 */ 
	}

	protected void startModeLinkEditor() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				getSite().getPage().closeEditor(ModeLinkStarter.this, false);
				try {
					// getSite().getPage().openEditor(ModeLinkStarter.this.getEditorInput(),
					// "org.eclipse.ui.DefaultTextEditor");
					getSite()
							.getPage()
							.openEditor(
									new FileEditorInputToModeLinkEditorInputConverter()
											.convert((FileEditorInput) ModeLinkStarter.this
													.getEditorInput()),
									"org.eclipse.epsilon.dt.exeed.modelink.ModeLinkEditor");
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
	}

	@Override
	public void setFocus() {

	}

	class FileEditorInputToModeLinkEditorInputConverter {

		public ModeLinkEditorInput convert(FileEditorInput input) {

			IEditorInput[] inputs = null;
			String[] editorIds = null;
			boolean threeWay = true;

			try {
				SAXBuilder builder = new SAXBuilder();
				input.getFile().refreshLocal(0, null);
				Document doc = builder.build(input.getFile().getContents());
				Element root = doc.getDocument().getRootElement();

				threeWay = !root.getAttributeValue("threeWay", "")
						.equalsIgnoreCase("false");

				int size = root.getChildren().size();
				inputs = new IEditorInput[size];
				editorIds = new String[size];

				ListIterator li = root.getChildren().listIterator();
				int i = 0;
				while (li.hasNext()) {
					Object next = li.next();
					if (next instanceof Element) {
						Element el = (Element) next;

						IEditorInput editorInput = null;
						String path = el.getAttributeValue("path");

						editorInput = new ModeLinkInnerEditorInput(
								ResourcesPlugin.getWorkspace().getRoot()
										.getFile(new Path(path)),
								getPosition(el.getAttributeValue("position",
										"left")));
						
						IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
						
						IEditorDescriptor editorDescriptor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(path, IDE.getContentType(file));
						System.err.println(editorDescriptor + " " + path);
						String editorId = null;
						if (editorDescriptor != null) editorId = editorDescriptor.getId();
						else 
							editorId = "org.eclipse.epsilon.dt.exeed.ExeedEditor";
							
						editorIds[i] = editorId;
						
						
						inputs[i] = editorInput;
						// editorIds[i] = editorId;
						i++;
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			ModeLinkEditorInput modeLinkEditorInput = new ModeLinkEditorInput(
					editorIds, inputs, (FileEditorInput) getEditorInput());
			modeLinkEditorInput.setThreeWay(threeWay);
			return modeLinkEditorInput;

		}

		protected Position getPosition(String str) {
			if (str.equalsIgnoreCase("right")) {
				return Position.RIGHT;
			} else if (str.equalsIgnoreCase("middle")) {
				return Position.MIDDLE;
			} else {
				return Position.LEFT;
			}
		}

	}

}
