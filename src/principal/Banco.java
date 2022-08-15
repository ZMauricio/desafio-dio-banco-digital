package principal;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contas;
	
	public Banco() {
		contas = new ArrayList<Conta>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void criarConta(Cliente cliente, boolean tipo) {
		if (tipo) 
		 this.contas.add( new ContaCorrente(cliente) );
		else 
			this.contas.add( new ContaPoupanca(cliente) );
	}
	
	public Conta getConta(String nome) {
		Conta conta = null;
		
		for(Conta obj : this.contas) {
			if ( obj.getCliente().getNome().equals(nome) ) {
				conta = obj;
				break;
			}
		}
		
		return conta;
	}
	
	public void gerarRelatorioContas() {
		for(Conta obj: this.contas)
			obj.imprimirExtrato();
	}
}
