package lab05_LuiggySilva;

import java.util.ArrayList;
/**
 * Classe CenarioBonus que herda todos atributos e metodos da classe Cenario
 * @author LUIGGY SILVA
 *
 */
public class CenarioBonus extends Cenario{
	
	private int bonus;
	
	/**
	 * Construtor do cenario bonus que cria o CenarioBonus apartir do numero do cenario, descricao e bonus
	 * @param numCenario e o numero do cenario no formato Integer
	 * @param desc e a descricao do cenario no formato String
	 * @param bonus e o bonus do cenario no formato Integer
	 */
	public CenarioBonus(int numCenario, String desc, int bonus) {
		super(numCenario, desc);
		if(bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		if(desc.trim().equals("") || desc == null) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		if(numCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: numero do cenario invalido");
		}
		this.bonus = bonus;
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe Pai Cenario que fecha as apostas no cenario
	 * @return o caixa do cenario
	 */
	@Override
	public int fecharAposta(boolean ocorreu, double taxa) {
		
		ArrayList<Integer> calculos = calculoCaixaCenarioRateio(ocorreu);
		
		this.caixaCenario = (calculos.get(0) * taxa);
		if(calculos.get(1) == 0) {
			this.rateio = 0;
		}
		else {
			this.rateio = ((this.caixaCenario * 100) / calculos.get(1) + this.bonus) - 20;
		}
		return (int)caixaCenario;
	}
	
	/**
	 * Metodo que sobrescreve o metodo da classe pai Cenario que e a representacao do cenario bonus
	 * @return a representacao do cenario bonus no formato String
	 */
	@Override
	public String toString() {
		return super.toString() + " - R$ " + formataDinheiro(this.bonus);
	}
	
	/**
	 * Metodo que devolve o bonus do cenario
	 * @return o bonus do cenario no formato double
	 */
	public double getBonus() {
		return bonus;
	}
	
	/**
	 * Metodo que formata o modo que os centavos sao representado
	 * @param e o valor em centavos 
	 * @return uma string com a representacao reais dos centavos
	 */
	private String formataDinheiro(int e) {
		String resul = "";
		String x = Integer.toString(e);
		int y = (int) e/100;
		resul += Integer.toString(y);
		resul += ",";
		for (int i = 0; i < x.length(); i++) {
			if(i >= x.length() - 2) {
				resul += x.charAt(i);
			}
		}
		return resul;
	}
}