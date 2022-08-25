package questao04.entidades;


public class Produto {
    
    private String id;
    private String nome;
    private String descricao;
    private CategoriaProdutoEnum categoria;


    public Produto(String id, String nome, String descricao,
            CategoriaProdutoEnum categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao="
                + descricao + "]";
    }

	public CategoriaProdutoEnum getCategoria() {
		return categoria;
	}

}
