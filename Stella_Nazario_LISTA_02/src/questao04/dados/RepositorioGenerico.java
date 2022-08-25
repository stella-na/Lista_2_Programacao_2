package questao04.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questao04.exceptions.ElementoJaExisteException;
import questao04.exceptions.ElementoNaoExisteException;

public class RepositorioGenerico<R> implements IRepositorioGenerico<R> {

	protected List<R> elementos;

	//@SuppressWarnings("unchecked")
	public RepositorioGenerico() {
       
        this.elementos = new ArrayList<>();
        
        if (elementos != null && elementos instanceof List<?>){
            this.elementos = (List<R>) elementos;
        }
    }

	public void inserir(R novoObj) throws ElementoJaExisteException {
		if (!this.elementos.contains(novoObj)) {
			this.elementos.add(novoObj);
		} else {
			throw new ElementoJaExisteException(novoObj);
		}
	}

	public List<R> listar() {
		return Collections.unmodifiableList(this.elementos);
	}

	public void remover(R obj) throws ElementoNaoExisteException {
		if (this.elementos.contains(obj)) {
			this.elementos.remove(this.elementos.indexOf(obj));
		} else {
			throw new ElementoNaoExisteException(obj);
		}
	}

	public void atualizar(R newObj) throws ElementoNaoExisteException {
		if (this.elementos.contains(newObj)) {
			int indice = this.elementos.indexOf(newObj);
			this.elementos.set(indice, newObj);
		} else {
			throw new ElementoNaoExisteException(newObj);
		}
	}
	
}
