package view.gui;

import view.dialogs.DlgCadAutor;
import view.dialogs.DlgCadLivro;
import view.dialogs.DlgCadUsuario;
import view.dialogs.DlgRecomendacao;

public class FrHome extends javax.swing.JFrame {

    public FrHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCadUsuario = new javax.swing.JButton();
        btnCadAutor = new javax.swing.JButton();
        btnCadLivro = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRecomendacao = new javax.swing.JButton();
        btnAddLivro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("BIBLIOTECA");
        jPanel1.add(jLabel1);

        btnCadUsuario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnCadUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avatar-de-perfil.png"))); // NOI18N
        btnCadUsuario.setText("CAD DE USUARIO");
        btnCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadUsuario);

        btnCadAutor.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnCadAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homem-de-negocios.png"))); // NOI18N
        btnCadAutor.setText("CAD DE AUTOR");
        btnCadAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadAutorActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadAutor);

        btnCadLivro.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnCadLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abra-o-livro.png"))); // NOI18N
        btnCadLivro.setText("CAD DE LIVRO");
        btnCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadLivroActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadLivro);

        btnRecomendacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRecomendacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pilha-de-livros.png"))); // NOI18N
        btnRecomendacao.setText("SISTEMA DE RECOMENDAÇÔES");
        btnRecomendacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecomendacaoActionPerformed(evt);
            }
        });
        jPanel3.add(btnRecomendacao);

        btnAddLivro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAddLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/livros.png"))); // NOI18N
        btnAddLivro.setText("ADCIONAR LIVRO LIDO");
        jPanel3.add(btnAddLivro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 302, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadUsuarioActionPerformed
        DlgCadUsuario tela = new DlgCadUsuario(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnCadUsuarioActionPerformed

    private void btnCadAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadAutorActionPerformed
        DlgCadAutor tela = new DlgCadAutor(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnCadAutorActionPerformed

    private void btnCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadLivroActionPerformed
        DlgCadLivro tela = new DlgCadLivro(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnCadLivroActionPerformed

    private void btnRecomendacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecomendacaoActionPerformed
        DlgRecomendacao tela = new DlgRecomendacao(this,true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnRecomendacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLivro;
    private javax.swing.JButton btnCadAutor;
    private javax.swing.JButton btnCadLivro;
    private javax.swing.JButton btnCadUsuario;
    private javax.swing.JButton btnRecomendacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
