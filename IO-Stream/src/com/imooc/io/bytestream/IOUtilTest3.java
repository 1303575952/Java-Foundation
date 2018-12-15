package com.imooc.io.bytestream;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {
	public static void main(String[] args) throws IOException {
		IOUtil.copyFile(new File("C:\\Users\\FELIX\\IdeaProjects\\Java-Foundation\\IO-Stream\\testFolder\\日记1.txt"),
				new File("C:\\Users\\FELIX\\IdeaProjects\\Java-Foundation\\IO-Stream\\testFolder\\日记2.txt"));
	}
}
