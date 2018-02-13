package org.eclipse.epsilon.emc.simulink.util;

public class SimulinkCommandBuilder {

	/**
	 * Convention:
	 *  Use %s for names/variables that are handled or created in the background
	 * 	Use ? for names/variables created by the user
	 */
		
	enum SimulinkCommand{
		PARAM_GET("get_param"),
		PARAM_SET("set_param"),
		
		BLOCK_DELETE("delete_block"),
		BLOCK_ADD("add_block"),
		
		LINE_DELETE("delete_line"),
		LINE_ADD("add_line"),
		
		INSPECT("inspect"),
		
		GET_SIMULINK_BLOCK_HANDLE("getSimulinkBlockHandle"),
		GET_FULL_NAME("getfullname"),
		
		SYSTEM_LOAD("load_system"),
		SYSTEM_OPEN("open_system"),
		SYSTEM_NEW("new_system"),
		SYSTEM_SAVE("save_system"),
		SYSTEM_FIND("find_system");
		
		private String cmd;
		
		SimulinkCommand(String command) {
			this.cmd = command;
		}
		
		public String getCommand() {
			return cmd;
		}
		
		public String handle(String handle) {
			return cmd + "(" + handle + ")";
		}
		
		public String val(String val) {
			return cmd + "('" + val + "')";
		}
		
		public String handleWithArgs(String handle, String...args) {
			return cmd + "(" + handle + ", " + ")";
		}
		
		public String valWithArgs(String val) {
			return cmd + "('" + val + "')";
		}
		/*
		public String base(String handle) {
			switch(this) {
			case SYSTEM_LOAD:
			case SYSTEM_OPEN:
				return val(handle);
			case BLOCK_DELETE:
			case SYSTEM_SAVE:
				return handle(handle);
			case PARAM_GET:
				return 
			case SYSTEM_FIND:
			case SYSTEM_NEW:
				
			default:
				
			}
		}
		
		public String base() {
			return this.base(HANDLE);
		}*/
	}
	
	
}
