/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import fachadas.FachadaJPA;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Material;
import objetosNegocio.Producto;
import persistencia.MaterialJpaController;
import persistencia.ProductoJpaController;

/**
 *
 * @author Francisco
 */
public class VentanaProductos extends javax.swing.JFrame {
    
    DefaultTableModel dtm;
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    FachadaJPA facade = new FachadaJPA();
    Producto productos = new Producto();
    ProductoJpaController jpaProducto = new ProductoJpaController();
    MaterialJpaController jpaMaterial = new MaterialJpaController();

    /**
     * Creates new form VentanaAnalisis
     */
    public VentanaProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarProductos();
        botonActualizar.setEnabled(false);
        botonEliminar.setEnabled(false);
        
    }
    
    private void mostrarProductos() {
        setModel(tablaProductos);
        DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
        try {
            jpaProducto.insertarModelo(modelo);
        } catch (Exception e) {
            Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void setModel(JTable table) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
    }
    
    private void validacion(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String txt = "-,+*¨{.}[]_!#$%&*/()=?¡áéíóú´|°¬;:";
        String caracter = String.valueOf(c);
        if (txt.contains(caracter)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Signo no permitido, Solo números y letras");
        }
    }
    
    private void validacionNumeros(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se permiten números");
        }
    }
    
    private void validacionLetras(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se permiten letras");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoUnidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonConsultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTANA PRODUCTOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Lista de Productos"));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Unidad"
            }
        ));
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 480, 240));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Datos Productos"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Clave:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Unidad:");

        campoClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoClave.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoClaveKeyTyped(evt);
            }
        });

        campoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        campoUnidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoUnidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoUnidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Opciones"));
        jPanel2.setInheritsPopupMenu(true);

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.setFocusable(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/actualizar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setFocusable(false);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/mostrarTodo.png"))); // NOI18N
        botonConsultar.setText("Mostrar Todos");
        botonConsultar.setFocusable(false);
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonConsultar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondoProductos.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        String Clave = campoClave.getText();
        String Nombre = campoNombre.getText();
        String Unidad = campoUnidad.getText();
        
        if (campoClave.getText().trim().length() == 0 || campoNombre.getText().trim().length() == 0 || campoUnidad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacios");
        } else {
            
            productos.setClave(Clave);
            productos.setNombre(Nombre);
            productos.setUnidad(Unidad);
            
            try {
                facade.agregar(productos);
                
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                campoClave.setText(null);
                campoNombre.setText(null);
                campoUnidad.setText(null);
                mostrarProductos();
            } catch (Exception e) {
                Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        String Clave = campoClave.getText();
        String Nombre = campoNombre.getText();
        String Unidad = campoUnidad.getText();
        
        if (campoClave.getText().trim().length() == 0 || campoNombre.getText().trim().length() == 0 || campoUnidad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacios");
        } else {
            
            productos.setClave(Clave);
            productos.setNombre(Nombre);
            productos.setUnidad(Unidad);
            
            try {
                facade.obten(productos);
                facade.actualizar(productos);
                
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
                campoClave.setText(null);
                campoNombre.setText(null);
                campoUnidad.setText(null);
                mostrarProductos();
            } catch (Exception e) {
                Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        
        if (campoClave.getText().trim().length() == 0 || campoNombre.getText().trim().length() == 0 || campoUnidad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacios");
        } else {
            
            try {
                Producto producto1 = new Producto(campoClave.getText());
                Producto encontrado = facade.obten(producto1);
//                Material material1 = new Material(campoClave.getText());

                facade.eliminar(producto1);
                
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                campoClave.setText(null);
                campoNombre.setText(null);
                campoUnidad.setText(null);
                mostrarProductos();
            } catch (Exception e) {
                Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        mostrarProductos();
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        int fila = tablaProductos.getSelectedRow();
        if (fila >= 0) {
            campoClave.setText(tablaProductos.getValueAt(fila, 0).toString());
            campoNombre.setText(tablaProductos.getValueAt(fila, 1).toString());
            campoUnidad.setText(tablaProductos.getValueAt(fila, 2).toString());
            botonEliminar.setEnabled(true);
            botonActualizar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN PRODUCTO");
        }
    }//GEN-LAST:event_tablaProductosMousePressed

    private void campoClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClaveKeyTyped
        validacion(evt);
    }//GEN-LAST:event_campoClaveKeyTyped

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        validacion(evt);
        validacionLetras(evt);
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoUnidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUnidadKeyTyped
        validacion(evt);
        validacionLetras(evt);
    }//GEN-LAST:event_campoUnidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}