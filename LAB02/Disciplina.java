package lab02;
import java.util.Arrays;

/**
* A classe Disciplina administra todas relaçoes do aluno com a Disciplina adicionada.
* @author Luiggy Silva
**/
public class Disciplina {
	
	private String nomeDaDisciplina; 
	private double[] notas;
	private double media;
	private int horasDeEstudo;
	
   /**
   * Armazena o nome da disciplina.
   * @param nomeDaDisciplina é o nome da disciplina.
   **/
	public Disciplina(String nomeDaDisciplina) {
		this.nomeDaDisciplina = nomeDaDisciplina;
		this.notas = new double[4];
		this.horasDeEstudo = horasDeEstudo;
		this.media = media;
	}
   /**
   * Armazena a quantidade de horas que foi dedicado para estudar a disciplina.
   * @param i é a quantidade de horas.
   **/
	public void cadastraHoras(int i) {
		horasDeEstudo = i;
	}
   /** 
   * Armazena as notas no sistema
   * @param qualNota é qual é a nota(primeira, segunda, terceira ou quarta).
   * @param nota é a nota.
   **/
	public void cadastraNota(int qualNota, double nota) {
		notas[qualNota - 1] = nota;
	}
   /**
   * Calcula a media apartir das notas e retorna true para aprovado e false para reprovado. 
   **/
	public boolean aprovado() {
		media = 0;
		for(int i = 0; i < notas.length; i++) {
			media += notas[i];
		}
		media = media / 4.0;
		if(media >= 7.0) {
			return true;
		}
		return false;
	}
	/**
	 * Concatena o estado geral da disciplina.
	 */
	public String toString() {
		return nomeDaDisciplina + " " + horasDeEstudo + " " + media + " " + Arrays.toString(notas);
	}

}
