package acimaDaMedia;
/**
* Laboratorio de Programacao 2 - Lab 1
* 
* @author Luiggy Silva - 117211159
*/

import java.util.ArrayList;
import java.util.Scanner;

public class AcimaDaMedia {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		
		ArrayList<String> saida  = new ArrayList<String>();
		double media = calculaMedia(numeros);
		
		for(int i = 0; i < numeros.length; i++) {
			if(Integer.parseInt(numeros[i]) > media) {
				saida.add(numeros[i]);
			}

		}
		String saidaConcatenada = String.join(" ", saida);
		System.out.println(saidaConcatenada);
		sc.close();
	}

	private static double calculaMedia(String[] lista) {
		double soma = 0;
		int tamanho = lista.length;
		for(int i = 0; i < tamanho; i++) {
			soma += Integer.parseInt(lista[i]);
		}
		return (soma / tamanho);
	}

}