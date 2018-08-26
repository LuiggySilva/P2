package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//import lab05_LuiggySilva.ApostaAsseguradaTaxa;
import lab05_LuiggySilva.ApostaAsseguradaValor;

public class ApostaAsseguradaValorTest {

	private ApostaAsseguradaValor apostaAsseguradaValor;

	@Before
	public void testApostaAsseguradaValor() {
		this.apostaAsseguradaValor = new ApostaAsseguradaValor("LuiggyFake", 10000, "VAI ACONTECER", 5000, 500); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorNomeVazio() {
		ApostaAsseguradaValor teste1 = new ApostaAsseguradaValor("", 10000, "VAI ACONTECER", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorNomeSoComEspacos() {
		ApostaAsseguradaValor teste2 = new ApostaAsseguradaValor("     ", 10000, "VAI ACONTECER", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorNomeNulo() {
		ApostaAsseguradaValor teste3 = new ApostaAsseguradaValor(null, 10000, "VAI ACONTECER", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorPrevisaoVazia() {
		ApostaAsseguradaValor teste4 = new ApostaAsseguradaValor("Luiggy", 10000, "", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorPrevisaoSoComEspacos() {
		ApostaAsseguradaValor teste5 = new ApostaAsseguradaValor("Luiggy", 10000, "    ", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorPrevisaoNula() {
		ApostaAsseguradaValor teste6 = new ApostaAsseguradaValor("Luiggy", 10000, null, 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComApostaZero() {
		ApostaAsseguradaValor teste7 = new ApostaAsseguradaValor("Luiggy", 0, "VAI ACONTECER", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComApostaNegativa() {
		ApostaAsseguradaValor teste8 = new ApostaAsseguradaValor("Luiggy", -1, "VAI ACONTECER", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComValorZero() {
		ApostaAsseguradaValor teste9 = new ApostaAsseguradaValor("Luiggy", 10000, "VAI ACONTECER", 0, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComValorNegativo() {
		ApostaAsseguradaValor teste10 = new ApostaAsseguradaValor("Luiggy", 10000, "VAI ACONTECER", -1, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComCustoSeguroZero() {
		ApostaAsseguradaValor teste11 = new ApostaAsseguradaValor("Luiggy", 10000, "VAI ACONTECER", 5000, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComCustoSeguroNegativo() {
		ApostaAsseguradaValor teste12 = new ApostaAsseguradaValor("Luiggy", 10000, "VAI ACONTECER", 5000, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComPrevisaoInvalida1() {
		ApostaAsseguradaValor teste13 = new ApostaAsseguradaValor("Luiggy", 10000, "ACONTECER", 5000, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorComPrevisaoInvalida2() {
		ApostaAsseguradaValor teste14 = new ApostaAsseguradaValor("Luiggy", 10000, "N ACONTECER", 5000, 5000);
	}
	
	@Test
	public void testToString() {
		assertEquals("ERRO: toString()", "LuiggyFake - R$ 100.0 - VAI ACONTECER - ASSEGURADA(VALOR) - R$ 50.0", apostaAsseguradaValor.toString());
	}

	@Test
	public void testGetCustoSeguro() {
		assertEquals("ERRO: getCustoSeguro()", 500, apostaAsseguradaValor.getCustoSeguro());
	}

	@Test
	public void testGetSeguroValor() {
		assertEquals("ERRO: getSeguroValor()", 5000, apostaAsseguradaValor.getSeguro());
	}

}
