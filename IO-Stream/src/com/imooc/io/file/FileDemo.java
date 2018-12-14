package com.imooc.io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("E:\\javaio\\imooc");
		//System.out.println(file.exists());
		if(!file.exists())
			file.mkdir(); //file.mkdirs()
		else
			file.delete();
		//�Ƿ���һ��Ŀ¼  �����Ŀ¼����true,�������Ŀ¼orĿ¼�����ڷ��ص���false
		System.out.println(file.isDirectory());
		//�Ƿ���һ���ļ�
		System.out.println(file.isFile());
		
		//File file2 = new File("e:\\javaio\\�ռ�1.txt");
		File file2 = new File("e:\\javaio","�ռ�1.txt");
		if(!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else 
			file2.delete();
         //���õ�File�����API
		System.out.println(file);//file.toString()������
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
