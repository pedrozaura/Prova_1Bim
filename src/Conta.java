import java.util.ArrayList;
import java.util.List;

class Conta {
    private int numero;
    private Pessoa proprietario;
    private double saldo;
    private List<String> movimentacoes;

    public Conta(Pessoa proprietario, int numero) {
        this.numero = numero;
        this.proprietario = proprietario;
        this.saldo = 0;
        this.movimentacoes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        movimentacoes.add("Depositou " + valor + " reais.");
    }

    public void sacar(double valor) {
        saldo -= valor;
        movimentacoes.add("Sacou " + valor + " reais.");
    }

    public void transferir(double valor, Conta destino) {
        saldo -= valor;
        destino.saldo += valor;
        movimentacoes.add("Transferiu " + valor + " reais para a conta " + destino.getNumero() + ".");
        destino.movimentacoes
                .add("Recebeu uma transferência de " + valor + " reais da conta " + this.getNumero() + ".");
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta " + this.numero + ":");
        for (String movimentacao : movimentacoes) {
            System.out.println(movimentacao);
        }
    }
}
