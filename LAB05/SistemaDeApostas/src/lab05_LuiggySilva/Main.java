package lab05_LuiggySilva;

public class Main {

	public static void main(String[] args) {
		Facade f = new Facade();
		
		f.inicializa(100000, 0.01);
		f.cadastrarCenario("Me fudi");
		f.cadastrarApostaSeguraValor(1, "Luiggy", 10000, "VAI ACONTECER", 5000, 5000);;
		System.out.println(f.exibeApostas(1));
		f.alterarSeguroTaxa(1, 1, 0.01);
		System.out.println(f.exibeApostas(1));
		
//		f.inicializa(100000, 0.01);
//		f.cadastrarCenario("Brasil 5 x 0 Mexico");
//		f.cadastrarCenario("Alemanha 0 x 2 Coreia Do Sul");
//		f.cadastrarCenario("Belgica 1 x 0 Inglaterra");
//		f.cadastrarCenario("Nigeria 2 x 1 Argentina");
//		
//		f.cadastrarAposta(1, "Irineu", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(1, "Irineu2", 50000, "VAI ACONTECER");
//		
//		f.cadastrarAposta(2, "Irineu3", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(2, "Irineu4", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(2, "Irineu5", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(2, "Irineu5", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(2, "Irineu6", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(2, "Irineu7", 50000, "VAI ACONTECER");
//		
//		f.cadastrarAposta(3, "Irineu8", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(3, "Irineu9", 50000, "VAI ACONTECER");
//		f.cadastrarAposta(3, "Irineu10", 50000, "VAI ACONTECER");
//		
//		System.out.println("\n====== Cenarios na ordem que foram adicionados e suas apostas ======\n");
//		System.out.println(f.exibirCenario(1) + "\n" + f.exibeApostas(1) + "\n");
//		System.out.println(f.exibirCenario(2) + "\n" + f.exibeApostas(2) + "\n");
//		System.out.println(f.exibirCenario(3) + "\n" + f.exibeApostas(3) + "\n");
//		System.out.println(f.exibirCenario(4) + "\n" + f.exibeApostas(4));
//		System.out.println("=============================================================");
//		
//		System.out.println("-------------------- Exibindo cenarios ordenados --------------------");
//		System.out.println("=============================================================\n");
//		System.out.println("Sem ordenação (1)\n" + f.exibirCenarioOrdenado(1) + System.lineSeparator());
//		f.alterarOrdem("Cadastro");
//		System.out.println("Por cadastro (3)\n" + f.exibirCenarioOrdenado(3) + System.lineSeparator());
//		f.alterarOrdem("Nome");
//		System.out.println("Por Nome (1)\n" + f.exibirCenarioOrdenado(1) + System.lineSeparator());
//		f.alterarOrdem("Apostas");
//		System.out.println("Por Qtd de Apostas do Cenario (3)\n" + f.exibirCenarioOrdenado(3) + System.lineSeparator());
	}
}
