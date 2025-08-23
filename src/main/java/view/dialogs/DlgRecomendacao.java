package view.dialogs;

import controller.LivroController;
import controller.PessoaController;
import model.Usuario;
import model.dao.IDaoPessoa;
import model.dao.LivroDaoFile;
import model.dao.UsuarioDaoFile;
import model.recomendacao.RecomendacaoLivros;
import view.TableModel.TMCadUsuario;

public class DlgRecomendacao extends javax.swing.JDialog {

    public DlgRecomendacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.atualizarTabela();
    }

IDaoPessoa<Usuario> usuarioRepo = new UsuarioDaoFile();
PessoaController<Usuario> usuarioController = new PessoaController<>(usuarioRepo, Usuario.class);    

LivroDaoFile repositorio = new LivroDaoFile();
LivroController livroController = new LivroController(repositorio);
    
    public void atualizarTabela() {
        
	TMCadUsuario tmCadUsuario = new TMCadUsuario(usuarioController.listar());
		
        grdUsuario.setModel(tmCadUsuario);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdUsuario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("RECOMENDAÇÔES DE LIVROS");
        jPanel1.add(jLabel1);

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

        jLabel2.setText("RECOMENDAR LIVRO PRA QUAL USUARIO?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void grdUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdUsuarioMouseClicked
        int linha = grdUsuario.getSelectedRow();
        
        
        TMCadUsuario tmCadUsuario = (TMCadUsuario) grdUsuario.getModel(); 
        Usuario user = tmCadUsuario.getObejctUsuario(linha);
            
      
        
        RecomendacaoLivros r = new RecomendacaoLivros(user, livroController.listar());
        
        DlgLivrosRecomendados tela = new DlgLivrosRecomendados(this, true, r.gerarRecomendacoes());
        tela.setVisible(true);
        
    }//GEN-LAST:event_grdUsuarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grdUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
