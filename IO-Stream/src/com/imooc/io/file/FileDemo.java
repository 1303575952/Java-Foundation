package com.imooc.io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\FELIX\\IdeaProjects\\Java-Foundation\\IO-Stream\\testFolder");
		System.out.println(file.exists());
		if (!file.exists()) {
			file.mkdir();
			//file.mkdirs(); //创建多级目录
		} else {
			// file.delete();
		}
		// 是否是一个目录
		System.out.println(file.isDirectory());
		// 是否是一个文件
		System.out.println(file.isFile());

		// File file2 = new
		// File("C:\\Users\\FELIX\\IdeaProjects\\Java-Foundation\\IO-Stream\\testFolder\\日记1.txt");
		File file2 = new File("C:\\Users\\FELIX\\IdeaProjects\\Java-Foundation\\IO-Stream\\testFolder", "日记1.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			file2.delete();
		}
		// 常用File对象的api
		System.out.println(file);// file.toString()的内容
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
