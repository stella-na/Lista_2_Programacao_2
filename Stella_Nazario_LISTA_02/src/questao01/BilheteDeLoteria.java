package questao01;

import java.util.Random;
import java.util.Arrays;

public class BilheteDeLoteria {

	private int[] inteiros;

	public BilheteDeLoteria(int tamanho) {
		this.inteiros = new int[tamanho];
		
		for (int i = 0; i < tamanho; ) {
			boolean diferente = false;
			Random random = new Random();
			int numero = random.nextInt(60) + 1;

			for (int j = 0; j < tamanho; j++) {
				if (numero != inteiros[j]) {
					diferente = true;
				}else {
					diferente = false;
					break;
				}
			}
			if(diferente == true) {
				inteiros[i] = numero;
				i++;
			}
		}
		Arrays.sort(inteiros);
	}

	public int[] getInteiros() {
		return inteiros;
	}

	public void setInteiros(int[] inteiros) {
		this.inteiros = inteiros;
	}

	public int qtdNumerosContidos(BilheteDeLoteria bilhete) {
		int contidos = 0;
		for(int i = 0; i<bilhete.inteiros.length; i++) {
			for(int j = 0; j<this.inteiros.length; j++) {
				if(this.inteiros[j] == bilhete.getInteiros()[i]) {
					contidos++;
					break;
				}
			}
		}
		return contidos;
	}
	
	public String toString() {
		return Arrays.toString(inteiros);
		
	}

}
