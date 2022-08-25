package questao03;

import java.time.LocalDateTime;

public abstract class Receita implements Transacao {
	private LocalDateTime data;
	private String descricao;

	public Receita(LocalDateTime data, String descricao) {
		this.data = data;
		this.descricao = descricao;
	}

	@Override
	public String getTipo() {

		return "RECEITA";
	}

	@Override
	public abstract double calcularTotal();

	public LocalDateTime getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return "Receita [data=" + data + ", descricao=" + descricao + "]";
	}
	
	
}
