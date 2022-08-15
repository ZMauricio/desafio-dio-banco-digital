package principal;

public class Cliente {
	private static int SEQUENCIAL = 0;
	private String nome;
	private int codigo;
	
	public Cliente() {
		this.codigo = SEQUENCIAL++;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
