package controleAcademico;

import java.util.ArrayList;
/**
 * Classe que cria o objeto onde ficam armazenados os registros do professor.
 * @author LUIGGY SILVA
 *
 */
public class RegistroDoProfessor {
	
	private ArrayList<Aluno> quemResopondeu;
	/**
	 * Contrutor do RegistroDoProfessor que inicializa o ArrayList de Alunos.
	 */
	public RegistroDoProfessor() {
		this.quemResopondeu = new ArrayList<Aluno>();
	}
	/**
	 * Metodo que adiciona Alunos no ArrayList de Alunos.
	 * @param aluno o aluno que vai ser adicionado.
	 */
	public void adicionaResposta(Aluno aluno) {
		if(aluno == null) {
			throw new NullPointerException("ALUNO NULO");
		}
		quemResopondeu.add(aluno);
	}
	/**
	 * Metodo que cria uma representacao textual do RegistroDoProfessor.
	 * @return uma string ordenada dos alunos que foram adicionados no ArrayList.
	 */
	@Override
	public String toString() {
		String saida = "";
		int cont = 1;
		for (Aluno aluno : quemResopondeu) {
			saida += cont + ". " + aluno.toString() + System.lineSeparator();
			cont += 1;
		}
		return saida.trim();
	}
}
