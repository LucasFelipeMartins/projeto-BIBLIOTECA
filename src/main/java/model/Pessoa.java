package model;

import java.util.List;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String cpf;
    protected List<String> lstLivros;

    // Construtores, getters e setters

    public Pessoa() {}

    public Pessoa(int id, String nome, String cpf, List<String> lstLivros) {
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

    public List<String> getLstLivros() {
        return lstLivros;
    }

    public void setLstLivros(List<String> lstLivros) {
        this.lstLivros = lstLivros;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome=" + nome + ", cpf=" + cpf + "}";
    }
}
