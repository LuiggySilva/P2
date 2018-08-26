package lab03LuiggySilva;

import java.util.Arrays;

/**
 *Classe Agenda e onde os contatos sao armazenados e gerenciados.
 * @author luiggyfds
 */
public class Agenda {

	private Contato[] contatos;

	public Agenda() {
		this.contatos = new Contato[100];
	}
	/**
	 * Adiciona o novo contato na lista.
	 * @param posicao é a posicao do contato no array.
	 * @param nome é o nome do contato.
	 * @param sobrenome é o sobrenome do contato.
	 * @param telefoneCelular é o numero do celular do contato. 
	 * @param telefoneTrabalho é o numero de trabalho do contato.
	 * @param telefoneCasa é o numero da casa do contato.
	 * @param nivelAmizade é o nivel de amizade do contato.
	 */
	public void adicionaContato(int posicao, String nome, String sobrenome, String telefoneCelular,
			String telefoneTrabalho, String telefoneCasa, int nivelAmizade) {
		this.contatos[posicao - 1] = new Contato(posicao, nome, sobrenome, telefoneCelular, telefoneTrabalho,
				telefoneCasa, nivelAmizade);
	}
	/**
	 * Metodo para listar todos contatos cadastrados.
	 * @return uma string com posicao e nome completo dos contatos cadastrados.
	 */
	public String listaDeContatos() {
		String saida = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null && i < ateOndeVou()) {
				saida += (i + 1) + " - " + contatos[i].getNomeCompleto() + System.lineSeparator();
			}
			if (contatos[i] != null && i == ateOndeVou()) {
				saida += (i + 1) + " - " + contatos[i].getNomeCompleto();
				break;
			}
		}
		return saida;
	}
	/**
	 * Metodo para listar todos os contatos cadastrados filtrando os mesmos pelo seu nivel de amizade e tambem retorna a quantidade de contatos com determinado nivel na agenda.
	 * @param nivel e o nivel dos contatos que seram exibidos na lista.
	 * @return retorna um array de string de tamanho 2 com todos contatos com o nivel que foi pedido na primeira posicao e na segunda a quantidade de contatos com esse nivel.
	 */
	public String[] listaDeContatosPorAmizade(int nivel) {
		String listaContatosPorAmizade = "";
		String[] saida = new String[2];
		boolean saidaAdequada = false;
		int qtdNivel = 0;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null && contatos[i].getNivelAmizade() == nivel && i < ateOndeVouPorNivel(nivel)) {
				listaContatosPorAmizade += (i + 1) + " - " + contatos[i].getNomeCompleto() + System.lineSeparator();
				saidaAdequada = true;
				qtdNivel += 1;
			}
			if (contatos[i] != null && contatos[i].getNivelAmizade() == nivel && i == ateOndeVouPorNivel(nivel)) {
				listaContatosPorAmizade += (i + 1) + " - " + contatos[i].getNomeCompleto();
				saidaAdequada = true;
				qtdNivel += 1;
				break;
			}
		}
		if (saidaAdequada) {
			saida[0] = listaContatosPorAmizade;
			saida[1] = Integer.toString(qtdNivel);
			return saida;
		}
		saida[0] = "NAO EXISTE UM AMIGO COM ESSE NIVEL DE AMIZADE";
		saida[1] = "0";
		return saida;
	}
	/**
	 * Metodo procura um contato cadastrado pelo seu nome.
	 * @param procura e o nome do contato a ser procurado.
	 * @return retorna todas as informacao(s) do contato(s).
	 */
	public String exibeContatoNome(String procura) {
		procura = procura.trim();
		String saida = "";
		boolean naoEhOPrimeiro = false;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (procura.split(" ").length > 1) {
					if (procura.equals(contatos[i].getNomeCompleto()) || procura.equals(contatos[i].getNome() + " " + contatos[i].getSobrenome())) {
						saida += contatos[i].toString();
						break;
					}
				} else if (!naoEhOPrimeiro && procura.equals(contatos[i].getNome()) && i < ateOndeVou()) {
					saida += contatos[i].toString() + System.lineSeparator();
					naoEhOPrimeiro = true;
				} else if (naoEhOPrimeiro) {
					saida += "\n" + contatos[i].toString();
				}
			}
		}

		if (saida.length() != 0) {
			return saida;
		} else {
			return "NÃO EXISTE CONTATO COM ESSE NOME!";
		}
	}
	/**
	 * Metodo para procurar um contato cadastrado por um dos seus numeros.
	 * @param numero e o numero do contato para ser encontrado.
	 * @return retorna todas as informacoes do contato.
	 */
	public String exibeContatoNum(String numero) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (numero.equals(contatos[i].getTelefoneCelular())) {
					return contatos[i].toString();
				} else if (numero.equals(contatos[i].getTelefoneCasa())) {
					return contatos[i].toString();
				} else if (numero.equals(contatos[i].getTelefoneTrabalho())) {
					return contatos[i].toString();
				}
			}
		}
		return "NAO EXISTE CONTATO COM ESSE NUMERO!";
	}
	/**
	 * Metodo para procurar um contato cadastrado pela sua posicao no array.
	 * @param posicao e a posicao do contato para ser encontrada.
	 * @return	retorna todas as informacoes do contato.
	 */
	public String exibeContatoPos(int posicao) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getPosicao() == posicao) {
					return contatos[i].toString();
				}
			}
		}
		return "NAO EXISTE CONTATO NESSA POSICAO!";
	}
	/**
	 * Metodo que calcula a media de amizade de todos contatos da agenda.
	 * @return retorna a media.
	 */
	public String mediaAmizade() {
		double soma = 0;
		int cont = 0;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				soma += contatos[i].getNivelAmizade();
				cont += 1;
			}
		}
		double media = 0.0;
		if (cont != 0) {
			media = soma / cont;
		}
		return "Media de amizade -> " + media;
	}
	/**
	 * Metodo para retornar o ultimo indice de um contato nao nulo no array. 
	 * @return retorna o indice do ultimo contato nao nulo.
	 */
	private int ateOndeVou() {
		int ateOndeVou = 0;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				ateOndeVou = i;
			}
		}
		return ateOndeVou;
	}
	/**
	 * Metodo para retornar o ultimo indice de um contato pelo nivel determinado nao nulo no array.
	 * @return retorna o indice do ultimo contato pelo indice determinado nao nulo.
	 */
	private int ateOndeVouPorNivel(int nivel) {
		int ateOndeVouPorNivel = 0;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null && contatos[i].getNivelAmizade() == nivel) {
				ateOndeVouPorNivel = i;
			}
		}
		return ateOndeVouPorNivel;
	}
	

}
