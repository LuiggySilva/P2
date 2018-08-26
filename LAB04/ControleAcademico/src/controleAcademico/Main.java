package controleAcademico;

import java.util.Scanner;
/**
 * Classe Principal  onde e trabalhado entrada e saida do programa que representa um controle academico onde e 
 * possivel cadastrar alunos e grupos, colocar alunos em grupos e registrar alunos que reponderam atividades.
 * @author LUIGGY SILVA
 *
 */
class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ControleDeGruposAlunos controle = new ControleDeGruposAlunos();
		boolean sair = false;
		
		while(!sair) {
			System.out.println("\n(C)adastrar Aluno");
			System.out.println("(E)xibir Aluno");
			System.out.println("(N)ovo Grupo");
			System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
			System.out.println("(R)egistrar Aluno que Respondeu");
			System.out.println("(I)mprimir Alunos que Responderam");
			System.out.println("(O)ra, vamos fechar o programa!");
			System.out.print("\nOpcão > ");
			String opcao = entrada.nextLine();
			
			switch(opcao) {
				case "C":
					try {	
						System.out.print("\nMatrícula: ");
						String matricula = entrada.nextLine();
						if(verificaMatriculaInvalida(matricula)) {
							throw new IllegalArgumentException("MATRICULA INVALIDA");
						}
						System.out.print("Nome: ");
						String nome = entrada.nextLine();
						if(verificaEntradaInvalida(nome)) {
							throw new IllegalArgumentException("NOME INVALIDO");
						}
						System.out.print("Curso: ");
						String curso = entrada.nextLine();
						if(verificaEntradaInvalida(curso)) {
							throw new IllegalArgumentException("CURSO INVALIDO");
						}
						if(!controle.cadastraAluno(nome, Integer.parseInt(matricula), curso)) {
							System.out.println("MATRICULA JA CADASTRADA!");
						}
						else {
							System.out.println("CADASTRO REALIZADO!");	
						}
					}
					catch(IllegalArgumentException e) {
						System.out.println(e);
					}
					break;
					
				case "E":
					try {
						System.out.print("\nMatrícula: ");
						String mat = entrada.nextLine();
						if(verificaMatriculaInvalida(mat)) {
							throw new IllegalArgumentException("MATRICULA INVALIDA");
						}
						if(controle.exibeAluno(Integer.parseInt(mat)).equals("")) {
							System.out.println("Aluno não cadastrado.");
						}
						else {
							System.out.println("Aluno: " + controle.exibeAluno(Integer.parseInt(mat)));
						}
					}
					catch(IllegalArgumentException e) {
						System.out.println(e);
					}
					break;
					
				case "N":
					try {
						System.out.print("Grupo: ");
						String grupo = entrada.nextLine();
						if(verificaEntradaInvalida(grupo)){
							throw new IllegalArgumentException("GRUPO INVALIDO");
						} 
						if(!controle.cadastraGrupo(grupo)) {
							System.out.println("GRUPO JA CADASTRADO!");
						}
						else {
							System.out.println("CADASTRO REALIZADO!");
						}
					}
					catch(IllegalArgumentException e) {
						System.out.println(e);
					}
					break;
					
				case "A":
					try {
						System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
						String op = entrada.nextLine();
						if(op.equals("A")) {
							System.out.print("Matrícula: ");
							String m = entrada.nextLine();
							if(verificaMatriculaInvalida(m)) {
								throw new IllegalArgumentException("MATRICULA INVALIDA");
							}
							System.out.print("Grupo: ");
							String g = entrada.nextLine();
							if(verificaEntradaInvalida(g)) {
								throw new IllegalArgumentException("GRUPO INVALIDO");
							}
							System.out.println(controle.alocaAlunoEmGrupo(Integer.parseInt(m), g));
						}
						else if(op.equals("I")) {
							System.out.print("Grupo: ");
							String n = entrada.nextLine();
							if(verificaEntradaInvalida(n)) {
								throw new IllegalArgumentException("GRUPO INVALIDO");
							}
							System.out.println(controle.imprimiGrupos(n));
						}
						else {
							System.out.println("OPÇÃO INVALIDA!");
						}
					}
					catch(IllegalArgumentException e) {
						System.out.println(e);
					}
					break;
					
				case "R":
					try {
						System.out.print("\nMatrícula: ");
						String ma = entrada.nextLine();
						if(verificaMatriculaInvalida(ma)) {
							throw new IllegalArgumentException("MATRICULA INVALIDA");
						}
						if(!controle.registraAlunoRespondeu(Integer.parseInt(ma))) {
							System.out.println("Aluno não cadastrado.");
						}
						else {
							System.out.println("ALUNO REGISTRADO!");
						}
					}
					catch(IllegalArgumentException e) {
						System.out.println(e);
					}
					break;
					
				case "I":
					System.out.println("\nAlunos: \n" + controle.imprimiAlunosResponderam());
					break;
					
				case "O":
					sair = true;
					break;
					
				default:
					System.out.println("OPCAO INVALIDA!");
					break;
				}
		}
		entrada.close();
	}
	/**
	 * Metodo que verifica se uma String e invalida.
	 * @param entrada a string que vai ser testada.
	 * @return true se a string e vazia ou composta so de espacos ou false se nao.
	 */
	private static boolean verificaEntradaInvalida(String entrada) {
		if(entrada.trim().equals("")) {
			return true;
		}
		return false;
	}
	/**
	 * Metodo que verifica se uma String matricula e invalida.
	 * @param matricula e a string que vai ser testada.
	 * @return true se a matricula nao conter apenas inteiros ou false se nao.
	 */
	private static boolean verificaMatriculaInvalida(String matricula) {
		try {
			Integer.parseInt(matricula);
		}
		catch(NumberFormatException e) {
			return true;
		}
		return false;
	}
	
}
