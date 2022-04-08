
public class Universitario {
	private String nome;
	private String cpf;
	private String entidadeEnsino;
	private double valorBolsa;
	private int ano;
	
	public Universitario(String nome, String Cpf, String entidadeEnsino, double valorBolsa, int ano) {
		this.nome = nome;
		cpf = Cpf;
		this.entidadeEnsino = entidadeEnsino;
		this.valorBolsa = valorBolsa;
		this.ano = ano;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String Cpf) {
		cpf = Cpf;
	}
	public String getEntidadeEnsino() {
		return entidadeEnsino;
	}
	public void setEntidadeEnsino(String entidadeEnsino) {
		this.entidadeEnsino = entidadeEnsino;
	}
	public double getValorBolsa() {
		return valorBolsa;
	}
	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return this.nome + ", " + this.cpf + ", " + this.entidadeEnsino + ", R$" + this.valorBolsa;
	}
}
