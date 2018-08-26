package lab02;
/**
* A classe ContaCantina administra todas relaçoes do aluno com a cantina adicionada.
* @author Luiggy Silva
*/
public class ContaCantina {
	private int quantidadeDeItens;
	private int DividaCentavos;
	private String nomeDaCantina;
   /**
   * Armazenando nome da cantina.
   * @param nomeDaCantina é onde foi comprado o lanche.
   */
	public ContaCantina(String nomeDaCantina) {
		this.quantidadeDeItens = quantidadeDeItens;
		this.DividaCentavos = DividaCentavos;
		this.nomeDaCantina = nomeDaCantina;
	}
   /**
   * Carteira de itens comprado e divida.
   * @param quantidadeDeIntes é a quantidade de itens comprados.
   * @param quantosCentavos é o preço total.
   */
	public void cadastraLanche(int quantidadeDeItens, int quantosCentavos) {
		this.quantidadeDeItens += quantidadeDeItens;
		this.DividaCentavos += quantosCentavos;
		
	}
   /**
   * Pagando a divida da cantina.
   * @param Pagando é o que foi pago da divida.
   */
	public void pagaConta(int Pagando) {
		if(!(this.DividaCentavos <= 0) && !(this.DividaCentavos - Pagando < 0)) {
			this.DividaCentavos -= Pagando;
		}
		
	}
	/**
	 * Concatena o estado geral da cantina.
	 */
	public String toString() {
		return this.nomeDaCantina + " " + quantidadeDeItens + " " + DividaCentavos;
	}

}
