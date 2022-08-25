package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
	private String nome;
	private LocalDate dataNascimento;

	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String toString() {
		return "Nome: " + nome + ", Data de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa qualquer = (Pessoa) obj;
			return this.nome.equals(qualquer.nome) && this.dataNascimento.equals(qualquer.dataNascimento);
		} else {
			return false;
		}
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

}
