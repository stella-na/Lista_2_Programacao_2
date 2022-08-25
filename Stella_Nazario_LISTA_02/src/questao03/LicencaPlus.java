package questao03;

import java.time.LocalDateTime;

public class LicencaPlus extends Receita{

	private int totalContas;

	public LicencaPlus(LocalDateTime data, String descricao, int totalContas) {
		super(data, descricao);
		this.totalContas =totalContas;
	}

	public int getTotalContas() {
		return totalContas;
	}

	@Override
	public double calcularTotal() {
		return this.totalContas*35;
	}
	
	@Override
	public String toString() {
		return "[" + super.getData() + "] Receita com Licença Plus: R$ " + this.calcularTotal();
	}
}
