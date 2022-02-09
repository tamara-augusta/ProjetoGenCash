package console;

import java.util.Scanner;

import ProjetoGenCash.PessoaFisica;
import ProjetoGenCash.PessoaMock;

public class Programa {

	public static void main(String[] args) {
		try {
			PessoaFisica pj = PessoaMock.getPessoaJuridica();
			PessoaFisica pf = PessoaMock.getPessoaFisica();

			Scanner sc = new Scanner(System.in);
			int opcao, agencia, conta, senha;
			double valorDeposito = 0, valorSaque = 0;

			System.out.println(".......... BEM VINDO AO GENCASH! .......... ");
			System.out.println("\n\nEscolha o tipo de ocupação: ");
			System.out.println("1. Pessoa Física");
			System.out.println("2. Pessoa Jurídica");
			System.out.println("3. Mais informações");
			System.out.print("\nOpção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			// MENU PF
			case 1:

				System.out.print("\nInsira sua agência: ");
				agencia = sc.nextInt();

				System.out.print("Insira sua conta: ");
				conta = sc.nextInt();

				System.out.print("Insira sua senha: ");
				senha = sc.nextInt();

				if (pf.verificarConta(agencia, conta, senha) == true) {

					do {
						System.out.println("\n\n        BEM VINDO !!!\n\n" + pf.getNome() + "\n" + pf.getDocumento());
						System.out.println("\n.......... MENU ........... ");
						System.out.println("1- Verificar Saldo");
						System.out.println("2- Depósito");
						System.out.println("3- Saque");
						System.out.println("4- Mostrar dados");
						System.out.println("5- Sair");
						System.out.print("Escolha uma operação : ");
						opcao = sc.nextInt();

						switch (opcao) {
						case 1:
							System.out.println("Saldo atual: " + pf.getSaldo());

							break;

						case 2:
							System.out.print("Digite a quantia para deposito: ");
							valorDeposito = sc.nextDouble();

							pf.realizarDeposito(valorDeposito);
							System.out.println("\n");
							break;

						case 3:
							System.out.print("Digite a quantia para saque: ");
							valorSaque = sc.nextDouble();

							pf.sacarDinheiro(valorSaque);
							System.out.println("\n");
							break;

						case 4:
							System.out.println(pf.mostrarDados());
							break;

						case 5:
							System.out.println("Sessão Finalizada. Fenchando o aplicativo...\n");
							System.exit(0);
							break;

						}

					} while (opcao != 4);

				}
				break;

			// MENU PJ
			case 2:

				System.out.print("\nInsira sua agência: ");
				agencia = sc.nextInt();

				System.out.print("Insira sua conta: ");
				conta = sc.nextInt();

				System.out.print("Insira sua senha: ");
				senha = sc.nextInt();

				if (pj.verificarConta(agencia, conta, senha) == true) {

					do {
						System.out.println("\n\n        BEM VINDO !!!\n\n" + pj.getNome() + "\n" + pj.getDocumento());
						System.out.println("\n.......... MENU ........... ");
						System.out.println("1- Verificar Saldo");
						System.out.println("2- Depósito");
						System.out.println("3- Saque");
						System.out.println("4- Pagar salario");
						System.out.println("5- Mostrar dados");
						System.out.println("6- Sair");

						opcao = sc.nextInt();

						switch (opcao) {
						case 1:
							System.out.println("Saldo atual: " + pj.getSaldo());
							System.out.println("\n");
							break;

						case 2:
							System.out.print("Digite a quantia para deposito: ");
							valorDeposito = sc.nextDouble();

							pf.realizarDeposito(valorDeposito);
							System.out.println("\n");
							break;

						case 3:
							System.out.print("Digite a quantia para saque: ");
							valorSaque = sc.nextDouble();

							pj.sacarDinheiro(valorSaque);
							System.out.println("\n");
							break;

						case 4:
							pj.realizarDeposito(pj.sacarDinheiro(5000));
							System.out.println("Transferido R$5.000,00 para " + pf.getNome());
							break;
						case 5:
							System.out.println(pj.mostrarDados());
							break;
						case 6:
							System.out.println("Sessão Finalizada. Fenchando o aplicativo...\n");
							System.exit(0);
							break;
						}

					} while (opcao != 4);

				}
				break;

			// MAIS INFORMACOES

			case 3:

				System.out.println("\nSobre\n-----------------------------");
				System.out.println(
						"O GenCash é um serviço para bancos e instituições financeiras, que \npermite que o usuário (cliente do banco) acesse seu saldo bancário e \nsaque dinheiro. Além disso, a aplicação também permite ao usuário \nacesso à serviços como empréstimo, financiamento e assessoria de \ninvestimento.");

				System.out.println("\n\nComo utilizar o GenCash?\n-----------------------------");
				System.out.println(
						"1. Na tela de boas-vindas, onde há o primeiro menu, insira '1' caso seja um \ncliente Pessoa Física, baseado apenas em CPF e '2' caso seja um cliente \nPessoa Jurídica, baseado em CPF e CNPJ. Para mais informações, \ndocumentação, tutorial e contato com desenvolvedores, insira '3'.");
				System.out.println(
						"\n2. Após informar o tipo de cliente, efetue o login com suas devidas \ncredenciais (número de agência, conta e senha). Se as informações forem \ncorretas e representarem um usuário cadastrado no sistema, o login será \nefetuado com sucesso. Caso contrário, o programa informa que há \ninformações de acesso erradas e encerra.");
				System.out.println(
						"\n3. Após a identificação do usuário, o segundo menu é mostrado. Insira '1' \npara verificar saldo; '2' para realizar um \ndepósito; '3' para realizar um saque, '4' para acessar o menu de serviços e '5' para sair.");

				System.out.println("\n\nContatos & Licenças\n-----------------------------");
				System.out.println(
						"O GenCash é um programa de código aberto, desenvolvido em Java, \npelos alunos do grupo __, da turma 45, da Generation Brasil, entre \n01/02/22 e 04/02/22.");
				System.out.println(
						"Para dúvidas, críticas, sugestões e contatos gerais, por favor, procure os \ndesenvolvedores por e-mail.");

				System.out.println(
						"\nGuilherme M. Petry (petr078@gmail.com)\nHenrique Mendes (riquesmendes@gmail.com)\nLuciana Soares (lucianat.s@hotmail.com)");
				System.out.println(
						"Gaby Federmann (gabyfederman@gmail.com)\nSamuel Santos (lesmak.ss@gmail.com);\nJeferson Aristaque (jeferson.aristaque@gmail.com)\nTamara Augusta (tamara-augusta@hotmail.com)");
				System.out.println("\n");

				break;

			default:
				System.out.println("Operação inválida.");
			}

		} catch (Exception e) {
			System.out.println("ERRO - Sistema será fechado.");
			System.out.println("ERRO"+e);
		}
	}
}