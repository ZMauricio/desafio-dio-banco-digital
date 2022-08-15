package principal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Banco bancoDIO = new Banco();
		Scanner leitor = new Scanner(System.in);
		
		String nome = "";
		String nomeTransferencia = "";
		double valor = 0;
		int opcao = 0, tipoConta;
		
		
		do {
			System.out.println("=== Bem vindo ao Banco DIO ===");
			System.out.println("Escolha uma das seguintes opções: ");
			System.out.println("1 - Criar conta.\n"+
							   "2 - Fazer depósito.\n"+
							   "3 - Sacar dinheiro.\n"+
							   "4 - Consultar conta.\n"+
							   "5 - Transferir dinheiro entre contas.\n"+
							   "6 - Gerar relatório de todas as contas.\n"+
							   "0 - Sair.\n");
			
			opcao = Integer.parseInt(leitor.nextLine());
			
			switch(opcao) {
				case 1: {
					// criação de conta
					
					System.out.println("=== Criação de conta ===");
					
					System.out.println("Informe o seu nome:");
					nome = leitor.nextLine();
					
					System.out.println("Informe o tipo de conta: \n1 - Conta corrente\n 2 - Conta poupança");
					tipoConta = Integer.parseInt(leitor.nextLine());
					
					Cliente mauricio = new Cliente();
					mauricio.setNome(nome);
					bancoDIO.criarConta(mauricio, (tipoConta == 1)? true : false);
					
					System.out.println("Conta criada com sucesso!");
					break;
				}
				case 2: {
					System.out.println("=== Depósito em conta ===");
					
					System.out.println("Informe o seu nome:");
					nome = leitor.nextLine();
					
					System.out.println("Informe o valor do depósito:");
					valor = Double.parseDouble(leitor.nextLine());
					
					bancoDIO.getConta(nome).depositar(valor);
					
					System.out.println("Depósito realizado com sucesso!");
					break;
				}
				case 3: {
					System.out.println("=== Saque em conta ===");
					
					System.out.println("Informe o seu nome:");
					nome = leitor.nextLine();
					
					System.out.println("Informe o valor do saque:");
					valor = Double.parseDouble(leitor.nextLine());
					
					bancoDIO.getConta(nome).sacar(valor);
					
					System.out.println("Saque realizado com sucesso!");
					break;
				}
				case 4: {
					System.out.println("=== Consultar conta ===");
					
					System.out.println("Informe o seu nome:");
					nome = leitor.nextLine();
					
					bancoDIO.getConta(nome).imprimirExtrato();
					
					break;
				}
				case 5: {
					System.out.println("=== Transferência entre conta ===");
					
					System.out.println("Informe o seu nome:");
					nome = leitor.nextLine();
					
					System.out.println("Informe o nome do cliente que receberá a transferência:");
					nomeTransferencia = leitor.nextLine();
					
					
					System.out.println("Informe o valor da transferência:");
					valor = Double.parseDouble(leitor.nextLine());
					
					bancoDIO.getConta(nome).transferir(valor, bancoDIO.getConta(nomeTransferencia));
					
					System.out.println("Tranferência realizada com sucesso!");
					break;
				}
				case 6: {
					
					bancoDIO.gerarRelatorioContas();
					
					break;
				}
				default: {
					System.out.println("Obrigado e volte sempre! Saindo... ");
					break;
				}
			}
			
		} while(opcao > 0);

		
	}
}
