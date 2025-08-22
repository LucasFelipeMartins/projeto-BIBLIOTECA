package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Livro {
    
    private String titulo;
    private List<String> lstNomeAutor;
    private int ano;
    private String genero;
    private double avaliacao;

    public Livro(String titulo, List<String> lstNomeAutor, int ano, double avaliacao, String genero) {
        this.titulo = titulo;
        this.lstNomeAutor = lstNomeAutor;
        this.ano = ano;
        this.genero = genero;
        this.avaliacao = avaliacao;
    }
    
    public Livro(){
        
        this.titulo = "";
        this.ano = 0;
        this.lstNomeAutor = new ArrayList<>();
        this.genero = "";
        this.avaliacao = 0.0;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getLstNomeAutor() {
        return lstNomeAutor;
    }

    public void setLstNomeAutor(List<String> lstNomeAutor) {
        this.lstNomeAutor = lstNomeAutor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.lstNomeAutor);
        hash = 59 * hash + this.ano;
        hash = 59 * hash + Objects.hashCode(this.genero);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.avaliacao) ^ (Double.doubleToLongBits(this.avaliacao) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (Double.doubleToLongBits(this.avaliacao) != Double.doubleToLongBits(other.avaliacao)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        return Objects.equals(this.lstNomeAutor, other.lstNomeAutor);
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", lstNomeAutor=" + lstNomeAutor + ", ano=" + ano + ", genero=" + genero + ", avaliacao=" + avaliacao + '}';
    }

        
}
