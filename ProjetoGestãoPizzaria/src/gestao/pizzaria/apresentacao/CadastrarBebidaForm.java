/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao.pizzaria.apresentacao;

import gestao.pizzaria.entidade.Bebida;
import gestao.pizzaria.excecao.CampoObrigatorioException;
import gestao.pizzaria.excecao.GestaoPizzariaException;
import gestao.pizzaria.negocio.BebidaBO;
import javax.swing.JOptionPane;

/**
 *
 * @author melot_000
 */
public class CadastrarBebidaForm extends javax.swing.JFrame {

    private PesquisarBebidaForm pesquisarBebidaForm;
    private Bebida bebida;

    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarBebidaForm() {
        this.bebida = new Bebida();
        initComponents();
    }

    public CadastrarBebidaForm(PesquisarBebidaForm pesquisarBebidaForm, Bebida bebidaParaEdicao) {
        this.pesquisarBebidaForm = pesquisarBebidaForm;

        this.bebida = bebidaParaEdicao;
        initComponents();
        this.inicializarCamposTela();

    }

    private void inicializarCamposTela() {
        txtMarca.setText(bebida.getMarca());
        txtSabor.setText(bebida.getSabor());
        txtVolume.setText(bebida.getVolume());

        String preco = Double.toString(bebida.getPreco());
        txtPreco.setText(preco);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadastroDeBebida = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblSabor = new javax.swing.JLabel();
        lblCampoObrigatorio = new javax.swing.JLabel();
        txtSabor = new javax.swing.JTextField();
        lblVolume = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblPreco = new javax.swing.JLabel();
        txtVolume = new javax.swing.JTextField();
        txtPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Bebidas");
        setExtendedState(6);

        pnlCadastroDeBebida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de bebidas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lblMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMarca.setText("*Marca:");

        txtMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        lblSabor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSabor.setText("*Sabor:");

        lblCampoObrigatorio.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblCampoObrigatorio.setText("Campos com (*) são obrigtórios.");

        txtSabor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaborActionPerformed(evt);
            }
        });

        lblVolume.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVolume.setText("*Volume (ex:. 2 L | 500 ml):");

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPreco.setText("*Preço R$:");

        txtVolume.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVolumeActionPerformed(evt);
            }
        });

        txtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPreco.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlCadastroDeBebidaLayout = new javax.swing.GroupLayout(pnlCadastroDeBebida);
        pnlCadastroDeBebida.setLayout(pnlCadastroDeBebidaLayout);
        pnlCadastroDeBebidaLayout.setHorizontalGroup(
            pnlCadastroDeBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroDeBebidaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlCadastroDeBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(txtSabor)
                    .addComponent(lblPreco)
                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(lblMarca)
                    .addComponent(lblSabor)
                    .addComponent(lblCampoObrigatorio)
                    .addComponent(lblVolume)
                    .addGroup(pnlCadastroDeBebidaLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtVolume))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        pnlCadastroDeBebidaLayout.setVerticalGroup(
            pnlCadastroDeBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroDeBebidaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblCampoObrigatorio)
                .addGap(18, 18, 18)
                .addComponent(lblMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSabor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblVolume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnlCadastroDeBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCadastroDeBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadastroDeBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaborActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaborActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
       this.fecharCadastroBebida();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.salvarBebida();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVolumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolumeActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarBebidaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarBebidaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarBebidaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarBebidaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarBebidaForm().setVisible(true);
            }
        });
    }

    private void salvarBebida() {
        try {
            this.validarCamposObrigatorios();
            this.recuperarCamposTela();

            BebidaBO bebidaBO = new BebidaBO();
            String tituloMensagem;

            if (bebida.getId() == -1) {
                tituloMensagem = "Cadastro de bebida";
                bebidaBO.inserir(bebida);
                JOptionPane.showMessageDialog(this, "Bebida cadastrada com sucesso!", tituloMensagem, JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                tituloMensagem = "Editar bebida";
                bebidaBO.alterar(bebida);
                JOptionPane.showMessageDialog(this, "Bebida alterada com sucesso!", tituloMensagem, JOptionPane.INFORMATION_MESSAGE);
                if (pesquisarBebidaForm == null) {
                    pesquisarBebidaForm = new PesquisarBebidaForm();
                }
                this.fecharCadastroBebida();
            }
            this.limparCamposTela();
        } catch (GestaoPizzariaException e) {
            String mensagem = "Erro ao realizar cadastro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Cadastro de bebida", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Cadastro de bebida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCamposTela() {
        txtMarca.setText("");
        txtSabor.setText("");
        txtVolume.setText("");
        txtPreco.setText("");
    }

    private void recuperarCamposTela(){        
        bebida.setMarca(txtMarca.getText());
        bebida.setSabor(txtSabor.getText());
        bebida.setVolume(txtVolume.getText());

        String precoString = txtPreco.getText();
        precoString = precoString.replace(",", ".");

        double preco = Double.parseDouble(precoString);
        bebida.setPreco(preco);
    }

    private void validarCamposObrigatorios() {
        if (txtMarca.getText().trim().isEmpty()
                || txtSabor.getText().trim().isEmpty()
                || txtVolume.getText().trim().isEmpty()
                || txtPreco.getText().trim().isEmpty()) {
            throw new CampoObrigatorioException();
        }
    }
    
    private void fecharCadastroBebida(){
        CadastrarBebidaForm.this.dispose();
        if (pesquisarBebidaForm == null) {
            pesquisarBebidaForm = new PesquisarBebidaForm();
        }
        pesquisarBebidaForm.setVisible(true);
        pesquisarBebidaForm.toFront();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCampoObrigatorio;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblSabor;
    private javax.swing.JLabel lblVolume;
    private javax.swing.JPanel pnlCadastroDeBebida;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextField txtSabor;
    private javax.swing.JTextField txtVolume;
    // End of variables declaration//GEN-END:variables
}
