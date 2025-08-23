package view.dialogs;

import controller.PessoaController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Usuario;
import model.dao.IDaoPessoa;
import model.dao.UsuarioDaoFile;
import view.TableModel.TMCadUsuario;


public class DlgCadUsuario extends javax.swing.JDialog {
    public DlgCadUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.habilitarCampo(false);
        this.limparCampos();
        this.editando = false;
        this.atualizarTabela();
        
    }

IDaoPessoa<Usuario> usuarioRepo = new UsuarioDaoFile();
PessoaController<Usuario> usuarioController = new PessoaController<>(usuarioRepo, Usuario.class);
boolean editando = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        edtId = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtCpf = new javax.swing.JTextField();
        edtGenero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE USUARIO");
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

        lblId.setText("ID:");

        lblNome.setText("NOME:");

        lblCpf.setText("CPF:");

        lblGenero.setText("GENEROS:");

        jLabel6.setText("obs:(Coloque os generos separados por \" , \")");

        grdUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblCpf)
                    .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblGenero)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void habilitarCampo(boolean tag){
        
        this.edtId.setEditable(tag);
        this.edtNome.setEditable(tag);
        this.edtCpf.setEditable(tag);
        this.edtGenero.setEditable(tag);
        
    }
    
    public void limparCampos(){
        
        this.edtNome.setText("");
        this.edtId.setText("");
        this.edtCpf.setText("");
        this.edtGenero.setText("");
        
    }
    
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
        usuarioController.remover(usuarioController.buscar(id));
        this.limparCampos();
        this.habilitarCampo(false);
        this.atualizarTabela();
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String generosDigitados = this.edtGenero.getText();
        List<String> lstGeneros = Arrays.stream(generosDigitados.split(",")).map(String::trim).collect(Collectors.toList());
        
        if(this.editando){
            usuarioController.atualizar(this.edtId.getText(), this.edtNome.getText(), this.edtCpf.getText(), lstGeneros );
        }else{
       
            usuarioController.salvar(this.edtId.getText(), this.edtNome.getText(), this.edtCpf.getText(), lstGeneros );
        }
        
        this.atualizarTabela();
        this.limparCampos();
        this.habilitarCampo(false);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editando = true;
        
        this.habilitarCampo(true);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void grdUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdUsuarioMouseClicked
        int linha = grdUsuario.getSelectedRow();
        
        
        TMCadUsuario tmCadUsuario = (TMCadUsuario) grdUsuario.getModel(); 
        Usuario user = tmCadUsuario.getObejctUsuario(linha);
        this.objetoParaCampo(user);
        
    }//GEN-LAST:event_grdUsuarioMouseClicked

    public void objetoParaCampo(Usuario p){
        this.edtId.setText(String.valueOf(p.getId()));
        this.edtNome.setText(p.getNome());
        this.edtCpf.setText(p.getCpf());

        // se quiser exibir os gêneros no campo edtGeneros, separados por vírgula:
        if (p.getLstGenero() != null) {
            this.edtGenero.setText(String.join(", ", p.getLstGenero()));
        }
        
    }
    
    public void atualizarTabela() {
        
	TMCadUsuario tmCadUsuario = new TMCadUsuario(usuarioController.listar());
		
        grdUsuario.setModel(tmCadUsuario);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtGenero;
    private javax.swing.JTextField edtId;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTable grdUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables
}
