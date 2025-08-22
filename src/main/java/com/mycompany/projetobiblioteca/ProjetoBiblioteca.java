package com.mycompany.projetobiblioteca;

import controller.LivroController;
import controller.PessoaController;
import model.Autor;
import model.Usuario;
import model.Pessoa;
import model.dao.PessoaDaoFile;
import model.file.ISerializador;
import model.file.SerializadorJSON;
import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.dao.IDaoLivro;
import model.dao.IDaoPessoa;
import model.dao.LivroDaoFile;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

        IDaoPessoa repositorio = new PessoaDaoFile();
        IDaoLivro reposit = new LivroDaoFile();
        LivroController gerente = new LivroController(reposit); 
      
        Livro l = new Livro("Vida", null, 2004, 5.0, "Gospel");
        gerente.remover(l);

       
    }
}
