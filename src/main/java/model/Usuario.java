package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {

    private List<String> lstGenero;

    public Usuario() {
        super();
        this.lstGenero = new ArrayList<>();
    }

    public Usuario(int id, String nome, String cpf, List<Livro> lstLivros, List<String> lstGenero) {
        super(id, nome, cpf, lstLivros);
        this.lstGenero = lstGenero;
    }

    public List<String> getLstGenero() {
        return lstGenero;
    }

    public void setLstGenero(List<String> lstGenero) {
        this.lstGenero = lstGenero;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", lstGenero=" + lstGenero + '}';
    }
}
