package model.dao;

import model.Pessoa;
import model.Autor;
import model.file.FilePersistence;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import model.exceptions.PessoaException;

import java.util.ArrayList;
import java.util.List;

public class AutorDaoFile implements IDaoPessoa {

    private ISerializador serializador;
    private FilePersistence filePersistence;
    private final String filePath = "autores.json";  // caminho fixo para o arquivo autores

    public AutorDaoFile() {
        this.serializador = new SerializadorJSON();
        this.filePersistence = new FilePersistence();
    }

    public AutorDaoFile(ISerializador serializador) {
        this.serializador = serializador;
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void salvar(Pessoa p, boolean tipo) {
        if (!(p instanceof Autor)) {
            throw new PessoaException("Erro - Apenas objetos Autor podem ser salvos aqui");
        }

        List<Autor> autores = listarAutores();
        autores.add((Autor) p);

        String jsonData = serializador.toFileAutores(autores);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Autor salvo com sucesso no arquivo.");
    }

    @Override
    public void remover(Pessoa p, boolean tipo) {
        if (!(p instanceof Autor)) {
            throw new PessoaException("Erro - Apenas objetos Autor podem ser removidos aqui");
        }

        List<Autor> autores = listarAutores();
        autores.removeIf(a -> a.equals(p));

        String jsonData = serializador.toFileAutores(autores);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Autor removido com sucesso no arquivo.");
    }

    @Override
    public void atualizar(int codPessoa, Pessoa p, boolean tipo) {
        if (!(p instanceof Autor)) {
            throw new PessoaException("Erro - Apenas objetos Autor podem ser atualizados aqui");
        }

        List<Autor> autores = listarAutores();
        autores.removeIf(a -> a.getId() == codPessoa); // supondo que getId() é int
        autores.add((Autor) p);

        String jsonData = serializador.toFileAutores(autores);
        filePersistence.saveToFile(jsonData, filePath);
        System.out.println("Autor atualizado com sucesso no arquivo.");
    }

    @Override
    public Object buscar(int codPessoa, boolean tipo) {
        List<Autor> autores = listarAutores();
        for (Autor autor : autores) {
            if (autor.getId() == codPessoa) { // supondo que getId() é int
                return autor;
            }
        }
        throw new PessoaException("Erro - Autor não encontrado");
    }

    @Override
    public List<Pessoa> listar(boolean tipo) {
        return new ArrayList<>(listarAutores()); // retorna como Pessoa
    }

    // ======= MÉTODO AUXILIAR =======
    private List<Autor> listarAutores() {
        String jsonData = filePersistence.loadFromFile(filePath);
        if (jsonData == null || jsonData.isEmpty()) {
            return new ArrayList<>();
        }
        return serializador.fromFileAutores(jsonData);
    }
}
