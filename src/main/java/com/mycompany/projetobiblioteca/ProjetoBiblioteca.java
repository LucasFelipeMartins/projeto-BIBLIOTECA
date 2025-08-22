package com.mycompany.projetobiblioteca;

import controller.LivroController;
import controller.PessoaController;
import java.util.Arrays;
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
import model.recomendacao.RecomendacaoLivros;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

     
        // ===== Criando livros =====
        Livro livro1 = new Livro("O Pequeno Príncipe", Arrays.asList("Antoine de Saint-Exupéry"), 1943, null, "Infantil");
        livro1.addAvaliacao(4.0);
        livro1.addAvaliacao(5.0);

        Livro livro2 = new Livro("1984", Arrays.asList("George Orwell"), 1949, null, "Distopia");
        livro2.addAvaliacao(4.0);
        livro2.addAvaliacao(3.0);

        Livro livro3 = new Livro("Harry Potter", Arrays.asList("J.K. Rowling"), 1997, null, "Fantasia");
        livro3.addAvaliacao(5.0);

        Livro livro4 = new Livro("Dom Casmurro", Arrays.asList("Machado de Assis"), 1899,null, "Romance");
        livro4.addAvaliacao(4.0);

        List<Livro> todosLivros = Arrays.asList(livro1, livro2, livro3, livro4);

        // ===== Criando usuários =====
        Usuario usuario1 = new Usuario(1, "Lucas", "123456789", Arrays.asList(livro1), Arrays.asList("Distopia", "Fantasia"));
        Usuario usuario2 = new Usuario(2, "Mariana", "987654321", Arrays.asList(), Arrays.asList("Romance", "Infantil"));

        // ===== Gerando recomendações para Lucas =====
        RecomendacaoLivros recomendacaoLucas = new RecomendacaoLivros(usuario1, todosLivros);
        List<Livro> livrosRecomendadosLucas = recomendacaoLucas.gerarRecomendacoes();

        System.out.println("Recomendações para " + usuario1.getNome() + ":");
        livrosRecomendadosLucas.forEach(l -> System.out.println("- " + l.getTitulo()));

        // ===== Gerando recomendações para Mariana =====
        RecomendacaoLivros recomendacaoMariana = new RecomendacaoLivros(usuario2, todosLivros);
        List<Livro> livrosRecomendadosMariana = recomendacaoMariana.gerarRecomendacoes();

        System.out.println("\nRecomendações para " + usuario2.getNome() + ":");
        livrosRecomendadosMariana.forEach(l -> System.out.println("- " + l.getTitulo()));
    }
}
