package model.dao;

import java.util.List;
import model.Livro;

public interface IDaoLivro {
    
    public void salvar(Livro l);
    public void remover(Livro l);
    public void atualizar(String titulo, Livro livroAtualizado);
    public Livro buscar(String titulo);
    public List<Livro> listar();
    
}
