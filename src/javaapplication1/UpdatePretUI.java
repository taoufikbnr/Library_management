/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import javax.swing.JOptionPane;
import java.awt.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author lenovo
 */
public class UpdatePretUI extends javax.swing.JFrame {
String selectedCriteria="nom";

    /**
     * Creates new form AddSubsriberUI
     */
    public UpdatePretUI() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rt_icon.png")));
        setLocationRelativeTo(null);
        performSearch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addSubBtn = new javax.swing.JButton();
        nomLabel = new javax.swing.JLabel();
        updateUserImg = new javax.swing.JLabel();
        pretIdInput = new javax.swing.JTextField();
        homeBtn1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pretTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        query = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        numExemplaire = new javax.swing.JTextField();
        nomLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RT | Enregistrer Retour Prêt");
        setResizable(false);

        addSubBtn.setBackground(new java.awt.Color(0, 153, 51));
        addSubBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addSubBtn.setForeground(new java.awt.Color(255, 255, 255));
        addSubBtn.setText("Enregistrer Retour");
        addSubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubBtnActionPerformed(evt);
            }
        });

        nomLabel.setText("Exemplaire");

        updateUserImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update pret.png"))); // NOI18N

        pretIdInput.setEditable(false);

        homeBtn1.setBackground(new Color(0, 0, 0, 0));
        homeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_icon.png"))); // NOI18N
        homeBtn1.setBorder(null);
        homeBtn1.setBorderPainted(false);
        homeBtn1.setFocusPainted(false);
        homeBtn1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home icon 50.png"))); // NOI18N
        homeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtn1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new Color(0, 0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return_icon.png"))); // NOI18N
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverEnabled(false);
        jButton1.setVerifyInputWhenFocusTarget(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pretTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }
    );
    pretTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    pretTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            pretTableMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(pretTable);

    jButton2.setText("Rechercher");
    jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jButton2.setPreferredSize(new java.awt.Dimension(61, 27));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cin" }));
    jComboBox1.setPreferredSize(new java.awt.Dimension(72, 27));
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
        }
    });

    query.setPreferredSize(new java.awt.Dimension(64, 27));
    query.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            queryActionPerformed(evt);
        }
    });

    title.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    title.setText("Enregistrer Retour Pret");

    numExemplaire.setEditable(false);
    numExemplaire.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            numExemplaireActionPerformed(evt);
        }
    });

    nomLabel1.setText("ID prêt");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 250, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(230, 230, 230))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addSubBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                                    .addComponent(updateUserImg)
                                    .addGap(75, 75, 75))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(nomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(numExemplaire, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(nomLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(pretIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(167, 167, 167)
                            .addComponent(homeBtn1)))
                    .addContainerGap())))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(updateUserImg)
                .addComponent(homeBtn1)
                .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(title)
            .addGap(44, 44, 44)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pretIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nomLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(numExemplaire, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
            .addComponent(addSubBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14))
    );

    homeBtn1.setOpaque(false);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubBtnActionPerformed
        String id = pretIdInput.getText();
        String numEx = numExemplaire.getText();
        
       if(id.isEmpty()){
        JOptionPane.showMessageDialog(this,"Veuillez selection un prêt.");
        }else{
            try {
                new Pret().updatePret(Integer.parseInt(id));
                new Exemplaires().setStatut("disponible", Integer.parseInt(numEx));

                pretIdInput.setText("");
                performSearch();
                
                JOptionPane.showMessageDialog(this,"Prêt enregistré");
            } catch (ParseException ex) {
                Logger.getLogger(UpdatePretUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
         }
        
    }//GEN-LAST:event_addSubBtnActionPerformed

    private void homeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtn1ActionPerformed
        new AdminDashboardUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeBtn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new PretManagementUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pretTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pretTableMouseClicked
        int selectedRow=pretTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) pretTable.getModel();
        
        Object id = model.getValueAt(selectedRow, 0);

        pretIdInput.setText((String)id);
        Object numEx = model.getValueAt(selectedRow, 2);
        numExemplaire.setText((String)numEx);

        

    }//GEN-LAST:event_pretTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        performSearch();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        selectedCriteria = (String) jComboBox1.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        performSearch();
    }//GEN-LAST:event_queryActionPerformed

    private void numExemplaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numExemplaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numExemplaireActionPerformed
    private void performSearch() {
        String queryStr = query.getText();
       
         Pret pret = new Pret();

        Object[][] tableData=null;
    try {
        tableData = pret.getPret(queryStr);
    } catch (ParseException ex) {
        Logger.getLogger(UpdatePretUI.class.getName()).log(Level.SEVERE, null, ex);
    }
        pretTable.setModel(new javax.swing.table.DefaultTableModel(
            tableData,
            new String[]{"Id","CIN","Exemplaire","Date pret","Date Retour"}
                
        ));
                TableColumnModel columnModel = pretTable.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(5);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSubBtn;
    private javax.swing.JButton homeBtn1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel nomLabel1;
    private javax.swing.JTextField numExemplaire;
    private javax.swing.JTextField pretIdInput;
    private javax.swing.JTable pretTable;
    private javax.swing.JTextField query;
    private javax.swing.JLabel title;
    private javax.swing.JLabel updateUserImg;
    // End of variables declaration//GEN-END:variables
}
