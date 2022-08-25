package questao03;

import java.time.LocalDateTime;

public class DespesaComInternet extends Despesa{
	
	private double dadosTrafegados;
	
	public DespesaComInternet(LocalDateTime data, String descricao, double dadosTrafegados) {
		super(data, descricao);
		this.dadosTrafegados = dadosTrafegados;
	}
	
	public double getDadosTrafegados() {
		return dadosTrafegados;
	}

	@Override
	public double calcularTotal() {
		double total = 0;
		
		if (dadosTrafegados >= 20 && dadosTrafegados < 100) {
			double excedente = this.dadosTrafegados - 20;
			total = (excedente*3.9) + 90.9;

		} else if (dadosTrafegados >= 100 && dadosTrafegados < 500) {
			double excedente = this.dadosTrafegados - 100;
			total = (excedente*4.4) + 240.9;

		} else if (dadosTrafegados >= 500) {
			double excedente = this.dadosTrafegados - 500;
			total = (excedente*5.1) + 590.9;

		}
		
		return total;
	}
	
	@Override
	public String toString() {
		return "[" + super.getData() + "] " + "Despesa com consumo de " + this.dadosTrafegados + " Gb: R$ " + this.calcularTotal();
	}
}