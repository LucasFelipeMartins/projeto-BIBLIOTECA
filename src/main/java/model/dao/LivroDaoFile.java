package model.dao;

import model.Livro;
import model.file.FilePersistence;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import model.exceptions.LivroExceptions;

import java.util.ArrayList;
import java.util.List;

public class LivroDaoFile implements IDaoLivro {

    private ISerializador serializador;
    private FilePersistence filePersistence;
    private final String filePath = "livros.json";  // caminho fixo para o arquivo livros

    public LivroDaoFile() {
        this.serializador = new SerializadorJSON();
        this.filePersistence = new FilePersistence();
    }

    public LivroDaoFile(ISerializador serializador) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void salvar(Livro livro) {
        List<Livro> livros = listar();
        if (livros == null) {
            livros = new ArrayList<>();
        }
        livros.add(livro);

        String jsonData = serializador.toFile(livros);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Livro salvo com sucesso no arquivo.");
    }

    @Override
    public void remover(Livro livro) {
        List<Livro> livros = listar();
        if (livros != null) {
            livros.removeIf(l -> l.equals(livro)); // remove livro igual
            String jsonData = serializador.toFile(livros);
            filePersistence.saveToFile(jsonData, filePath);
            System.out.println("Livro removido com sucesso no arquivo.");
        }
    }

    @Override
    public void atualizar(String titulo, Livro livroAtualizado) {
        List<Livro> livros = listar();
        if (livros != null) {
            // Remove o livro pelo título ignorando case
            livros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
            livros.add(livroAtualizado);

            String jsonData = serializador.toFile(livros);
            filePersistence.saveToFile(jsonData, filePath);
            System.out.println("Livro atualizado com sucesso no arquivo.");
        }
    }

    @Override
    public Livro buscar(String titulo) {
        List<Livro> livros = listar();
        if (livros != null) {
            for (Livro livro : livros) {
                if (livro != null && livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        throw new LivroExceptions("Erro - Livro não encontrado");
    }

    @Override
    public List<Livro> listar() {
        String jsonData = filePersistence.loadFromFile(filePath);

        if (jsonData == null || jsonData.isEmpty()) {
            return new ArrayList<>();
        }

        // Aqui chama o método genérico para desserializar livros
        return serializador.fromFileLivros(jsonData, Livro.class);
    }
}
