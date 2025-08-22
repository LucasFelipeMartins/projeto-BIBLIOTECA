package model.dao;

import model.Autor;
import model.file.FilePersistence;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import model.exceptions.PessoaException;

import java.util.ArrayList;
import java.util.List;

public class AutorDaoFile implements IDaoPessoa<Autor> {

    private ISerializador serializador;
    private FilePersistence filePersistence;
    private final String filePath = "autores.json";

    public AutorDaoFile() {
        this.serializador = new SerializadorJSON();
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void salvar(Autor a) {
        List<Autor> autores = listar();
        autores.add(a);
        String jsonData = serializador.toFileAutores(autores);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Autor salvo com sucesso.");
    }

    @Override
    public void remover(Autor a) {
        List<Autor> autores = listar();
        autores.removeIf(autor -> autor.getId() == a.getId());
        String jsonData = serializador.toFileAutores(autores);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Autor removido com sucesso.");
    }

    @Override
    public void atualizar(int codPessoa, Autor a) {
        List<Autor> autores = listar();
        autores.removeIf(autor -> autor.getId() == codPessoa);
        autores.add(a);
        String jsonData = serializador.toFileAutores(autores);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Autor atualizado com sucesso.");
    }

    @Override
    public Autor buscar(int codPessoa) {
        List<Autor> autores = listar();
        for (Autor a : autores) {
            if (a.getId() == codPessoa) return a;
        }
        throw new PessoaException("Autor não encontrado");
    }

    @Override
    public List<Autor> listar() {
        String jsonData = filePersistence.loadFromFile(filePath);
        if (jsonData == null || jsonData.isEmpty()) return new ArrayList<>();
        return serializador.fromFileAutores(jsonData);
    }
}
