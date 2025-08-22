package model.avaliacao;

import model.Livro;
import model.exceptions.LivroExceptions;

public class AvaliacaoLivro {

    private Livro livro;

    public AvaliacaoLivro(Livro livro) {
        if (livro == null) {
            throw new LivroExceptions("Erro - Livro não pode ser nulo para avaliação.");
        }
        this.livro = livro;
    }

    /**
     * Adiciona uma avaliação ao livro.
     * @param nota valor da avaliação entre 0.0 e 5.0
     */
    public void adicionarAvaliacao(double nota) {
        if (nota < 0.0 || nota > 5.0) {
            throw new LivroExceptions("Erro - Avaliação deve estar entre 0.0 e 5.0.");
        }
        livro.addAvaliacao(nota);
        System.out.println("Avaliação " + nota + " adicionada ao livro: " + livro.getTitulo());
    }

    /**
     * Calcula a média das avaliações do livro.
     * @return média das avaliações
     */
    public double calcularMedia() {
        if (livro.getAvaliacoes()== null || livro.getAvaliacoes().isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        for (double nota : livro.getAvaliacoes()) {
            soma += nota;
        }
        return soma / livro.getAvaliacoes().size();
    }

    public Livro getLivro() {
        return livro;
    }
}
