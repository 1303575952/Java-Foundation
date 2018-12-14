package com.imooc.io.file;

import java.io.File;
import java.io.IOException;

public class FileUtilTest1 {
	public static void main(String[] args) throws IOException {
		FileUtil.listDirectory(new File("C:\\Users\\FELIX\\IdeaProjects\\Java-Foundation\\IO-Stream"));
	}
}
