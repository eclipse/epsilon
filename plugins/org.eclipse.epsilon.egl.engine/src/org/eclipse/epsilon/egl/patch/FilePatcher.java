package org.eclipse.epsilon.egl.patch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FilePatcher {
	
	public static void main(String[] args) throws Exception {
		
		if (args.length != 3) {
			System.out.println("Usage: java -jar filepatcher.jar inputfile patchfile outputfile");
		}
		
		new FilePatcher().run(args[0], args[1], args[2]);
		
	}
	
	public void run(String inputPath, String patchPath, String targetPath) throws Exception {
		
		TextBlock input = new TextBlock(readFromPath(inputPath));
		Patch patch = new Patch(readFromPath(patchPath));
		if (!patch.validate().isEmpty()) throw new Exception("Invalid patch");
		TextBlock output = patch.apply(input);
		
		FileWriter targetWriter = new FileWriter(targetPath);
		ListIterator<Line> lineIterator = output.getLines().listIterator();
		while (lineIterator.hasNext()) {
			Line line = lineIterator.next();
			targetWriter.write(line.getText());
			if (lineIterator.hasNext()) targetWriter.write(System.lineSeparator());
		}
		targetWriter.close();
		
	}
	
	protected String[] readFromPath(String path) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		List<String> lines = new ArrayList<String>();
		String line = null;
		
		while((line = bufferedReader.readLine()) != null) {
		    lines.add(line);
		}
		bufferedReader.close();

		return lines.toArray(new String[]{});
	}
	
}
