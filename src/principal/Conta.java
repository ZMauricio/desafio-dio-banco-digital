package principal;

public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 0;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0;
		
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		if (this.saldo >= valor)
			this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	protected void imprimirInfosPadrao() {
		System.out.println(String.format("Titular %s - Código %d", cliente.getNome(), cliente.getCodigo()));
		System.out.println(String.format("Agência %d", agencia));
		System.out.println(String.format("Número %d", numero));
		System.out.println(String.format("Saldo %.2f", saldo));
	}
	
	
	
}
