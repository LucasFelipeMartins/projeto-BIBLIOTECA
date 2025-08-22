package model.file;

import java.util.List;
import model.Pessoa;
import model.Autor;
import model.Usuario;

public interface ISerializador {
    
    // Salva uma lista genérica (pessoas ou livros)
    String toFile(List<?> lista);
    
    // Desserializa lista de Autores
    List<Autor> fromFileAutores(String data);
    
    // Desserializa lista de Usuários
    List<Usuario> fromFileUsuarios(String data);
    
    // Desserializa lista mista de Pessoas (Autor ou Usuario)
    List<Pessoa> fromFilePessoas(String data);
    
    // Desserializa lista genérica de livros (ou qualquer outro tipo)
    <T> List<T> fromFileLivros(String data, Class<T> clazz);
}
