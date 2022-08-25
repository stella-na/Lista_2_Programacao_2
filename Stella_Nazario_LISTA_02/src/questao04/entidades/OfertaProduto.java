package questao04.entidades;

import java.time.LocalDate;
//import java.util.Comparator;
import java.time.format.DateTimeFormatter;

public class OfertaProduto {
    
    private Produto produto;
    private Float preco;
    private Loja lojaOfertante;
    private LocalDate data;

    public OfertaProduto(Produto produto, float preco, Loja lojaOFertante,
            LocalDate data) {
        this.produto = produto;
        this.preco = preco;
        this.lojaOfertante = lojaOFertante;
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Loja getLojaOFertante() {
        return lojaOfertante;
    }

    public void setLojaOFertante(Loja lojaOFertante) {
        this.lojaOfertante = lojaOFertante;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    //@Override
    public String toString() {
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Oferta Produto [produto=" + produto + ", preco=" + preco
                + ", loja Ofertante=" + lojaOfertante +"\n";
    }

	
    
    

}
