/**
* Laboratorio de Programacao 2 - Lab 1
*
* @author Luiggy Silva - 117211159
*/

import java.util.ArrayList;
import java.util.Scanner;

public class alunosEnotas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> notas = new ArrayList();
		
		int contador = 0;
		while(true) {
			String[] nomeEnota = sc.nextLine().split(" ");
			
			if(nomeEnota[0].equals("-")) {
				break;
			}
			else {
				notas.add(nomeEnota[1]);
				contador ++;
			}

		}
		
		int media = (calculaMedia(notas)/contador);
		int notaMaior = Integer.parseInt((calculaMaiorEmenor(notas).get(1)));
		int notaMenor = Integer.parseInt((calculaMaiorEmenor(notas).get(0)));
		int acimaDaMedia = Integer.parseInt((calculaMaiorEmenor(notas).get(2)));
		int abaixoDaMedia = Integer.parseInt((calculaMaiorEmenor(notas).get(3)));
		
		System.out.println("maior: " + notaMaior);
		System.out.println("menor: " + notaMenor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acimaDaMedia);
		System.out.println("abaixo: " + abaixoDaMedia);
		
		sc.close();
	}
	

	private static ArrayList<String> calculaMaiorEmenor(ArrayList<String> notas) {
		
		ArrayList<String> dados = new ArrayList();
		
		String maior = "0";
		int menor = Integer.MAX_VALUE;
		int contadorAcima = 0;
		int contadorAbaixo = 0;
	
		for(int i = 0; i < notas.size(); i++) {
			if(Integer.parseInt((notas.get(i))) > Integer.parseInt((maior))) {
				maior = notas.get(i);
			}
			if(Integer.parseInt((notas.get(i))) >= 700) {
				contadorAcima += 1;
			}
			else {
				contadorAbaixo += 1;
			}
		}
		for(int i = 0; i < notas.size(); i++) {
			if(Integer.parseInt((notas.get(i))) < menor){
				menor = Integer.parseInt(notas.get(i));
			}
		}
	
		dados.add(Integer.toString(menor));
		dados.add(maior);
		dados.add(Integer.toString(contadorAcima));
		dados.add(Integer.toString(contadorAbaixo));
		
		
		return dados;
	}

	private static int calculaMedia(ArrayList<String> notas) {
		int soma = 0;
		for(int i = 0; i < notas.size(); i++) {
			soma += Integer.parseInt((notas.get(i)));
		}
		return soma;

	}
	
}