package questao02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RepositorioPessoa {

	ArrayList<Pessoa> pessoas = new ArrayList<>();

	public RepositorioPessoa() {

	}

	public void cadastrarPessoa(Pessoa pessoa) {
		boolean igual = false;
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoa.equals(pessoas.get(i)) == true) {
				igual = true;
				break;
			} 
		}
		if (igual == false) {
			pessoas.add(pessoa);
		}
	}

	public ArrayList<Pessoa> listarPessoasMaioresIdade() {
		ArrayList<Pessoa> pessoasMaioresIdade = new ArrayList<>();
		LocalDate hoje = LocalDate.now();
		for (int i = 0; i < pessoas.size(); i++) {
			int idade = (int) pessoas.get(i).getDataNascimento().until(hoje, ChronoUnit.YEARS);
			if (idade >= 18) {
				pessoasMaioresIdade.add(pessoas.get(i));
			}
		}

		return pessoasMaioresIdade;
	}

	public ArrayList<Cliente> listarClientesMaioresIdade() {
		ArrayList<Cliente> clientesMaioresIdade = new ArrayList<>();
		LocalDate hoje = LocalDate.now();
		for (int i = 0; i < pessoas.size(); i++) {
			int idade = (int) pessoas.get(i).getDataNascimento().until(hoje, ChronoUnit.YEARS);
			if (pessoas.get(i) instanceof Cliente && idade >= 18) {
				clientesMaioresIdade.add(((Cliente) pessoas.get(i)));
			}
		}

		return clientesMaioresIdade;
	}

	public ArrayList<Funcionario> listarFuncionariosComSalarioMaiorQue(double salario) {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i) instanceof Funcionario && ((Funcionario)pessoas.get(i)).getSalario() > salario) {
				funcionarios.add(((Funcionario)pessoas.get(i)));
			}
		}

		return funcionarios;
	}

	public ArrayList<Gerente> listarGerentesDaArea(String s) {
		ArrayList<Gerente> gerentes = new ArrayList<>();

		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i) instanceof Gerente && ((Gerente)pessoas.get(i)).getArea().equals(s)) {
				gerentes.add(((Gerente) pessoas.get(i)));
			}
		}
		return gerentes;
	}
}