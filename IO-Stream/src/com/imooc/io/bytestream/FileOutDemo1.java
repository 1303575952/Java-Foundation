package com.imooc.io.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {
	public static void main(String[] args) throws IOException {
		//如果文件不存在，则直接创建，如果存在，删除后创建，若追加内容，还有另一个构造方法，第二个参数设true
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		out.write('A');//写出A的低八位
		out.write('B');//写出B的低八位
		int a = 10;//write只能写八位，那么写一个int需要写四次，每次八位
		out.write(a>>>24);
		out.write(a>>>16);
		out.write(a>>>8);
		out.write(a);
		
		byte[] utf8 = "中国".getBytes("utf8");
		out.write(utf8);
		out.close();
		
		IOUtil.printHex("demo/out.dat");
	}
}
