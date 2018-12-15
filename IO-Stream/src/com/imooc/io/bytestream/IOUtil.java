package com.imooc.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	/*
	 * 读取指定文件内容，按照16进制输出到控制台 并且每输出10个byte换行
	 */
	public static void printHex(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		int b;
		int i = -1;
		while ((b = in.read()) != -1) {
			if (b <= 0xf) {
				// 单位数前补零
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}

	public static void printHexByByteArray(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		byte[] buf = new byte[20 * 1024];
		/*
		 * 从in中批量读取字节，放入buf这个字节数组中， 从第0个位置开始读，最多放buf.length个 返回的是读到的字节的个数
		 */
		/*int bytes = in.read(buf, 0, buf.length);
		int j = 1;
		for (int i = 0; i < bytes; i++) {
			if (buf[i] <= 0xf) {
				System.out.print("0");
				System.out.print(Integer.toHexString(buf[i]&0xf) + " ");
			}
			System.out.print(Integer.toHexString(buf[i]&0xff) + " ");
			if (j++ % 10 == 0) {
				System.out.println();
			}
		}*/
		int bytes = 0;
		  int j = 1;
		  while((bytes = in.read(buf,0,buf.length))!=-1){
			  for(int i = 0 ; i < bytes;i++){
				  System.out.print(Integer.toHexString(buf[i] & 0xff)+"  ");
				  if(j++%10==0){
					  System.out.println();
				  }
			  }
		  }
		  in.close();
	}
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8*1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf, 0, b);
			out.flush();
		}
		in.close();
		out.close();
	}
}
