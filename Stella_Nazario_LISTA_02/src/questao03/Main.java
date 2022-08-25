package questao03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		FluxoCaixa fc = new FluxoCaixa("Software & CIA", "123523464");

		Transacao t1 = new LicencaBasica(LocalDateTime.of(2022, 5, 12, 10, 1), "Basica", 10);
		Transacao t2 = new LicencaBasica(LocalDateTime.of(2022, 7, 20, 7, 1), "Basica", 15);
		Transacao t3 = new LicencaPlus(LocalDateTime.of(2022, 2, 13, 8, 1), "Plus", 32);
		Transacao t4 = new LicencaPlus(LocalDateTime.of(2022, 3, 30, 2, 1), "Plus", 21);
		Transacao t5 = new LicencaEnterprise(LocalDateTime.of(2022, 7, 11, 3, 1), "Enterprise", 5);
		Transacao t6 = new LicencaEnterprise(LocalDateTime.of(2022, 4, 5, 6, 1), "Enterprise", 7);

		Transacao t7 = new DespesaComAgua(LocalDateTime.of(2021, 12, 15, 10, 1), "Água", 20);
		Transacao t8 = new DespesaComAgua(LocalDateTime.of(2021, 1, 3, 3, 1), "Água", 12);
		Transacao t9 = new DespesaComEnergia(LocalDateTime.of(2022, 1, 7, 6, 1), "Energia", 98);
		Transacao t10 = new DespesaComEnergia(LocalDateTime.of(2022, 7, 19, 9, 1), "Energia", 120);
		Transacao t11 = new DespesaComInternet(LocalDateTime.of(2022, 1, 15, 12, 1), "Internet", 23);
		Transacao t12 = new DespesaComInternet(LocalDateTime.of(2022, 1, 3, 4, 1), "Internet", 32);

		fc.adicionarTransacao(t1);
		fc.adicionarTransacao(t2);
		fc.adicionarTransacao(t3);
		fc.adicionarTransacao(t4);
		fc.adicionarTransacao(t5);
		fc.adicionarTransacao(t6);
		fc.adicionarTransacao(t7);
		fc.adicionarTransacao(t8);
		fc.adicionarTransacao(t9);
		fc.adicionarTransacao(t10);
		fc.adicionarTransacao(t11);
		fc.adicionarTransacao(t12);

		double despesa = fc.calcularDespesas(LocalDate.of(2022, 1, 3), LocalDate.of(2022, 1, 7));
		double receita = fc.calcularReceitas(LocalDate.of(2022, 5, 12), LocalDate.of(2022, 7, 11));
		double percentualReceita = fc.percentualReceitasNoMes(5, 2022);
		double percentualDespesa = fc.percentualDespesasNoMes(1, 2022);
		double saldo = fc.saldoAtual();
		List<Transacao> transacoes = fc.listarTransacoesNoMes(7, 2022);

		System.out.println("Valor da Despesa: R$ " + despesa);
		System.out.println("Valor da Receita: R$ " + receita);
		System.out.printf("Percentual da Receita: %.2f\n", percentualReceita);
		System.out.printf("Percentual da Despesa: %.2f\n", percentualDespesa);
		System.out.println("Valor do saldo Atual: R$ " + saldo);
		
		System.out.println("\n------------------TRANSAÇÕES LISTADAS------------------");
		
		for (int i = 0; i < transacoes.size(); i++) {
			System.out.println(transacoes.get(i).toString());
		}

	}

}
