package model.dao;

import java.util.List;

public interface IDaoPessoa<T> {
    void salvar(T p);
    void remover(T p);
    void atualizar(int codPessoa, T p);
    T buscar(int codPessoa);
    List<T> listar();
}
