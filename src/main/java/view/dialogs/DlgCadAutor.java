package view.dialogs;

import controller.PessoaController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Autor;
import model.dao.AutorDaoFile;
import model.dao.IDaoPessoa;
import view.TableModel.TMCadAutor;

public class DlgCadAutor extends javax.swing.JDialog {

    public DlgCadAutor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.habilitarCampo(false);
        this.limparCampos();
        this.editando = false;
        this.atualizarTabela();
        
    }
    
IDaoPessoa<Autor> autorRepo = new AutorDaoFile();
PessoaController<Autor> autorController = new PessoaController<>(autorRepo, Autor.class);
boolean editando = false;
    
    public void habilitarCampo(boolean tag){
        
        this.edtId.setEditable(tag);
        this.edtNome.setEditable(tag);
        this.edtCpf.setEditable(tag);
        
    }
    
    public void limparCampos(){
        
        this.edtNome.setText("");
        this.edtId.setText("");
        this.edtCpf.setText("");
        
    }

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
        txtId = new javax.swing.JLabel();
        edtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdAutor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE AUTOR");
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

        txtId.setText("ID:");

        txtNome.setText("NOME:");

        txtCpf.setText("CPF:");

        grdAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdAutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdAutor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(209, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId)
                    .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if(this.editando){
            autorController.atualizar(this.edtId.getText(), this.edtNome.getText(), this.edtCpf.getText(), null);
        }else{
       
            autorController.salvar(this.edtId.getText(), this.edtNome.getText(), this.edtCpf.getText(), null);
        }
        
        this.atualizarTabela();
        this.limparCampos();
        this.habilitarCampo(false);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.editando = false;
        this.habilitarCampo(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampo(false);
        this.limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int id = Integer.parseInt(this.edtId.getText());
        autorController.remover(autorController.buscar(id));
        this.limparCampos();
        this.habilitarCampo(false);
        this.atualizarTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editando = true;
        
        this.habilitarCampo(true);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void grdAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdAutorMouseClicked
        int linha = grdAutor.getSelectedRow();
        
        
        TMCadAutor tmCadUsuario = (TMCadAutor) grdAutor.getModel(); 
        Autor autor = tmCadUsuario.getObejctUsuario(linha);
        this.objetoParaCampo(autor);
    }//GEN-LAST:event_grdAutorMouseClicked

    public void objetoParaCampo(Autor p){
        this.edtId.setText(String.valueOf(p.getId()));
        this.edtNome.setText(p.getNome());
        this.edtCpf.setText(p.getCpf());
        
    }
    
    public void atualizarTabela() {
        
	TMCadAutor tmCadAutor = new TMCadAutor(autorController.listar());
		
        grdAutor.setModel(tmCadAutor);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtId;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTable grdAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtCpf;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
