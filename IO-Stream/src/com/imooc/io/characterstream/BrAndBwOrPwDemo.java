package com.imooc.io.characterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwOrPwDemo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("testFolder/日记1.txt")));
		/*BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("testFolder/日记1.txt")));*/
		PrintWriter pw = new PrintWriter("testFolder/日记1.txt");
		//PrintWriter pw1 = new PrintWriter(outputStream,boolean autoFlush);
		String line ;
		while((line = br.readLine())!=null){
			System.out.println(line);
			/*bw.write(line);
			bw.newLine();
			bw.flush();*/
			pw.println(line);
			pw.flush();
		}
		br.close();
		//bw.close();
		pw.close();
	}

}
