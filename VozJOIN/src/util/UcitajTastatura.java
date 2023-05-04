package util;

import java.util.Scanner;

public class UcitajTastatura {
	
	public static String ucitajString(String print) {
		System.out.print(print);
		
		
		Scanner scan = new Scanner(System.in);
		String vracanje = scan.nextLine();
		
		return vracanje;

		}
	public static double ucitajDouble(String print) {
		System.out.println(print);
		
		
		Scanner scan = new Scanner(System.in);
		double vracanje = scan.nextDouble();
		return vracanje;
	}
	public static int ucitajInt(String print) {
		System.out.println(print);
		
		Scanner scan = new Scanner(System.in);
		int vracanje = scan.nextInt();
		return vracanje;
		
	}
	public static long ucitajLong(String print) {
		System.out.println(print);
		
		Scanner scan = new Scanner(System.in);
		long vracanje = scan.nextLong();
		return vracanje;
		
	}
}
