package org.eclipse.epsilon.picto.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.picto.PictoPlugin;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

public class ViewContentsMenuAction extends Action implements IMenuCreator {
	
	protected PictoView pictoView;
	
	public ViewContentsMenuAction(PictoView pictoView) {
		super("View source", AS_DROP_DOWN_MENU);
		setImageDescriptor(PictoPlugin.getDefault().getImageDescriptor("icons/source.png"));
		setMenuCreator(this);
		this.pictoView = pictoView;
	}

	@Override
	public void dispose() {}

	@Override
	public Menu getMenu(Control parent) {
		
		if (pictoView.getActiveView() == null) return null;
		
		Menu viewContentsMenu = new Menu(parent);
		
		
		List<ViewContent> viewContents = pictoView.getActiveView().getContents(pictoView.getViewRenderer());
		
		for (ViewContent viewContent : viewContents) {
			ActionContributionItem item= new ActionContributionItem(new RenderViewContentAction(viewContent, viewContents, pictoView.getViewRenderer()));
			item.fill(viewContentsMenu, 0);
		}
		
		if (viewContents.stream().filter(vc -> vc.isActive()).findAny().orElse(null) != null) {
			new Separator().fill(viewContentsMenu, 0);
			new ActionContributionItem(new RenderActiveViewAction(pictoView, viewContents)).fill(viewContentsMenu, 0);
		}
		
		return viewContentsMenu;
	}

	@Override
	public Menu getMenu(Menu parent) {
		return null;
	}
}
