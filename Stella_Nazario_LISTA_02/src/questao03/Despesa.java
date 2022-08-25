package questao03;

import java.time.LocalDateTime;

public abstract class Despesa implements Transacao{
	private LocalDateTime data;
	private String descricao;
	
	public Despesa(LocalDateTime data, String descricao) {
		this.data = data;
		this.descricao = descricao;
	}

	@Override
	public String getTipo() {
		
		return "DESPESA";
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
		return "Despesa [data=" + data + ", descricao=" + descricao + "]";
	}
	
	
}
