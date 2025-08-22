package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.List;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,       // Usa o nome do tipo
    include = JsonTypeInfo.As.PROPERTY,  // Insere no JSON como uma propriedade
    property = "tipo"                 // Nome da propriedade no JSON
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Autor.class, name = "autor"),
    @JsonSubTypes.Type(value = Usuario.class, name = "usuario")
})

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String cpf;
    protected List<Livro> lstLivros;

    // Construtores, getters e setters

    public Pessoa() {}

    public Pessoa(int id, String nome, String cpf, List<Livro> lstLivros) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.lstLivros = lstLivros;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Livro> getLstLivros() {
        return lstLivros;
    }

    public void setLstLivros(List<Livro> lstLivros) {
        this.lstLivros = lstLivros;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome=" + nome + ", cpf=" + cpf + "}";
    }
}
