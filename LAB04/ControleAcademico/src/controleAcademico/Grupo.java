package controleAcademico;

import java.util.HashSet;
/**
 * Classe que cria o objeto Grupo.
 * @author LUIGGY SILVA
 *
 */
public class Grupo {
	
	private String nome;
	private HashSet<Aluno> alunosNoGrupo;
	/**
	 * Construtor que constroi o grupo apartir de um nome.
	 * @param nome nome do grupo.
	 */
	public Grupo(String nome) {
		if(nome == null){
			throw new IllegalArgumentException("NOME NULO");
		}
		this.nome = nome;
		this.alunosNoGrupo = new HashSet<Aluno>();
	}
	/**
	 * Metodo que adiciona alunos que estao no grupo.
	 * @param aluno Objeto Aluno que vai ser adicionado no HashSet.
	 */
	public void setAlunosNoGrupo(Aluno aluno) {
		alunosNoGrupo.add(aluno);
	}
	/**
	 * Metodo que retorna uma representacao textual do grupo.
	 * @return uma String com as informacoes dos alunos no grupo.
	 */
	@Override
	public String toString() {
		String saida = "";
		for (Aluno aluno : alunosNoGrupo) {
			saida += "* " +  aluno.toString() + System.lineSeparator();
		}
		return saida.trim();
	}
	/**
	 * Metodo que cria um HashCode para o grupo.
	 * @return o hashcode gerado.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	/**
	 * Metodo que comparar se dois grupos sao iguais.
	 * @return true se os grupos tem a mesma classe e mesmo nome ou false see nao.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		Grupo a = (Grupo) obj;
		if(this.nome.toUpperCase().equals(a.nome.toUpperCase())) {
			return true;
		}
		return false;
	}
}
