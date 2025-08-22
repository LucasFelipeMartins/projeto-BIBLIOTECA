package com.mycompany.projetobiblioteca;

import controller.LivroController;
import controller.PessoaController;
import model.Livro;
import model.Autor;
import model.Usuario;
import model.dao.LivroDaoFile;
import model.dao.AutorDaoFile;
import model.dao.UsuarioDaoFile;
import model.dao.IDaoLivro;
import model.dao.IDaoPessoa;

import java.util.List;
import model.avaliacao.AvaliacaoLivro;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

       // ===== Inicializando repositório e controller =====
        IDaoLivro livroRepo = new LivroDaoFile();
        LivroController livroController = new LivroController(livroRepo);

        // ===== Criando e salvando livros =====
        livroController.salvar("O Pequeno Príncipe", List.of("Antoine de Saint-Exupéry"), "1943", null, "Infantil");
        livroController.salvar("1984", List.of("George Orwell"), "1949", null, "Distopia");

        System.out.println("Livros cadastrados:");
        livroController.listar().forEach(System.out::println);

        // ===== Avaliando livros =====
        Livro livro1984 = livroController.buscar("1984");
        AvaliacaoLivro avaliar1984 = new AvaliacaoLivro(livro1984);

        avaliar1984.adicionarAvaliacao(4.5);
        avaliar1984.adicionarAvaliacao(3.8);
        avaliar1984.adicionarAvaliacao(5.0);

        double media1984 = avaliar1984.calcularMedia();
        System.out.println("\nMédia de avaliações do livro '1984': " + media1984);

        // Atualizando livro com as avaliações
        livroController.atualizar("1984", avaliar1984.getLivro());

        // ===== Avaliando outro livro =====
        Livro pequenoPrincipe = livroController.buscar("O Pequeno Príncipe");
        AvaliacaoLivro avaliarPrincipe = new AvaliacaoLivro(pequenoPrincipe);

        avaliarPrincipe.adicionarAvaliacao(5.0);
        avaliarPrincipe.adicionarAvaliacao(4.8);

        double mediaPrincipe = avaliarPrincipe.calcularMedia();
        System.out.println("\nMédia de avaliações do livro 'O Pequeno Príncipe': " + mediaPrincipe);

        livroController.atualizar("O Pequeno Príncipe", avaliarPrincipe.getLivro());

        // ===== Listar livros atualizados =====
        System.out.println("\nLivros após avaliações:");
        livroController.listar().forEach(System.out::println);
    }
}
