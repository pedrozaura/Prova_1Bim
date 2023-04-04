import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        // Modo de seleção de escolha.
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Listar contas");
            System.out.println("6 - Calcular saldo total");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do proprietário:");
                    String nome = scanner.next();
                    banco.criarConta(nome);
                    break;
                case 2:
                    System.out.println("Digite o número da conta:");
                    int numeroConta = scanner.nextInt();
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    banco.depositar(numeroConta, valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o número da conta:");
                    int numeroConta2 = scanner.nextInt();
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    banco.sacar(numeroConta2, valorSaque);
                    break;
                case 4:
                    System.out.println("Digite o número da conta de origem:");
                    int numeroContaOrigem = scanner.nextInt();
                    System.out.println("Digite o número da conta de destino:");
                    int numeroContaDestino = scanner.nextInt();
                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = scanner.nextDouble();
                    banco.transferir(numeroContaOrigem, numeroContaDestino, valorTransferencia);
                    break;
                case 5:
                    banco.listarContas();
                    break;
                case 6:
                    double saldoTotal = banco.calcularSaldoTotal();
                    System.out.println("Saldo total: " + saldoTotal);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}