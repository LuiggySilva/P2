/**
* Laboratorio de Programacao 2 - Lab 1
* 
* @author Luiggy Silva - 117211159
*/

import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operador = sc.nextLine();	
		
		if (verificaEntrada(operador)) {
			System.out.println("ENTRADA INVALIDA");
		} 
		else {
			
			double num1 = sc.nextDouble();
			double num2 = sc.nextDouble();
			
			if (operador.equals("+")) {
				somando(num1, num2);
			} 
			else if (operador.equals("-")) {
				diminuindo(num1, num2);
			} 
			else if (operador.equals("*")) {
				multiplicando(num1, num2);
			} 
			else if (operador.equals("/")) {
				dividindo(num1, num2);
			}
		}
	sc.close();
	}

	public static boolean verificaEntrada(String operador) {
		String[] operadores = new String[4];
		operadores[0] = "+";
		operadores[1] = "-";
		operadores[2] = "*";
		operadores[3] = "/";
		for(int i = 0;i < operadores.length; i++) {
			if(operadores[i].equals(operador)) {
				return false;
			}
		}
	    return true;
	}

	public static void somando(double num1, double num2) {
		System.out.println("RESULTADO: " + (num1 + num2));
	}

	public static void diminuindo(double num1, double num2) {
		System.out.println("RESULTADO: " + (num1 - num2));
	}

	public static void multiplicando(double num1, double num2) {
		System.out.println("RESULTADO: " + (num1 * num2));
	}

	public static void dividindo(double num1, double num2) {
		if (num2 == 0.0) {
			System.out.println("ERRO");
		} else {
			System.out.println("RESULTADO: " + (num1 / num2));
		}

	}

}