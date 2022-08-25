package questao04.dados;

import java.util.Comparator;
import questao04.entidades.OfertaProduto;

public class Comparador implements Comparator<OfertaProduto>{
	
	public Comparador() {
	}

	@Override
	public int compare(OfertaProduto p1, OfertaProduto p2) {
		return p1.getPreco().compareTo(p2.getPreco());
	}

}
