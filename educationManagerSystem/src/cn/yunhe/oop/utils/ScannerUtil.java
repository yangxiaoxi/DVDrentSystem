package cn.yunhe.oop.utils;

import java.util.Scanner;

public class ScannerUtil {
	static Scanner scan = new Scanner(System.in);
	 public static int getInt(String des) {
		 System.out.println(des);
		 int result = scan.nextInt();
		 return result;
	 }
	 
	 public static String getString(String des) {
		 System.out.println(des);
		 String result = scan.next();
		 return result;
	 }
	 
	 public static boolean getBoolean(String des) {
		 System.out.println(des);
		 boolean result = scan.nextBoolean();
		 return result;
	 }
}
