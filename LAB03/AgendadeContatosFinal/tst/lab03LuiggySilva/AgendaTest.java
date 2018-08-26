package lab03LuiggySilva;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AgendaTest {
	
	private Agenda agenda;
	private String saidaEsperadaExibeContato = "Luiggy Silva\nTelefone Celular -> 5555-5555\nTelefone Trabalho -> 6666-6666\nTelefone Casa -> 8888-8888\nNivel de Amizade -> Irmão";

	@Before
	public void criaAgenda() {
		agenda = new Agenda();
		agenda.adicionaContato(1, "Luiggy", "Silva", "5555-5555", "6666-6666", "8888-8888", 5);
		agenda.adicionaContato(10, "Irineu", "kk", "2222-2222", "3333-3333", "9999-9999", 5);
	}
	
	@Test
	public void testListaDeContatos() {
		assertEquals("Erro LISTA","1 - Luiggy Silva" + System.lineSeparator() + "10 - Irineu kk", agenda.listaDeContatos());
	}
	@Test
	public void testListaDeContatosPorNivel() {
		int nivel = 5;
		assertEquals("Erro LISTA POR AMIZADE", "1 - Luiggy Silva" + System.lineSeparator() + "10 - Irineu kk", agenda.listaDeContatosPorAmizade(nivel)[0]);
	}
	
	@Test
	public void testQuantidadeDeContatosPorNivel() {
		int nivel = 5;
		assertEquals("Erro QUANTIDADE DA LISTA POR AMIZADE", "2", agenda.listaDeContatosPorAmizade(nivel)[1]);
	}
	
	@Test
	public void testExibeContatoNome() {
		assertEquals("Erro na exibição do contato", saidaEsperadaExibeContato, agenda.exibeContatoNome("Luiggy Silva"));
	}
	
	@Test
	public void testExibeContatoNum() {
		assertEquals("Erro na exibição do contato", saidaEsperadaExibeContato, agenda.exibeContatoNum("6666-6666"));
	}
	
	@Test
	public void testExibeContatoPos() {
		assertEquals("Erro na exibição do contato", saidaEsperadaExibeContato, agenda.exibeContatoPos(1));
	}
	
	@Test
	public void testMediaDeAmizade() {
		assertEquals("Erro na Média de amizade", "Média de amizade -> 5.0", agenda.mediaAmizade());
	}
}

