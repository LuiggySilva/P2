package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controleAcademico.ControleDeGruposAlunos;

public class ControleDeGruposAlunosTest {

	private ControleDeGruposAlunos controle;
	
	@Before
	public void testControleDeGruposAlunos() {
		this.controle = new ControleDeGruposAlunos();
	}
	/**
	 * Testa o cadastro de um aluno com sucesso.
	 */
	@Test
	public void testCadastraAluno() {
		assertEquals(true, controle.cadastraAluno("Luiggy", 12345, "CCC"));
	}
	/**
	 * Testa o cadastro de um aluno sem sucesso ja que a matricula ja existe.
	 */
	@Test
	public void testCadastraAlunoJaExistente() {
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		assertEquals(false, controle.cadastraAluno("Luiggy", 12345, "CCC"));
	}
	/**
	 * Testa o cadastro de um grupo com sucesso.
	 */
	@Test
	public void testCadastraGrupo() {
		assertEquals(true, controle.cadastraGrupo("P2"));
	}
	/**
	 * Testa o cadastro de um grupo sem sucesso ja que o grupo ja existe.
	 */
	@Test
	public void testCadastraGrupoJaExistente() {
		controle.cadastraGrupo("P2");
		assertEquals(false, controle.cadastraGrupo("P2"));
	}
	/**
	 * Testa o metodo que exibe o aluno com uma matricula com sucesso.
	 */
	@Test
	public void testExibeAluno() {
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		assertEquals("12345 - Luiggy - CCC", controle.exibeAluno(12345));
	}
	/**
	 * Testa o metodo que exibe o aluno com uma matricula sem sucesso pois a matriula nao existe.
	 */
	@Test
	public void testExibeAlunoNaoExistente() {
		assertEquals("", controle.exibeAluno(12345));
	}
	/**
	 * Testa o Alocamento de um aluno em um grupo apartir de uma matricula e o nome do grupo com sucesso.
	 */
	@Test
	public void testAlocaAlunoEmGrupo() {
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		controle.cadastraGrupo("P2");
		assertEquals("ALUNO ALOCADO!", controle.alocaAlunoEmGrupo(12345, "P2"));
	}
	/**
	 * Testa o Alocamento de um aluno em um grupo apartir de uma matricula e o nome do grupo sem sucesso pois o grupo nao foi cadastrado.
	 */
	
	@Test
	public void testAlocaAlunoEmGrupoNaoExistente() {
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		assertEquals("Grupo não cadastrado.", controle.alocaAlunoEmGrupo(12345, "P2"));
	}
	/**
	 * Testa o Alocamento de um aluno em um grupo apartir de uma matricula e o nome do grupo sem sucesso pois o aluno nao foi cadastrado.
	 */
	@Test
	public void testAlocaAlunoNaoExistenteEmGrupo() {
		controle.cadastraGrupo("P2");
		assertEquals("Aluno não cadastrado.", controle.alocaAlunoEmGrupo(12345, "P2"));
	}
	/**
	 * Testa o Alocamento de um aluno em um grupo apartir de uma matricula e o nome do grupo sem sucesso pois nem o aluno nem o grupo foram cadastrados.
	 */
	@Test
	public void testAlocaAlunoNaoExistenteEmGrupoNaoExistente() {
		assertEquals("Aluno não cadastrado.\nGrupo não cadastrado.", controle.alocaAlunoEmGrupo(12345, "P2"));
	}
	/**
	 * Testa a representacao textual de um grupo com sucesso.
	 */
	@Test
	public void testImprimiGrupos() {
		controle.cadastraGrupo("P2");
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		controle.cadastraAluno("Pedro", 54321, "EE");
		controle.alocaAlunoEmGrupo(12345, "P2");
		controle.alocaAlunoEmGrupo(54321, "P2");
		assertEquals("* 54321 - Pedro - EE" + System.lineSeparator() + "* 12345 - Luiggy - CCC", controle.imprimiGrupos("P2"));
	}
	/**
	 * Testa a representacao textual de um grupo sem sucesso pois o grupo nao existe.
	 */
	@Test
	public void testImprimiGrupoNaoExistente() {
		assertEquals("Grupo não cadastrado.", controle.imprimiGrupos("P2"));
	}
	/**
	 * Testa o Registro de um aluno que respondeu apartir da sua matricula com sucesso.
	 */
	@Test
	public void testRegistraAlunoRespondeu() {
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		assertEquals(true, controle.registraAlunoRespondeu(12345));
	}
	/**
	 * Testa o registro de um aluno que respondeu apartir da sua matricula sem sucesso ja que a matricula nao existe.
	 */
	@Test
	public void testRegistraAlunoNaoExistenteRespondeu() {
		assertEquals(false, controle.registraAlunoRespondeu(12345));
	}
	/**
	 * Testa a representacao textual de todos alunos que responderam.
	 */
	@Test
	public void testImprimiAlunosResponderam() {
		controle.cadastraAluno("Luiggy", 12345, "CCC");
		controle.cadastraAluno("Pedro", 54321, "EE");
		controle.registraAlunoRespondeu(12345);
		controle.registraAlunoRespondeu(54321);
		assertEquals("1. 12345 - Luiggy - CCC" + System.lineSeparator() + "2. 54321 - Pedro - EE", controle.imprimiAlunosResponderam());
	}

}
