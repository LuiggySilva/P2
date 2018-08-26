
/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luiggy - 117211159
*/

import java.util.Scanner;

public class DobroTriplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digíte um número: ");
		int numero = sc.nextInt();
		
		System.out.print("dobro: " + (numero * 2) + ", triplo: " + (numero * 3));
	}

}