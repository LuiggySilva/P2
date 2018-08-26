package lab03LuiggySilva;

import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Classe principal que representa uma agenda de contatos. Onde cada contato tem nome, sobrenome, numeros de contato e nivel de amizade.
 * O Programa permite cadastrar, listar, exibir e mostrar a media de amizade dos contatos.
 * @author luiggyfds
 */
public class lab03LuiggySilva {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Agenda Agenda = new Agenda();

		boolean controle = true;
		while (controle) {
			System.out.println("\n(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(M)edia de Amizade");
			System.out.println("(S)air\n");

			System.out.print("Opcao > ");
			String opcao = entrada.next();
			if (opcao.equals("C")) {
				System.out.print("\nPosicao: ");
				int posicao = entrada.nextInt();

				System.out.print("Nome: ");
				String nome = entrada.nextLine();
				nome = entrada.nextLine();
				if (verificaEntradaInvalida(nome)) {
					throw new IllegalArgumentException("NOME INVALIDO");
				}

				System.out.print("Sobrenome: ");
				String sobrenome = entrada.nextLine();
				if (verificaEntradaInvalida(sobrenome)) {
					throw new IllegalArgumentException("SOBRENOME INVALIDO");
				}
				
				System.out.println("\nFORMATO DO NÚMERO DO CELULAR - > +00 (00) 00000-0000\n");
				
				System.out.print("Numero do Celular: ");
				String telefoneCelular = entrada.nextLine();
				if (verificaEntradaInvalida(telefoneCelular)) {
					throw new IllegalArgumentException("NUMERO CELULAR INVALIDO");
				}

				System.out.print("Numero do Trabalho: ");
				String telefoneTrabalho = entrada.nextLine();
				if (verificaEntradaInvalida(telefoneTrabalho)) {
					throw new IllegalArgumentException("NUMERO TRABALHO INVALIDO");
				}

				System.out.print("Numero da Casa: ");
				String telefoneCasa = entrada.nextLine();
				if (verificaEntradaInvalida(telefoneCasa)) {
					throw new IllegalArgumentException("NUMERO CASA INVALIDO");
				}

				System.out.print("Nivel de Amizade (1 A 5): ");
				int nivelAmizade = entrada.nextInt();

				if (posicao < 1 || posicao > 100) {
					System.out.println("POSICAO INVALIDA!");
				}else if(verificaNumeroInvalido(telefoneCasa) || verificaNumeroInvalido(telefoneTrabalho) || verificaNumeroInvalido(telefoneCelular)){
					System.out.println("FORMATO DE NUMERO INVALIDO!");
				} else if (nivelAmizade < 1 || nivelAmizade > 5) {
					System.out.println("NIVEL DE AMIZADE INVALIDO! (1 À 5)");
				} else {
					Agenda.adicionaContato(posicao, nome, sobrenome, telefoneCelular, telefoneTrabalho, telefoneCasa, nivelAmizade);
					System.out.println("CADASTRO REALIZADO!");
				}
			}

			else if (opcao.equals("L")) {
				System.out.print("Listar por nivel de Amizade (\"S\" para Sim ou \"N\" para Nao): ");
				String escolha = entrada.nextLine();
				escolha = entrada.nextLine();
				if (escolha.equals("S")) {
					System.out.print("Qual o nivel de amizade? ");
					int nivel = entrada.nextInt();
					if (nivel >= 1 && nivel <= 5) {
						String lista = Agenda.listaDeContatosPorAmizade(nivel)[0];
						System.out.println("Quantidade de contatos com esse nivel -> " +  Agenda.listaDeContatosPorAmizade(nivel)[1]);
						System.out.println("\n" + lista);
					} else {
						System.out.println("NIVEL INVALIDO (1 À 5)");
					}
				} else if (escolha.equals("N")) {
					String lista = Agenda.listaDeContatos();
					System.out.println("\n" + lista);
				} else {
					System.out.println("ESCOLHA INVALIDA!");
				}
			}

			else if (opcao.equals("E")) {
				System.out.print("Por Nome \"N\", Numero \"T\" ou por Posicao \"P\" > ");
				String escolha = entrada.nextLine();
				escolha = entrada.nextLine();
				if (escolha.equals("N")) {
					System.out.print("Digite o nome > ");
					String texto = entrada.nextLine();
					System.out.println("\n" + Agenda.exibeContatoNome(texto));
				} else if (escolha.equals("P")) {
					System.out.print("Digite a posicao > ");
					int pos = entrada.nextInt();
					System.out.println("\n" + Agenda.exibeContatoPos(pos));
				} else if (escolha.equals("T")) {
					System.out.print("Digite o numero > ");
					String numero = entrada.nextLine();
					System.out.println("\n" + Agenda.exibeContatoNum(numero));
				} else {
					System.out.println("ESCOLHA INVALIDA");
				}
			}

			else if (opcao.equals("M")) {
				System.out.println(Agenda.mediaAmizade());
			}

			else if (opcao.equals("S")) {
				controle = false;
			}

			else {
				System.out.println("OPCAO INVALIDA!");
			}
		}
		entrada.close();
	}
	/**
	 * Metodo que recebe uma string e verifica se ela e vazia ou so composta por espacos.
	 * @param entrada a string para ser testada.
	 * @return true se a entrada for invalia e false se nao for invalida.
	 */
	private static boolean verificaEntradaInvalida(String entrada) {
		if (entrada.trim().equals("")) {
			return true;
		}
		return false;
	}
	/**
	 * Metodo que verifica se o formato dos numeros estao corretos.
	 * @param numero e o numero que vai ser testado.
	 * @return true se for inalido e false se nao for invalido.
	 */
	private static boolean verificaNumeroInvalido(String numero) {
    	if(!numero.matches("\\+\\d\\d\\s\\(\\d\\d\\)\\s\\d\\d\\d\\d\\d-\\d\\d\\d\\d")) {
    		return true;
    	}
    	return false;
	}
}
