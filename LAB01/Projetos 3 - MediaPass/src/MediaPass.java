
/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luiggy Silva - 117211159
*/
import java.util.Scanner;

public class MediaPass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double media;
		
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		
		media = (num1 + num2)/2.0;
		
		if(media >= 7.0) {
			System.out.print("pass: True!");
		}
		else {
			System.out.print("pass: False!");
		}

	}

}