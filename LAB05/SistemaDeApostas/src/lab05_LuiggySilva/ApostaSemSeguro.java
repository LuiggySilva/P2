package lab05_LuiggySilva;
/**
 * Classe que representa uma aposta
 * @author LUIGGY SILVA
 *
 */
public class ApostaSemSeguro{
	
	protected String previsao;
	protected int aposta;
	protected String apostador;
	
	/**
	 * Construtor que cria uma aposta apartir de um nome, aposta e uma previsao
	 * @param nome e o nome do apostador no formato String
	 * @param aposta e o valor da aposta do apostador no formato Integer
	 * @param previsao e a previsao do apostador que pode ser "VAI ACONTECER" ou "N VAI ACONTECER"
	 */
	public ApostaSemSeguro(String nome, int aposta, String previsao) {
		if(nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if(aposta <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if(previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		
		this.apostador = nome;
		this.aposta = aposta;
		this.previsao = previsao;
	}
	
	/**
	 * Metodo que cria uma representacao da aposta
	 * @return uma representacao da aposta no formato String
	 */
	@Override
	public String toString() { 
		return this.apostador + " - R$ " + this.aposta/100 + " - " + this.previsao;
	}
	/**
	 * Metodo que devolve a previsao da Aposta
	 * @return a previsao da aposta no formato String
	 */
	
	public String getPrevisao() {
		return previsao;
	}
	
	/**
	 * Metodo que retorna o nome do apostador
	 * @return o nome no formato String
	 */
	
	public String getNome() {
		return this.apostador;
	}
	
	/**
	 * Metodo que devolve o valor da aposta
	 * @return o valor da aposta no formato Integer
	 */
	public int getAposta() {
		return aposta;
	}

}