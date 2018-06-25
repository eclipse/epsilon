package org.eclipse.epsilon.egl.dt.launching.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;

public class EglAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {
	
	private enum EglLangauge {
		EVL("Evl"), EGX("Egx");
		
		private final String name;
		private String selectedImpl;

		private EglLangauge(String name) {
			this.name = name;
		}

	}
	
	private EglLangauge currentLanguage;
	

	@Override
	public EpsilonPlugin getPlugin() {
		return EglPlugin.getDefault();
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		selectLanguageFromSource(configuration);	
		super.initializeFrom(configuration);
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		try {
			if (selectLanguageFromSource(configuration)) {
				configuration.setAttribute(IMPL_NAME, currentLanguage.selectedImpl);
			}
			else {
				currentLanguage.selectedImpl = configuration.getAttribute(IMPL_NAME, "");
			}
		} catch (CoreException e) {
			// Ignore
		}
	}

	@Override
	public String getLanguage() {
		return currentLanguage.name;
	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}
	
	
	/**
	 * @param configuration
	 */
	private boolean selectLanguageFromSource(ILaunchConfiguration configuration) {
		boolean changed = false;
		String source = null;
		try {
			source = configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "");
		} catch (CoreException e) {
		
		}
		if (source != null) {
			int extPoint = source.lastIndexOf('.');
			if (extPoint > 0) {
				String fileExtension = source.substring(extPoint+1);
				EglLangauge newLanguage = EglLangauge.valueOf(fileExtension.toUpperCase());
				if (newLanguage != currentLanguage) {
					currentLanguage = newLanguage;
					changed = true;
				}
			}
		}
		if (currentLanguage == null) {
			currentLanguage = EglLangauge.EVL;
		}
		return changed;
	}
	
}
