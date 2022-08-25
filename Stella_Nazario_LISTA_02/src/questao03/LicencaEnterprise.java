package questao03;

import java.time.LocalDateTime;

public class LicencaEnterprise extends Receita{

	private int totalContas;

	public LicencaEnterprise(LocalDateTime data, String descricao, int totalContas) {
		super(data, descricao);
		this.totalContas =totalContas;
	}

	public int getTotalContas() {
		return totalContas;
	}

	@Override
	public double calcularTotal() {		
		return this.totalContas*150;
	}
	
	@Override
	public String toString() {
		return "[" + super.getData() + "] Receita com Licença Enterprise: R$ " + this.calcularTotal();
	}
}
