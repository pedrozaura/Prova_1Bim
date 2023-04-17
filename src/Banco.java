import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void criarConta(String nomeProprietario) {
        Pessoa proprietario = new Pessoa(nomeProprietario);
        Conta conta = new Conta(proprietario, contas.size() + 1);
        contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " criada para " + nomeProprietario + ".");
    }

    public void depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        conta.depositar(valor);
        System.out.println("Depositados " + valor + " reais na conta " + numeroConta + ".");
    }

    public void sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        conta.sacar(valor);
        System.out.println("Sacados " + valor + " reais da conta " + numeroConta + ".");
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = buscarConta(numeroContaOrigem);
        Conta contaDestino = buscarConta(numeroContaDestino);
        contaOrigem.transferir(valor, contaDestino);
        System.out.println("Transferidos " + valor + " reais da conta " + numeroContaOrigem + " para a conta "
                + numeroContaDestino + ".");
    }

    public double calcularSaldoTotal() {
        double saldoTotal = 0;
        for (Conta conta : contas) {
            saldoTotal += conta.getSaldo();
        }
        return saldoTotal;
    }

    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println(conta.toString());
        }
    }

    private Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        throw new RuntimeException("Conta não encontrada.");
    }
}