package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import lab05_LuiggySilva.Aposta;
import lab05_LuiggySilva.ApostaAsseguradaTaxa;
import lab05_LuiggySilva.ApostaAsseguradaValor;
import lab05_LuiggySilva.CenarioController;

public class CenarioControllerTest {

	private CenarioController cenarioController;

	@Before
	public void testCenarioController() {
		this.cenarioController = new CenarioController();
	}

	@Test
	public void testInicializa() {
		this.cenarioController.inicializa(1, 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaCaixaNegativo() {
		cenarioController.inicializa(0.01, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaTaxaNegativa() {
		cenarioController.inicializa(-1, 100000);
	}

	@Test
	public void testAdicionaCenario() {
		this.cenarioController.adicionaCenario("Brasil vai ser HEXA");
		this.cenarioController.adicionaCenario("Brasil vai ser Campeao");
	}

	@Test
	public void testExibeCenario() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: exibeCenario()", "1 - Brasil vai ser HEXA - Nao finalizado", cenarioController.exibeCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioComCenarioInvalido() {
		cenarioController.exibeCenario(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioComCenarioNegativo() {
		cenarioController.exibeCenario(-1);
	}

	@Test
	public void testExibeCenarios() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.adicionaCenario("Brasil vai ser Campeao");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: exibeCenarios()", "1 - Brasil vai ser HEXA - Nao finalizado" + System.lineSeparator() + "2 - Brasil vai ser Campeao - Nao finalizado", cenarioController.exibeCenarios());
	}

	@Test
	public void testCadastraAposta() {
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioInvalido() {
		cenarioController.cadastrarAposta(100, "Luiggy", 100000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioNegativo() {
		cenarioController.cadastrarAposta(-1, "Luiggy", 100000, "VAI ACONTECER");
	}
	
	@Test
	public void testCadastraApostaAsseguradaValor() {
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaValorComCenarioZero() {
		cenarioController.cadastrarAposta(0, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaValorComCenarioNegativo() {
		cenarioController.cadastrarAposta(-1, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaValorComCenarioInvalido() {
		cenarioController.cadastrarAposta(100, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test
	public void testCadastraApostaAsseguradaTaxa() {
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaTaxaComCenarioZero() {
		cenarioController.cadastrarAposta(0, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaTaxaComCenarioNegativo() {
		cenarioController.cadastrarAposta(-1, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaTaxaComCenarioInvalido() {
		cenarioController.cadastrarAposta(100, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test
	public void testValorTotalDeApostas() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: valorTotalDeApostas()", 300000, (int)this.cenarioController.valorTotalDeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasComCenarioZero() {
		cenarioController.valorTotalDeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasComCenarioNegativo() {
		cenarioController.valorTotalDeApostas(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasComCenarioInvalido() {
		cenarioController.valorTotalDeApostas(100);
	}

	@Test
	public void testTotalDeApostas() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: totalDeApostas()", 3, this.cenarioController.totalDeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasComCenarioZero() {
		cenarioController.totalDeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasComCenarioNegativo() {
		cenarioController.totalDeApostas(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasComCenarioInvalido() {
		cenarioController.totalDeApostas(100);
	}

	@Test
	public void testExibeApostas() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: exibeApostas()", "Luiggy - R$ 1000.0 - VAI ACONTECER" + System.lineSeparator() + "Fresco - R$ 1000.0 - N VAI ACONTECER" + System.lineSeparator() + "Matheus - R$ 1000.0 - VAI ACONTECER", cenarioController.exibeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasComCenarioZero() {
		cenarioController.exibeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasComCenarioNegativo() {
		cenarioController.exibeApostas(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasComCenarioInvalido() {
		cenarioController.exibeApostas(100);
	}

	@Test
	public void testFechaAposta() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		cenarioController.fechaAposta(1, true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaComCenarioZero() {
		cenarioController.fechaAposta(0, true);;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaComCenarioNegativo() {
		cenarioController.fechaAposta(-1, true);;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaComCenarioInvalido() {
		cenarioController.fechaAposta(100, true);;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaJaFechada() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.fechaAposta(1, true);
		cenarioController.fechaAposta(1, true);
	}

	@Test
	public void testGetCaixaCenario() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		cenarioController.fechaAposta(1, true);
		assertEquals("ERRO: getCaixaCenario()", 100000, (int)cenarioController.getCaixaCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioZero() {
		cenarioController.getCaixaCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioNegativo() {
		cenarioController.getCaixaCenario(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioInvalido() {
		cenarioController.getCaixaCenario(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioAberto() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.getCaixaCenario(1);
	}

	@Test
	public void testGetRateioCenario() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		cenarioController.fechaAposta(1, true);
		assertEquals("ERRO: getRateioCenario()", 9900000, (int)cenarioController.getRateioCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioZero() {
		cenarioController.getRateioCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioNegativo() {
		cenarioController.getRateioCenario(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioInvalido() {
		cenarioController.getRateioCenario(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioAberto() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.getRateioCenario(1);
	}

	@Test
	public void testGetCaixa() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: getCaixa()", 100000, (int)cenarioController.getCaixa());
	}

	@Test
	public void testGetTaxa() {
		cenarioController.inicializa(1, 100000);
		cenarioController.adicionaCenario("Brasil vai ser HEXA");
		cenarioController.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		cenarioController.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: getTaxa()", 1, (int)cenarioController.getTaxa());
	}
}
