package view.dialogs;

import controller.LivroController;
import java.util.List;
import javax.swing.JOptionPane;
import model.Livro;
import model.Usuario;
import model.avaliacao.AvaliacaoLivro;
import model.dao.LivroDaoFile;
import model.dao.UsuarioDaoFile;
import view.TableModel.TMCadLivro;

public class DlgAdcionarLivro extends javax.swing.JDialog {

    Usuario user;

    LivroDaoFile repositorio = new LivroDaoFile();
    LivroController livroController = new LivroController(repositorio);   

    UsuarioDaoFile reposit = new UsuarioDaoFile();
    
    public DlgAdcionarLivro(java.awt.Dialog parent, boolean modal, Usuario u) {
        super(parent, modal);
        initComponents();
        this.atualizarTabela();
        user = u;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdLivro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("MARCAR LIVRO COMO LIDO");
        jPanel1.add(jLabel1);

        jLabel2.setText("ESCOLHA O LIVRO LIDO PELO USUARIO:");

        grdLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdLivro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void grdLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdLivroMouseClicked
        int linha = grdLivro.getSelectedRow();
        if (linha < 0) return; // Nenhuma linha selecionada

        TMCadLivro tmCadLivro = (TMCadLivro) grdLivro.getModel();
        Livro l = tmCadLivro.getObejctLivro(linha);

        if (l != null) {
            reposit.addLivro(user, l.getTitulo());
            
        }
        
        boolean notaValida = false;
        while (!notaValida) {
            String input = JOptionPane.showInputDialog(this, "Digite uma nota para o livro (0.0 a 5.0):");
            if (input == null) break; // usuário cancelou
            
            try {
                double nota = Double.parseDouble(input.replace(",", "."));
                if (nota < 0 || nota > 5) {
                    JOptionPane.showMessageDialog(this, "A nota deve estar entre 0 e 5!");
                } else {
                    notaValida = true;

                    // Adiciona avaliação ao livro
                    l.addAvaliacao(nota); // usa seu método no Livro

                    // Atualiza o livro no JSON usando o método existente
                    livroController.atualizar(l.getTitulo(), l); 

                    JOptionPane.showMessageDialog(this, "Livro adicionado e avaliado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Digite um número válido!");
            }
        }
    }//GEN-LAST:event_grdLivroMouseClicked

    public void atualizarTabela() {
        
	TMCadLivro tmCadAluno = new TMCadLivro(livroController.listar());
		
        grdLivro.setModel(tmCadAluno);
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grdLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
