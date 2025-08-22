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
import view.gui.FrHome;

public class ProjetoBiblioteca {

    public static void main(String[] args) {

        FrHome tela = new FrHome();
        tela.setVisible(true);
       
    }
}
