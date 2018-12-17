package com.imooc.io.file;

import java.io.File;
import java.io.IOException;

//File类的常用操作，比如过滤、遍历等操作
public class FileUtil {
	/*
	 * 列出指定目录下（包括其子目录）的所有文件
	 */
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录：" + dir + "不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}
		// 返回字符串数组，子目录名称，不包含子目录下的内容
		String[] filenames = dir.list();
		for (String string : filenames) {
			System.out.println(dir + "\\" + string);
		}
		// 如果要便利子目录下的内容需要构造File对象做递归操作
		File[] files = dir.listFiles();
		/*
		 * for (File file : files) { System.out.println(file); }
		 */
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}
	}
}
