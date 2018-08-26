package lab05_LuiggySilva;
/**
 * Classe ApostaAsseguradaValor que herda todos Atributos e Metodos da classe Aposta
 * @author LUIGGY SILVA
 *
 */
public class ApostaAsseguradaValor implements TipoSeguro{
	
	private int seguroValor;
	private int custoSeguro;
	private String previsao;
	private int aposta;
	private String nome;
	
	/**
	 * Construtor de uma ApostaAsseguradaValor que a cria apartir de um nome, aposta, previsao, seguroValor e custo
	 * @param nome e o nome do apostador no formato String
	 * @param aposta e o valor da aposta no formato String
	 * @param previsao e a previsao que pode ser "VAI ACONTECER" ou "N VAI ACONTECER" no formato String
	 * @param seguroValor e o valor do seguro por valor no formato Integer
	 * @param custo e o cursto do seguro no formato Integer
	 */
	public ApostaAsseguradaValor(String nome, int aposta, String previsao, int seguroValor, int custo) {
		if(nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if(seguroValor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if(previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		if(custo <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: custo do seguro invalido");
		}
		if(aposta <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		this.nome = nome;
		this.aposta = aposta;
		this.previsao = previsao;
		this.seguroValor = seguroValor;
		this.custoSeguro = custo;
	}
	
	/**
	 * Metodo que devolde o custo do seguro
	 * @return o cursto do seguro no formato Integer
	 */
	public int getCustoSeguro() {
		return this.custoSeguro;
	}
	
	/**
	 * Metodo que devolve o valor do segurovalor
	 * @return o valor do seguroValor no formato Integer
	 */
	@Override
	public int getSeguro() {
		return this.seguroValor;
	}
	
	/**
	 * Metodo que retorna a aposta do apostador
	 * @return a aposta no formato Integer
	 */
	@Override
	public int getAposta() {
		return this.aposta;
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
	 * Metodo que retorna o nome do apostador
	 * @return o nome no formato String
	 */
	@Override
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que cria uma representacao da ApostaAsseguradaValor
	 * @return a representacao da ApostaAsseguradaValor no formato String
	 */
	@Override
	public String toString() {
		return this.nome + " - R$ " + this.aposta/100 + " - " + this.previsao + " - ASSEGURADA(VALOR) - R$ " + (double)this.seguroValor/100;
	}
}