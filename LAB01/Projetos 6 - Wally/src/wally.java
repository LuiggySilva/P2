
/**
* Laboratório de Programação 2 - Lab 1
*
* @author Luiggy Silva - 117211159
*/

import java.util.Scanner;

public class wally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean acheiWally = false;
		while(!acheiWally) {
			String[] nomes = sc.nextLine().split(" ");
			
			if (nomes[0].equals("wally")) {
				acheiWally = true;
			}
			else if(!acheiWally){
				String possivelWally = "";
				for(int i = 0; i < nomes.length; i++) {
					if(nomes[i].length() == 5) {
						possivelWally = nomes[i];
					}	
				}
				if(!possivelWally.equals("")) {
					System.out.println(possivelWally);
				}
				else {
					System.out.println("?");
				}
			
			}
		}

	}
}