package controller;

import java.util.List;
import model.Pessoa;
import model.valid.ValidarPessoa;
import model.dao.IDaoPessoa;

public class PessoaController<T extends Pessoa> {

    private IDaoPessoa<T> repositorio;
    private ValidarPessoa validador;
    private Class<T> tipoClasse; // Para saber se é Usuario ou Autor

    public PessoaController(IDaoPessoa<T> repositorio, Class<T> tipoClasse) {
        this.repositorio = repositorio;
        this.validador = new ValidarPessoa();
        this.tipoClasse = tipoClasse;
    }

    // Salvar com validação
    public void salvar(String id, String nome, String cpf, List<String> lstGenero) {
        T pessoaValidada = validarDados(id, nome, cpf, lstGenero);
        repositorio.salvar(pessoaValidada);
    }

    // Remover (sem validação)
    public void remover(T p) {
        repositorio.remover(p);
    }

    // Atualizar com validação
    public void atualizar(String id, String nome, String cpf, List<String> lstGenero) {
        T pessoaValidada = validarDados(id, nome, cpf, lstGenero);
        repositorio.atualizar(pessoaValidada.getId(), pessoaValidada);
    }

    public T buscar(int idPessoa) {
        return repositorio.buscar(idPessoa);
    }

    public List<T> listar() {
        return repositorio.listar();
    }

    // ======= MÉTODO AUXILIAR =======
    private T validarDados(String id, String nome, String cpf, List<String> lstGenero) {
        boolean tipoUsuario = tipoClasse.equals(model.Usuario.class); // define se é Usuario
        Pessoa p = validador.validacao(tipoUsuario, id, nome, cpf, lstGenero);
        return tipoClasse.cast(p);
    }
}
