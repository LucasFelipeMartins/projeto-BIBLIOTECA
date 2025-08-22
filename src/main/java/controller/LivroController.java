package controller;

import java.util.List;
import model.Livro;
import model.dao.IDaoLivro;
import model.valid.ValidarLivro;

public class LivroController {

    private IDaoLivro repositorio;

    public LivroController(IDaoLivro repositorio) {
        this.repositorio = repositorio;
    }

    public void salvar(String titulo, List<String> lstNomeAutor, String anoStr, String avaliacaoStr, String genero) {
        ValidarLivro valid = new ValidarLivro();
        Livro newLivro = valid.validacao(titulo, lstNomeAutor, anoStr, avaliacaoStr, genero);
        repositorio.salvar(newLivro);
    }

    public void remover(Livro livro) {
        repositorio.remover(livro);
    }

    public void atualizar(String tituloOriginal, Livro livroAtualizado) {
        repositorio.atualizar(tituloOriginal, livroAtualizado);
    }

    public Livro buscar(String titulo) {
        System.out.println(repositorio.buscar(titulo).toString());
        return repositorio.buscar(titulo);
    }

    public List<Livro> listar() {
        return repositorio.listar();
    }
}
