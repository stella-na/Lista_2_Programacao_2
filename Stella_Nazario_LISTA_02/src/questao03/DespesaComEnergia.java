package questao03;

import java.time.LocalDateTime;

public class DespesaComEnergia extends Despesa {

	private double kWh;

	public DespesaComEnergia(LocalDateTime data, String descricao, double kWh) {
		super(data, descricao);
		this.kWh = kWh;
	}

	public double getkWh() {
		return kWh;
	}

	@Override
	public double calcularTotal() {
		double total = 0;

		if (kWh < 100) {
			total = kWh * 0.5;
			if(kWh <= 50) {
				total += 2;
			}else {
				total += 15;
			}

		} else if (kWh >= 100) {
			int centena = (int) this.kWh / 100;
			total = kWh * 0.5 + centena * 1.2;
			if(kWh <= 200) {
				total += 15;
			}else {
				total += 35;
			}
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "[" + super.getData() + "] " + "Despesa com consumo de " + this.kWh + " kWh: R$ " + this.calcularTotal();
	}

}
