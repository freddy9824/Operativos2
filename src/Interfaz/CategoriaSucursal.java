/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import gamabanquero.Logica;
import javax.swing.JOptionPane;

/**
 *
 * @author Felix Castillo
 */
public class CategoriaSucursal extends javax.swing.JFrame {

    /**
     * Creates new form Gama
     * @param logica
     */
    public Logica logica;
    
    public CategoriaSucursal(Logica logica) {
        this.logica = logica;
        initComponents();
        setLocationRelativeTo(this);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Categoria = new javax.swing.JTextField();
        Subcursales = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matriz Categoría / Sucursal");

        Categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });

        Subcursales.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Categorías (Recursos)");

        jLabel3.setText("Sucursales (Procesos)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Subcursales, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Subcursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int num_processes = Integer.parseInt(Subcursales.getText());
        while (num_processes < 6) {
           String aux = JOptionPane.showInputDialog(null,"Minimo de sucursales 6","Aviso!", JOptionPane.ERROR_MESSAGE);
            if (aux == null || aux.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Recuadro Vacio o Presionado Botón cancelar, se ha iniciado el cierre del programa", "Aviso!", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            num_processes = Integer.parseInt(aux);
        }
        logica.sucursales = new String[num_processes];
        logica.imprimirSucursales(num_processes, logica.sucursales);
        int num_resources = Integer.parseInt(Categoria.getText());
        logica.need = new int[num_processes][num_resources];
        logica.max = new int[num_processes][num_resources];
        logica.allocated_resources = new int[num_processes][num_resources];
        logica.available_resources = new int[1][num_resources];
        
        setVisible(false);
        String aux;
        
        // Get Max Matrix input
	JOptionPane.showMessageDialog(rootPane, "Por favor introduce la matriz de empleados requeridos en cada sucursal en cada una de sus categorías");
	for (int i = 0; i < num_processes; i++) {
            JOptionPane.showMessageDialog(rootPane, "Usted esta llenando los valores de Sucursal " + (i + 1) + " (P" + i + "): ");
            for (int j = 0; j < num_resources; j++) {
                                aux = JOptionPane.showInputDialog("Colocar número");
                                if (aux == null || aux.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Recuadro Vacio o Presionado Botón cancelar, se ha iniciado el cierre del programa", "Aviso!", JOptionPane.ERROR_MESSAGE);
                                    System.exit(0);
                                }
                                logica.max[i][j] = Integer.parseInt(aux); // max matrix
            }
	}
        
        JOptionPane.showMessageDialog(rootPane, "Por favor introduce la matriz de empleados iniciales en cada categoría al abrir la sucursal");
        for (int i = 0; i < num_processes; i++) {
            JOptionPane.showMessageDialog(rootPane, "Usted esta llenando los valores de la Sucursal " + (i + 1) + " (P" + i + "): ");
            for (int j = 0; j < num_resources; j++) {
                aux = JOptionPane.showInputDialog("Colocar número");
                if (aux == null || aux.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Recuadro Vacio o Presionado Botón cancelar, se ha iniciado el cierre del programa", "Aviso!", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                logica.allocated_resources[i][j] = Integer.parseInt(aux); // allocation matrix
            }
        }

	// Get available matrix input
	JOptionPane.showMessageDialog(rootPane, "Por favor introduzca la cantidad de empleados disponibles en cada categoría");
	for (int j = 0; j < num_resources; j++) {
                    aux = JOptionPane.showInputDialog("Colocar número");
                    if (aux == null || aux.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Recuadro Vacio o Presionado Botón cancelar, se ha iniciado el cierre del programa", "Aviso!", JOptionPane.ERROR_MESSAGE);
                         System.exit(0);
                    }
                    logica.available_resources[0][j] = Integer.parseInt(aux); // available matrix
                 }
        
              logica.need = logica.calc_need();
              
              Requeridos requerido = new Requeridos();
              Iniciales inicial = new Iniciales();
              Necesario necesario = new Necesario();
              Orden orden = new Orden();
              logica.imprimirEnInterfaz(requerido.Disponible, logica.max);
              requerido.setVisible(true);
              logica.imprimirEnInterfaz(inicial.jTextArea1, logica.allocated_resources);
              inicial.setVisible(true);
              logica.imprimirEnInterfaz(necesario.necesario, logica.need);
              necesario.setVisible(true);
              logica.imprimirArray(orden.jTextArea1, logica.order ,logica.sucursales);
              orden.setVisible(true);
              logica.revisarInterbloqueo();	
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CategoriaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoriaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoriaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Categoria;
    private javax.swing.JTextField Subcursales;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
