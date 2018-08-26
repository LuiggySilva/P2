package controleAcademico;

import java.util.HashMap;
/**
 * Classe que armazena e controla as atividades realizadas das classes Grupo e Aluno.
 * @author LUIGGY SILVA
 *
 */
public class ControleDeGruposAlunos {
	
	private HashMap<Integer, Aluno> matriculasEalunos;
	private HashMap<String, Grupo> nomesDosGrupos;
	private RegistroDoProfessor registroDoProfessor;
	/**
	 * Construtor da Classe que inicializa o HashMap de matriculasEalunos e nomedosGrupos e tambem inicializa o RegistroDoProfessor.
	 */
	public ControleDeGruposAlunos() {
		this.matriculasEalunos = new HashMap<Integer, Aluno>();
		this.nomesDosGrupos = new HashMap<String, Grupo>();
		this.registroDoProfessor = new RegistroDoProfessor();
	}
	/**
	 * Metodo que constroi o objeto Aluno apartir de um nome, matricula e curso, e mapeia a matricula para esse objeto Aluno criado.
	 * @param nome e o nome do aluno.
	 * @param matricula e a matricula do aluno.
	 * @param curso e o curso do aluno.
	 * @return true se o cadastro foi concluido com sucesso ou false se a matricula ja existir.
	 */
	public boolean cadastraAluno(String nome, int matricula, String curso) {
		Aluno aluno = new Aluno(nome, matricula, curso);
		if(matriculasEalunos.containsKey(matricula)) {
			return false;
		}
		matriculasEalunos.put(matricula, aluno);
		return true;
	}
	/**
	 * Metodo que constroi objeto Grupo apartir de um nome e mapeia o nome para o objeto Grupo criado.
	 * @param nome e o nome do grupo.
	 * @return true se o cadastro foi concluido com sucesso ou false se ja existir um grupo com esse nome.
	 */
	public boolean cadastraGrupo(String nome) {
		Grupo grupo = new Grupo(nome);	
		if(nomesDosGrupos.containsKey(nome.toUpperCase())) {
			return false;
		}
		nomesDosGrupos.put(nome.toUpperCase(), grupo);
		return true;
	}
	/**
	 * Metodo que exibe uma representacao textual de um aluno apartir de sua matricula.
	 * @param matricula e a matricula do aluno.
	 * @return uma representacao textual do aluno se a matricula dele existir, se nao retorna uma string vazia.
	 */
	public String exibeAluno(int matricula) {
		if(!matriculasEalunos.containsKey(matricula)) {
			return "";
		}
		return matriculasEalunos.get(matricula).toString();
	}
	/**
	 * Metodo que lista todos os alunos que estao em um grupo especifico.
	 * @param grupo e o nome do grupo.
	 * @return uma string com a representacao textual de cada aluno no grupo.
	 */
	public String imprimiGrupos(String grupo) {
		if(!nomesDosGrupos.containsKey(grupo.toUpperCase())) {
			return "Grupo não cadastrado.";
		}
		Grupo g = nomesDosGrupos.get(grupo.toUpperCase());
		return g.toString();
	}
	/**
	 * Metodo que aloca alunos em um grupo apartir de matricula do aluno e do nome do grupo.
	 * @param matricula e a matricula do aluno.
	 * @param grupo e o nome do grupo.
	 * @return uma string com o resultado da opercao, que pode nao ser realizado se o aluno ou o grupo nao estiverem cadastrados.
	 */
	public String alocaAlunoEmGrupo(int matricula, String grupo) {
		if(!matriculasEalunos.containsKey(matricula) && !nomesDosGrupos.containsKey(grupo.toUpperCase())) {
			return "Aluno não cadastrado.\nGrupo não cadastrado.";
		}
		else if(!nomesDosGrupos.containsKey(grupo.toUpperCase())) {
			return "Grupo não cadastrado.";
		}
		else if(!matriculasEalunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		Grupo g = nomesDosGrupos.get(grupo.toUpperCase());
		g.setAlunosNoGrupo(matriculasEalunos.get(matricula));
		return "ALUNO ALOCADO!";
	}
	/**
	 * Metodo que registra um aluno apartir de sua matricula que respondeu no quadro.
	 * @param matricula e a matricula do aluno.
	 * @return true se foi registrado com sucesso ou false se a matricula nao existir.
	 */
	public boolean registraAlunoRespondeu(int matricula) {
		if(!matriculasEalunos.containsKey(matricula)) {
			return false;
		}
		registroDoProfessor.adicionaResposta(matriculasEalunos.get(matricula));
		return true;
	}
	/**
	 * Metodo que lista todos os alunos que reponderam no quadro na ordem correta.
	 * @return uma string com uma representacao textual dos alunos.
	 */
	public String imprimiAlunosResponderam() {
		return registroDoProfessor.toString();
	}
}
