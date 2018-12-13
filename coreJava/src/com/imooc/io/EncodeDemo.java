package com.imooc.io;

public class EncodeDemo {
	public static void main(String[] args) throws Exception {
		String s = "慕课ABC";
		//utf-8编码，中文字符占三个字节，英文字符占一个字节
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
		//gbk编码，中文字符占两个字节，英文字符占一个字节
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
		//java是utf-16be编码，中文字符占用两个字节，英文字符占用两个字节
		byte[] byte3 = s.getBytes("utf-16be");
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b) + " ");
		}
		System.out.println();
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
	}
}
