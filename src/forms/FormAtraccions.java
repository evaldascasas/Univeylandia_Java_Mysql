package forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumne
 */
public class FormAtraccions extends javax.swing.JFrame {

    static final String DB_URL = "jdbc:mysql://univeylandia.cat:3306/univeylandia_test2";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "super";
    static final String DB_PASSWD = "Alumne123";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * Creates new form FormAtraccions
     */
    public FormAtraccions() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Univeylandia Database Management");
        this.setExtendedState(this.MAXIMIZED_BOTH);
        inici();
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
        insertBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        enrereBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultats = new javax.swing.JTable();
        connectionStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel1.setText("Atraccions");

        insertBtn.setText("Inserir");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Modificar");

        deleteBtn.setText("Eliminar");

        enrereBtn.setText("Enrere");
        enrereBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrereBtnActionPerformed(evt);
            }
        });

        resultats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(resultats);

        connectionStatus.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(insertBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(enrereBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectionStatus)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(connectionStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(enrereBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enrereBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrereBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_enrereBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        FormAtraccionsInsert fmi = new FormAtraccionsInsert();
        this.setVisible(false);
        fmi.setVisible(true);
    }//GEN-LAST:event_insertBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FormAtraccions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAtraccions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAtraccions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAtraccions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAtraccions().setVisible(true);
            }
        });
    }

    public void inici() {
        try {
            ArrayList columnNames = new ArrayList();

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            connectionStatus.setText("Connectat com: " + DB_USER);

            String query = "SELECT * FROM atraccions;";

            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            // obtenir metadades del resultat de la consulta
            ResultSetMetaData md = resultSet.getMetaData();

            // comptar el numero de columnes del resultat
            int columnCount = md.getColumnCount();

            // emmagatzemar el nom de les columnes en un ArrayList
            for (int i = 1; i <= columnCount; i++) {
                //System.out.print(md.getColumnName(i)+"\t");
                columnNames.add(md.getColumnName(i));
            }

            // Generar taula
            DefaultTableModel model = new DefaultTableModel();
            resultats.setModel(model);

            for (int i = 0; i < columnNames.size(); i++) {
                model.addColumn(columnNames.get(i));
            }

            // mostrar les dades en la taula despres d'haver-les guardat en un Objecte[]
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];

                for (int i = 0; i < columnCount; ++i) {
                    //row.add(resultSet.getObject(i));
                    row[i] = resultSet.getObject(i + 1);
                }
                //data.add(row);
                model.addRow(row);
            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectionStatus;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton enrereBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultats;
    // End of variables declaration//GEN-END:variables
}
