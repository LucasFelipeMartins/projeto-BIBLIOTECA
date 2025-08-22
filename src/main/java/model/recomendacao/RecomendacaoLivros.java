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
        this.todosLivros = todosLivros;
    }

    public List<Livro> gerarRecomendacoes() {
        List<Livro> recomendados = new ArrayList<>();

        for (Livro livro : todosLivros) {
            // Já foi lido?
            if (usuario.getLstLivros().contains(livro)) continue;

            // Gênero preferido?
            if (!usuario.getLstGenero().contains(livro.getGenero())) continue;

            // Média das avaliações
            double media = livro.getAvaliacoes().isEmpty() ? 0.0 :
                    livro.getAvaliacoes().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            if (media > 3.0) {
                recomendados.add(livro);
            }
        }

        return recomendados;
    }
}
