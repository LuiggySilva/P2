package lab05_LuiggySilva;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa um cenario
 * @author LUIGGY SILVA
 *
 */
public class Cenario{
	
	protected String descricao;
	protected String estado;
	protected int numCenario;
	protected ArrayList<ApostaSemSeguro> apostaSemSeguro;
	protected HashMap<Integer, Aposta> apostasAsseguradas;
	protected double caixaCenario;
	protected double rateio;
	protected int apostasAsseguradasAdicionadas;
	
	/**
	 * Construtor do cenario que cria o cenario apartir do numero do cenario e da sua descricao e inicializa o seu estado
	 * como "Nao finalizado" e inicializa o ArrayList de Aposta
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param desc e a descricao do cenario no formato String
	 */
	public Cenario(int numCenario, String desc) {
		if( desc == null || desc.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro do cenario: numero do cenario invalido");
		}
		this.apostasAsseguradas = new HashMap<>();
		this.numCenario = numCenario;
		this.descricao = desc;
		this.estado = "Nao finalizado";
		this.apostaSemSeguro = new ArrayList<>();
		this.apostasAsseguradasAdicionadas = 1;
	}
	
	/**
	 * Metodo que adiciona uma Aposta ao ArrayList de Aposta
	 * @param aposta e a aposta que sera adicionada no formato Aposta
	 */
	public void adicionaAposta(String nome, int valorAposta, String previsao) {
		ApostaSemSeguro aposta = new ApostaSemSeguro(nome, valorAposta, previsao);
		this.apostaSemSeguro.add(aposta);
	}
	
	/**
	 * Metodo que adiciona uma aposta assegurada por valor no cenario
	 * @param nome e o nome do apostador
	 * @param aposta e o valor de sua aposta
	 * @param previsao e a sua previsao para o cenario
	 * @param seguroValor e o valor do seguro
	 * @param custo e o custo do seguro
	 */
	public void adicionaApostaValor(String nome, int aposta, String previsao, int seguroValor, int custo) {
		Aposta apostaValor = new Aposta(nome, aposta, previsao, seguroValor, custo);
		this.apostasAsseguradasAdicionadas++;
		apostasAsseguradas.put(this.apostasAsseguradasAdicionadas, apostaValor);
	}
	
	/**
	 * Metodo que adiciona uma aposta Assegurada por taxa no cenario
	 * @param nome e o nome do apostador
	 * @param aposta e o valor de sua aposta
	 * @param previsao e a sua previsao para o cenario
	 * @param seguroTaxa e a taxa do seguro
	 * @param custo e o custo do seguro
	 */
	public void adicionaApostaTaxa(String nome, int aposta, String previsao, double seguroTaxa, int custo) {
		Aposta apostaTaxa = new Aposta(nome, aposta, previsao, seguroTaxa, custo);
		this.apostasAsseguradasAdicionadas++;
		apostasAsseguradas.put(this.apostasAsseguradasAdicionadas, apostaTaxa);
	}
	
	/**
	 * Metodo que listas as apostas contidas no cenario
	 * @return uma representacao em formato string de todas apostas do cenario
	 */
	public String listarApostas() {
		String resultado = "";
		for (int i = 0; i < apostaSemSeguro.size(); i++) {
			resultado += apostaSemSeguro.get(i).toString() + System.lineSeparator();
		}
		
		for (Aposta aposta : apostasAsseguradas.values()) {
			resultado += aposta.toString() + System.lineSeparator();
		}
		
		return resultado.trim();
	}
	
	/**
	 * Metodo que faz os calculos do Caixa e Rateio do cenario
	 * @param ocorreu e a variavel que informa se o cenario ocorreu no formato boolean
	 * @return um ArrayList de Integer com a soma das apostas dos perdedores e a quantidade de vencedores no formato ArrayList de Integer
	 */
	protected ArrayList<Integer> calculoCaixaCenarioRateio(boolean ocorreu){
		double somaPerdedores = 0;
		int qtdVencedores = 0;
		int seguroParaOCaixaPrincipal = 0;
		ArrayList<Integer> saida = new ArrayList<>();
		
		if(!this.estado.equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
		if(ocorreu) {
			this.estado = "Finalizado (ocorreu)";
			
			for (ApostaSemSeguro apostador : apostaSemSeguro) {
				if(apostador.getPrevisao().equals("N VAI ACONTECER")) {
					somaPerdedores += apostador.getAposta();
				}
				else {
					qtdVencedores++;
				}
			}
			
			for (Aposta apostador : apostasAsseguradas.values()) {
				if(apostador.getPrevisao().equals("N VAI ACONTECER")) {
					somaPerdedores += apostador.getAposta();
					seguroParaOCaixaPrincipal += apostador.getSeguro();
				}
				else{
					qtdVencedores++;
				}
			}
		}
		else {
			this.estado = "Finalizado (n ocorreu)";
			for (ApostaSemSeguro apostador : apostaSemSeguro) {
				if(apostador.getPrevisao().equals("VAI ACONTECER")) {
					somaPerdedores += apostador.getAposta();
				}
				else {
					qtdVencedores++;
				}
			}
			
			for (Aposta apostador : apostasAsseguradas.values()) {
				if(apostador.getPrevisao().equals("VAI ACONTECER")) {
					somaPerdedores += apostador.getAposta();
					seguroParaOCaixaPrincipal += apostador.getSeguro();
				}
				else{
					qtdVencedores++;
				}
			}
		}
		saida.add((int)somaPerdedores);
		saida.add(qtdVencedores);
		saida.add(seguroParaOCaixaPrincipal);
		return saida;
	}
	
	/**
	 * Metodo que fecha as apostas no cenario
	 * @param ocorreu e a variavel que informa se o cenario ocorreu no formato boolean
	 * @param taxa e a taxa do sistema principal no formato double
	 * @return o caixa do cenario no formato Integer
	 */
	public int fecharAposta(boolean ocorreu, double taxa) {
		
		ArrayList<Integer> calculos = calculoCaixaCenarioRateio(ocorreu);
		
		this.caixaCenario = calculos.get(0) * taxa;
		if(calculos.get(1) == 0) {
			this.rateio = 0;
		}
		else {
			this.rateio = (this.caixaCenario * 100) - caixaCenario;
		}
		return (int)caixaCenario + calculos.get(2);
	}
	
	/**
	 * Metodo que altera um seguro assegurado por taxa para um seguro assegurado por valor 
	 * @param apostaAssegurada e o identificador da aposta assegurada
	 * @param valor o valor do seguro
	 */
	public void alteraSeguroValor(int apostaAssegurada, int valor) {
		if(apostasAsseguradas.containsKey(apostaAssegurada)) {
			Aposta novaAposta = apostasAsseguradas.get(apostaAssegurada);
			novaAposta.AlteraSeguroValor(valor);
			apostasAsseguradas.remove(apostaAssegurada);
			apostasAsseguradas.put(apostaAssegurada, novaAposta);
		}	
	}
	
	/**
	 * Metodo que altera um seguro assegurado por valor para um seguro assegurado por taxa
	 * @param apostaAssegurada e o identificador da aposta assegurada
	 * @param taxa e o valor da taxa
	 */
	public void alteraSeguroTaxa(int apostaAssegurada, double taxa) {
		if(apostasAsseguradas.containsKey(apostaAssegurada)) {
			Aposta novaAposta = apostasAsseguradas.get(apostaAssegurada);
			novaAposta.AlteraSeguroTaxa(taxa);
			apostasAsseguradas.remove(apostaAssegurada);
			apostasAsseguradas.put(apostaAssegurada, novaAposta);
		}	
	}
	
	/**
	 * Metodo que cria a representacao do cenario
	 * @return a representacao do cenario no formato String
	 */
	@Override
	public String toString() {
		return this.numCenario + " - " + this.descricao + " - " + this.estado;
	}
	
	/**
	 * Metodo que devolve o rateio total do cenario
	 * @return o rateio total do cenario no formato double
	 */
	public double getRateio() {
		return rateio;
	}
	
	/**
	 * Metodo que devolve o caixa do cenario
	 * @return o caixa do cenario no formato double
	 */
	public double getCaixaCenario() {
		return caixaCenario;
	}
	
	/**
	 * Metodo que devolve o estado do cenario
	 * @return o estado do cenario que pode ser "Nao finalizado", "Finalizado (ocorreu)" ou "Finalizado (n ocorreu)"
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * Metodo que retorna as apostas feitas no cenario
	 * @return um ArrayList de Aposta
	 */
	public ArrayList<ApostaSemSeguro> getApostadores() {
		return apostaSemSeguro;
	}
	
	/**
	 * Metodo que retorna a quantidade de apostas contidas no cenario
	 * @return a quantidade de apostas do cenario no formato Integer
	 */
	public int getQtdApostas() {
		return this.apostasAsseguradas.size() + this.apostaSemSeguro.size();
	}
	
	/**
	 * Metodo que retorna a descricao do cenario
	 * @return a descricao do cenario no formato String
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Metodo que retorna o numero que identifica a ordem em que o cenario foi adicionado
	 * @return o numero do cenario no formato Integer
	 */
	public int getNumCenario() {
		return numCenario;
	}
}