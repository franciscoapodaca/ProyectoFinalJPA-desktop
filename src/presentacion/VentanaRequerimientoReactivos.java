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
import objetosNegocio.Analisis;
import objetosNegocio.Producto;
import objetosNegocio.ReqReactivo;
import persistencia.AnalisisJpaController;
import persistencia.ProductoJpaController;
import persistencia.ReqReactivoJpaController;

/**
 *
 * @author Francisco
 */
public class VentanaRequerimientoReactivos extends javax.swing.JFrame {

    DefaultTableModel dtm;
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    FachadaJPA facade = new FachadaJPA();
    ReqReactivo reqReactivo = new ReqReactivo();
    ReqReactivoJpaController jpaReqRea = new ReqReactivoJpaController();
    Analisis analisis = new Analisis();
    AnalisisJpaController jpaAnalisis = new AnalisisJpaController();
    Producto productos = new Producto();
    ProductoJpaController jpaProducto = new ProductoJpaController();

    /**
     * Creates new form VentanaAnalisis
     */
    public VentanaRequerimientoReactivos() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarAnalisis();
        mostrarProductos();
        botonActualizar.setEnabled(false);
        botonEliminar.setEnabled(false);
    }

    private void mostrarAnalisis() {
        setModel(tablaAnalisis);
        DefaultTableModel modelo = (DefaultTableModel) tablaAnalisis.getModel();
        try {
            jpaAnalisis.insertarModelo(modelo);
        } catch (Exception e) {
            Logger.getLogger(VentanaRequerimientoReactivos.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setModel(JTable table) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
    }

    private void mostrarProductos() {
        setModelProductos(tablaProductos);
        DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
        try {
            jpaProducto.insertarModelo(modelo);
        } catch (Exception e) {
            Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setModelProductos(JTable table) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
    }

    private void mostrarRequerimientosReactivos() {
        setModelRequerimientoMateriales(tablaReqReactivos);
        DefaultTableModel modelo = (DefaultTableModel) tablaReqReactivos.getModel();
        try {
            jpaReqRea.insertarModelo(modelo);
        } catch (Exception e) {
            Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setModelRequerimientoMateriales(JTable table) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        campoClaveAnalisis = new javax.swing.JTextField();
        campoClaveProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonConsultar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAnalisis = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaReqReactivos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTANA REQUERIMIENTO MATERIALES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Datos Requerimiento de Reactivos"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Clave:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Clave Analisis:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Clave Producto:");

        campoClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoClave.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoClaveKeyTyped(evt);
            }
        });

        campoClaveAnalisis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoClaveAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoClaveAnalisis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoClaveAnalisisKeyTyped(evt);
            }
        });

        campoClaveProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoClaveProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoClaveProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoClaveProductoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        campoCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        campoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoClaveAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(campoClave)
                    .addComponent(campoClaveProducto))
                .addContainerGap(149, Short.MAX_VALUE))
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
                    .addComponent(campoClaveAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoClaveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 23, -1, -1));

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
                .addContainerGap(14, Short.MAX_VALUE))
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Lista Analisis"));

        tablaAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Frecuencia"
            }
        ));
        tablaAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaAnalisis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaAnalisisMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAnalisis);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 542, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Lista Productos"));

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
        jScrollPane4.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 542, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Lista Requerimiento Reactivos"));

        tablaReqReactivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Cantidad", "Clave Producto", "Clave Analisis"
            }
        ));
        tablaReqReactivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaReqReactivos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaReqReactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaReqReactivosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaReqReactivos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondoRequerimientoReacivos.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed

        String Clave = campoClave.getText();

        if (campoClaveProducto.getText().trim().length() == 0 || campoCantidad.getText().trim().length() == 0 || campoClave.getText().trim().length() == 0 || campoClaveAnalisis.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacios");
        } else {
            reqReactivo.setCveReq(Clave);
            reqReactivo.setCantidad(Double.parseDouble(campoCantidad.getText()));

            try {
                Producto producto = new Producto(campoClaveProducto.getText());
                Producto encontrado = facade.obten(producto);
                Analisis analisis1 = new Analisis(campoClaveAnalisis.getText());
                Analisis encontrado1 = facade.obten(analisis1);
                facade.agregar(new ReqReactivo(campoClave.getText(), Integer.parseInt(campoCantidad.getText()), producto, analisis1));

                JOptionPane.showMessageDialog(null, "Requerimiento de Reactivo agregado correctamente");
                campoClave.setText(null);
                campoCantidad.setText(null);
                campoClaveAnalisis.setText(null);
                campoClaveProducto.setText(null);
                mostrarRequerimientosReactivos();
            } catch (Exception e) {
                Logger.getLogger(VentanaMateriales.class.getName()).log(Level.SEVERE, null, e);

            }
        }

    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        String Clave = campoClave.getText();

        if (campoClaveProducto.getText().trim().length() == 0 || campoCantidad.getText().trim().length() == 0 || campoClave.getText().trim().length() == 0 || campoClaveAnalisis.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacios");
        } else {
            reqReactivo.setCveReq(Clave);
            reqReactivo.setCantidad(Double.parseDouble(campoCantidad.getText()));
            reqReactivo.setProducto(new Producto(campoClaveProducto.getText()));
            reqReactivo.setAnalisis(new Analisis(campoClaveAnalisis.getText()));
            try {
                facade.actualizar(reqReactivo);

                JOptionPane.showMessageDialog(null, "Requerimiento de Reactivo actualizado correctamente");
                campoClave.setText(null);
                campoCantidad.setText(null);
                campoClaveAnalisis.setText(null);
                campoClaveProducto.setText(null);
                mostrarRequerimientosReactivos();
            } catch (Exception e) {
                Logger.getLogger(VentanaMateriales.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (campoClaveProducto.getText().trim().length() == 0 || campoCantidad.getText().trim().length() == 0 || campoClave.getText().trim().length() == 0 || campoClaveAnalisis.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacios");
        } else {
            try {
                ReqReactivo r1 = new ReqReactivo();
                r1.setCveReq(campoClave.getText());
                ReqReactivo r2 = facade.obten(r1);
                facade.eliminar(r2);

                JOptionPane.showMessageDialog(null, "Requerimiento de Reactivo eliminado correctamente");
                campoClave.setText(null);
                campoCantidad.setText(null);
                campoClaveAnalisis.setText(null);
                campoClaveProducto.setText(null);
                mostrarRequerimientosReactivos();
            } catch (Exception e) {
                Logger.getLogger(VentanaMateriales.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("No se pudo eliminar el requerimiento de material");
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        mostrarRequerimientosReactivos();
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void tablaAnalisisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAnalisisMousePressed
        int fila = tablaAnalisis.getSelectedRow();
        if (fila >= 0) {
            campoClaveAnalisis.setText(tablaAnalisis.getValueAt(fila, 0).toString());
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN ANALISIS");
        }
    }//GEN-LAST:event_tablaAnalisisMousePressed

    private void tablaReqReactivosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReqReactivosMousePressed
        int fila = tablaReqReactivos.getSelectedRow();
        if (fila >= 0) {
            campoClave.setText(tablaReqReactivos.getValueAt(fila, 0).toString());
            campoCantidad.setText(tablaReqReactivos.getValueAt(fila, 1).toString());
            campoClaveProducto.setText(tablaReqReactivos.getValueAt(fila, 2).toString());
            campoClaveAnalisis.setText(tablaReqReactivos.getValueAt(fila, 3).toString());
            botonActualizar.setEnabled(true);
            botonEliminar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN REQUERIMIENTO DE REACTIVO");
        }
    }//GEN-LAST:event_tablaReqReactivosMousePressed

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        int fila = tablaProductos.getSelectedRow();
        if (fila >= 0) {
            campoClaveProducto.setText(tablaProductos.getValueAt(fila, 0).toString());

        } else {
            JOptionPane.showMessageDialog(null, "NO A SELECCIONADO NINGUN PRODUCTO");
        }
    }//GEN-LAST:event_tablaProductosMousePressed

    private void campoClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClaveKeyTyped
        validacion(evt);
    }//GEN-LAST:event_campoClaveKeyTyped

    private void campoClaveAnalisisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClaveAnalisisKeyTyped
        validacion(evt);
    }//GEN-LAST:event_campoClaveAnalisisKeyTyped

    private void campoClaveProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClaveProductoKeyTyped
        validacion(evt);
    }//GEN-LAST:event_campoClaveProductoKeyTyped

    private void campoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCantidadKeyTyped
        validacionNumeros(evt);
    }//GEN-LAST:event_campoCantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoClaveAnalisis;
    private javax.swing.JTextField campoClaveProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaAnalisis;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaReqReactivos;
    // End of variables declaration//GEN-END:variables
}
