package model;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa {

    public Autor() {
        super();
        this.lstLivros = new ArrayList<>();
    }

    public Autor(int id, String nome, String cpf, List<Livro> lstLivros) {
        super(id, nome, cpf, lstLivros);
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + '}';
    }
}
