package questao03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FluxoCaixa {

	List<Transacao> transacoes;
	private String nomeEmpresa;
	private String cnpj;

	public FluxoCaixa(String nomeEmpresa, String cnpj) {
		this.transacoes = new ArrayList<>();
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void adicionarTransacao(Transacao transacao) {
		transacoes.add(transacao);

	}

	public double calcularDespesas(LocalDate inicio, LocalDate fim) {
		double despesa = 0;
		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i) instanceof Despesa) {
				if (transacoes.get(i).getData().toLocalDate().isAfter(inicio.minusDays(1))
						&& transacoes.get(i).getData().toLocalDate().isBefore(fim.plusDays(1))) {
					despesa += transacoes.get(i).calcularTotal();
				}
			}

		}
		return despesa;
	}

	public double calcularReceitas(LocalDate inicio, LocalDate fim) {
		double receita = 0;
		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i) instanceof Receita) {
				if (transacoes.get(i).getData().toLocalDate().isAfter(inicio.minusDays(1))
						&& transacoes.get(i).getData().toLocalDate().isBefore(fim.plusDays(1))) {
					receita += transacoes.get(i).calcularTotal();
				}
			}

		}
		return receita;
	}

	public double percentualReceitasNoMes(int mes, int ano) {
		double percentual = 0;
		double receita = 0;
		double receitaDoAno = 0;
		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i) instanceof Receita) {
				if (transacoes.get(i).getData().getYear() == ano) {
					receitaDoAno += transacoes.get(i).calcularTotal();
					if (transacoes.get(i).getData().getMonthValue() == mes) {
						receita += transacoes.get(i).calcularTotal();
					}
				}
			}
		}
		percentual = (receita / receitaDoAno) * 100;

		return percentual;
	}

	public double receitaTotal() {
		double receita = 0;
		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i) instanceof Receita) {
				receita += transacoes.get(i).calcularTotal();
			}
		}

		return receita;
	}

	public double percentualDespesasNoMes(int mes, int ano) {
		double percentual = 0;
		double despesa = 0;
		double despesaDoAno = 0;
		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i) instanceof Despesa) {
				if (transacoes.get(i).getData().getYear() == ano) {
					despesaDoAno += transacoes.get(i).calcularTotal();
					if (transacoes.get(i).getData().getMonthValue() == mes) {
						despesa += transacoes.get(i).calcularTotal();
					}
				}
			}
		}
		percentual = (despesa / despesaDoAno) * 100;

		return percentual;
	}

	public double despesaTotal() {
		double despesa = 0;
		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i) instanceof Despesa) {
				despesa += transacoes.get(i).calcularTotal();
			}
		}

		return despesa;
	}

	public double saldoAtual() {
		return receitaTotal() - despesaTotal();
	}

	public List<Transacao> listarTransacoesNoMes(int mes, int ano) {
		List<Transacao> t = new ArrayList<>();

		for (int i = 0; i < this.transacoes.size(); i++) {
			if (transacoes.get(i).getData().getMonthValue() == mes && transacoes.get(i).getData().getYear() == ano) {
				t.add(transacoes.get(i));
			}
		}

		return t;
	}

}
