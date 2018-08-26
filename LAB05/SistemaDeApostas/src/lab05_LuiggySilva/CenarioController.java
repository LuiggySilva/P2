package lab05_LuiggySilva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
/**
 * Classe que controla todos metodos que podem ser realizados apartir da classe cenario
 * @author LUIGGY SILVA
 *
 */
public class CenarioController {
	
	private HashMap<Integer, Cenario> cenarios;
	private int cenariosAdicionados;
	private int caixa;
	private double taxa;
	private Comparator<Cenario> ordemDeOrdenacao;
	/**
	 * Construtor do CenarioContorller que inicializa um HashMap e define os cenarios adicionados como um
	 */
	public CenarioController() {
		this.cenarios = new HashMap<Integer, Cenario>();
		this.cenariosAdicionados = 1;
	}
	/**
	 * Metodo que inicializa o caixa principal
	 * @param taxa e a taxa no formato double
	 * @param caixa e o caixa no formato Integer
	 */
	public void inicializa(double taxa, int caixa) {
		if(taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		if(caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		this.taxa = taxa;
		this.caixa = caixa;
	}
	/**
	 * Metodo que cria um cenario sem bonuns e mapeia um Integer(numero do cenario) para um objeto Cenario(o cenario criado)
	 * @param descCenario e a descricao do cenario no formato String
	 */
	public void adicionaCenario(String descCenario) {
		Cenario cenario = new Cenario(cenariosAdicionados, descCenario);
		cenarios.put(cenariosAdicionados, cenario);
		cenariosAdicionados++;
	}
	/**
	 * Metodo que cria um cenario sem bonuns e mapeia um Integer(numero do cenario) para um objeto Cenario(o cenario criado)
	 * @param descCenario e a descricao do cenario no formato String
	 * @param bonus e o bonus do cenario no formato Integer
	 */
	public void adicionaCenario(String descCenario, int bonus) {
		CenarioBonus cenarioBonus = new CenarioBonus(cenariosAdicionados, descCenario, bonus);
		cenarios.put(cenariosAdicionados, cenarioBonus);
		setCaixaDecremento(bonus);
		cenariosAdicionados++;
	}
	/**
	 * Metodo que exibe um cenario apartir de seu numero
	 * @param numCenario e o numero do cenario
	 * @return uma representacao do cenario no formato String
	 */
	public String exibeCenario(int numCenario){
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenarios.get(numCenario).toString();
	}
	/**
	 * Metodo que exibe todos cenarios criados
	 * @return uma representacao de todos cenarios criados no formato String
	 */
	public String exibeCenarios() {
		String saida = "";
		for (Cenario cenario : cenarios.values()) {
			saida += cenario.toString() + System.lineSeparator();
		}
		return saida.trim();
	}
	/**
	 * Metodo que adiciona uma aposta sem seguro em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param aposta e a aposta no formato Aposta
	 */
	public void cadastrarAposta(int numCenario, String nome, int valorAposta, String previsao) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");			
		}

		Cenario cenario = cenarios.get(numCenario);
		if(cenario.getEstado().equals("Nao finalizado")) {
			cenario.adicionaAposta(nome, valorAposta, previsao);
		}
	}
	/**
	 * Metodo que adiciona uma aposta assegurada por valor em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param apostaAsseguradaValor e a aposta assegurada por valor no formato ApostaAsseguradaValor
	 */
	public void cadastrarAposta(int numCenario, String nome, int valorAposta, String previsao, int seguroValor, int custo) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");			
		}

		Cenario cenario = cenarios.get(numCenario);
		if(cenario.getEstado().equals("Nao finalizado")) {
			cenario.adicionaApostaValor(nome, valorAposta, previsao, seguroValor, custo);
		}
		ApostaAsseguradaValor aposta = new ApostaAsseguradaValor(nome, valorAposta, previsao, seguroValor, custo);
		setCaixaIncremento(aposta.getCustoSeguro());
	}
	/**
	 * Metodo que adiciona uma aposta assegurada por taxa em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param apostaAsseguradaTaxa e a aposta assegurada por taxa no formato ApostaAsseguradaTaxa
	 */
	public void cadastrarAposta(int numCenario, String nome, int valorAposta, String previsao, double seguroTaxa, int custo) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");			
		}
		Cenario cenario = cenarios.get(numCenario);
		if(cenario.getEstado().equals("Nao finalizado")) {
			cenario.adicionaApostaTaxa(nome, valorAposta, previsao, seguroTaxa, custo);
		}
		ApostaAsseguradaTaxa aposta = new ApostaAsseguradaTaxa(nome, valorAposta, previsao, seguroTaxa, custo);
		setCaixaIncremento(aposta.getCustoSeguro());
	}
	
	/**
	 * Metodo que calcula a soma de todas apostas feitas em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return a soma de todas apostas feitas no cenario no formato Integer
	 */
	public int valorTotalDeApostas(int numCenario) {
		int valorTotalDeApostas = 0;
		
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		
		Cenario cenario = cenarios.get(numCenario);
		for (int i = 0; i < cenario.getApostadores().size(); i++) {
			valorTotalDeApostas += cenario.getApostadores().get(i).getAposta();
		}
		return valorTotalDeApostas;
	}
	
	/**
	 * Metodo que calcula a quantidade de apostas feitas em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return a quantidade de apostas feitas no cenario no formato Integer
	 */
	public int totalDeApostas(int numCenario) {
		int qtdApostas = 0;
		
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}

		Cenario cenario = cenarios.get(numCenario);
		qtdApostas = cenario.getApostadores().size();
		return qtdApostas;
	}
	
	/**
	 * Metodo que altera o modo que os cenarios sao listados podendo ser por Cadastro, Nome ou quantidade de Apostas
	 * @param ordem e a ordem em que vai ser ordenada a lista no formato String
	 */
	public void alterarOrdem(String ordem) {
		if(ordem == null || ordem.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		
		if(ordem.toUpperCase().equals("CADASTRO")) {
			this.ordemDeOrdenacao = new OrdenaCadastro();
		}
		else if(ordem.toUpperCase().equals("NOME")) {
			this.ordemDeOrdenacao = new OrdenaNome();
		}
		else if(ordem.toUpperCase().equals("APOSTAS")){
			this.ordemDeOrdenacao = new OrdenaApostas(); 
		}
		else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}
	
	/**
	 * Metodo que exibe um cenario apartir da lista ordenada de cenarios
	 * @param numCenario e o cenario que sera exibido
	 * @return uma representacao string do cenario
	 */
	public String exibirCenarioOrdenado(int numCenario) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		else if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		else if(!(this.ordemDeOrdenacao instanceof OrdenaApostas) && !(this.ordemDeOrdenacao instanceof OrdenaNome) && !(this.ordemDeOrdenacao instanceof OrdenaCadastro)) {
			return exibeCenario(numCenario);
		}

		ArrayList<Cenario> cenariosOrdenados = new ArrayList<Cenario>();
		cenariosOrdenados.addAll(this.cenarios.values());
		
		if(this.ordemDeOrdenacao instanceof OrdenaCadastro) {
			Collections.sort(cenariosOrdenados, new OrdenaCadastro());
		}
		else if(this.ordemDeOrdenacao instanceof OrdenaNome) {
			Collections.sort(cenariosOrdenados, new OrdenaNome());
		}
		else {
			Collections.sort(cenariosOrdenados, new OrdenaApostas());			
		}
		
		String saida = "";
		saida = cenariosOrdenados.get(numCenario - 1).toString();
		
		return saida;
	}
	
	/**
	 * Metodo que exibe todas apostas feitas em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return uma representacao de todas apostas do cenario no formato String
	 */
	public String exibeApostas(int numCenario) {
		String saida = "";
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenarios.get(numCenario).listarApostas();
	}
	
	/**
	 * Metodo que fecha o cadastro de apostas em um cenario e informa se o mesmmo ocorreu
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param ocorreu e o que informa se o cenario ocorreu ou nao no formato boolean
	 */
	public void fechaAposta(int numCenario, boolean ocorreu) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if(!cenarios.get(numCenario).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
		Cenario cenario = cenarios.get(numCenario);
		setCaixaIncremento(cenario.fecharAposta(ocorreu, this.taxa));
	}
	
	/**
	 * Metodo que pega o caixa de um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return o caixa do cenario no formato Integer
	 */
	public int getCaixaCenario(int numCenario) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		if(cenarios.get(numCenario).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return (int)cenarios.get(numCenario).getCaixaCenario();
	}
	
	/**
	 * Metodo que pega o Rateio total de um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return o rateio total do cenario no formato double
	 */
	public double getRateioCenario(int numCenario) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		if(cenarios.get(numCenario).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return cenarios.get(numCenario).getRateio();
	}
	
	/**
	 * Metodo que altera uma aposta assegurada de taxa para valor
	 * @param numCenario o cenario onde se localiza a aposta
	 * @param apostaAssegurada a identificacao da aposta assegurada
	 * @param valor o valor do seguro
	 * @return o numero do cenario que foi alterado a aposta
	 */
	public int alteraSeguroValor(int numCenario, int apostaAssegurada, int valor) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do cenario: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta do cenario: Cenario nao cadastrado");
		}
		Cenario novoCenario = cenarios.get(numCenario);
		novoCenario.alteraSeguroValor(apostaAssegurada, valor);
		cenarios.remove(numCenario);
		cenarios.put(numCenario, novoCenario);
		return numCenario;
	}
	
	/**
	 * Metodo que altera uma aposta assegurada de valor para taxa
	 * @param numCenario o cenario onde se localiza a aposta
	 * @param apostaAssegurada a identificacao da aposta assegurada
	 * @param taxa e a taxa
	 * @return o numero do cenario que foi alterado a aposta
	 */
	public int alteraSeguroTaxa(int numCenario, int apostaAssegurada, double taxa) {
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do cenario: Cenario invalido");
		}
		if(!cenarios.containsKey(numCenario)) {
			throw new IllegalArgumentException("Erro na consulta do cenario: Cenario nao cadastrado");
		}
		Cenario novoCenario = cenarios.get(numCenario);
		novoCenario.alteraSeguroTaxa(apostaAssegurada, taxa);
		cenarios.remove(numCenario);
		cenarios.put(numCenario, novoCenario);
		return numCenario;
	}
	
	/**
	 * Metodo que devolve o caixa principal
	 * @return o caixa principal no formato Integer
	 */
	public int getCaixa() {
		return caixa;
	}
	/**
	 * Metodo que retorna a taxa
	 * @return a taxa no formato double
	 */
	public double getTaxa() {
		return taxa;
	}
	/**
	 * Metodo que incrementa o caixa principal
	 * @param caixa e o incremento que o caixa ira sofrer no formato Integer
	 */
	private void setCaixaIncremento(int caixa) {
		this.caixa += caixa;
	}
	/**
	 * Metodo que decrementa o caixa principal
	 * @param caixa e o decremento que o caixa ira sofrer no formato Integer
	 */
	private void setCaixaDecremento(int caixa) {
		this.caixa -= caixa;
	}
}