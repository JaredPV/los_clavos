/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author jared
 */
public class Sucursales extends javax.swing.JFrame {

    /**
     * Creates new form plantilla
     */
    public Sucursales() {
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

        pnlEmpleado = new javax.swing.JPanel();
        lblEmpleado = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnActopan = new javax.swing.JButton();
        btnGeneral = new javax.swing.JButton();
        btnMineral = new javax.swing.JButton();
        btnPachuca1 = new javax.swing.JButton();
        btnPachuca2 = new javax.swing.JButton();
        btnZempoala = new javax.swing.JButton();
        lblSucursales = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlEmpleado.setBackground(new java.awt.Color(51, 255, 255));
        pnlEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblEmpleado.setFont(new java.awt.Font("Verdana", 3, 32)); // NOI18N
        lblEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        lblEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmpleado.setText("Joaquín Perez");

        lblBrand.setFont(new java.awt.Font("Verdana", 3, 32)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(0, 0, 0));
        lblBrand.setText("Los Clavos");

        javax.swing.GroupLayout pnlEmpleadoLayout = new javax.swing.GroupLayout(pnlEmpleado);
        pnlEmpleado.setLayout(pnlEmpleadoLayout);
        pnlEmpleadoLayout.setHorizontalGroup(
            pnlEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEmpleadoLayout.setVerticalGroup(
            pnlEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpleadoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpleado)
                    .addComponent(lblBrand))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnInicio.setBackground(new java.awt.Color(102, 153, 255));
        btnInicio.setFont(new java.awt.Font("Verdana", 0, 31)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(0, 0, 0));
        btnInicio.setText("Inicio");

        btnReportes.setBackground(new java.awt.Color(102, 153, 255));
        btnReportes.setFont(new java.awt.Font("Verdana", 0, 31)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(0, 0, 0));
        btnReportes.setText("Reportes");

        btnInventario.setBackground(new java.awt.Color(102, 153, 255));
        btnInventario.setFont(new java.awt.Font("Verdana", 0, 31)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(0, 0, 0));
        btnInventario.setText("Inventario");

        btnActopan.setBackground(new java.awt.Color(102, 255, 153));
        btnActopan.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnActopan.setForeground(new java.awt.Color(0, 0, 0));
        btnActopan.setText("Actopan");

        btnGeneral.setBackground(new java.awt.Color(255, 102, 51));
        btnGeneral.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnGeneral.setForeground(new java.awt.Color(0, 0, 0));
        btnGeneral.setText("General");

        btnMineral.setBackground(new java.awt.Color(102, 255, 153));
        btnMineral.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnMineral.setForeground(new java.awt.Color(0, 0, 0));
        btnMineral.setText("Mineral de la Reforma");

        btnPachuca1.setBackground(new java.awt.Color(102, 255, 153));
        btnPachuca1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnPachuca1.setForeground(new java.awt.Color(0, 0, 0));
        btnPachuca1.setText("Pachuca I");

        btnPachuca2.setBackground(new java.awt.Color(102, 255, 153));
        btnPachuca2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnPachuca2.setForeground(new java.awt.Color(0, 0, 0));
        btnPachuca2.setText("Pachuca II");

        btnZempoala.setBackground(new java.awt.Color(102, 255, 153));
        btnZempoala.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnZempoala.setForeground(new java.awt.Color(0, 0, 0));
        btnZempoala.setText("Zempoala");

        lblSucursales.setFont(new java.awt.Font("Verdana", 1, 32)); // NOI18N
        lblSucursales.setForeground(new java.awt.Color(0, 0, 0));
        lblSucursales.setText("Sucursales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnActopan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMineral)
                    .addComponent(btnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPachuca1)
                    .addComponent(btnPachuca2)
                    .addComponent(btnZempoala)
                    .addComponent(lblSucursales))
                .addGap(197, 197, 197))
            .addComponent(pnlEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSucursales)
                        .addGap(32, 32, 32)
                        .addComponent(btnActopan)
                        .addGap(18, 18, 18)
                        .addComponent(btnMineral)
                        .addGap(18, 18, 18)
                        .addComponent(btnPachuca1)
                        .addGap(18, 18, 18)
                        .addComponent(btnPachuca2)
                        .addGap(18, 18, 18)
                        .addComponent(btnZempoala)
                        .addGap(18, 18, 18)
                        .addComponent(btnGeneral)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(51, 51, 51))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sucursales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActopan;
    public javax.swing.JButton btnGeneral;
    public javax.swing.JButton btnInicio;
    public javax.swing.JButton btnInventario;
    public javax.swing.JButton btnMineral;
    public javax.swing.JButton btnPachuca1;
    public javax.swing.JButton btnPachuca2;
    public javax.swing.JButton btnReportes;
    public javax.swing.JButton btnZempoala;
    public javax.swing.JLabel lblBrand;
    public javax.swing.JLabel lblEmpleado;
    public javax.swing.JLabel lblSucursales;
    public javax.swing.JPanel pnlEmpleado;
    // End of variables declaration//GEN-END:variables
}