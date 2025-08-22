package model.file;

import java.util.List;
import model.Autor;
import model.Usuario;
import model.Livro;

public interface ISerializador {
    
    // -------- Autores --------
    String toFileAutores(List<Autor> autores);
    List<Autor> fromFileAutores(String data);
    
    // -------- Usuários --------
    String toFileUsuarios(List<Usuario> usuarios);
    List<Usuario> fromFileUsuarios(String data);
    
    // -------- Livros --------
    String toFileLivros(List<Livro> livros);
    List<Livro> fromFileLivros(String data);
}