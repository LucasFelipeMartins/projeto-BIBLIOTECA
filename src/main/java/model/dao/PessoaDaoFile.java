package model.dao;

import model.Pessoa;
import model.file.FilePersistence;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import model.exceptions.PessoaException;

import java.util.ArrayList;
import java.util.List;

public class PessoaDaoFile implements IDaoPessoa {
    
    private ISerializador serializador;
    private FilePersistence filePersistence;

    public PessoaDaoFile() {
        this.serializador = new SerializadorJSON();
        this.filePersistence = new FilePersistence();
    }

    public PessoaDaoFile(ISerializador serializador) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
    }
    
    @Override
    public void salvar(Pessoa p, boolean tipo) {
        List<Pessoa> pessoas = listar(tipo);
        if (pessoas == null) {
            pessoas = new ArrayList<>();
        }
        pessoas.add(p);
        
        String jsonData = serializador.toFile(pessoas);
        String filePath = tipo ? "usuario.json" : "autor.json";
        
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Pessoa salva com sucesso no arquivo.");
    }

    @Override
    public void remover(Pessoa p, boolean tipo) {
        List<Pessoa> pessoas = listar(tipo);
        pessoas.remove(p);
        
        String jsonData = serializador.toFile(pessoas);
        String filePath = tipo ? "usuario.json" : "autor.json";
        
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Pessoa removida com sucesso no arquivo.");
    }

    @Override
    public void atualizar(int idPessoa, Pessoa p, boolean tipo) {
        List<Pessoa> pessoas = listar(tipo);
        pessoas.removeIf(pessoa -> pessoa.getId() == idPessoa);
        pessoas.add(p);
        
        String jsonData = serializador.toFile(pessoas);
        String filePath = tipo ? "usuario.json" : "autor.json";
        
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Pessoa atualizada com sucesso no arquivo.");
    }

    @Override
    public Pessoa buscar(int idPessoa, boolean tipo) {
        List<Pessoa> pessoas = listar(tipo);
        
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getId() == idPessoa) {
                return pessoa;
            }
        }
        throw new PessoaException("Error - Pessoa não encontrada");
    }

    @Override
    public List<Pessoa> listar(boolean tipo) {
        String filePath = tipo ? "usuario.json" : "autor.json";
        String jsonData = filePersistence.loadFromFile(filePath);

        if (tipo) {
            return new ArrayList<>(serializador.fromFileUsuarios(jsonData));
        } else {
            return new ArrayList<>(serializador.fromFileAutores(jsonData));
        }
    }
}
