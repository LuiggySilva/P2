package lab05_LuiggySilva;

import java.util.Comparator;

public class OrdenaNome implements Comparator<Cenario>{

	@Override
	public int compare(Cenario c1, Cenario c2) {
		if(c1.getDescricao().compareTo(c2.getDescricao()) == 0) {
			return c1.getNumCenario() - c2.getNumCenario();
		}
		return c1.getDescricao().compareTo(c2.getDescricao()) ;
	}

}
