package controller;

import java.util.List;
import model.Pessoa;
import model.valid.ValidarPessoa;
import model.dao.IDaoPessoa;

public class PessoaController<T extends Pessoa> {

    private IDaoPessoa<T> repositorio;

    public PessoaController(IDaoPessoa<T> repositorio) {
        this.repositorio = repositorio;
    }

    public void salvar(T p) {
        repositorio.salvar(p);
    }

    public void remover(T p) {
        repositorio.remover(p);
    }

    public void atualizar(int idPessoa, T p) {
        repositorio.atualizar(idPessoa, p);
    }

    public T buscar(int idPessoa) {
        return repositorio.buscar(idPessoa);
    }

    public List<T> listar() {
        return repositorio.listar();
    }
}
