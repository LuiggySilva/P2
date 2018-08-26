package lab05_LuiggySilva;

import java.util.Comparator;

public class OrdenaCadastro implements Comparator<Cenario> {

	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getNumCenario() - c2.getNumCenario() * -1;
	}
}
