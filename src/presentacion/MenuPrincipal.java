/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        getEntityManager();
        
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonReactivos = new javax.swing.JButton();
        botonAnalisis = new javax.swing.JButton();
        botonProducto = new javax.swing.JButton();
        botonMaterial = new javax.swing.JButton();
        botonReqMaterial = new javax.swing.JButton();
        botonInventarioReactivos = new javax.swing.JButton();
        botonInventarioMateriales = new javax.swing.JButton();
        botonReqReactivo = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LABORATORIO CENTRO DE DIAGNÓSTICO ITSON");
        setMinimumSize(new java.awt.Dimension(950, 745));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonReactivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonReactivos.png"))); // NOI18N
        botonReactivos.setBorderPainted(false);
        botonReactivos.setContentAreaFilled(false);
        botonReactivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReactivos.setFocusTraversalPolicyProvider(true);
        botonReactivos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonReactivos2.png"))); // NOI18N
        botonReactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReactivosActionPerformed(evt);
            }
        });
        getContentPane().add(botonReactivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 220, -1));

        botonAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonAnalisis2.png"))); // NOI18N
        botonAnalisis.setBorderPainted(false);
        botonAnalisis.setContentAreaFilled(false);
        botonAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAnalisis.setFocusTraversalPolicyProvider(true);
        botonAnalisis.setFocusable(false);
        botonAnalisis.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonAnalisis.png"))); // NOI18N
        botonAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalisisActionPerformed(evt);
            }
        });
        getContentPane().add(botonAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 200, 220));

        botonProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonProductos.png"))); // NOI18N
        botonProducto.setBorderPainted(false);
        botonProducto.setContentAreaFilled(false);
        botonProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonProducto.setFocusable(false);
        botonProducto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonProductos2.png"))); // NOI18N
        botonProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProductoActionPerformed(evt);
            }
        });
        getContentPane().add(botonProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 200, 180));

        botonMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonMateriales.png"))); // NOI18N
        botonMaterial.setBorderPainted(false);
        botonMaterial.setContentAreaFilled(false);
        botonMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMaterial.setFocusPainted(false);
        botonMaterial.setFocusable(false);
        botonMaterial.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonMateriales2.png"))); // NOI18N
        botonMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMaterialActionPerformed(evt);
            }
        });
        getContentPane().add(botonMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 200, 200));

        botonReqMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonRequerimientoMateriales.png"))); // NOI18N
        botonReqMaterial.setToolTipText("");
        botonReqMaterial.setBorderPainted(false);
        botonReqMaterial.setContentAreaFilled(false);
        botonReqMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReqMaterial.setFocusable(false);
        botonReqMaterial.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonRequerimientoMateriales2.png"))); // NOI18N
        botonReqMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReqMaterialActionPerformed(evt);
            }
        });
        getContentPane().add(botonReqMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, 180));

        botonInventarioReactivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonInventarioReactivos2.png"))); // NOI18N
        botonInventarioReactivos.setBorderPainted(false);
        botonInventarioReactivos.setContentAreaFilled(false);
        botonInventarioReactivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInventarioReactivos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonInventarioReactivos.png"))); // NOI18N
        botonInventarioReactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInventarioReactivosActionPerformed(evt);
            }
        });
        getContentPane().add(botonInventarioReactivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        botonInventarioMateriales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonInventarioMateriales.png"))); // NOI18N
        botonInventarioMateriales.setBorderPainted(false);
        botonInventarioMateriales.setContentAreaFilled(false);
        botonInventarioMateriales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInventarioMateriales.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonInventarioMateriales2.png"))); // NOI18N
        botonInventarioMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInventarioMaterialesActionPerformed(evt);
            }
        });
        getContentPane().add(botonInventarioMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        botonReqReactivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonRequerimientoReactivos.png"))); // NOI18N
        botonReqReactivo.setBorderPainted(false);
        botonReqReactivo.setContentAreaFilled(false);
        botonReqReactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReqReactivo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonRequerimientoReactivos2.png"))); // NOI18N
        botonReqReactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReqReactivoActionPerformed(evt);
            }
        });
        getContentPane().add(botonReqReactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 230, 190));

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonSalir.png"))); // NOI18N
        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSalir.setFocusable(false);
        botonSalir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/botonSalir2.png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Fondo2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalisisActionPerformed
       VentanaAnalisis va;
       va = new VentanaAnalisis();
       va.setVisible(true);
    }//GEN-LAST:event_botonAnalisisActionPerformed

    private void botonReqMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReqMaterialActionPerformed
        VentanaRequerimientoMateriales vrm;
        vrm = new VentanaRequerimientoMateriales();
        vrm.setVisible(true);
    }//GEN-LAST:event_botonReqMaterialActionPerformed

    private void botonMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMaterialActionPerformed
        VentanaMateriales venMa;
        venMa = new VentanaMateriales();
        venMa.setVisible(true);
    }//GEN-LAST:event_botonMaterialActionPerformed

    private void botonProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProductoActionPerformed
        VentanaProductos vp;
        vp = new VentanaProductos();
        vp.setVisible(true);
    }//GEN-LAST:event_botonProductoActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
      int response = JOptionPane.showConfirmDialog(null, "¿Desea Salir del Sistema?", "Mensaje",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
             JOptionPane.showMessageDialog(null, "ELABORADO POR:\nFRANCISCO APODACA #35675\nLEOBARDO PEREZ #109037\nFRANCISCO SIQUEIROS #108336");
             System.exit(0);
        }
        
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonReactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReactivosActionPerformed
        VentanaReactivos vr;
        vr = new VentanaReactivos();
        vr.setVisible(true);
    }//GEN-LAST:event_botonReactivosActionPerformed

    private void botonReqReactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReqReactivoActionPerformed
       VentanaRequerimientoReactivos vrr;
       vrr = new VentanaRequerimientoReactivos();
       vrr.setVisible(true);
    }//GEN-LAST:event_botonReqReactivoActionPerformed

    private void botonInventarioMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInventarioMaterialesActionPerformed
        VentanaInventarioMateriales vim;
        vim = new VentanaInventarioMateriales();
        vim.setVisible(true);
    }//GEN-LAST:event_botonInventarioMaterialesActionPerformed

    private void botonInventarioReactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInventarioReactivosActionPerformed
        VentanaInventarioReactivos vir;
        vir = new VentanaInventarioReactivos();
        vir.setVisible(true);
    }//GEN-LAST:event_botonInventarioReactivosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnalisis;
    private javax.swing.JButton botonInventarioMateriales;
    private javax.swing.JButton botonInventarioReactivos;
    private javax.swing.JButton botonMaterial;
    private javax.swing.JButton botonProducto;
    private javax.swing.JButton botonReactivos;
    private javax.swing.JButton botonReqMaterial;
    private javax.swing.JButton botonReqReactivo;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
