package questao02;

import java.time.LocalDate;

public class Cliente extends Pessoa{
	
	private long codigo;

	public Cliente(String nome, LocalDate dataNascimento, long codigo) {
		super(nome, dataNascimento);
		this.codigo = codigo;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		
		return "Código: " + this.codigo + ", Nome: " + 
				super.getNome() + ", Data de nascimento: " + 
				super.getDataNascimento();
	}

	public boolean equals(Pessoa pessoa) {
		
		if (pessoa instanceof Cliente) {
			Cliente qualquer = (Cliente) pessoa;
			return super.getNome().equals(qualquer.getNome()) && super.getDataNascimento().equals(qualquer.getDataNascimento()) &&
					this.codigo == qualquer.codigo;
		} else {
			return false;
		}
	}

}
