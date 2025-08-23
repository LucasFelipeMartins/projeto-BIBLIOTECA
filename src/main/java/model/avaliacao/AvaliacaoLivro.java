package model.avaliacao;

import model.Livro;
import model.exceptions.LivroExceptions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AvaliacaoLivro {

    private Livro livro;

    public AvaliacaoLivro(Livro livro) {
        if (livro == null) {
            throw new LivroExceptions("Erro - Livro não pode ser nulo para avaliação.");
        }
        this.livro = livro;
    }

    /**
     * Adiciona uma avaliação ao livro (entre 0.0 e 5.0),
     * sempre arredondando para 1 casa decimal.
     */
    public void adicionarAvaliacao(double nota) {
        if (nota < 0.0 || nota > 5.0) {
            throw new LivroExceptions("Erro - Avaliação deve estar entre 0.0 e 5.0.");
        }
        // Arredonda a nota para 1 casa decimal
        BigDecimal bd = new BigDecimal(nota).setScale(1, RoundingMode.HALF_UP);
        double notaArredondada = bd.doubleValue();

        livro.addAvaliacao(notaArredondada);
        System.out.println("Avaliação " + notaArredondada + " adicionada ao livro: " + livro.getTitulo());
    }

    public Livro getLivro() {
        return livro;
    }
}
