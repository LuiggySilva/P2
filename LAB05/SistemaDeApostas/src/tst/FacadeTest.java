package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import lab05_LuiggySilva.Facade;

public class FacadeTest {

	private Facade facade;

	@Before
	public void testFacade() {
		this.facade = new Facade();
	}

	@Test
	public void testInicializa() {
		this.facade.inicializa(100000, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaCaixaNegativo() {
		facade.inicializa(-1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaTaxaNegativa() {
		facade.inicializa(100000, -1);
	}

	@Test
	public void testCadastrarCenarioString() {
		this.facade.cadastrarCenario("BRASIL VAI SER HEXA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoVazia() {
		facade.cadastrarCenario("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoSoComEspacos() {
		facade.cadastrarCenario("    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoNula() {
		facade.cadastrarCenario(null);
	}

	@Test
	public void testCadastrarCenarioBonus() {
		this.facade.cadastrarCenario("Brasil 7 x 1 Alemanha", 10000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusComBonusZero() {
		facade.cadastrarCenario("Greve na UFCG", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusComBonusNegativo() {
		facade.cadastrarCenario("Greve na UEPB", -1);
	}
	
	@Test
	public void testExibirCenario() {
		facade.cadastrarCenario("BRASIL VAI SER HEXA");
		assertEquals("ERRO: exibeCenario()", "1 - BRASIL VAI SER HEXA - Nao finalizado", facade.exibirCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioComCenarioInvalido() {
		facade.exibirCenario(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioComCenarioNegativo() {
		facade.exibirCenario(-1);
	}

	@Test
	public void testExibeCenarios() {
		facade.cadastrarCenario("BRASIL VAI SER HEXA");
		facade.cadastrarCenario("Brasil 7 x 1 Alemanha", 10000);
		facade.cadastrarCenario("Brasil vai ser Campeao");
		assertEquals("ERRO: ExibeCenarios()", "1 - BRASIL VAI SER HEXA - Nao finalizado" + System.lineSeparator() + "2 - Brasil 7 x 1 Alemanha - Nao finalizado - R$ 100.0" + System.lineSeparator() + "3 - Brasil vai ser Campeao - Nao finalizado", facade.exibeCenarios());
	}

	@Test
	public void testCadastraAposta() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		this.facade.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		this.facade.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		this.facade.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioInvalido() {
		facade.cadastrarAposta(100, "Luiggy", 100000, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioNegativo() {
		facade.cadastrarAposta(-1, "Luiggy", 100000, "VAI ACONTECER");
	}

	@Test
	public void testCadastraApostaAsseguradaValor() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		this.facade.cadastrarApostaSeguraValor(1, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaValorComCenarioZero() {
		facade.cadastrarApostaSeguraValor(0, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaValorComCenarioNegativo() {
		facade.cadastrarApostaSeguraValor(-1, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaValorComCenarioInvalido() {
		facade.cadastrarApostaSeguraValor(100, "Luiggy", 50000, "VAI ACONTECER", 5000, 500);
	}
	
	@Test
	public void testCadastraApostaAsseguradaTaxa() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		this.facade.cadastrarApostaSeguraTaxa(1, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaTaxaComCenarioZero() {
		facade.cadastrarApostaSeguraTaxa(0, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaTaxaComCenarioNegativo() {
		facade.cadastrarApostaSeguraTaxa(-1, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaAsseguradaTaxaComCenarioInvalido() {
		facade.cadastrarApostaSeguraTaxa(100, "Luiggy", 50000, "VAI ACONTECER", 0.01, 5000);
	}

	@Test
	public void testExibeApostas() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		facade.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		facade.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		facade.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: exibeApostas()", "Luiggy - R$ 1000.0 - VAI ACONTECER" + System.lineSeparator() + "Fresco - R$ 1000.0 - N VAI ACONTECER" + System.lineSeparator() + "Matheus - R$ 1000.0 - VAI ACONTECER", facade.exibeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasComCenarioZero() {
		facade.exibeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasComCenarioNegativo() {
		facade.exibeApostas(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasComCenarioInvalido() {
		facade.exibeApostas(100);
	}
	
	@Test
	public void testValorTotalDeApostas() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		facade.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		facade.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		facade.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: valorTotalDeApostas()", 300000, (int)this.facade.valorTotalDeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasComCenarioZero() {
		facade.valorTotalDeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasComCenarioNegativo() {
		facade.valorTotalDeApostas(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasComCenarioInvalido() {
		facade.valorTotalDeApostas(100);
	}

	@Test
	public void testTotalDeApostas() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		facade.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		facade.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		facade.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		assertEquals("ERRO: totalDeApostas()", 3, this.facade.totalDeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasComCenarioZero() {
		facade.totalDeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasComCenarioNegativo() {
		facade.totalDeApostas(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasComCenarioInvalido() {
		facade.totalDeApostas(100);
	}

	@Test
	public void testFechaAposta() {
		facade.cadastrarCenario("Brasil vai ser Campeao");
		this.facade.fecharAposta(1, true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaComCenarioZero() {
		facade.fecharAposta(0, true);;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaComCenarioNegativo() {
		facade.fecharAposta(-1, true);;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaComCenarioInvalido() {
		facade.fecharAposta(100, true);;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaJaFechada() {
		facade.fecharAposta(2, true);
		facade.fecharAposta(2, true);
	}

	@Test
	public void testGetCaixaCenario() {
		facade.inicializa(100000, 1);
		facade.cadastrarCenario("Brasil vai ser Campeao");
		facade.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		facade.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		facade.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		facade.fecharAposta(1, true);
		assertEquals("ERRO: getCaixaCenario()", 100000, (int)facade.getCaixaCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioZero() {
		facade.getCaixaCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioNegativo() {
		facade.getCaixaCenario(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioInvalido() {
		facade.getCaixaCenario(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioComCenarioAberto() {
		facade.getCaixaCenario(3);
	}

	@Test
	public void testGetRateioCenario() {
		facade.inicializa(100000, 0.1);
		facade.cadastrarCenario("Brasil vai ser Campeao");
		facade.cadastrarAposta(1, "Luiggy", 100000, "VAI ACONTECER");
		facade.cadastrarAposta(1, "Fresco", 100000, "N VAI ACONTECER");
		facade.cadastrarAposta(1, "Matheus", 100000, "VAI ACONTECER");
		facade.fecharAposta(1, true);
		assertEquals("ERRO: getRateioCenario()", 990000, (int)facade.getTotalRateioCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioZero() {
		facade.getTotalRateioCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioNegativo() {
		facade.getTotalRateioCenario(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioInvalido() {
		facade.getTotalRateioCenario(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetRateioCenarioComCenarioAberto() {
		facade.getTotalRateioCenario(3);
	}

	@Test
	public void testGetCaixa() {
		facade.inicializa(100000, 1);
		assertEquals("ERRO: getCaixa()", 100000, (int)facade.getCaixa());
	}
}
