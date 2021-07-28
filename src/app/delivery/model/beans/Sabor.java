package app.delivery.model.beans;

public class Sabor {
    private int id;
    private String nome;
    private TipoSabor tipo;

    public Sabor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSabor getTipo() {
        return tipo;
    }

    public void setTipo(TipoSabor tipo) {
        this.tipo = tipo;
    }

}
