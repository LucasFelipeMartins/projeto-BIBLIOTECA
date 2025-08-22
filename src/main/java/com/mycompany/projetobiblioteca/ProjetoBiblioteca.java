package com.mycompany.projetobiblioteca;

import controller.PessoaController;
import model.Autor;
import model.Usuario;
import model.dao.AutorDaoFile;
import model.dao.IDaoPessoa;
import model.dao.UsuarioDaoFile;

import java.util.List;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

        // ===== Teste com Autor =====
        IDaoPessoa<Autor> autorRepo = new AutorDaoFile();
        PessoaController<Autor> autorController = new PessoaController<>(autorRepo, Autor.class);

        // Salvar autores
        autorController.salvar("1", "Lucas Felipe", "123456789", null);
        autorController.salvar("3", "Mariana", "987654321", null);
        System.out.println("Autores cadastrados:");
        autorController.listar().forEach(System.out::println);

        // Atualizar autor
        autorController.atualizar("3", "Mariana Silva", "987654321", null);
        System.out.println("\nAutores após atualização:");
        autorController.listar().forEach(System.out::println);

        // Remover autor
        Autor autorParaRemover = autorController.buscar(1);
        autorController.remover(autorParaRemover);
        System.out.println("\nAutores após remoção:");
        autorController.listar().forEach(System.out::println);

        // ===== Teste com Usuario =====
        IDaoPessoa<Usuario> usuarioRepo = new UsuarioDaoFile();
        PessoaController<Usuario> usuarioController = new PessoaController<>(usuarioRepo, Usuario.class);

        // Salvar usuários
        usuarioController.salvar("5", "Diego", "555555555", List.of("Aventura", "Ficção"));
        usuarioController.salvar("6", "Ana", "111222333", List.of("Romance"));
        System.out.println("\nUsuarios cadastrados:");
        usuarioController.listar().forEach(System.out::println);

        // Atualizar usuário
        usuarioController.atualizar("5", "Diego Silva", "555555555", List.of("Ficção", "Aventura"));
        System.out.println("\nUsuarios após atualização:");
        usuarioController.listar().forEach(System.out::println);

        // Remover usuário
        Usuario usuarioParaRemover = usuarioController.buscar(6);
        usuarioController.remover(usuarioParaRemover);
        System.out.println("\nUsuarios após remoção:");
        usuarioController.listar().forEach(System.out::println);
    }
}
