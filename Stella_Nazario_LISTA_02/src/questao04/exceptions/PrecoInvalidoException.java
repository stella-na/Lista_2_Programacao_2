package questao04.exceptions;

public class PrecoInvalidoException extends Exception {
    
    private static final long serialVersionUID = -3959837647874839852L;
	
    private float precoAlvoInvalido;
    
    public PrecoInvalidoException(float preco) {
        this.precoAlvoInvalido = preco;
    }

    public float getPrecoAlvoInvalido() {
        return precoAlvoInvalido;
    }
}
