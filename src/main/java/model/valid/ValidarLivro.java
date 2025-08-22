package model.valid;

import java.util.List;
import model.Livro;
import model.exceptions.LivroExceptions;

public class ValidarLivro {

    public Livro validacao(String titulo, List<String> lstNomeAutor, String anoStr, String avaliacaoStr, String genero) {

        Livro livro = new Livro(null, null, 0, 0.0, null);

        // Validar título
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'titulo'.");
        } else {
            livro.setTitulo(titulo.trim());
        }

        // Validar lista de autores
//        if (lstNomeAutor == null || lstNomeAutor.isEmpty()) {
//            throw new LivroExceptions("Erro - Lista de autores vazia.");
//        } else {
//            livro.setLstNomeAutor(lstNomeAutor);
//        }

        // Validar ano
        if (anoStr == null || anoStr.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'ano'.");
        } else {
            try {
                int ano = Integer.parseInt(anoStr.trim());
                if (ano <= 0) {
                    throw new LivroExceptions("Erro - Ano inválido.");
                }
                livro.setAno(ano);
            } catch (NumberFormatException e) {
                throw new LivroExceptions("Erro - Ano deve ser um número inteiro.");
            }
        }

        // Validar avaliação
        if (avaliacaoStr == null || avaliacaoStr.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'avaliacao'.");
        } else {
            try {
                double avaliacao = Double.parseDouble(avaliacaoStr.trim());
                if (avaliacao < 0.0 || avaliacao > 5.0) {
                    throw new LivroExceptions("Erro - Avaliação deve estar entre 0.0 e 5.0.");
                }
                livro.setAvaliacao(avaliacao);
            } catch (NumberFormatException e) {
                throw new LivroExceptions("Erro - Avaliação deve ser um número decimal.");
            }
        }

        // Validar gênero
        if (genero == null || genero.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'genero'.");
        } else {
            livro.setGenero(genero.trim());
        }

        return livro;
    }
}
