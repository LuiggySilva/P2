package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import lab05_LuiggySilva.ApostaSemSeguro;

public class ApostaTest {

	private ApostaSemSeguro aposta;

	@Before
	public void testAposta() {
		this.aposta = new ApostaSemSeguro("Luiggy", 10000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaNomeVazio() {
		ApostaSemSeguro teste1 = new ApostaSemSeguro("", 10000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaNomeSoComEspacos() {
		ApostaSemSeguro teste2 = new ApostaSemSeguro("    ", 10000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaNomeNulo() {
		ApostaSemSeguro teste3 = new ApostaSemSeguro(null, 10000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoVazia() {
		ApostaSemSeguro teste4 = new ApostaSemSeguro("Luiggy", 10000, "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoSoComEspacos() {
		ApostaSemSeguro teste5 = new ApostaSemSeguro("Luiggy", 10000, "    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoNula() {
		ApostaSemSeguro teste6 = new ApostaSemSeguro("Luiggy", 10000, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComApostaZero() {
		ApostaSemSeguro teste7 = new ApostaSemSeguro("Luiggy", 0, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComApostaNegativa() {
		ApostaSemSeguro teste8 = new ApostaSemSeguro("Luiggy", -1, "VAI ACONTECER");
	}
	
	@Test
	public void testToString() {
		assertEquals("ERRO: toString()", "Luiggy - R$ 100 - VAI ACONTECER", aposta.toString());
	}

	@Test
	public void testGetPrevisao() {
		assertEquals("ERRO: getPrevisao()", "VAI ACONTECER", aposta.getPrevisao());
	}

	@Test
	public void testGetAposta() {
		assertEquals("ERRO: getAposta()", 10000, (int)aposta.getAposta());
	}

}
