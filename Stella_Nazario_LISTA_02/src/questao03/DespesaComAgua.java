package questao03;

import java.time.LocalDateTime;

public class DespesaComAgua extends Despesa {

	private double totalM3;

	public DespesaComAgua(LocalDateTime data, String descricao, double totalM3) {
		super(data, descricao);
		this.totalM3 = totalM3;
	}

	public double getToTalM3() {
		return totalM3;
	}

	@Override
	public double calcularTotal() {
		double total = 0;
		if (totalM3 <= 10) {
			total = 45;

		} else if (totalM3 > 10 && totalM3 <= 20) {
			double excedente = this.totalM3 - 10;

			total = (5*excedente) + 45;

		} else if (totalM3 > 20) {
			double excedente = this.totalM3 - 20;

			total = (6*excedente) + 50 + 45;

		}
		return total;
	}

	@Override
	public String toString() {
		return "[" + super.getData() + "] " + "Despesa com consumo de " + this.totalM3 + " m3: R$ " + this.calcularTotal();
	}
	

}