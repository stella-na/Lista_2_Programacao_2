package questao03;

import java.time.LocalDateTime;

public class LicencaBasica extends Receita{
	
	private int totalContas;

	public LicencaBasica(LocalDateTime data, String descricao, int totalContas) {
		super(data, descricao);
		this.totalContas =totalContas;
	}

	public int getTotalContas() {
		return totalContas;
	}

	@Override
	public double calcularTotal() {		
		return this.totalContas*20;
	}
	
	@Override
	public String toString() {
		return "[" + super.getData() + "] Receita com Licença Básica: R$ " + this.calcularTotal();
	}
	
	
}
