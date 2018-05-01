package com.java.basic.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileReadandWriteTest {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("D:\\Bala\\test.txt");
		FileReader fr = new FileReader(f);
		
		Scanner sc = new Scanner(System.in);
		String a =sc.nextLine();
		System.out.println(a);

	}

}
