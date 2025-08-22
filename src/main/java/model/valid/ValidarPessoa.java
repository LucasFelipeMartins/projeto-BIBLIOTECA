package model.valid;

import java.util.List;
import model.Autor;
import model.Pessoa;
import model.Usuario;
import model.exceptions.PessoaException;


public class ValidarPessoa {    
    
    public Pessoa validacao(boolean tipo, String id, String nome, String cpf, List<String> lstGenero) {
    
    if (id == null || id.isEmpty()) {
        throw new PessoaException("Error - Campo vazio: 'codigo'.");
    }
    
    int intId;
    try {
        intId = Integer.parseInt(id);
    } catch (NumberFormatException e) {
        throw new PessoaException("Error - Campo inválido: 'codigo' deve ser numérico.");
    }

    if (nome == null || nome.isEmpty()) {
        throw new PessoaException("Error - Campo vazio: 'nome'.");
    }

    if (cpf == null || cpf.isEmpty()) {
        throw new PessoaException("Error - Campo vazio: 'CPF'.");
    }
    
    Pessoa p;
    
    if (tipo) { // Usuario
        Usuario usuario = new Usuario();
        usuario.setId(intId);
        usuario.setNome(nome);
        usuario.setCpf(cpf);

        if (lstGenero != null && !lstGenero.isEmpty()) {
            usuario.setLstGenero(lstGenero);
        }
        // Se for null ou vazia, deixa a lista como está (inicializada vazia no construtor)
        
        p = usuario;
    } else { // Autor
        Autor autor = new Autor();
        autor.setId(intId);
        autor.setNome(nome);
        autor.setCpf(cpf);
        p = autor;
    }
    
    return p;
}

    
}
