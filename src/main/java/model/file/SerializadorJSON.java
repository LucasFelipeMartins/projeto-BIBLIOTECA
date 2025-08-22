package model.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Usuario;
import model.Livro;

public class SerializadorJSON implements ISerializador {

    private final ObjectMapper mapper;

    public SerializadorJSON() {
        this.mapper = new ObjectMapper();
    }

    // ----------- Autores -----------
    @Override
    public String toFileAutores(List<Autor> autores) {
        try {
            return mapper.writeValueAsString(autores);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

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

    // ----------- Usuários -----------
    @Override
    public String toFileUsuarios(List<Usuario> usuarios) {
        try {
            return mapper.writeValueAsString(usuarios);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

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

    // ----------- Livros -----------
    @Override
    public String toFileLivros(List<Livro> livros) {
        try {
            return mapper.writeValueAsString(livros);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Livro> fromFileLivros(String jsonString) {
        try {
            if (jsonString == null || jsonString.trim().isEmpty()) {
                return new ArrayList<>();
            }
            return mapper.readValue(jsonString, new TypeReference<List<Livro>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
