package com.mycompany.projetobiblioteca;

import controller.LivroController;
import controller.PessoaController;
import model.Autor;
import model.Livro;
import model.Usuario;
import model.dao.AutorDaoFile;
import model.dao.IDaoLivro;
import model.dao.IDaoPessoa;
import model.dao.LivroDaoFile;
import model.dao.UsuarioDaoFile;

import java.util.Arrays;
import java.util.List;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

        try {
            // ===== CRIAR AUTORES =====
            IDaoPessoa<Autor> autorRepo = new AutorDaoFile();
            PessoaController<Autor> autorController = new PessoaController<>(autorRepo, Autor.class);

            autorController.salvar("1", "Lucas Felipe", "123456789", null);
            autorController.salvar("2", "Mariana Silva", "987654321", null);

            System.out.println("Autores cadastrados:");
            autorController.listar().forEach(System.out::println);

            // ===== CRIAR USUÁRIOS =====
            IDaoPessoa<Usuario> usuarioRepo = new UsuarioDaoFile();
            PessoaController<Usuario> usuarioController = new PessoaController<>(usuarioRepo, Usuario.class);

            usuarioController.salvar("1", "Diego", "555555555", Arrays.asList("Aventura", "Ficção"));
            usuarioController.salvar("2", "Ana", "111222333", Arrays.asList("Romance"));

            System.out.println("\nUsuários cadastrados:");
            usuarioController.listar().forEach(System.out::println);

            // ===== CRIAR LIVROS =====
            IDaoLivro livroRepo = new LivroDaoFile();
            LivroController livroController = new LivroController(livroRepo);

            livroController.salvar(
                    "O Pequeno Príncipe",
                    Arrays.asList("Lucas Felipe"),
                    "1943",
                    null,
                    "Infantil"
            );

            livroController.salvar(
                    "1984",
                    Arrays.asList("Mariana Silva"),
                    "1949",
                    "4.5",
                    "Distopia"
            );

            System.out.println("\nLivros cadastrados:");
            livroController.listar().forEach(System.out::println);

            // ===== BUSCAR LIVRO =====
            System.out.println("\nBuscando livro '1984':");
            Livro buscado = livroController.buscar("1984");
            System.out.println("Livro encontrado: " + buscado);

            // ===== ATUALIZAR LIVRO =====
            Livro livroAtualizado = new Livro(
                    "1984",
                    Arrays.asList("Mariana Silva"),
                    1949,
                    5.0,
                    "Ficção Científica"
            );
            livroController.atualizar("1984", livroAtualizado);

            System.out.println("\nLivros após atualização:");
            livroController.listar().forEach(System.out::println);

            // ===== REMOVER LIVRO =====
            livroController.remover(livroAtualizado);
            System.out.println("\nLivros após remoção:");
            livroController.listar().forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
