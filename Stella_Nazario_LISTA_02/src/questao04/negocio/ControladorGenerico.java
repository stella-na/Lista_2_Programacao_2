package questao04.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import questao04.dados.Comparador;
import questao04.dados.IRepositorioGenerico;
import questao04.dados.RepositorioGenerico;
import questao04.entidades.*;

public class ControladorGenerico{

	private IRepositorioGenerico<OfertaProduto> repositorioOfertas;
	private IRepositorioGenerico<AlertaPreco> repositorioAlertas;
	private IRepositorioGenerico<Produto> repositorioProdutos;
	private IRepositorioGenerico<Loja> repositorioLojas;
	private IRepositorioGenerico<Usuario> repositorioUsuarios;

	public ControladorGenerico() {
		super();
		this.repositorioOfertas = new RepositorioGenerico<>();
		this.repositorioAlertas = new RepositorioGenerico<>();
		this.repositorioProdutos = new RepositorioGenerico<>();
		this.repositorioLojas = new RepositorioGenerico<>();
		this.repositorioUsuarios = new RepositorioGenerico<>();
	}

	public IRepositorioGenerico<OfertaProduto> getRepositorioOfertas() {
		return repositorioOfertas;
	}

	public void setRepositorioOfertas(IRepositorioGenerico<OfertaProduto> repositorioOfertas) {
		this.repositorioOfertas = repositorioOfertas;
	}

	public IRepositorioGenerico<AlertaPreco> getRepositorioAlertas() {
		return repositorioAlertas;
	}

	public void setRepositorioAlertas(IRepositorioGenerico<AlertaPreco> repositorioAlertas) {
		this.repositorioAlertas = repositorioAlertas;
	}

	public IRepositorioGenerico<Produto> getRepositorioProdutos() {
		return repositorioProdutos;
	}

	public void setRepositorioProdutos(IRepositorioGenerico<Produto> repositorioProdutos) {
		this.repositorioProdutos = repositorioProdutos;
	}

	public IRepositorioGenerico<Loja> getRepositorioLojas() {
		return repositorioLojas;
	}

	public void setRepositorioLojas(IRepositorioGenerico<Loja> repositorioLojas) {
		this.repositorioLojas = repositorioLojas;
	}

	public IRepositorioGenerico<Usuario> getRepositorioUsuarios() {
		return repositorioUsuarios;
	}

	public void setRepositorioUsuarios(IRepositorioGenerico<Usuario> repositorioUsuarios) {
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public List<OfertaProduto> listarOfertasOrdenadasPorPrecoNaData(Produto param, LocalDate dataAtual) {
		List<OfertaProduto> oferta = repositorioOfertas.listar();
		List<OfertaProduto> listaOferta = new ArrayList<>();
		for (int i = 0; i < oferta.size(); i++) {
			if (oferta.get(i).getData().equals(dataAtual) && oferta.get(i).getProduto().equals(param)) {
				listaOferta.add(oferta.get(i));
			}
		}
		Collections.sort(listaOferta, new Comparador());
		return listaOferta;
	}

	public Map<LocalDate, List<OfertaProduto>> montarHistoricoDeOfertasDoProdutoNoPeriodo(Produto param, LocalDate dataInicial, LocalDate dataFinal) {
		
		Map<LocalDate, List<OfertaProduto>> mapa = new HashMap<>();
		List<OfertaProduto> oferta = repositorioOfertas.listar();
		List<OfertaProduto> ofertaNaData = new ArrayList<>();
		for (int i = 0; i < oferta.size(); i++) {
			if (oferta.get(i).getProduto().equals(param) && oferta.get(i).getData().isAfter(dataInicial.minusDays(1))
					&& oferta.get(i).getData().isBefore(dataFinal.plusDays(1))) {
				ofertaNaData.add(oferta.get(i));
			}
		}
			mapa.put(ofertaNaData.get(0).getData(), ofertaNaData);		
		
		return mapa;
	}

	public List<AlertaPreco> verificarAlertasDePrecoAtingido(Usuario u) {
		List<AlertaPreco> alerta = repositorioAlertas.listar();
		List<AlertaPreco> alertaUsuario = new ArrayList<>();
		List<AlertaPreco> alertaPrecoAtingido = new ArrayList<>();
		List<OfertaProduto> oferta = repositorioOfertas.listar();

		LocalDate hoje = LocalDate.now();
		for (int i = 0; i < alerta.size(); i++) {
			if (alerta.get(i).getUsuario().equals(u)) {
				alertaUsuario.add(alerta.get(i));
			}
		}
		for (int j = 0; j < alertaUsuario.size(); j++) {
			if (oferta.get(j).getData().equals(hoje)) {
				for (int k = j; k < oferta.size(); k++) {
					if (oferta.get(k).getPreco() <= alertaUsuario.get(j).getPrecoAlvo() && oferta.get(k).getProduto().equals(alertaUsuario.get(j).getProduto())) {
						alertaPrecoAtingido.add(alertaUsuario.get(j));
					}
				}
			}
		}
		return alertaPrecoAtingido;
	}

}
