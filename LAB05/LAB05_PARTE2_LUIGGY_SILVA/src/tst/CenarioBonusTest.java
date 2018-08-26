package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import lab05_LuiggySilva.CenarioBonus;

public class CenarioBonusTest {

	private CenarioBonus cenarioBonus;

	@Before
	public void testCenarioBonus() {
		this.cenarioBonus = new CenarioBonus(1, "Brasil vai ser HEXA", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusDescricaoVazia() {
		CenarioBonus teste1 = new CenarioBonus(2, "", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusDescricaoSoComEspacos() {
		CenarioBonus teste2 = new CenarioBonus(2, "    ", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusDescricaoNula() {
		CenarioBonus teste3 = new CenarioBonus(2, null, 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusIndiceZero() {
		CenarioBonus teste4 = new CenarioBonus(0, "Brasil 7 x 1 Alemanha", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusIndiceNegativo() {
		CenarioBonus teste5 = new CenarioBonus(-1, "Brasil 3 x 0 Alemanha", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusComBonusZero() {
		CenarioBonus teste6 = new CenarioBonus(2, "Greve na UFCG", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusComBonusNegativo() {
		CenarioBonus teste7 = new CenarioBonus(2, "Greve na UEPB", -1);
	}
	
	@Test
	public void testFecharAposta() {
		cenarioBonus.adicionaAposta("Luiggy", 10000, "VAI ACONTECER");
		cenarioBonus.adicionaAposta("Fresco", 10000, "N VAI ACONTECER");
		cenarioBonus.adicionaAposta("Moral", 10000, "VAI ACONTECER");
		assertEquals("ERRO: fecharAposta()", 100, cenarioBonus.fecharAposta(true, 0.01));
	}

	@Test
	public void testToString() {
		assertEquals("ERRO: toString()", "1 - Brasil vai ser HEXA - Nao finalizado - R$ 100.0", cenarioBonus.toString());
	}
}
