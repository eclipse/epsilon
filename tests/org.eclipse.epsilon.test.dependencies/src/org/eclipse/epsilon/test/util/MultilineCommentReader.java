package org.eclipse.epsilon.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.eclipse.epsilon.common.util.FileUtil;

public class MultilineCommentReader {
	
	protected File findFile(String className, String javafilename) {
		try {
			Class<?> clazz = Class.forName(className);
			String filename = FileUtil.getFile(javafilename, clazz).getAbsolutePath().replace("bin", "src");
			return new File(filename);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public String readNextComment() {
		
		Exception ex = new Exception();
		
		StackTraceElement[] stackTrace = ex.getStackTrace();
		
		StackTraceElement s = stackTrace[1];
		
		String filename = s.getFileName();
		
		File file = findFile(s.getClassName(), filename);
				
		String collected = "";
		
		if (file != null && file.exists()) {
			int line = s.getLineNumber();
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				try {
					int currentLine = 0;
					while (reader.readLine() != null && currentLine < line - 1) {
						currentLine++;
					}

					String leadingWhitespace = "";

					ReaderState readerState = ReaderState.BeforeComment;
					while (readerState != ReaderState.AfterComment) {
						String l = reader.readLine();
						if (readerState == ReaderState.BeforeComment) {
							if (l.trim().equals("/*"))
								readerState = ReaderState.InFirstLineOfComment;
						} else if (readerState == ReaderState.InComment
								|| readerState == ReaderState.InFirstLineOfComment) {
							if (l.trim().equals("*/")) {
								readerState = ReaderState.AfterComment;
							} else {
								if (readerState == ReaderState.InFirstLineOfComment) {
									readerState = ReaderState.InComment;
									boolean nonWhitespaceFound = false;
									for (char c : l.toCharArray()) {
										if (Character.isWhitespace(c)) {
											if (!nonWhitespaceFound) {
												leadingWhitespace += c;
											}
										} else {
											nonWhitespaceFound = true;
										}
									}
								}
								collected = collected
										+ l.replace(leadingWhitespace, "")
										+ "\r\n";
							}
						}
					}
				} finally {
					reader.close();
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return collected.trim();
			
		}
		
		return null;
	}
	
	enum ReaderState {
		BeforeComment,
		InFirstLineOfComment,
		InComment,
		AfterComment
	}
	
}
