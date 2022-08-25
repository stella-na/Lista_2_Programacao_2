package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gerente extends Funcionario {

	private String area;

	public Gerente(String nome, LocalDate dataNascimento, double salario, String area) {
		super(nome, dataNascimento, salario);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String toString() {
		
		return "Nome: " + super.getNome() + ", Data de nascimento: " + 
				super.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", O salário teto é: " + 
				SALARIO_TETO_IMPOSTO + ", O salário é: " + super.getSalario() + 
				", O imposto devido é de: " + calcularImpostoDevido()  + ", Área: " + this.area;
	}
	@Override
	public boolean equals(Pessoa pessoa) {
		if (pessoa instanceof Gerente) {
			Gerente qualquer = (Gerente) pessoa;
			return super.getNome().equals(qualquer.getNome()) && super.getDataNascimento().equals(qualquer.getDataNascimento()) && 
					super.getSalario() == qualquer.getSalario() && this.area.equals(qualquer.area);
		} else {
			return false;
		}
	}

}
