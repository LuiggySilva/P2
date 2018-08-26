package lab05_LuiggySilva;

import java.util.Comparator;

public class OrdenaApostas implements Comparator<Cenario>{

	@Override
	public int compare(Cenario c1, Cenario c2) {
		if((c1.getQtdApostas() - c2.getQtdApostas()) == 0) {
			return c1.getNumCenario() - c2.getNumCenario();
		}
		return (c1.getQtdApostas() - c2.getQtdApostas()) * - 1;
	}

}
