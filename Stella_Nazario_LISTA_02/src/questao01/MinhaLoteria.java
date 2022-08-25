package questao01;

import java.util.ArrayList;

public class MinhaLoteria {

	public static void main(String[] args) {
		
		BilheteDeLoteria bilhetePremiado = new BilheteDeLoteria(6);

		for (int i = 6; i <= 15; i++) {
			int quadra = 0;
			int quina = 0;
			int mega_sena = 0;
			int total = 0;
			int outro = 0;
			
			@SuppressWarnings("unused")
			ArrayList<BilheteDeLoteria> bilhetes = new ArrayList<>();

			boolean fim = false;
			while (fim == false) {
				BilheteDeLoteria bilheteSorteado = new BilheteDeLoteria(i);
				//A linha de código abaixo resulta na maioria dos casos em exception de OutOfMemoryError: Java heap space
				//bilhetes.add(bilheteSorteado); 

				int numerosContidos = bilheteSorteado.qtdNumerosContidos(bilhetePremiado);

				if (numerosContidos == 4) {
					quadra++;

				} else if (numerosContidos == 5) {
					quina++;

				} else if (numerosContidos == 6) {
					mega_sena++;
					fim = true;
				}
				else {
					outro++;
				}
				total = quadra + quina + outro + mega_sena;
			}
			System.out.printf("Jogos de %d números: você apostou %d vezes para ganhar na mega-sena. Dentre esses jogos, você acertou %d quadras e %d quinas.\n", i, total, quadra, quina);
		}
		
	}

}
