package model.dao;

import model.Pessoa;
import model.Usuario;
import model.file.FilePersistence;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import model.exceptions.PessoaException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoFile implements IDaoPessoa {

    private ISerializador serializador;
    private FilePersistence filePersistence;
    private final String filePath = "usuarios.json";  // caminho fixo para o arquivo usuários

    public UsuarioDaoFile() {
        this.serializador = new SerializadorJSON();
        this.filePersistence = new FilePersistence();
    }

    public UsuarioDaoFile(ISerializador serializador) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void salvar(Pessoa p, boolean tipo) {
        if (!(p instanceof Usuario)) {
            throw new PessoaException("Erro - Apenas objetos Usuario podem ser salvos aqui");
        }

        List<Usuario> usuarios = listarUsuarios();
        usuarios.add((Usuario) p);

        String jsonData = serializador.toFile(usuarios);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Usuário salvo com sucesso no arquivo.");
    }

    @Override
    public void remover(Pessoa p, boolean tipo) {
        if (!(p instanceof Usuario)) {
            throw new PessoaException("Erro - Apenas objetos Usuario podem ser removidos aqui");
        }

        List<Usuario> usuarios = listarUsuarios();
        usuarios.removeIf(u -> u.equals(p));

        String jsonData = serializador.toFile(usuarios);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Usuário removido com sucesso no arquivo.");
    }

    @Override
    public void atualizar(int codPessoa, Pessoa p, boolean tipo) {
        if (!(p instanceof Usuario)) {
            throw new PessoaException("Erro - Apenas objetos Usuario podem ser atualizados aqui");
        }

        List<Usuario> usuarios = listarUsuarios();
        usuarios.removeIf(u -> u.getId() == codPessoa); // supondo que getId() é int
        usuarios.add((Usuario) p);

        String jsonData = serializador.toFile(usuarios);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Usuário atualizado com sucesso no arquivo.");
    }

    @Override
    public Object buscar(int codPessoa, boolean tipo) {
        List<Usuario> usuarios = listarUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == codPessoa) { // supondo que getId() é int
                return usuario;
            }
        }
        throw new PessoaException("Erro - Usuário não encontrado");
    }

    @Override
    public List<Pessoa> listar(boolean tipo) {
        return new ArrayList<>(listarUsuarios()); // retorna como Pessoa
    }

    // ======= MÉTODO AUXILIAR =======
    private List<Usuario> listarUsuarios() {
        String jsonData = filePersistence.loadFromFile(filePath);
        if (jsonData == null || jsonData.isEmpty()) {
            return new ArrayList<>();
        }
        return serializador.fromFileUsuarios(jsonData);
    }
}
