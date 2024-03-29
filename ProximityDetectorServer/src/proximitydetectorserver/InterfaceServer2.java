/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximitydetectorserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author vitoria
 */
public class InterfaceServer2 extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceServer2
     */
    
    public InterfaceServer2() {
        initComponents();
    }
    
    public InterfaceServer2(String longitude, String latitude) {
        initComponents();
        labelAddLongitude.setText(longitude);
        labelAddLatitude.setText(latitude);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelAlerta = new javax.swing.JLabel();
        labelMsgAlerta = new javax.swing.JLabel();
        labelLongitude = new javax.swing.JLabel();
        labelLatitude = new javax.swing.JLabel();
        labelAddLongitude = new javax.swing.JLabel();
        labelAddLatitude = new javax.swing.JLabel();
        labelMsgEmailEnviando = new javax.swing.JLabel();
        buttonStopAlert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        labelTitulo.setText("ProximityDetectorServer");

        labelAlerta.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        labelAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proximitydetectorserver/alert (2).png"))); // NOI18N
        labelAlerta.setText("Alerta!");

        labelMsgAlerta.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        labelMsgAlerta.setText("Seu dispositivo pode estar em risco.");

        labelLongitude.setText("Longitude:");

        labelLatitude.setText("Latitude:");

        labelAddLongitude.setText("jLabel1");

        labelAddLatitude.setText("jLabel1");

        labelMsgEmailEnviando.setText("Enviando as informações para seu email secundário.");

        buttonStopAlert.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        buttonStopAlert.setText("Parar alerta");
        buttonStopAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopAlertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addComponent(labelMsgEmailEnviando, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAlerta)
                                .addGap(84, 84, 84))
                            .addComponent(labelMsgAlerta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAddLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAddLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(labelLongitude))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(buttonStopAlert))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(labelLatitude)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(29, 29, 29)
                .addComponent(labelAlerta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMsgAlerta)
                .addGap(59, 59, 59)
                .addComponent(labelLongitude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAddLongitude)
                .addGap(18, 18, 18)
                .addComponent(labelLatitude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAddLatitude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(labelMsgEmailEnviando)
                .addGap(18, 18, 18)
                .addComponent(buttonStopAlert)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStopAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopAlertActionPerformed
        try {
            // TODO add your handling code here:
            Server.audio.stop();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(InterfaceServer2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceServer2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(InterfaceServer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
        Server.flag = false;
        try {
            Server.cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceServer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonStopAlertActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceServer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceServer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceServer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceServer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceServer2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStopAlert;
    private javax.swing.JLabel labelAddLatitude;
    private javax.swing.JLabel labelAddLongitude;
    private javax.swing.JLabel labelAlerta;
    private javax.swing.JLabel labelLatitude;
    private javax.swing.JLabel labelLongitude;
    private javax.swing.JLabel labelMsgAlerta;
    private javax.swing.JLabel labelMsgEmailEnviando;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
