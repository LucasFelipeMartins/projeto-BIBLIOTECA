package model.recomendacao;

import model.Usuario;
import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoLivros {

    private Usuario usuario;
    private List<Livro> todosLivros;

    public RecomendacaoLivros(Usuario usuario, List<Livro> todosLivros) {
        this.usuario = usuario;
        
        this.todosLivros = (todosLivros != null) ? todosLivros : new ArrayList<>();
    }

    public List<Livro> gerarRecomendacoes() {
        List<Livro> recomendados = new ArrayList<>();

        
        List<String> livrosLidos = (usuario.getLstLivros() != null) ? usuario.getLstLivros() : new ArrayList<>();
        List<String> generosPref = (usuario.getLstGenero() != null) ? usuario.getLstGenero() : new ArrayList<>();

        for (Livro livro : todosLivros) {
            // Já foi lido?
            if (livrosLidos.contains(livro.getTitulo())) continue;

            // Gênero preferido?
            if (!generosPref.contains(livro.getGenero())) continue;

            // Média das avaliações
            double media = (livro.getAvaliacoes() == null || livro.getAvaliacoes().isEmpty())
                    ? 0.0
                    : livro.getAvaliacoes().stream()
                          .mapToDouble(Double::doubleValue)
                          .average()
                          .orElse(0.0);

            if (media > 3.0) {
                recomendados.add(livro);
            }
        }

        return recomendados;
    }
}
