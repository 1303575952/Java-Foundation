package com.imooc.io.randomaccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {
	public static void main(String[] args) throws IOException {
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo,"raf.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//指针的位置
		System.out.println(raf.getFilePointer());
		raf.write('A');
		System.out.println(raf.getFilePointer());
		raf.write('B');
		
		int i=0x7fffffff;
		//用write方法每次只能写一个字节，如果要把i写进去就要写4次
		raf.write(i>>>24);
		raf.write(i>>>16);
		raf.write(i>>>8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		
		//可以直接写int
		raf.writeInt(i);
		
		String s = "中";
		byte[] utf8 = s.getBytes("utf-8");
		raf.write(utf8);
		System.out.println(raf.length());
		
		//读文件必须把指针移到头部
		raf.seek(0);
		//一次性读取
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		String string = new String(buf,"utf-8");
		System.out.println(string);
		
		for(byte b:buf){
			System.out.println(Integer.toHexString(b&0xff)+" ");
		}
		raf.close();
	}
}
