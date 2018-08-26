package lab05_LuiggySilva;
/**
 * Classe ApostaAsseguradaTaxa que herda todos Atributos e Metodos da classe Aposta
 * @author LUIGGY SILVA
 *
 */
public class ApostaAsseguradaTaxa implements TipoSeguro{
	
	private int custoSeguro;
	private double segurotaxa;
	private int valorSeguro;
	private String nome;
	private int aposta;
	private String previsao;
	/**
	 * Construtor de uma ApostaAsseguradaValor que a cria apartir de um nome, aposta, previsao, seguroValor e custo
	 * @param nome e o nome do apostador no formato String
	 * @param aposta e o valor da aposta no formato String
	 * @param previsao e a previsao que pode ser "VAI ACONTECER" ou "N VAI ACONTECER" no formato String
	 * @param seguroTaxa e o valor do seguro por taxa no formato double
	 * @param custo e o cursto do seguro no formato Integer
	 */
	public ApostaAsseguradaTaxa(String nome, int aposta, String previsao, double seguroTaxa, int custo) {
		if( nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if(seguroTaxa <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if( previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		if(custo <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: custo do seguro invalido");
		}
		if(aposta <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		this.nome = nome;
		this.aposta = aposta;
		this.previsao = previsao;
		this.segurotaxa = seguroTaxa;
		this.custoSeguro = custo;
		this.valorSeguro = (int) (seguroTaxa * aposta);
	}

	/**
	 * Metodo que devolve o custo do seguro
	 * @return o custo do seguro no formato Integer
	 */
	@Override
	public int getCustoSeguro() {
		return this.custoSeguro;
	}
	
	/**
	 * Metodo que devolve o valor do seguro
	 * @return o valor do seguro no formato Integer
	 */
	@Override
	public int getSeguro() {
		return this.valorSeguro;
	}
	
	/**
	 * Metodo que retorna a aposta do apostador
	 * @return a aposta no formato Integer
	 */
	@Override
	public int getAposta() {
		return this.aposta;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que retorna a previsao do apostador
	 * @return a previsao no formato String
	 */
	@Override
	public String getPrevisao() {
		return this.previsao;
	}
	
	/**
	 * Metodo que cria uma representacao da ApostaAsseguradaTaxa
	 * @return a representacao da ApostaAsseguradaTaxa no formato String
	 */
	@Override
	public String toString() {
		return this.nome + " - R$ " + this.aposta/100 + " - " + this.previsao + " - ASSEGURADA(TAXA) - " + (int)(this.segurotaxa * 100) + "%";
	}
}