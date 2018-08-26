package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import lab05_LuiggySilva.ApostaAsseguradaTaxa;

public class ApostaAsseguradaTaxaTest {

	private ApostaAsseguradaTaxa apostaAsseguradaTaxa;

	@Before
	public void testApostaAsseguradaTaxa() {
		this.apostaAsseguradaTaxa = new ApostaAsseguradaTaxa("Luiggy", 10000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaNomeVazio() {
		ApostaAsseguradaTaxa teste1 = new ApostaAsseguradaTaxa("", 10000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaNomeSoComEspacos() {
		ApostaAsseguradaTaxa teste2 = new ApostaAsseguradaTaxa("     ", 10000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaNomeNulo() {
		ApostaAsseguradaTaxa teste3 = new ApostaAsseguradaTaxa(null, 10000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaPrevisaoVazia() {
		ApostaAsseguradaTaxa teste4 = new ApostaAsseguradaTaxa("Luiggy", 10000, "", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaPrevisaoSoComEspacos() {
		ApostaAsseguradaTaxa teste5 = new ApostaAsseguradaTaxa("Luiggy", 10000, "    ", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaPrevisaoNula() {
		ApostaAsseguradaTaxa teste6 = new ApostaAsseguradaTaxa("Luiggy", 10000, null, 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaComApostaZero() {
		ApostaAsseguradaTaxa teste7 = new ApostaAsseguradaTaxa("Luiggy", 0, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaComApostaNegativa() {
		ApostaAsseguradaTaxa teste8 = new ApostaAsseguradaTaxa("Luiggy", -1, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaComTaxaZero() {
		ApostaAsseguradaTaxa teste9 = new ApostaAsseguradaTaxa("Luiggy", 10000, "VAI ACONTECER", 0, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaComTaxaNegativa() {
		ApostaAsseguradaTaxa teste10 = new ApostaAsseguradaTaxa("Luiggy", 10000, "VAI ACONTECER", -1, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaComCustoSeguroZero() {
		ApostaAsseguradaTaxa teste11 = new ApostaAsseguradaTaxa("Luiggy", 10000, "VAI ACONTECER", 0.01, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaComCustoSeguroNegativo() {
		ApostaAsseguradaTaxa teste12 = new ApostaAsseguradaTaxa("Luiggy", 10000, "VAI ACONTECER", 0.01, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComPrevisaoInvalida1() {
		ApostaAsseguradaTaxa teste13 = new ApostaAsseguradaTaxa("Luiggy", 10000, "ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComPrevisaoInvalida2() {
		ApostaAsseguradaTaxa teste14 = new ApostaAsseguradaTaxa("Luiggy", 10000, "N ACONTECER", 0.01, 5000);
	}
	
	@Test
	public void testToString() {
		assertEquals("ERRO: toString()", "Luiggy - R$ 100.0 - VAI ACONTECER - ASSEGURADA(TAXA) - 1%", apostaAsseguradaTaxa.toString());
	}

	@Test
	public void testGetSeguroTaxa() {
		assertEquals("ERRO: getSeguroTaxa", 0, (int)apostaAsseguradaTaxa.getSeguro());
	}

	@Test
	public void testGetCustoSeguro() {
		assertEquals("ERRO: getCustoSeguro()", 5000, apostaAsseguradaTaxa.getCustoSeguro());
	}

	@Test
	public void testGetValorSeguro() {
		assertEquals("ERRO: getValorSeguro()", (int)(0.01 * 10000), apostaAsseguradaTaxa.getSeguro());
	}

}
