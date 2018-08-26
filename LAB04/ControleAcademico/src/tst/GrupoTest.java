package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import controleAcademico.Aluno;
import controleAcademico.Grupo;

public class GrupoTest {

	private Grupo grupo1;
	private Aluno aluno;
	private Grupo grupo2;
	private Grupo grupo3;

	@Before
	public void testGrupo() {
		this.grupo1 = new Grupo("PROGRAMAÇÂO");
		this.grupo2 = new Grupo("LP2");
		this.grupo3 = new Grupo("PROGRAMAÇÂO");
		this.aluno = new Aluno("Luiggy", 12345, "CCC");
	}
	/**
	 * Testa o toString() do grupo.
	 */
	@Test
	public void testToString() {
		grupo1.setAlunosNoGrupo(aluno);
		assertEquals("* 12345 - Luiggy - CCC", grupo1.toString());
	}
	/**
	 * Testa o caso true do Equals do grupo. 
	 */
	@Test
	public void testEqualsTrue() {
		assertEquals(true, grupo1.equals(grupo3));
	}
	/**
	 * Testa o caso false do Equals do grupo.
	 */
	@Test
	public void testEqualsFalse() {
		assertEquals(false, grupo1.equals(grupo2));
	}
}
