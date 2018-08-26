package lab03LuiggySilva;
/**
 * Classe Contato e onde o contato e criado com todos seus atributos.
 * @author luiggyfds
 */
public class Contato {
	private int posicao;
	private String nome;
	private String sobrenome;
	private String telefoneTrabalho;
	private String telefoneCelular;
	private String telefoneCasa;
	private int nivelAmizade;
	private String tipoAmizade;
	private int contatosAdicionados;
	/**
	 * Controi o contato apartir de sua posicao, nome, sobrenome, numero do celular, trabalho, casa e seu nivel de amizade.
	 * @param posicao e posicao do contato no array.
	 * @param nome e o nome do contato.
	 * @param sobrenome e o sobrenome do contato.
	 * @param telefoneCelular e o numero do celular do contato.
	 * @param telefoneTrabalho e o numero de trabalho do contato.
	 * @param telefoneCasa e o numero da casa do contato.
	 * @param nivelAmizade e o nivel de amizade do contato.
	 */
	public Contato(int posicao, String nome, String sobrenome, String telefoneCelular, String telefoneTrabalho, String telefoneCasa, int nivelAmizade) {
		if (nome == null || sobrenome == null || telefoneCelular == null || telefoneTrabalho == null || telefoneCasa == null) {
			throw new NullPointerException("INFORMACAO NULA NO CADASTRO!");
		}

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefoneCelular = telefoneCelular;
		this.telefoneTrabalho = telefoneTrabalho;
		this.telefoneCasa = telefoneCasa;
		this.nivelAmizade = nivelAmizade;
		this.posicao = posicao;
		this.tipoAmizade = verificaAmizade(nivelAmizade);
		this.contatosAdicionados += 1;
	}
	/**
	 * Metodo que verifica o nivel de amizade para lhe atribuir um tipo.
	 * @param nivelAmizade e o nivel de amizade do contato.
	 * @return retorna o tipo de amizade do contato que pode ser Distante, Colega, Amigo, Amigao ou Irmao.
	 */
	private String verificaAmizade(int nivelAmizade) {
		if (nivelAmizade == 1) {
			return "Distante";
		} else if (nivelAmizade == 2) {
			return "Colega";
		} else if (nivelAmizade == 3) {
			return "Amigo";
		} else if (nivelAmizade == 4) {
			return "Amigão";
		} else if (nivelAmizade == 5) {
			return "Irmão";
		}
		return "INDEFINIDO";
	}
	/**
	 * Metodo que retorna o nome do contato.
	 * @return retorna uma string com o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Metodo que retorna o sobrenome do contato.
	 * @return retorna uma string com o sobernome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	/**
	 * Metodo que retorna o nome completo do contato.
	 * @return retorna uma string com nome e sobrenome do contato.
	 */
	public String getNomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}
	/**
	 * Metodo que retorna o numero da casa do contato.
	 * @return retrorna uma string com o numero da casa do contato.
	 */
	public String getTelefoneCasa() {
		return this.telefoneCasa;
	}
	/**
	 * Metodo que retorna o numero do celular do contato.
	 * @return retorna uma string com o numero do celular do contato.
	 */
	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}
	/**
	 * Metodo que retorna o numero do trabalho do contato.
	 * @return retorna uma string com o numero do trabalho do contato.
	 */
	public String getTelefoneTrabalho() {
		return this.telefoneTrabalho;
	}
	/**
	 * Metodo que retorna todos os numeros do contatos.
	 * @return retorna uma string com todos numeros do contato.
	 */
	public String getTelefones() {
		return "Telefone Celular -> " + this.telefoneCelular + "\nTelefone Trabalho -> " + this.telefoneTrabalho + "\nTelefone Casa -> " + this.telefoneCasa;
	}
	/**
	 * Metodo que retorna o tipo de amizade do contato.
	 * @return retorna uma string com o tipo de amizade do contato.
	 */
	public String getTipoAmizade() {
		return "Nivel de Amizade -> " + this.tipoAmizade;
	}
	/**
	 * Metodo que retorna o nivel de amizade do contato.
	 * @return retorna um inteiro
	 */
	public int getNivelAmizade() {
		return this.nivelAmizade;
	}
	/**
	 * Metodo que retorna a quantidade de contatos adicionados no array.
	 * @return retorna um inteiro que representa a quantidade de contatos cadastrados.
	 */
	public int getContatosAdicionados() {
		return this.contatosAdicionados;
	}
	/**
	 * Metodo que retorna a posicao do contato no array.
	 * @return retorna um inteiro que representa a posicao do contato no array.
	 */
	public int getPosicao() {
		return this.posicao;
	}
	/**Metodo que concatena todas informacoes do contato.
	 * @return String com todas informacoes do contato.
	 */
	public String toString() {
		return getNomeCompleto() + "\n" + getTelefones() + "\n" + getTipoAmizade();
	}
}
