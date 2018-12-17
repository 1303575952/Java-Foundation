package com.imooc.io.characterstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("testFolder/日记1.txt");
		InputStreamReader isr = new InputStreamReader(in, "utf-8");

		FileOutputStream out = new FileOutputStream("testFolder/日记4.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		/*
		 * int c; while ((c = isr.read()) != -1) { System.out.print((char) c); }
		 */

		char[] buffer = new char[8 * 1024];
		int c;
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			String s = new String(buffer, 0, c);
			System.out.print(s);
			osw.write(buffer, 0, c);
			osw.flush();
		}
		isr.close();
		osw.close();

	}
}
