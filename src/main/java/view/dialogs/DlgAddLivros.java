package view.dialogs;

import controller.PessoaController;
import model.Usuario;
import model.dao.IDaoPessoa;
import model.dao.UsuarioDaoFile;
import view.TableModel.TMCadUsuario;

public class DlgAddLivros extends javax.swing.JDialog {

    public DlgAddLivros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("MARCAR LIVRO COMO LIDO");
        jPanel1.add(jLabel1);

        jLabel2.setText("QUAL USUARIO DESEJA ADCIONAR UM LIVRO:");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

IDaoPessoa<Usuario> usuarioRepo = new UsuarioDaoFile();
PessoaController<Usuario> usuarioController = new PessoaController<>(usuarioRepo, Usuario.class);  

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void grdUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdUsuarioMouseClicked
        int linha = grdUsuario.getSelectedRow();       
        
        TMCadUsuario tmCadUsuario = (TMCadUsuario) grdUsuario.getModel(); 
        Usuario user = tmCadUsuario.getObejctUsuario(linha);
        DlgAdcionarLivro tela = new DlgAdcionarLivro(this, true, user);
        tela.setVisible(true);
        
    }//GEN-LAST:event_grdUsuarioMouseClicked

    public void atualizarTabela() {
        
	TMCadUsuario tmCadUsuario = new TMCadUsuario(usuarioController.listar());
		
        grdUsuario.setModel(tmCadUsuario);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grdUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
