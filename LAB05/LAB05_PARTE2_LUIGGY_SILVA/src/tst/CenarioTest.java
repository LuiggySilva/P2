package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import lab05_LuiggySilva.Aposta;
import lab05_LuiggySilva.Cenario;

public class CenarioTest {

	private Cenario cenario;

	@Before
	public void testCenario() {
		this.cenario = new Cenario(1, "BRASIL VAI SER HEXA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoVazia() {
		Cenario teste1 = new Cenario(2, "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoSoComEspacos() {
		Cenario teste2 = new Cenario(2, "    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoNula() {
		Cenario teste3 = new Cenario(2, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioIndiceZero() {
		Cenario teste4 = new Cenario(0, "Brasil 7 x 1 Alemanha");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioIndiceNegativo() {
		Cenario teste5 = new Cenario(-1, "Brasil 3 x 0 Alemanha");
	}

	@Test
	public void testGetRateio() {
		cenario.adicionaAposta("Luiggy", 10000, "VAI ACONTECER");
		cenario.adicionaAposta("Fresco", 10000, "N VAI ACONTECER");
		cenario.adicionaAposta("Moral", 10000, "VAI ACONTECER");
		cenario.fecharAposta(true, 1);
		assertEquals("ERRO: getRateio()", 990000, (int)cenario.getRateio());
	}

	@Test
	public void testGetCaixaCenario() {
		cenario.adicionaAposta("Luiggy", 10000, "VAI ACONTECER");
		cenario.adicionaAposta("Fresco", 10000, "N VAI ACONTECER");
		cenario.adicionaAposta("Moral", 10000, "VAI ACONTECER");
		cenario.fecharAposta(true, 1);
		assertEquals("ERRO: getCaixaCenario()", 10000, (int)cenario.getCaixaCenario());
	}

}
