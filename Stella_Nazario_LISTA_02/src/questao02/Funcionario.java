package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

	protected static final double SALARIO_TETO_IMPOSTO = 5000;
	private double salario;

	public Funcionario(String nome, LocalDate dataNascimento, double salario) {
		super(nome, dataNascimento);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double calcularImpostoDevido() {
		double imposto = 0;
		
		if(this.salario <= SALARIO_TETO_IMPOSTO) {
			imposto = this.salario*0.05;
		}
		else {
			imposto = this.salario*0.075;
		}
		
		return imposto;
	}
	
	public String toString() {
		
		return "Nome: " + super.getNome() + ", Data de nascimento: " + 
				super.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", O salário teto é: " + 
				SALARIO_TETO_IMPOSTO + ", O salário é: " + this.salario + 
				", Imposto de: " + calcularImpostoDevido();
	}
	
	public boolean equals(Pessoa pessoa) {
		if (pessoa instanceof Funcionario) {
			Funcionario qualquer = (Funcionario) pessoa;
			return super.getNome().equals(qualquer.getNome()) && super.getDataNascimento().equals(qualquer.getDataNascimento()) &&
					this.salario == qualquer.salario;
		} else {
			return false;
		}
	}
	}
