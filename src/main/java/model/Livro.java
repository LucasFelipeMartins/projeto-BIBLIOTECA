package model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private List<String> lstNomeAutor;
    private int ano;
    private List<Double> avaliacoes; // Antes era double
    private String genero;

    public Livro(String titulo, List<String> lstNomeAutor, int ano, List<Double> avaliacoes, String genero) {
        this.titulo = titulo;
        this.lstNomeAutor = lstNomeAutor != null ? lstNomeAutor : new ArrayList<>();
        this.ano = ano;
        this.avaliacoes = avaliacoes != null ? avaliacoes : new ArrayList<>();
        this.genero = genero;
    }

    public Livro() {
        this.lstNomeAutor = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public List<String> getLstNomeAutor() { return lstNomeAutor; }
    public void setLstNomeAutor(List<String> lstNomeAutor) { this.lstNomeAutor = lstNomeAutor; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public List<Double> getAvaliacoes() { return avaliacoes; }
    public void setAvaliacoes(List<Double> avaliacoes) { this.avaliacoes = avaliacoes; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    // Adicionar avaliação individual
    public void addAvaliacao(double nota) {
        if (nota < 0.0 || nota > 5.0) {
            throw new IllegalArgumentException("Avaliação deve estar entre 0.0 e 5.0");
        }
        this.avaliacoes.add(nota);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + lstNomeAutor +
                ", ano=" + ano +
                ", avaliacoes=" + avaliacoes +
                ", genero='" + genero + '\'' +
                '}';
    }

    // Método opcional para calcular média
    public double mediaAvaliacoes() {
        if (avaliacoes.isEmpty()) return 0.0;
        return avaliacoes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
