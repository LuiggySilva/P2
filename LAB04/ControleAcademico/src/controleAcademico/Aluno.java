package controleAcademico;
/**
 * Classe que cria o objeto Aluno.
 * @author LUIGGY SILVA
 *
 */
public class Aluno {
	
	private String curso;
	private int matricula;
	private String nome;
	/**
	 * Construtor do Aluno que cria o mesmo apartir do nome, matricula e cruso.
	 * @param nome e o nome do aluno.
	 * @param matricula e a matricula do aluno.
	 * @param curso e o curso do aluno.
	 */
	public Aluno(String nome, int matricula, String curso) {
		if(nome == null || curso == null) {
			throw new NullPointerException("NOME OU CURSO NULOS");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	/**
	 * Metodo que cria uma representacao textual do aluno.
	 * @return uma string com as informacoes do aluno.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	/**
	 * Metodo que compara se dois alunos sao iguais.
	 * @return true se os objeto e da classe Aluno e se tem a mesma matricula ou false se nao.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Aluno a = (Aluno) obj;
		if(this.matricula == a.matricula) {
			return true;
		}
		return false;
	}
	/**
	 * Metodo que cria um HashCode para o aluno apartir da matricula do mesmo.
	 * @return o hashcode gerado.
	 */
	@Override
	public int hashCode() {
		return this.matricula * 31;
	}
	
}
