package cursojava.thread;

import java.util.Scanner;

public class AnoSeculo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("digite o ano :");
		
		int ano = scanner.nextInt();
		int sec;
		
		sec = ano/100;
		
		System.out.println("vc esta no seculo  :"+sec);
		
		
	}

}
