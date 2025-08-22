package model.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Pessoa;
import model.Usuario;

public class SerializadorJSON implements ISerializador {

    private final ObjectMapper mapper;

    public SerializadorJSON() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public String toFile(List<?> pessoas) {
        try {
            return mapper.writeValueAsString(pessoas);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método genérico para carregar pessoas e separar em Autor e Usuario
    @Override
    public List<Pessoa> fromFilePessoas(String jsonString) {
        List<Pessoa> pessoas = new ArrayList<>();

        if (jsonString == null || jsonString.trim().isEmpty()) {
            return pessoas;
        }

        try {
            // Ler o JSON como array de nodes
            JsonNode arrayNode = mapper.readTree(jsonString);
            if (arrayNode.isArray()) {
                for (JsonNode node : arrayNode) {
                    // Verifica se tem propriedade específica para decidir
                    if (node.has("lstGenero")) {
                        // Provavelmente Usuario
                        Usuario u = mapper.treeToValue(node, Usuario.class);
                        pessoas.add(u);
                    } else {
                        // Provavelmente Autor
                        Autor a = mapper.treeToValue(node, Autor.class);
                        pessoas.add(a);
                    }
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    // Caso queira carregar só Autores
    @Override
    public List<Autor> fromFileAutores(String jsonString) {
        try {
            if (jsonString == null || jsonString.trim().isEmpty()) {
                return new ArrayList<>();
            }
            return mapper.readValue(jsonString, new TypeReference<List<Autor>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Caso queira carregar só Usuários
    @Override
    public List<Usuario> fromFileUsuarios(String jsonString) {
        try {
            if (jsonString == null || jsonString.trim().isEmpty()) {
                return new ArrayList<>();
            }
            return mapper.readValue(jsonString, new TypeReference<List<Usuario>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Método para salvar livros (assumindo que existe classe Livro)
    public String toFileLivros(List<?> livros) {
        try {
            return mapper.writeValueAsString(livros);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para carregar livros (assumindo classe Livro)
    public <T> List<T> fromFileLivros(String jsonString, Class<T> clazz) {
        try {
            if (jsonString == null || jsonString.trim().isEmpty()) {
                return new ArrayList<>();
            }
            return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
