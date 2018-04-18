/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.RadioButton;
import static javafx.scene.input.KeyCode.R;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cramery
 */
public class SWE_GetInfos extends javax.swing.JFrame {

    /**
     * Creates new form SWE_GetInfos
     */
    public SWE_GetInfos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbl_Hersteller = new javax.swing.JLabel();
        lbl_HausName = new javax.swing.JLabel();
        lbl_Von = new javax.swing.JLabel();
        lbl_Bis = new javax.swing.JLabel();
        lbl_Woche = new javax.swing.JLabel();
        txt_HausName = new javax.swing.JTextField();
        txt_Von = new javax.swing.JTextField();
        txt_Bis = new javax.swing.JTextField();
        txt_Woche = new javax.swing.JTextField();
        rb_AnzMHaus = new javax.swing.JRadioButton();
        rb_AnzProd = new javax.swing.JRadioButton();
        rb_DurchBestellwert = new javax.swing.JRadioButton();
        rb_BestellwertZeit = new javax.swing.JRadioButton();
        rb_DreiBestellwert = new javax.swing.JRadioButton();
        rb_DurchLieferzeit = new javax.swing.JRadioButton();
        rb_FiveProd = new javax.swing.JRadioButton();
        rb_AnzBestellWoche = new javax.swing.JRadioButton();
        rb_BestellwertWoche = new javax.swing.JRadioButton();
        btn_OK = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        cb_Hersteller = new javax.swing.JComboBox<>();
        lbl_HausCode = new javax.swing.JLabel();
        txt_HausCode = new javax.swing.JTextField();
        btn_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Möbelhaus");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Möbelhaus"));

        lbl_Hersteller.setText("Möbelhersteller:");

        lbl_HausName.setText("Möbelhausname:");

        lbl_Von.setText("Zeitraum von:");

        lbl_Bis.setText("Zeitraum bis:");

        lbl_Woche.setText("Kalenderwoche:");

        txt_HausName.setText("Möbelhaus Name");
        txt_HausName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HausNameActionPerformed(evt);
            }
        });

        txt_Von.setText("01.01.2017");

        txt_Bis.setText("01.01.2018");

        txt_Woche.setText("1");

        buttonGroup1.add(rb_AnzMHaus);
        rb_AnzMHaus.setText("Anzahl Möbelhäsuer bei Möbelhersteller");

        buttonGroup1.add(rb_AnzProd);
        rb_AnzProd.setText("Anzahl Produkt-Typen von Möbelhaus");

        buttonGroup1.add(rb_DurchBestellwert);
        rb_DurchBestellwert.setText("Durchschnittliche Bestellwert pro Möbelhaus bei Möbelhersteller");

        buttonGroup1.add(rb_BestellwertZeit);
        rb_BestellwertZeit.setText("Bestellwert pro Möbelhaus in Zeitperiode");

        buttonGroup1.add(rb_DreiBestellwert);
        rb_DreiBestellwert.setText("Drei grössten Bestellwerte bei Möbelhersteller");

        buttonGroup1.add(rb_DurchLieferzeit);
        rb_DurchLieferzeit.setText("Durchschnittliche Lieferzeit eines Möbelherstellers");

        buttonGroup1.add(rb_FiveProd);
        rb_FiveProd.setText("Fünf häufigsten verkauften Produkt-Typen bei Möbelhersteller");

        buttonGroup1.add(rb_AnzBestellWoche);
        rb_AnzBestellWoche.setText("Anzahl Bestellungen pro Möbelhaus in Kalenderwoche");

        buttonGroup1.add(rb_BestellwertWoche);
        rb_BestellwertWoche.setText("Bestellwert pro Möbelhaus in Kalenderwoche");

        btn_OK.setText("Go");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });

        btn_Update.setText("Update");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        cb_Hersteller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fischer", "Walker", "Zwissig" }));

        lbl_HausCode.setText("Möbelhauscode:");

        txt_HausCode.setText("Möbelhaus Code");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_BestellwertWoche)
                    .addComponent(rb_AnzBestellWoche)
                    .addComponent(rb_DurchLieferzeit)
                    .addComponent(rb_DreiBestellwert)
                    .addComponent(rb_BestellwertZeit)
                    .addComponent(rb_DurchBestellwert)
                    .addComponent(rb_AnzProd)
                    .addComponent(rb_AnzMHaus)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(rb_FiveProd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_HausCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Hersteller, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_HausName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Von, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Bis, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Woche, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_HausName)
                            .addComponent(txt_Bis)
                            .addComponent(txt_Von, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txt_Woche, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_Hersteller, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_HausCode))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Hersteller)
                    .addComponent(cb_Hersteller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_HausName)
                    .addComponent(txt_HausName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_HausCode)
                    .addComponent(txt_HausCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Von)
                    .addComponent(txt_Von, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Bis)
                    .addComponent(txt_Bis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Woche)
                    .addComponent(txt_Woche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_AnzMHaus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_AnzProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_DurchBestellwert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_BestellwertZeit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_DreiBestellwert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_DurchLieferzeit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_FiveProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_AnzBestellWoche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_BestellwertWoche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_OK)
                    .addComponent(btn_Update))
                .addGap(12, 12, 12))
        );

        btn_Exit.setText("Exit");
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Exit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Exit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        //Check which Möbelhersteller
        String herstellerURL = "";
        
        //Fill variables from GUI
        String mobelhausCode = "";
        String mobelhausName = "";
        
        //check which radiobutton is selected       
        if (rb_AnzMHaus.isSelected()){
            try {
                Anforderungen.A01(mobelhausCode, mobelhausName, herstellerURL);
            } catch (ParseException ex) {
                Logger.getLogger(SWE_GetInfos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SWE_GetInfos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (rb_AnzProd.isSelected()){
            try {
                Anforderungen.A02(herstellerURL);
            } catch (ParseException ex) {
                Logger.getLogger(SWE_GetInfos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SWE_GetInfos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (rb_DurchBestellwert.isSelected()){
 
        }else if (rb_BestellwertZeit.isSelected()){
            
        }else if (rb_DreiBestellwert.isSelected()){
            
        }else if (rb_DurchLieferzeit.isSelected()){
            
        }else if (rb_FiveProd.isSelected()){
            
        }else if (rb_AnzBestellWoche.isSelected()){
            
        }else if (rb_BestellwertWoche.isSelected()){
            
        }
    }//GEN-LAST:event_btn_OKActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        try {
            Update.Update();  //Update infos from Json
        } catch (ParseException ex) {
            Logger.getLogger(SWE_GetInfos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SWE_GetInfos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void txt_HausNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HausNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HausNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SWE_GetInfos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SWE_GetInfos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SWE_GetInfos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SWE_GetInfos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SWE_GetInfos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_OK;
    private javax.swing.JButton btn_Update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_Hersteller;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Bis;
    private javax.swing.JLabel lbl_HausCode;
    private javax.swing.JLabel lbl_HausName;
    private javax.swing.JLabel lbl_Hersteller;
    private javax.swing.JLabel lbl_Von;
    private javax.swing.JLabel lbl_Woche;
    private javax.swing.JRadioButton rb_AnzBestellWoche;
    private javax.swing.JRadioButton rb_AnzMHaus;
    private javax.swing.JRadioButton rb_AnzProd;
    private javax.swing.JRadioButton rb_BestellwertWoche;
    private javax.swing.JRadioButton rb_BestellwertZeit;
    private javax.swing.JRadioButton rb_DreiBestellwert;
    private javax.swing.JRadioButton rb_DurchBestellwert;
    private javax.swing.JRadioButton rb_DurchLieferzeit;
    private javax.swing.JRadioButton rb_FiveProd;
    private javax.swing.JTextField txt_Bis;
    private javax.swing.JTextField txt_HausCode;
    private javax.swing.JTextField txt_HausName;
    private javax.swing.JTextField txt_Von;
    private javax.swing.JTextField txt_Woche;
    // End of variables declaration//GEN-END:variables
    
}
