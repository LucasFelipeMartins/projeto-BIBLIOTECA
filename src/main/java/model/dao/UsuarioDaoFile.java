package model.dao;

import model.Usuario;
import model.file.FilePersistence;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import model.exceptions.PessoaException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoFile implements IDaoPessoa<Usuario> {

    private ISerializador serializador;
    private FilePersistence filePersistence;
    private final String filePath = "usuarios.json";

    public UsuarioDaoFile() {
        this.serializador = new SerializadorJSON();
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void salvar(Usuario u) {
        List<Usuario> usuarios = listar();
        usuarios.add(u);
        String jsonData = serializador.toFileUsuarios(usuarios);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Usuário salvo com sucesso.");
    }

    @Override
    public void remover(Usuario u) {
        List<Usuario> usuarios = listar();
        usuarios.removeIf(user -> user.getId() == u.getId());
        String jsonData = serializador.toFileUsuarios(usuarios);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Usuário removido com sucesso.");
    }

    @Override
    public void atualizar(int codPessoa, Usuario u) {
        List<Usuario> usuarios = listar();
        usuarios.removeIf(user -> user.getId() == codPessoa);
        usuarios.add(u);
        String jsonData = serializador.toFileUsuarios(usuarios);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Usuário atualizado com sucesso.");
    }

    @Override
    public Usuario buscar(int codPessoa) {
        List<Usuario> usuarios = listar();
        for (Usuario u : usuarios) {
            if (u.getId() == codPessoa) return u;
        }
        throw new PessoaException("Usuário não encontrado");
    }

    @Override
    public List<Usuario> listar() {
        String jsonData = filePersistence.loadFromFile(filePath);
        if (jsonData == null || jsonData.isEmpty()) return new ArrayList<>();
        return serializador.fromFileUsuarios(jsonData);
    }
}
