package questao02;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		RepositorioPessoa rp = new RepositorioPessoa();

		Pessoa c1 = new Cliente("João", LocalDate.of(2002, 3, 15), 13);
		Pessoa c2 = new Cliente("Maria", LocalDate.of(2014, 5, 2), 16);
		Pessoa c3 = new Cliente("José", LocalDate.of(2010, 7, 8), 8);
		Pessoa c4 = new Cliente("Marta", LocalDate.of(1996, 6, 22), 3);
		Pessoa c5 = new Cliente("Ana", LocalDate.of(1992, 4, 19), 7);
		Pessoa c6 = new Cliente("Ana", LocalDate.of(1992, 4, 19), 7);

		rp.cadastrarPessoa(c1);
		rp.cadastrarPessoa(c2);
		rp.cadastrarPessoa(c3);
		rp.cadastrarPessoa(c4);
		rp.cadastrarPessoa(c5);
		rp.cadastrarPessoa(c6);

		Pessoa f1 = new Funcionario("Caio", LocalDate.of(1990, 5, 1), 4800);
		Pessoa f2 = new Funcionario("Vinicios", LocalDate.of(1994, 4, 4), 4000);
		Pessoa f3 = new Funcionario("Luciana", LocalDate.of(1982, 2, 12), 5100);
		Pessoa f4 = new Funcionario("Karol", LocalDate.of(2007, 8, 17), 3500);
		Pessoa f5 = new Funcionario("Lúcia", LocalDate.of(2004, 12, 23), 3800);
		Pessoa f6 = new Funcionario("Caio", LocalDate.of(1990, 5, 1), 4800);

		rp.cadastrarPessoa(f1);
		rp.cadastrarPessoa(f2);
		rp.cadastrarPessoa(f3);
		rp.cadastrarPessoa(f4);
		rp.cadastrarPessoa(f5);
		rp.cadastrarPessoa(f6);

		Pessoa g1 = new Gerente("Silvio", LocalDate.of(1984, 10, 6), 5700, "RH");
		Pessoa g2 = new Gerente("Carmen", LocalDate.of(1992, 5, 3), 5700, "Administrativo");
		Pessoa g3 = new Gerente("Paulo", LocalDate.of(1977, 11, 15), 5700, "Financeiro");
		Pessoa g4 = new Gerente("Jéssica", LocalDate.of(1998, 2, 8), 5700, "Licitações e Contratos");
		Pessoa g5 = new Gerente("Samantha", LocalDate.of(2000, 1, 30), 5700, "Vendas");
		Pessoa g6 = new Gerente("Silvio", LocalDate.of(1984, 10, 6), 5700, "RH");

		rp.cadastrarPessoa(g1);
		rp.cadastrarPessoa(g2);
		rp.cadastrarPessoa(g3);
		rp.cadastrarPessoa(g4);
		rp.cadastrarPessoa(g5);
		rp.cadastrarPessoa(g6);

		ArrayList<Pessoa> pessoasMaioresIdade = rp.listarPessoasMaioresIdade();
		ArrayList<Cliente> clientesMaioresIdade = rp.listarClientesMaioresIdade();
		ArrayList<Funcionario> FuncionariosComSalarioMaiorQue = rp.listarFuncionariosComSalarioMaiorQue(4000);
		ArrayList<Gerente> GerentesDaArea = rp.listarGerentesDaArea("RH");

		System.out.println("-------------------------PESSOAS MAIORES DE IDADE-------------------------\n");
		for (int i = 0; i < pessoasMaioresIdade.size(); i++) {
			System.out.println(pessoasMaioresIdade.get(i).toString());
		}
		System.out.println("\n-------------------------CLIENTES MAIORES DE IDADE-------------------------\n");
		
		for (int i = 0; i < clientesMaioresIdade.size(); i++) {
			System.out.println(clientesMaioresIdade.get(i).toString());
		}
		System.out.println("\n--------------------FUNCIONARIOS COM SALARIOS MAIOR QUE--------------------\n");
		
		for (int i = 0; i < FuncionariosComSalarioMaiorQue.size(); i++) {
			System.out.println(FuncionariosComSalarioMaiorQue.get(i).toString());
		}
		System.out.println("\n---------------------------GERENTES DA ÁREA-------------------------------\n");
		
		for (int i = 0; i < GerentesDaArea.size(); i++) {
			System.out.println(GerentesDaArea.get(i).toString());

		}

	}

}
