package view.dialogs;

import controller.LivroController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Livro;
import model.dao.LivroDaoFile;
import model.valid.ValidarLivro;
import view.TableModel.TMCadLivro;

public class DlgCadLivro extends javax.swing.JDialog {

    public DlgCadLivro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.habilitarCampo(false);
        this.limparCampos();
        this.editando = false;
        this.atualizarTabela();
        
    }

    LivroDaoFile repositorio = new LivroDaoFile();
    LivroController livroController = new LivroController(repositorio);
    boolean editando = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        txtAutor = new javax.swing.JLabel();
        edtAutor = new javax.swing.JTextField();
        txtGenero = new javax.swing.JLabel();
        txtAno = new javax.swing.JLabel();
        edtTitulo = new javax.swing.JTextField();
        edtGenero = new javax.swing.JTextField();
        edtAno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdLivro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE LIVROS");
        jPanel1.add(jLabel1);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_32x32.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit3_32x32.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel_32x32.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/del_32x32.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo_32x32.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNovo);

        txtTitulo.setText("TITULO:");

        txtAutor.setText("AUTORES:");

        txtGenero.setText("GENERO:");

        txtAno.setText("ANO:");

        jLabel6.setText("obs:(Coloque os Autores separados por \" , \")");

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAutor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo)
                    .addComponent(txtGenero)
                    .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAno)
                    .addComponent(edtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutor)
                    .addComponent(edtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.editando = false;
        this.habilitarCampo(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        livroController.remover(livroController.buscar(this.edtTitulo.getText()));
        this.limparCampos();
        this.habilitarCampo(false);
        this.atualizarTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampo(true);
        this.limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String autoresDigitados = this.edtAutor.getText();
        List<String> lstAutor = Arrays.stream(autoresDigitados.split(",")).map(String::trim).collect(Collectors.toList());
        
        if(this.editando){
            ValidarLivro valid = new ValidarLivro();
            Livro l = valid.validacao(this.edtTitulo.getText(), lstAutor, this.edtAno.getText(), null, this.edtGenero.getText());
            livroController.atualizar(this.edtTitulo.getText(), l);
        }else{
       
            livroController.salvar(this.edtTitulo.getText(), lstAutor, this.edtAno.getText(), null , this.edtGenero.getText());
        }
        this.atualizarTabela();
        this.limparCampos();
        this.habilitarCampo(false);
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editando = true;
        
        this.habilitarCampo(true);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void grdLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdLivroMouseClicked
        int linha = grdLivro.getSelectedRow();
        
        
        TMCadLivro tmCadUsuario = (TMCadLivro) grdLivro.getModel(); 
        Livro l = tmCadUsuario.getObejctLivro(linha);
        this.objetoParaCampo(l);
    }//GEN-LAST:event_grdLivroMouseClicked

    public void objetoParaCampo(Livro l){
        this.edtAno.setText(String.valueOf(l.getAno()));
        this.edtTitulo.setText(l.getTitulo());
        this.edtGenero.setText(l.getGenero());

        // se quiser exibir os gêneros no campo edtGeneros, separados por vírgula:
        if (l.getLstNomeAutor() != null) {
            this.edtAutor.setText(String.join(", ", l.getLstNomeAutor()));
        }
    
    }
    
    public void habilitarCampo(boolean tag){
        
        this.edtTitulo.setEditable(tag);
        this.edtAno.setEditable(tag);
        this.edtGenero.setEditable(tag);
        this.edtAutor.setEditable(tag);
        
    }
    
    public void limparCampos(){
        
        this.edtTitulo.setText("");
        this.edtAno.setText("");
        this.edtGenero.setText("");
        this.edtAutor.setText("");
        
    }

    public void atualizarTabela() {
        
	TMCadLivro tmCadAluno = new TMCadLivro(livroController.listar());
		
        grdLivro.setModel(tmCadAluno);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtAno;
    private javax.swing.JTextField edtAutor;
    private javax.swing.JTextField edtGenero;
    private javax.swing.JTextField edtTitulo;
    private javax.swing.JTable grdLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtAno;
    private javax.swing.JLabel txtAutor;
    private javax.swing.JLabel txtGenero;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
