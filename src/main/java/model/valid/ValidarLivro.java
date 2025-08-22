package model.valid;

import java.util.List;
import model.Livro;
import model.exceptions.LivroExceptions;

public class ValidarLivro {

    public Livro validacao(String titulo, List<String> lstNomeAutor, String anoStr, String avaliacaoStr, String genero) {

        // Cria livro vazio com listas já inicializadas
        Livro livro = new Livro();
        
        // Validar título
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'titulo'.");
        }
        livro.setTitulo(titulo.trim());

        // Validar lista de autores (obrigatório pelo menos 1)
        if (lstNomeAutor == null || lstNomeAutor.isEmpty()) {
            throw new LivroExceptions("Erro - Deve haver pelo menos um autor.");
        }
        livro.setLstNomeAutor(lstNomeAutor);

        // Validar ano
        if (anoStr == null || anoStr.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'ano'.");
        }
        try {
            int ano = Integer.parseInt(anoStr.trim());
            if (ano <= 0) {
                throw new LivroExceptions("Erro - Ano inválido.");
            }
            livro.setAno(ano);
        } catch (NumberFormatException e) {
            throw new LivroExceptions("Erro - Ano deve ser um número inteiro.");
        }

        // Validar avaliação (opcional)
        if (avaliacaoStr != null && !avaliacaoStr.trim().isEmpty()) {
            try {
                double nota = Double.parseDouble(avaliacaoStr.trim());
                if (nota < 0.0 || nota > 5.0) {
                    throw new LivroExceptions("Erro - Avaliação deve estar entre 0.0 e 5.0.");
                }
                livro.addAvaliacao(nota);
            } catch (NumberFormatException e) {
                throw new LivroExceptions("Erro - Avaliação deve ser um número decimal.");
            }
        }

        // Validar gênero
        if (genero == null || genero.trim().isEmpty()) {
            throw new LivroExceptions("Erro - Campo vazio: 'genero'.");
        }
        livro.setGenero(genero.trim());

        return livro;
    }
}
