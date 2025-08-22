package com.mycompany.projetobiblioteca;

import controller.PessoaController;
import model.Autor;
import model.Usuario;
import model.dao.AutorDaoFile;
import model.dao.UsuarioDaoFile;
import model.dao.IDaoPessoa;

import java.util.ArrayList;
import java.util.List;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

        // ======== TESTE AUTOR ========
        IDaoPessoa<Autor> autorRepo = new AutorDaoFile();
        PessoaController<Autor> autorController = new PessoaController<>(autorRepo);

        // Criar autores
        Autor autor1 = new Autor(1, "Lucas", "123456789", null);
        Autor autor2 = new Autor(2, "Maria", "987654321", null);

        // Salvar autores
        autorController.salvar(autor1);
        autorController.salvar(autor2);

        // Listar autores
        System.out.println("Autores cadastrados:");
        autorController.listar().forEach(System.out::println);

        // Buscar autor
        Autor buscado = autorController.buscar(1);
        System.out.println("Autor buscado: " + buscado);

        // Atualizar autor
        Autor autorAtualizado = new Autor(1, "Lucas Felipe", "123456789", null);
        autorController.atualizar(1, autorAtualizado);
        System.out.println("Autores após atualização:");
        autorController.listar().forEach(System.out::println);

        // Remover autor
        autorController.remover(autor2);
        System.out.println("Autores após remoção:");
        autorController.listar().forEach(System.out::println);

        // ======== TESTE USUÁRIO ========
        IDaoPessoa<Usuario> usuarioRepo = new UsuarioDaoFile();
        PessoaController<Usuario> usuarioController = new PessoaController<>(usuarioRepo);

        // Criar usuários
        List<String> generos = new ArrayList<>();
        generos.add("Ficção");
        generos.add("Aventura");

        Usuario user1 = new Usuario(1, "Diego", "111222333", null, generos);
        Usuario user2 = new Usuario(2, "Ana", "444555666", null, null);

        // Salvar usuários
        usuarioController.salvar(user1);
        usuarioController.salvar(user2);

        // Listar usuários
        System.out.println("Usuários cadastrados:");
        usuarioController.listar().forEach(System.out::println);

        // Buscar usuário
        Usuario userBuscado = usuarioController.buscar(1);
        System.out.println("Usuário buscado: " + userBuscado);

        // Atualizar usuário
        user1.setNome("Diego Silva");
        usuarioController.atualizar(1, user1);
        System.out.println("Usuários após atualização:");
        usuarioController.listar().forEach(System.out::println);

        // Remover usuário
        usuarioController.remover(user2);
        System.out.println("Usuários após remoção:");
        usuarioController.listar().forEach(System.out::println);
    }
}
