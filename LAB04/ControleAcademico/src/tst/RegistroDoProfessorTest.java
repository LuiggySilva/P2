package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controleAcademico.Aluno;
import controleAcademico.RegistroDoProfessor;

public class RegistroDoProfessorTest {

	private RegistroDoProfessor registroDoProfessor;
	private Aluno aluno1;
	private Aluno aluno2;

	@Before
	public void testRegistroDoProfessor() {
		this.registroDoProfessor = new RegistroDoProfessor();
		this.aluno1 = new Aluno("Luiggy", 12345, "CCC");
		this.aluno2 = new Aluno("Pedro", 54321, "EE");
	}
	/**
	 * Testa o toString() do RegistroDoProfessor.
	 */
	@Test
	public void testToString() {
		registroDoProfessor.adicionaResposta(aluno1);
		registroDoProfessor.adicionaResposta(aluno2);
		assertEquals("1. 12345 - Luiggy - CCC" + System.lineSeparator() + "2. 54321 - Pedro - EE", registroDoProfessor.toString());
	}
	/**
	 * Testa adicionar uma resposta com um Aluno nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionandoAlunoNulo() {
		registroDoProfessor.adicionaResposta(null);
	}
}
