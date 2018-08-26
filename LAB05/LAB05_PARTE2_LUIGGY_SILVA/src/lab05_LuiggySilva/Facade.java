package lab05_LuiggySilva;

import easyaccept.EasyAccept;
/**
 * Representacao de um sistema de apostas onde e possivel cadastrar cenarios com ou sem bonus
 * e cadastrar apostas com ou sem seguro.
 * @author LUIGGY SILVA
 *
 */
public class Facade {
	/**
	 * Metodo main onde sao realizado os testes EasyAccept
	 */
	public static void main(String[] args) {
		args = new String[] {"lab05_LuiggySilva.Facade", 
			"acceptance_test/us1_test.txt",
			"acceptance_test/us2_test.txt",
			"acceptance_test/us3_test.txt",
			"acceptance_test/us4_test.txt",
			"acceptance_test/us5_test.txt",
			"acceptance_test/us6_test.txt",
			"acceptance_test/us7_test.txt"};
		EasyAccept.main(args);
	}
	
	private CenarioController cenarioController;
	/**
	 * Construtor do Facade que inicializa a classe CenarioController
	 */
	public Facade() {
		this.cenarioController = new CenarioController();
	}
	/**
	 * Metodo que inicializa o caixa principal que tem um caixa e uma taxa
	 * @param caixa e o valor do caixa
	 * @param taxa e o valor da taxa
	 */
	public void inicializa(int caixa, double taxa) {
		cenarioController.inicializa(taxa, caixa);
	}
	/**
	 * Metodo que cadastra um cenario sem bonus com uma descricao
	 * @param descCenario a descricao do cenario no formato string
	 */
	public void cadastrarCenario(String descCenario) {
		cenarioController.adicionaCenario(descCenario);
	}
	/**
	 * Metodo que cadastra um cenario com bonus com a descricao e o bonus
	 * @param descCenario a descricao do cenario no formato string
	 * @param bonus o bonus do cenario no formato Integer
	 */
	public void cadastrarCenario(String descCenario, int bonus) {
		cenarioController.adicionaCenario(descCenario, bonus);
	}
	/**
	 * Metodo que exibe um cenario apartir do seu numero
	 * @param cenario e o numero do cenario no formato Integer
	 * @return uma representacao no formato string do cenario
	 */
	public String exibirCenario(int numCenario) {
		return cenarioController.exibeCenario(numCenario);
	}
	/**
	 * Metodo que exibe todos enarios cadastrados
	 * @return uma representacao no formato string de todos cenarios cadastrados
	 */
	public String exibeCenarios() {
		return cenarioController.exibeCenarios();
	}
	
	public void alterarOrdem(String ordem) {
		cenarioController.alterarOrdem(ordem);
	}
	
	public String exibirCenarioOrdenado(int numCenario) {
		return cenarioController.exibirCenarioOrdenado(numCenario);
	}
	/**
	 * Metodo que cadastra uma aposta sem seguro em um cenario
	 * @param numCenario o numero do cenario onde vai ser cadastrado a aposta no formato Integer
	 * @param nome e o nome do apostador no formato String
	 * @param valorAposta e o quando o apostador vai apostadar no formato Integer
	 * @param previsao a sua previsao para o cenario que pode ser "VAI ACONTECER" ou "N VAI ACONTECER" no formato String
	 */
	public void cadastrarAposta(int numCenario, String nome, int valorAposta, String previsao) {
		cenarioController.cadastrarAposta(numCenario, nome, valorAposta, previsao);
	}
	/** 
	 * Metodo que cadastra uma aposta com seguro por valor em um cenario
	 * @param numCenario o numero do cenario onde vai ser cadastrado a aposta no formato Integer
	 * @param nome e o nome do apostador no formato String
	 * @param valorAposta e o quando o apostador vai apostadar no formato Integer
	 * @param previsao a sua previsao para o cenario que pode ser "VAI ACONTECER" ou "N VAI ACONTECER" no formato String
	 * @param seguroValor e o valor do seguro da aposta no formato Integer
	 * @param custo e o custo do seguro no formato Integer
	 */
	public void cadastrarApostaSeguraValor(int numCenario, String nome, int valorAposta, String previsao, int seguroValor, int custo) {
		cenarioController.cadastrarAposta(numCenario, nome, valorAposta, previsao, seguroValor, custo);
	}
	/**
	 * Metodo que cadastra uma aposta com seguro por taxa em um cenario
	 * @param numCenario o numero do cenario onde vai ser cadastrado a aposta no formato Integer
	 * @param nome e o nome do apostador no formato String
	 * @param valorAposta e o quando o apostador vai apostadar no formato Integer
	 * @param previsao a sua previsao para o cenario que pode ser "VAI ACONTECER" ou "N VAI ACONTECER" no formato String
	 * @param seguroTaxa e o valor do seguro da aposta no formato double
	 * @param custo e o custo do seguro no formato Integer
	 */
	public void cadastrarApostaSeguraTaxa(int numCenario, String nome, int valorAposta, String previsao, double seguroTaxa, int custo) {
		cenarioController.cadastrarAposta(numCenario, nome, valorAposta, previsao, seguroTaxa, custo);
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return cenarioController.alteraSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return cenarioController.alteraSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
	/**
	 * Metodo que exibe todas apostas de um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return uma representacao no formato String de todas apostas contidas no cenario no formato String
	 */
	public String exibeApostas(int numCenario) {
		return cenarioController.exibeApostas(numCenario);
	}
	/**
	 * Metodo que calcula a soma do valor de todas apostas feitas em um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return a soma de todas apostas do cenario no formmato Integer
	 */
	public int valorTotalDeApostas(int numCenario) {
		return cenarioController.valorTotalDeApostas(numCenario);
	}
	/**
	 * Metodo que calcula a quantidade de aposta feitas em uma cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return a quantidade de apostas feitas no cenario no formato Integer 
	 */
	public int totalDeApostas(int numCenario) {
		return cenarioController.totalDeApostas(numCenario);
	}
	/**
	 * Metodo que fecha o cadastro de apostas em um cenario e informa se o mesmmo ocorreu ou nao
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param ocorreu e um booleano que se for "true" o cenario ocorreu se for "false" o cenario nao ocorreu
	 */
	public void fecharAposta(int numCenario, boolean ocorreu) {
		cenarioController.fechaAposta(numCenario, ocorreu);
	}
	/**
	 * Metodo que pega o caixa de um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return o caixa do cenario no formato Integer
	 */
	public int getCaixaCenario(int numCenario) {
		return cenarioController.getCaixaCenario(numCenario);
	}
	/**
	 * Metodo que pega o rateio total de um cenario
	 * @param numCenario e o numero do cenario no formato Integer
	 * @return o rateio total do cenario no formato Integer
	 */
	public int getTotalRateioCenario(int numCenario) {
		return (int)cenarioController.getRateioCenario(numCenario);
	}
	/**
	 * Metodo que devolve o caixa principal
	 * @return o caixa principal no formato Integer
	 */
	public int getCaixa() {
		return cenarioController.getCaixa();
	}
}
