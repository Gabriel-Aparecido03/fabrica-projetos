/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fabrica.de.projetos;
import java.util.InputMismatchException;
import objetos.Fornecedor;
import conexao.MySQL;
import javax.swing.JOptionPane;
/**
 *
 * @author gabri
 */
public class ForncedorTela extends javax.swing.JFrame {

    /**
     * Creates new form ForncedorTela
     */
    MySQL conectar = new MySQL("localhost:3306","DataFarmaBanco","root","123mudar");
    Fornecedor novoFornecedor = new Fornecedor();
    public ForncedorTela() {
        initComponents();
    }
    
    public static boolean isCNPJ(String CNPJ) {

    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
       (CNPJ.length() != 14))
       return(false);

    char dig13, dig14;
    int sm, i, r, num, peso;


    try {

      sm = 0;
      peso = 2;
      for (i=11; i>=0; i--) {

        num = (int)(CNPJ.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig13 = '0';
      else dig13 = (char)((11-r) + 48);


      sm = 0;
      peso = 2;
      for (i=12; i>=0; i--) {
        num = (int)(CNPJ.charAt(i)- 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig14 = '0';
      else dig14 = (char)((11-r) + 48);


      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
         return(true);
      else return(false);
    } catch (InputMismatchException erro) {
        return(false);
    }
  }
    
    private boolean validarDados() {
        boolean isvalidateCNPJ = this.isCNPJ(txtCnpj.getText());
        if(
                isvalidateCNPJ && 
                txtNome.getText().length() > 0 
                && txtTelefone.getText().length() > 0 
                && txtEmail.getText().length() > 0 
                && txtCnpj.getText().length() > 0
                && txtEndereco.getText().length() > 0
                && txtCep.getText().length() > 0)
        { return true;}
        else {
            return false;
        }
    }
    
    private void CadastrarFornecedor(Fornecedor novoFornecedor) {
        if(!this.validarDados()) {
            JOptionPane.showMessageDialog(null, "Verifique os dados inserido",
            "Error Database!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            
            this.conectar.conectaBanco();
        
            novoFornecedor.setNome(txtNome.getText());
            novoFornecedor.setTelefone(txtTelefone.getText());
            novoFornecedor.setEmail(txtEmail.getText());
            novoFornecedor.setEndereco(txtEndereco.getText());
            novoFornecedor.setCnpj(txtCnpj.getText());
            novoFornecedor.setCep(txtCep.getText());

            try {
                this.conectar.insertSQL("INSERT INTO fornecedores values("+null+",'"+novoFornecedor.getNome()+"','"
                        +novoFornecedor.getTelefone()+"','"
                        +novoFornecedor.getEmail()+"','"
                        +novoFornecedor.getCnpj()+"','"
                        +novoFornecedor.getEndereco()+"','"
                        +novoFornecedor.getCep()+"');");
                JOptionPane.showMessageDialog (null, "Cadastrado", "Fornecedor cadastro no banco de dados", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                this.conectar.conectaBanco();
            }
        }
    };
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtConsultaForn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_confirmar = new javax.swing.JButton();
        btnFecharForn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Tipo2 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCnpj = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        btn_confirmar1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Procure um fornecedor no sistema");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(140, 40, 310, 16);

        txtConsultaForn.setBackground(new java.awt.Color(224, 229, 243));
        txtConsultaForn.setBorder(null);
        jPanel2.add(txtConsultaForn);
        txtConsultaForn.setBounds(70, 100, 460, 60);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Digite o nome de um fornecedor");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(70, 80, 180, 16);

        btn_confirmar.setBackground(new java.awt.Color(38, 53, 99));
        btn_confirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_confirmar.setForeground(new java.awt.Color(255, 255, 255));
        btn_confirmar.setText("confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_confirmar);
        btn_confirmar.setBounds(180, 230, 280, 30);

        btnFecharForn.setBackground(new java.awt.Color(255, 51, 51));
        btnFecharForn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFecharForn.setForeground(new java.awt.Color(255, 255, 255));
        btnFecharForn.setText("Fechar");
        btnFecharForn.setBorder(null);
        btnFecharForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharFornActionPerformed(evt);
            }
        });
        jPanel2.add(btnFecharForn);
        btnFecharForn.setBounds(550, 0, 100, 30);

        jTabbedPane1.addTab("Consultar", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Nome\n");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(60, 30, 37, 16);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Telefone");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(50, 110, 70, 16);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Email");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(60, 190, 37, 16);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Cnpj");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(320, 30, 30, 16);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Endereco");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(320, 110, 80, 16);

        Tipo2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tipo2.setForeground(new java.awt.Color(0, 0, 0));
        Tipo2.setText("Cep");
        jPanel1.add(Tipo2);
        Tipo2.setBounds(330, 190, 30, 16);

        txtTelefone.setBackground(new java.awt.Color(224, 229, 243));
        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 229, 243), 2));
        txtTelefone.setCaretColor(new java.awt.Color(38, 53, 99));
        txtTelefone.setSelectionColor(new java.awt.Color(38, 53, 99));
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefone);
        txtTelefone.setBounds(130, 100, 140, 30);

        txtEmail.setBackground(new java.awt.Color(224, 229, 243));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 229, 243), 2));
        txtEmail.setCaretColor(new java.awt.Color(38, 53, 99));
        txtEmail.setSelectionColor(new java.awt.Color(38, 53, 99));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(100, 180, 170, 30);

        txtCnpj.setBackground(new java.awt.Color(224, 229, 243));
        txtCnpj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 229, 243), 2));
        txtCnpj.setCaretColor(new java.awt.Color(38, 53, 99));
        txtCnpj.setSelectionColor(new java.awt.Color(38, 53, 99));
        txtCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnpjActionPerformed(evt);
            }
        });
        jPanel1.add(txtCnpj);
        txtCnpj.setBounds(360, 20, 180, 30);

        txtCep.setBackground(new java.awt.Color(224, 229, 243));
        txtCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 229, 243), 2));
        txtCep.setCaretColor(new java.awt.Color(38, 53, 99));
        txtCep.setSelectionColor(new java.awt.Color(38, 53, 99));
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        jPanel1.add(txtCep);
        txtCep.setBounds(390, 180, 140, 30);

        txtNome.setBackground(new java.awt.Color(224, 229, 243));
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 229, 243), 2));
        txtNome.setCaretColor(new java.awt.Color(38, 53, 99));
        txtNome.setSelectionColor(new java.awt.Color(38, 53, 99));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome);
        txtNome.setBounds(100, 20, 180, 30);

        txtEndereco.setBackground(new java.awt.Color(224, 229, 243));
        txtEndereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 229, 243), 2));
        txtEndereco.setCaretColor(new java.awt.Color(38, 53, 99));
        txtEndereco.setSelectionColor(new java.awt.Color(38, 53, 99));
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(txtEndereco);
        txtEndereco.setBounds(400, 100, 140, 30);

        btn_confirmar1.setBackground(new java.awt.Color(38, 53, 99));
        btn_confirmar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_confirmar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_confirmar1.setText("confirmar");
        btn_confirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_confirmar1);
        btn_confirmar1.setBounds(470, 230, 110, 30);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Fechar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(560, 0, 90, 30);

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(668, 358));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCnpjActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void btn_confirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmar1ActionPerformed
        CadastrarFornecedor(novoFornecedor);
    }//GEN-LAST:event_btn_confirmar1ActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        Fornecedor novoFornecedor = new Fornecedor();
        
        if(txtConsultaForn.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique os dados digitados",
            "Error!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            this.conectar.conectaBanco();
            try {
                this.conectar.executarSQL("SELECT nome,telefone,email,cnpj,endereco,cep from fornecedores where nome = "+ "'" + txtConsultaForn.getText()+ "'" + ";");
                while(this.conectar.getResultSet().next()) {
                    novoFornecedor.setNome(this.conectar.getResultSet().getString(1));
                    novoFornecedor.setTelefone(this.conectar.getResultSet().getString(2));
                    novoFornecedor.setEmail(this.conectar.getResultSet().getString(3));
                    novoFornecedor.setCnpj(this.conectar.getResultSet().getString(4));
                    novoFornecedor.setEndereco(this.conectar.getResultSet().getString(5));
                    novoFornecedor.setCep(this.conectar.getResultSet().getString(6));
                } 
                if(novoFornecedor.getNome() == null) {
                    JOptionPane.showMessageDialog(null, "Verifique os dados digitados",
                    "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    ResultadoFornecedor telaResultado = new ResultadoFornecedor();
                    telaResultado.setCampos(novoFornecedor);
                    telaResultado.setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                this.conectar.fechaBanco();
            }
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btnFecharFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFornActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharFornActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ForncedorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForncedorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForncedorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForncedorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForncedorTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tipo2;
    private javax.swing.JButton btnFecharForn;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_confirmar1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtConsultaForn;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
