/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestao.pizzaria.apresentacao;

import br.com.gestao.pizzaria.entidade.Usuario;
import br.com.gestao.pizzaria.excecao.GestaoPizzariaException;
import br.com.gestao.pizzaria.excecao.ValidarCamposPesquisaException;
import br.com.gestao.pizzaria.negocio.UsuarioBO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class PesquisarUsuarioForm extends javax.swing.JFrame {

    private List<Usuario> usuarios;

    private CadastrarUsuarioForm novoUsuarioForm;
    private CadastrarUsuarioForm editarUsuarioForm;

    /**
     * Creates new form PesquisarAlunosForm
     */
    public PesquisarUsuarioForm() {
        this.prepararTela();
    }

    private void prepararTela() {
        try {
            this.initComponents();
            this.carregarTabelaUsuarios();
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Usuários Cadastradas", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    public void carregarTabelaUsuarios() throws SQLException {
        UsuarioBO usuarioBO = new UsuarioBO();
        this.usuarios = usuarioBO.buscarTodos();

        ModeloTabelaUsuario modelo = new ModeloTabelaUsuario();
        tblResultado.setModel(modelo);
    }

    public void carregarTabelaPesquisaUsuarios() throws SQLException {

        ModeloTabelaUsuario modelo = new ModeloTabelaUsuario();
        tblResultado.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpPesquisarPor = new javax.swing.ButtonGroup();
        pnlFiltro = new javax.swing.JPanel();
        lblPesquisarPor = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        rdoNome = new javax.swing.JRadioButton();
        rdoNomeUsuario = new javax.swing.JRadioButton();
        lblPalavraPesquisada = new javax.swing.JLabel();
        txtPalavraPesquisada = new javax.swing.JTextField();
        btnLimparPesquisa = new javax.swing.JButton();
        pnlResultado = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários Cadastrados");
        setExtendedState(6);

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15))); // NOI18N

        lblPesquisarPor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPesquisarPor.setText("Pesquisar usuário por:");

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestao/pizzaria/icones/magnifying-glass11.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        grpPesquisarPor.add(rdoNome);
        rdoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNome.setText("Nome");

        grpPesquisarPor.add(rdoNomeUsuario);
        rdoNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNomeUsuario.setText("Nome de Usuario");

        lblPalavraPesquisada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPalavraPesquisada.setText("Insira a palavra ou parte da palavra a ser pesquisada:");

        btnLimparPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestao/pizzaria/icones/eraser8.png"))); // NOI18N
        btnLimparPesquisa.setText("Limpar");
        btnLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtPalavraPesquisada)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFiltroLayout.createSequentialGroup()
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLimparPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblPesquisarPor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPalavraPesquisada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addComponent(rdoNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNomeUsuario)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPesquisarPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNome)
                    .addComponent(rdoNomeUsuario))
                .addGap(18, 18, 18)
                .addComponent(lblPalavraPesquisada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPalavraPesquisada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnLimparPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
        );

        pnlResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15))); // NOI18N

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestao/pizzaria/icones/delete81.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestao/pizzaria/icones/edition2.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestao/pizzaria/icones/add133.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblResultado);

        btnFechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gestao/pizzaria/icones/clear5.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultadoLayout = new javax.swing.GroupLayout(pnlResultado);
        pnlResultado.setLayout(pnlResultadoLayout);
        pnlResultadoLayout.setHorizontalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(pnlResultadoLayout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlResultadoLayout.setVerticalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.exibirTelaCadastroUsuario();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.excluirUsuario();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editarUsuario();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        PesquisarUsuarioForm.this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.pesquisarUsuario();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPesquisaActionPerformed
        this.limparPesquisa();
    }//GEN-LAST:event_btnLimparPesquisaActionPerformed

    private void limparPesquisa(){
        this.limparCamposPesquisa();
        try {
            this.carregarTabelaUsuarios();
        } catch (SQLException e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Limpar Pesquisa", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void limparCamposPesquisa(){
        txtPalavraPesquisada.setText("");
    }
    private void pesquisarUsuario() {

        try {
            this.validarCamposPesquisa();
            String filtro = this.recuperarFiltro();
            String palavraPesquisada = this.recuperarPalavraPesquisada();

            UsuarioBO usuarioBO = new UsuarioBO();
            this.usuarios = usuarioBO.pesquisar(filtro, palavraPesquisada);

            this.carregarTabelaPesquisaUsuarios();

        } catch (GestaoPizzariaException e) {
            String mensagem = "Pesquisa não realizada:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            String mensagem = "Sua pesquisa não retornou nenhum resultado.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validarCamposPesquisa() {
        if ((!rdoNome.isSelected() && !rdoNomeUsuario.isSelected())
                || txtPalavraPesquisada.getText().trim().isEmpty()) {
            throw new ValidarCamposPesquisaException();
        }
    }

    private String recuperarFiltro() {

        String filtro;
        if (rdoNome.isSelected()) {
            filtro = "NOME";
        } else{
            filtro = "NOME_USUARIO";
        }
        return filtro;

    }

    private String recuperarPalavraPesquisada() {
        String palavraPesquisada =txtPalavraPesquisada.getText().trim();
        return palavraPesquisada;
    }

    private void editarUsuario() {
        int linhaSelecionada = tblResultado.getSelectedRow();
        if (linhaSelecionada != -1) {
            Usuario usuarioSelecionado = usuarios.get(linhaSelecionada);

            if (this.editarUsuarioForm != null) {
                this.editarUsuarioForm.dispose();
            }
            this.editarUsuarioForm = new CadastrarUsuarioForm(this, usuarioSelecionado);
            this.editarUsuarioForm.setVisible(true);
            PesquisarUsuarioForm.this.dispose();

        } else {
            String mensagem = "Nenhum Usuário Selecionado.";
            JOptionPane.showMessageDialog(this, mensagem, "Edição de Usuário", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void excluirUsuario() {
        try {
            int linhaSelecionada = tblResultado.getSelectedRow();
            if (linhaSelecionada != -1) {
                Usuario usuarioSelecionado = usuarios.get(linhaSelecionada);

                int resposta;
                String mensagem = "Deseja excluir o usuario: "
                        + usuarioSelecionado.getNome();
                String titulo = "Exclusão de Usuário";
                resposta = JOptionPane.showConfirmDialog(this,
                        mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    UsuarioBO usuarioBO = new UsuarioBO();
                    usuarioBO.excluir(usuarioSelecionado.getID());

                    String mensagemSuceso = "Usuário: "
                            + usuarioSelecionado.getNome() + ", "
                            + "excluído com sucesso.";
                    JOptionPane.showMessageDialog(this,
                            mensagemSuceso, titulo,
                            JOptionPane.INFORMATION_MESSAGE);

                    this.carregarTabelaUsuarios();
                }
            } else {
                String mensagem = "Nenhum usuário selecionado.";
                JOptionPane.showMessageDialog(this,
                        mensagem,
                        "Exclusão de Usuário",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Exclusão de Usuário", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }

    }

    private void exibirTelaCadastroUsuario() {
        if (this.novoUsuarioForm == null) {
            this.novoUsuarioForm = new CadastrarUsuarioForm();
        }
        novoUsuarioForm.setVisible(true);
        novoUsuarioForm.toFront();
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisarUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisarUsuarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimparPesquisa;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup grpPesquisarPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPalavraPesquisada;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JPanel pnlResultado;
    private javax.swing.JRadioButton rdoNome;
    private javax.swing.JRadioButton rdoNomeUsuario;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtPalavraPesquisada;
    // End of variables declaration//GEN-END:variables

    private class ModeloTabelaUsuario extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "Nome";
            } else {
                return "Nome de Usuário";
            }
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            if (columnIndex == 0) {
                return usuario.getNome();
            } else{
                return usuario.getNomeUsuario();
            }
        }
    }
}
