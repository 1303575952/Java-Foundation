package com.imooc.io;

public class EncodeDemo {
	public static void main(String[] args) throws Exception {
		String s = "慕课ABC";
		// utf-8编码，中文字符占三个字节，英文字符占一个字节
		byte[] byte1 = s.getBytes("utf-8");
		for (byte b : byte1) {
			System.out.print(Integer.toHexString(b) + " ");
		}
		System.out.println();
		for (byte b : byte1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		System.out.println("============================");
		// gbk编码，中文字符占两个字节，英文字符占一个字节
		byte[] byte2 = s.getBytes("gbk");
		for (byte b : byte2) {
			System.out.print(Integer.toHexString(b) + " ");
		}
		System.out.println();
		for (byte b : byte2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		System.out.println("============================");
		// java是utf-16be编码，中文字符占用两个字节，英文字符占用两个字节
		byte[] byte3 = s.getBytes("utf-16be");
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b) + " ");
		}
		System.out.println();
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		System.out.println("============================");
		// 字节序列是某种编码，当把字节序列变成字符串，也需要用这种编码，否则乱码
		String str1 = new String(byte3);
		System.out.println(str1);
		String str2 = new String(byte3,"utf-16be");
		System.out.println(str2);
		/*
		 * 文本文件就是字节序列
		 * 可以是任意编码的字节序列
		 * 如果在中文机器上直接创建文本文件，该文本文件ansi编码
		 * 联通、联是一种巧合，正好符合utf-8编码规范
		 */
	}
}
