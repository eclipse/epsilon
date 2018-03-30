package org.eclipse.epsilon.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OsUtil {

	private OsUtil() {}

	public enum OSFamily {
		WINDOWS,
		UNIX,
		LINUX,
		SOLARIS,
		MAC,
		OTHER;
		
		public static OSFamily getOSFamily() {
			switch (System.getProperty("os.name").substring(0, 3).toLowerCase()) {
				case "win": return WINDOWS;
				case "lin": case "deb": case "cen": case "fed": case "ubu": case "and": return LINUX;
				case "uni": return UNIX;
				case "mac": case "ios": return MAC;
				case "sun": case "sol": return SOLARIS;
				default: return OTHER;
			}
		}
	}
	
	public static String execCmd(String... args) throws IOException {
		Process process = new ProcessBuilder(args).redirectErrorStream(true).start();
		StringBuilder processOutput = new StringBuilder();

        try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String readLine;
            while ((readLine = processOutputReader.readLine()) != null) {
                processOutput.append(readLine + System.lineSeparator());
            }
            try {
				process.waitFor();
			}
			catch (InterruptedException ex) {
				throw new IOException(ex);
			}
        }

        return processOutput.toString().trim();
	}
	
	public static String getCpuName() {
		try {
			return execCmd(OSFamily.getOSFamily().equals(OSFamily.WINDOWS) ?
				new String[] {"powershell.exe", "-Command", "\"wmic CPU get NAME | findstr '@'\""} :
				new String[] {"/bin/sh", "-c", "cat /proc/cpuinfo | grep -m 1 'model name'"}
			);
		}
		catch (IOException ex) {
			System.err.println("Could not get CPU name: "+ex.getMessage());
			return "";
		}
	}

}
