package lab02;
/**
* A classe ContaLaboratorio administra todas relaçoes do aluno com a cantina adicionada sua conta do Laboratorio.
* @author Luiggy Silva
**/
public class ContaLaboratorio {
	
	private String nomeLaboratorio;
	private int mbytes;
	private int espacoTotal = 2000;
	private int espacoUsado;

   /**
   * Recebe o nome do laboratório.
   * @param nomeLaboratorio é o nome do laboratório no formato String.
   **/
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.mbytes = mbytes;
		this.espacoTotal = espacoTotal;
		this.espacoUsado = espacoUsado;
	}
	
   /**
   * Calcula o espaço consumido pelo aluno.
   * @param mbytes é o quanto foi consumido pelo aluno.
   **/
	public void consomeEspaco(int mbytes) {
		espacoUsado += mbytes;	
	}
	
   /**
   * Verifica se foi atingido o espaço total da cota de memória. 
   **/
	public boolean atingiuCota() {
		if (espacoUsado >= espacoTotal){
			return true;
		}
		return false;
	}
	
   /**
   * Libera mais espaço na cota de espaço.
   * @param mbytes é a quantidade de memória para liberar.
   **/
	public void liberaEspaco(int mbytes) {
		espacoUsado -= mbytes;		
	}
	
   /**
   * Concatena o estado geral da conta do laboratorio.
   **/
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoUsado + "/" + this.espacoTotal;
	}

}
