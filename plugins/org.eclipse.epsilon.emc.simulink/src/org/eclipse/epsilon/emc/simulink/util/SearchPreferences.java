package org.eclipse.epsilon.emc.simulink.util;

public class SearchPreferences {

	public static final String PROPERTY_FOLLOW_LINKS = "follow_links";
	public static final String PROPERTY_LOOK_UNDER_MASKS = "look_under_masks";
	public static final String PROPERTY_INCLUDE_COMMENTED = "include_commented";
	
	
	private static SearchPreferences instance;
	
	private SearchPreferences() {}
	
	public static SearchPreferences getInstance(){
		if (instance == null) {
			instance = new SearchPreferences();
		}
		return instance;
	}
	
	protected Boolean followLinks = false;
	protected Boolean includeCommented = true;
	protected String lookUnderMasks = "on";
	
	public void setFollowLinks(Boolean followLinks) {
		this.followLinks = followLinks;
	}
	
	
	public Boolean isFollowLinks() {
		return followLinks;
	}
	
	public String followLinks(){
		return (followLinks) ? "on" : "off";
	}
	
	/** 
	 * @param lookUnderMasks Any of: graphical, none, functional, all, on, off
	 */
	public void setLookUnderMasks(String lookUnderMasks) {
		this.lookUnderMasks = lookUnderMasks;
	}	
	
	public String getLookUnderMasks() {
		return lookUnderMasks;
	}
	
	public void setIncludeCommented(Boolean includeCommented) {
		this.includeCommented = includeCommented;
	}
	
	public Boolean isIncludeCommented() {
		return includeCommented;
	}
	
	public String includeCommented() {
		return includeCommented ? "on" : "off";
	}
	
	public String searchStatement() {
		return String.format("'LookUnderMasks','%s','FollowLinks','%s', 'IncludeCommented','%s'",getLookUnderMasks(), followLinks(), includeCommented()); 
	}
	
}
