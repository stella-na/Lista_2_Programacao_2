package questao04.dados;

import java.util.List;

import questao04.exceptions.ElementoJaExisteException;
import questao04.exceptions.ElementoNaoExisteException;

public interface IRepositorioGenerico<R> {
	    
	    void inserir(R obj) throws ElementoJaExisteException;
	    
	    List<R> listar();
	    
	    void remover(R obj) throws ElementoNaoExisteException;

	    void atualizar(R newObj) throws ElementoNaoExisteException;


}
