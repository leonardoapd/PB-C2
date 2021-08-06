/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

/**
 *
 * @author Leonardo Perdomo
 */
public class ViewPedido extends javax.swing.JFrame {

    FrmViewTerceros2 gestionarTerceros;
    FrmViewProductos gestionarProductos;
    FrmViewGestorInventario gestionarInventario;
    FrmViewVerInventario verInventario;
    FrmViewPedidos2 gestionarPedido;

    /**
     * Creates new form ViewPedido
     */
    public ViewPedido() {
        gestionarTerceros = new FrmViewTerceros2();
        gestionarProductos = new FrmViewProductos();
        gestionarInventario = new FrmViewGestorInventario();
        verInventario = new FrmViewVerInventario();
        gestionarPedido = new FrmViewPedidos2();
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

        jMenu1 = new javax.swing.JMenu();
        jDesktopPane = new javax.swing.JDesktopPane();
        gestionarTercerosBtn = new javax.swing.JLabel();
        gestionarPedidosBtn = new javax.swing.JLabel();
        gestionarProductosBtn = new javax.swing.JLabel();
        gestionarInventarioBtn = new javax.swing.JLabel();
        gestionarVentasBtn = new javax.swing.JLabel();
        verInventarioBtn = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de Pedidos");
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(1366, 725));
        setResizable(false);

        jDesktopPane.setToolTipText("");
        jDesktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jDesktopPane.setPreferredSize(new java.awt.Dimension(1366, 690));

        gestionarTercerosBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestionarTercerosBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lperd\\Documents\\NetBeansProjects\\PB-C2\\RetoPB-C2\\src\\main\\java\\Resources\\worker-128px.png")); // NOI18N
        gestionarTercerosBtn.setText("Gestionar Terceros");
        gestionarTercerosBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gestionarTercerosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarTercerosBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionarTercerosBtn.setPreferredSize(new java.awt.Dimension(128, 148));
        gestionarTercerosBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestionarTercerosBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionarTercerosBtnMouseClicked(evt);
            }
        });

        gestionarPedidosBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lperd\\Documents\\NetBeansProjects\\PB-C2\\RetoPB-C2\\src\\main\\java\\Resources\\delivery-box-128px.png")); // NOI18N
        gestionarPedidosBtn.setText("Gestionar Pedidos");
        gestionarPedidosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarPedidosBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionarPedidosBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestionarPedidosBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionarPedidosBtnMouseClicked(evt);
            }
        });

        gestionarProductosBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lperd\\Documents\\NetBeansProjects\\PB-C2\\RetoPB-C2\\src\\main\\java\\Resources\\caja.png")); // NOI18N
        gestionarProductosBtn.setText("Gestionar Productos");
        gestionarProductosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarProductosBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionarProductosBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestionarProductosBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionarProductosBtnMouseClicked(evt);
            }
        });

        gestionarInventarioBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lperd\\Documents\\NetBeansProjects\\PB-C2\\RetoPB-C2\\src\\main\\java\\Resources\\estar.png")); // NOI18N
        gestionarInventarioBtn.setText("Gestionar Inventario");
        gestionarInventarioBtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gestionarInventarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarInventarioBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionarInventarioBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gestionarInventarioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionarInventarioBtnMouseClicked(evt);
            }
        });

        gestionarVentasBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lperd\\Documents\\NetBeansProjects\\PB-C2\\RetoPB-C2\\src\\main\\java\\Resources\\shopping-basket.png")); // NOI18N
        gestionarVentasBtn.setText("Gestionar Ventas");
        gestionarVentasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarVentasBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gestionarVentasBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        verInventarioBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lperd\\Documents\\NetBeansProjects\\PB-C2\\Reto-PB-C2\\src\\Resources\\inventario-128-px.png")); // NOI18N
        verInventarioBtn.setText("Ver Inventario");
        verInventarioBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        verInventarioBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        verInventarioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verInventarioBtnMouseClicked(evt);
            }
        });

        jDesktopPane.setLayer(gestionarTercerosBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(gestionarPedidosBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(gestionarProductosBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(gestionarInventarioBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(gestionarVentasBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(verInventarioBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionarInventarioBtn)
                    .addComponent(gestionarProductosBtn)
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addComponent(gestionarPedidosBtn)
                        .addGap(18, 18, 18)
                        .addComponent(verInventarioBtn))
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addComponent(gestionarTercerosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gestionarVentasBtn)))
                .addContainerGap(1077, Short.MAX_VALUE))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gestionarTercerosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gestionarVentasBtn))
                        .addGap(18, 18, 18)
                        .addComponent(gestionarPedidosBtn))
                    .addComponent(verInventarioBtn))
                .addGap(18, 18, 18)
                .addComponent(gestionarProductosBtn)
                .addGap(18, 18, 18)
                .addComponent(gestionarInventarioBtn)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestionarTercerosBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionarTercerosBtnMouseClicked
        try {
            jDesktopPane.add(gestionarTerceros);
            gestionarTerceros.show();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_gestionarTercerosBtnMouseClicked

    private void gestionarProductosBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionarProductosBtnMouseClicked
        try {
            jDesktopPane.add(gestionarProductos);
            gestionarProductos.show();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_gestionarProductosBtnMouseClicked

    private void gestionarInventarioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionarInventarioBtnMouseClicked
        try {
            jDesktopPane.add(gestionarInventario);
            gestionarInventario.show();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_gestionarInventarioBtnMouseClicked

    private void verInventarioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verInventarioBtnMouseClicked
        try {
            jDesktopPane.add(verInventario);
            verInventario.show();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_verInventarioBtnMouseClicked

    private void gestionarPedidosBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionarPedidosBtnMouseClicked
        try {
            jDesktopPane.add(gestionarPedido);
            gestionarPedido.show();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_gestionarPedidosBtnMouseClicked
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPedido().setVisible(true);
            }
        });
    }

    /**
     * Metodo para mostrar el icono deseado en la barra de la ventana.
     * Se debe configurar el iconImage en las propiedades del jFrame 
     * principal
     * @return retValue que configura el icono de la ventana
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Resources/order-24px.png"));

        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gestionarInventarioBtn;
    private javax.swing.JLabel gestionarPedidosBtn;
    private javax.swing.JLabel gestionarProductosBtn;
    private javax.swing.JLabel gestionarTercerosBtn;
    private javax.swing.JLabel gestionarVentasBtn;
    protected javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel verInventarioBtn;
    // End of variables declaration//GEN-END:variables
}
