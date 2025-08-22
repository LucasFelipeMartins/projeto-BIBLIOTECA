package controller;

import java.util.List;
import model.Pessoa;
import model.valid.ValidarPessoa;
import model.dao.IDaoPessoa;

public class PessoaController {
    
    private IDaoPessoa repositorio;

    public PessoaController(IDaoPessoa repositorio) {
        this.repositorio = repositorio;
    }
    
    // Agora recebe também a lista de gêneros (usada apenas se tipo == Usuario)
    public void salvar(boolean tipo, String id, String nome, String cpf, List<String> generos) {
        ValidarPessoa valid = new ValidarPessoa();
        Pessoa newPessoa = valid.validacao(tipo, id, nome, cpf, generos);
        repositorio.salvar(newPessoa, tipo);
    }
    
    public void remover(boolean tipo, String id, String nome, String cpf, List<String> generos) {
        ValidarPessoa valid = new ValidarPessoa();
        Pessoa newPessoa = valid.validacao(tipo, id, nome, cpf, generos);
        repositorio.remover(newPessoa, tipo);
    }
    
    public void atualizar(int idPessoa, Pessoa p, boolean tipo) {
        repositorio.atualizar(idPessoa, p, tipo);
    }
    
    public Object buscar(int idPessoa, boolean tipo) {
        return repositorio.buscar(idPessoa, tipo);
    }
    
    public List<Pessoa> listar(boolean tipo) {
        return repositorio.listar(tipo);
    }
}
