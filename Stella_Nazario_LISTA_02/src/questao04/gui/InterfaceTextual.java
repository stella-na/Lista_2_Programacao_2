package questao04.gui;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import questao04.exceptions.ElementoJaExisteException;
import questao04.entidades.*;
import questao04.negocio.*;

public class InterfaceTextual {

	public static void main(String[] args) throws ElementoJaExisteException {
		
		ControladorGenerico cg = new ControladorGenerico();	
		
		Produto p1 = new Produto("34", "bicicleta", "veiculo", CategoriaProdutoEnum.UTENSILIOS_DOMESTICOS);
		Produto p2 = new Produto("36", "videogame", "Diversão", CategoriaProdutoEnum.ELETRONICOS);
		Usuario u1 = new Usuario("maria@hotmail.com", "Maria", LocalDate.of(2022, 7, 5));
		Usuario u2 = new Usuario("joao@gmail.com", "João", LocalDate.of(2022, 6, 20));
		AlertaPreco a1 = new AlertaPreco(u1, p1, 150);
		AlertaPreco a2 = new AlertaPreco(u1, p2, 450);
		Loja l1 = new Loja("3", "Americanas", "americanas.com");
		Loja l2 = new Loja("243", "Magazine", "magazine.com");
		Loja l3 = new Loja("233", "Amazon", "amazon.com");
		OfertaProduto op1 = new OfertaProduto(p1, 135, l1, LocalDate.of(2022, 8, 22));
		OfertaProduto op2 = new OfertaProduto(p2, 400, l1, LocalDate.of(2022, 8, 22));
		
		try {
		cg.getRepositorioLojas().inserir(l1);
		cg.getRepositorioLojas().inserir(l2);
		cg.getRepositorioLojas().inserir(l3);
		cg.getRepositorioAlertas().inserir(a1);
		cg.getRepositorioAlertas().inserir(a2);
		cg.getRepositorioUsuarios().inserir(u1);
		cg.getRepositorioUsuarios().inserir(u2);
		cg.getRepositorioProdutos().inserir(p1);
		cg.getRepositorioProdutos().inserir(p2);
		cg.getRepositorioOfertas().inserir(op1);	
		cg.getRepositorioOfertas().inserir(op2);
		
		}
		catch (ElementoJaExisteException elementoExiste) {
			elementoExiste.printStackTrace();
		}
		
		List<OfertaProduto> ofertasOrdenadas = cg.listarOfertasOrdenadasPorPrecoNaData(p1, LocalDate.of(2022, 8, 22));
		System.out.println("\n--------------------------------------Ofertas Ordenadas Por Preco Na Data--------------------------------\n");
		for(int i = 0; i<ofertasOrdenadas.size(); i++) {
			System.out.println(ofertasOrdenadas.get(i).toString());
		}
		
		Map<LocalDate, List<OfertaProduto>> historicoDeOfertas = cg.montarHistoricoDeOfertasDoProdutoNoPeriodo(p1, LocalDate.of(2022, 6, 14), LocalDate.of(2022, 8, 23));
		System.out.println("\n-----------------------------------Historico De Ofertas Do Produto No Periodo--------------------------------\n");
		for(Map.Entry<LocalDate, List<OfertaProduto>> be : historicoDeOfertas.entrySet()) {
			System.out.print(be.getValue());
		}
		
		List<AlertaPreco> alertasDePrecoAtingido = cg.verificarAlertasDePrecoAtingido(u1);
		System.out.println("\n----------------------------------------------Alertas De Preco Atingido--------------------------------\n");
		for(int b = 0; b<alertasDePrecoAtingido.size(); b++) {
			System.out.println(alertasDePrecoAtingido.get(b).toString());
		}
		

	}
}
















