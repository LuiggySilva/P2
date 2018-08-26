package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controleAcademico.Aluno;

public class AlunoTest {

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@Before
	public void testAluno() {
		this.aluno1 = new Aluno("Luiggy", 123, "CCC");
		this.aluno2 = new Aluno("Pedro", 321, "EE");
		this.aluno3 = new Aluno("LuiggyFake", 123, "CCC");
	}
	/**
	 * Testa o toString() do Aluno.
	 */
	@Test
	public void testToString() {
		assertEquals("321 - Pedro - EE", aluno2.toString());
	}
	/**
	 * Testa o caso true do Equals do Aluno.
	 */
	@Test
	public void testEqualsTrue() {
		assertEquals(true, aluno1.equals(aluno3));
	}
	/**
	 * Testa o caso false do Equals do Aluno.
	 */
	@Test
	public void testEqualsFalse() {
		assertEquals(false, aluno1.equals(aluno2));
	}
	/**
	 * Testa a cricacao de um aluno com o nome nulo como parametro esperando um NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNull() {
		Aluno a = new Aluno(null, 123, "ccc");
 	}
	/**
	 * Testa a cricacao de um aluno com o curso nulo como parametro esperando um NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testCursoNull() {
		Aluno a = new Aluno("Luiggy", 123, null);
 	}

}
