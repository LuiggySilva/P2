package lab03LuiggySilva;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContatoTest {

	private Contato contatoBasico;
	private String saidaEsperadaToString = "Luiggy Silva\nTelefone Celular -> 2101-0000\nTelefone Trabalho -> 6666-6666\nTelefone Casa -> 8888-8888\nNivel de Amizade -> Irmão"; 

	@Before
	public void criaContato() {
		contatoBasico = new Contato(1, "Luiggy", "Silva", "2101-0000", "6666-6666", "8888-8888", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNomeNulo() {
		contatoBasico = new Contato(1, null, "Silva", "2101-0000", "6666-6666", "8888-8888", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSobrenomeNulo() {
		contatoBasico = new Contato(1, "Luiggy", null, "2101-0000", "6666-6666", "8888-8888", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNumeroCelularNulo() {
		contatoBasico = new Contato(1, "Luiggy", "Silva", null, "6666-6666", "8888-8888", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNumeroTrabalhoNulo() {
		contatoBasico = new Contato(1, "Luiggy", "Silva", "2101-0000", null, "8888-8888", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNumeroCasaNulo() {
		contatoBasico = new Contato(1, "Luiggy", "Silva", "2101-0000", "6666-6666", null, 5);
	}
	
	@Test
	public void testToString(){
		contatoBasico = new Contato(1, "Luiggy", "Silva", "2101-0000", "6666-6666", "8888-8888", 5);
		assertEquals("toString com Erro", saidaEsperadaToString, contatoBasico.toString());
	}
	
}
