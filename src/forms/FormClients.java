/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Client;                                                          //IMPORT de les classes CLIENT
import classes.ClientMetodes;                                                   //iMPORT de la classe ClientMetodes
import connection.DBConnection;                                                 //IMPORT de la conexio 
import java.awt.HeadlessException;                                              //IMPORT de excepcions
import java.sql.Connection;                                                     //IMPORT de SQL
import java.sql.ResultSet;                                                      //IMPORT de SQL
import java.sql.ResultSetMetaData;                                              //IMPORT de SQL
import java.sql.SQLException;                                                   //IMPORT de SQL
import java.sql.Statement;                                                      //IMPORT de SQL
import java.util.ArrayList;                                                     //IMPORT per les Arraylist
import java.util.logging.Level;                                                 //IMPORT per el loging level
import java.util.logging.Logger;                                                //IMPORT per el loggin logger
import javax.swing.JOptionPane;                                                 //IMPORT  per els JOPTION
import javax.swing.table.DefaultTableModel;                                     //IMPORT per a la taula
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ferran Climent - GRUP2 Sprint5
 */
public class FormClients extends javax.swing.JFrame {

    int posicioTaula[];                                                        //On es guardara la posicio que seleccionem
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form FormClients
     */
    public FormClients() {
        DBConnection.getConnection();                                           //Aconseguir la conexio amb la BD
        initComponents();
        cargarTaulaClient();                                                    //Cargar la taula amb la BD
        this.setExtendedState(MAXIMIZED_BOTH);                                  //Mostrar el programa a pantalla completa

    }

    public void cargarTaulaClient() {
        DBConnection cc = new DBConnection();
        Connection conn = DBConnection.getConnection();
        Statement stmt = null;

        try {

            ArrayList nomCol = new ArrayList();                                 //Declarar arraylist per guardar el nom de les columnes 

            stmt = conn.createStatement();                                      //Crear un STATEMENT amb la conexio 

            String consulta = "SELECT * FROM users WHERE  id_rol = 1";
   
                ResultSet rs = stmt.executeQuery(consulta);                     //Executar la consulta amb el STATEMNT i guardar-ho al resultSet

            ResultSetMetaData dades = rs.getMetaData();

            int numCol = dades.getColumnCount();                            //Guardar el numero de columnes de la taula que fas la consulta

            for (int i = 1; i <= numCol; i++) {                             //Recorrer tota la taula que i guardar-ho a la arraylist
                nomCol.add(dades.getColumnName(i));
            }

                Object[] etiquetes = new Object[numCol];                        // Crear un OBJECTE amb el numero de columnes
               
                c_taula.removeAll();
                model = new DefaultTableModel();
                c_taula.setModel(model);
               

            c_taula.setModel(model);

            for (int i = 0; i < nomCol.size(); i++) {                       //Afegir una columna amb tots els objectes de nomCol
                model.addColumn(nomCol.get(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[numCol];                         //Afegir una fila amb tots els resultats del resultSet

                for (int i = 0; i < numCol; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);

            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());                                 //Si existeix un error mostrar-ho per pantalla

        } finally {
            try {
                stmt.close();                                                   //Tancar statement
                conn.close();                                                   //Tancar connexio
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void filter(String consulta, JTable c_taula) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

        c_taula.setRowSorter(sorter);

        sorter.setRowFilter(RowFilter.regexFilter(consulta));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        c_nom = new javax.swing.JTextField();
        c_cognom1 = new javax.swing.JTextField();
        c_cognom2 = new javax.swing.JTextField();
        c_email = new javax.swing.JTextField();
        c_password = new javax.swing.JTextField();
        c_adreca = new javax.swing.JTextField();
        c_ciutat = new javax.swing.JTextField();
        c_provincia = new javax.swing.JTextField();
        c_codi_postal = new javax.swing.JTextField();
        c_tipus_document = new javax.swing.JTextField();
        c_numero_document = new javax.swing.JTextField();
        c_sexe = new javax.swing.JTextField();
        c_telefon = new javax.swing.JTextField();
        b_registrar = new javax.swing.JButton();
        b_actualitzar = new javax.swing.JButton();
        b_cargar = new javax.swing.JButton();
        b_eliminar = new javax.swing.JButton();
        b_borrardades = new javax.swing.JButton();
        p_status = new javax.swing.JTextField();
        b_cargardades = new javax.swing.JButton();
        c_data_naixement2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        c_taula = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        filtertxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        c_recargartaula = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom");

        jLabel2.setText("Cogom1");

        jLabel3.setText("Cogom2");

        jLabel4.setText("email");

        jLabel5.setText("password");

        jLabel6.setText("data_naixement");

        jLabel7.setText("adreca");

        jLabel8.setText("ciutat");

        jLabel9.setText("provincia");

        jLabel10.setText("codi_postal");

        jLabel11.setText("tipus_document");

        jLabel12.setText("numero_document");

        jLabel13.setText("sexe");

        jLabel14.setText("telefon");

        c_ciutat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_ciutatActionPerformed(evt);
            }
        });

        b_registrar.setText("Registrar");
        b_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_registrarActionPerformed(evt);
            }
        });

        b_actualitzar.setText("Actualitzar");
        b_actualitzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_actualitzarActionPerformed(evt);
            }
        });

        b_cargar.setText("Cargar usuari");
        b_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cargarActionPerformed(evt);
            }
        });

        b_eliminar.setText("Eliminar");
        b_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_eliminarActionPerformed(evt);
            }
        });

        b_borrardades.setText("Borrar dades");
        b_borrardades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_borrardadesActionPerformed(evt);
            }
        });

        p_status.setEditable(false);
        p_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_statusActionPerformed(evt);
            }
        });

        b_cargardades.setText("SEEDS de DADES");
        b_cargardades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cargardadesActionPerformed(evt);
            }
        });

        c_taula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(c_taula);

        jLabel15.setText("ID");

        c_id.setEditable(false);

        filtertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtertxtActionPerformed(evt);
            }
        });
        filtertxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtertxtKeyReleased(evt);
            }
        });

        jLabel16.setText("Cercador per buscar:");

        c_recargartaula.setText("RECARGAR TAULA");
        c_recargartaula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_recargartaulaActionPerformed(evt);
            }
        });

        jButton1.setText("Enrere");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(b_borrardades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(b_cargardades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(c_id, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(c_sexe, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(c_cognom1)
                                    .addComponent(c_cognom2)
                                    .addComponent(c_email)
                                    .addComponent(c_password)
                                    .addComponent(c_adreca)
                                    .addComponent(c_ciutat)
                                    .addComponent(c_provincia)
                                    .addComponent(c_codi_postal)
                                    .addComponent(c_tipus_document)
                                    .addComponent(c_numero_document)
                                    .addComponent(c_data_naixement2)
                                    .addComponent(c_nom)
                                    .addComponent(c_telefon)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b_actualitzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b_cargar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(filtertxt)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(c_recargartaula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(p_status, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_cognom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_cognom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(c_data_naixement2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(c_adreca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(c_ciutat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(c_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(c_codi_postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(c_tipus_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(c_numero_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(c_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(c_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(b_borrardades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_cargardades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_recargartaula)
                .addGap(22, 22, 22)
                .addComponent(b_registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_actualitzar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_cargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_registrarActionPerformed
        Client users = new Client();                                            //Crear un nou users de tipus client
        users.setNom(c_nom.getText());                                          //Agafar les variables dels texfields i enviar-les als users
        users.setCognom1(c_cognom1.getText());
        users.setCognom2(c_cognom2.getText());
        users.setEmail(c_email.getText());
        users.setPassword(c_password.getText());
        users.setData_naixement(c_data_naixement2.getText());
        users.setAdreca(c_adreca.getText());
        users.setCiutat(c_ciutat.getText());
        users.setProvincia(c_provincia.getText());
        users.setCodi_postal(c_codi_postal.getText());
        users.setTipus_document(c_tipus_document.getText());
        users.setNumero_document(c_numero_document.getText());
        users.setSexe(c_sexe.getText());
        users.setTelefon(c_telefon.getText());
        users.setId_rol(1);

        try {
            String resp = ClientMetodes.registrarClient(users);                 //Cridar al metode registrar client i passar el users
            p_status.setText(resp);                                             //Plenar el estat amb la resposta
        } catch (SQLException ex) {
            Logger.getLogger(FormClients.class.getName()).log(Level.SEVERE, null, ex);  //Mostrar error
        }

        c_nom.setText("");                                                      //Buidar tots els camps per nova operacio
        c_cognom1.setText("");
        c_cognom2.setText("");
        c_email.setText("");
        c_password.setText("");
        c_data_naixement2.setText("");
        c_adreca.setText("");
        c_ciutat.setText("");
        c_provincia.setText("");
        c_codi_postal.setText("");
        c_tipus_document.setText("");
        c_numero_document.setText("");
        c_sexe.setText("");
        c_telefon.setText("");
        
        cargarTaulaClient();                                                   //Cargar la taula per veure els cambis
    }//GEN-LAST:event_b_registrarActionPerformed

    private void b_borrardadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_borrardadesActionPerformed
        c_id.setText("");                                                       //Borrar totes les dades dels texfield a la vegada per agiitzar
        c_nom.setText("");
        c_cognom1.setText("");
        c_cognom2.setText("");
        c_email.setText("");
        c_password.setText("");
        c_data_naixement2.setText("");
        c_adreca.setText("");
        c_ciutat.setText("");
        c_provincia.setText("");
        c_codi_postal.setText("");
        c_tipus_document.setText("");
        c_numero_document.setText("");
        c_sexe.setText("");
        c_telefon.setText("");
    }//GEN-LAST:event_b_borrardadesActionPerformed

    private void b_actualitzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_actualitzarActionPerformed
        Client users = new Client();                                            //Crear un nou users de tipus client
        users.setNom(c_nom.getText());                                          //Agafar les variables dels texfields i enviar-les als users
        users.setCognom1(c_cognom1.getText());
        users.setCognom2(c_cognom2.getText());
        users.setEmail(c_email.getText());
        users.setPassword(c_password.getText());
        users.setData_naixement(c_data_naixement2.getText());
        users.setAdreca(c_adreca.getText());
        users.setCiutat(c_ciutat.getText());
        users.setProvincia(c_provincia.getText());
        users.setCodi_postal(c_codi_postal.getText());
        users.setTipus_document(c_tipus_document.getText());
        users.setNumero_document(c_numero_document.getText());
        users.setSexe(c_sexe.getText());
        users.setTelefon(c_telefon.getText());
        users.setId(Integer.parseInt(c_id.getText()));

        try {
            String resp = ClientMetodes.actualitzarClient(users);               //Ennviar les dades al metode actualitzar client
            p_status.setText(resp);                                             //Plenar el estat amb la resposta
        } catch (SQLException ex) {
            Logger.getLogger(FormClients.class.getName()).log(Level.SEVERE, null, ex);
        }

        c_id.setText("");                                                       //Tornar tots els texfields buits per una nova operacio
        c_nom.setText("");
        c_cognom1.setText("");
        c_cognom2.setText("");
        c_email.setText("");
        c_password.setText("");
        c_data_naixement2.setText("");
        c_adreca.setText("");
        c_ciutat.setText("");
        c_provincia.setText("");
        c_codi_postal.setText("");
        c_tipus_document.setText("");
        c_numero_document.setText("");
        c_sexe.setText("");
        c_telefon.setText("");

        cargarTaulaClient();                                                   //Cargar la taula de nou per veure els cambis
    }//GEN-LAST:event_b_actualitzarActionPerformed

    private void b_cargardadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cargardadesActionPerformed
        c_nom.setText("Ferran");                                                //Dades prefabricades per agilitzar el proces
        c_cognom1.setText("Climent");
        c_cognom2.setText("Vidal");
        c_email.setText("ferran@climent.com");
        c_password.setText("Alumne123");
        c_data_naixement2.setText("1999-10-24");
        c_adreca.setText("Sant Josep 76");
        c_ciutat.setText("La Rapita");
        c_provincia.setText("Tarragona");
        c_codi_postal.setText("43540");
        c_tipus_document.setText("DNI");
        c_numero_document.setText("47479724L");
        c_sexe.setText("Home");
        c_telefon.setText("659784325");
    }//GEN-LAST:event_b_cargardadesActionPerformed

    private void p_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_statusActionPerformed

    private void c_ciutatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_ciutatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_ciutatActionPerformed

    private void b_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cargarActionPerformed

        try {

            posicioTaula = c_taula.getSelectedRows();                           //Iguales la array de la posicio de la taula a les files seleccionades

            if (posicioTaula.length > 1) {                                       //Alerta per evitar errors de mes de una fila seleccionada
                JOptionPane.showMessageDialog(null, "Nomes pots seleccionar una fila");
            } else {
                String client_id = c_taula.getValueAt(c_taula.getSelectedRow(), 0).toString(); //Agafar el valor del id de la taula
                String client_nom = c_taula.getValueAt(c_taula.getSelectedRow(), 1).toString(); //Agafar el valor del nom de la taula
                String client_cognom1 = c_taula.getValueAt(c_taula.getSelectedRow(), 2).toString(); //Agafar el valor del cognom1 de la taula
                String client_cognom2 = c_taula.getValueAt(c_taula.getSelectedRow(), 3).toString(); //Agafar el valor del cognom2 de la taula
                String client_email = c_taula.getValueAt(c_taula.getSelectedRow(), 4).toString(); //Agafar el valor del email de la taula
                String client_password = c_taula.getValueAt(c_taula.getSelectedRow(), 6).toString(); //Agafar el valor del password de la taula
                String client_data = c_taula.getValueAt(c_taula.getSelectedRow(), 7).toString(); //Agafar el valor del data de la taula
                String client_adreca = c_taula.getValueAt(c_taula.getSelectedRow(), 8).toString(); //Agafar el valor del adreca de la taula
                String client_ciutat = c_taula.getValueAt(c_taula.getSelectedRow(), 9).toString(); //Agafar el valor del ciutat de la taula
                String client_provincia = c_taula.getValueAt(c_taula.getSelectedRow(), 10).toString(); //Agafar el valor del provincia de la taula
                String client_codi_postal = c_taula.getValueAt(c_taula.getSelectedRow(), 11).toString(); //Agafar el valor del codi_postal de la taula
                String client_tipus_document = c_taula.getValueAt(c_taula.getSelectedRow(), 12).toString(); //Agafar el valor del tipus_document de la taula
                String client_numero_document = c_taula.getValueAt(c_taula.getSelectedRow(), 13).toString(); //Agafar el valor del numero_document de la taula
                String client_sexe = c_taula.getValueAt(c_taula.getSelectedRow(), 14).toString(); //Agafar el valor del sexe de la taula
                String client_telefon = c_taula.getValueAt(c_taula.getSelectedRow(), 15).toString(); //Agafar el valor del telfon de la taula

                c_id.setText(client_id);                                    //Plenar els Textfield amb la variable corresponent
                c_nom.setText(client_nom);                                  //Plenar els Textfield amb la variable corresponent
                c_cognom1.setText(client_cognom1);                          //Plenar els Textfield amb la variable corresponent
                c_cognom2.setText(client_cognom2);                          //Plenar els Textfield amb la variable corresponent
                c_email.setText(client_email);                              //Plenar els Textfield amb la variable corresponent
                c_password.setText(client_password);                        //Plenar els Textfield amb la variable corresponent
                c_data_naixement2.setText(client_data);                     //Plenar els Textfield amb la variable corresponent
                c_adreca.setText(client_adreca);                            //Plenar els Textfield amb la variable corresponent
                c_ciutat.setText(client_ciutat);                            //Plenar els Textfield amb la variable corresponent
                c_provincia.setText(client_provincia);                      //Plenar els Textfield amb la variable corresponent
                c_codi_postal.setText(client_codi_postal);                  //Plenar els Textfield amb la variable corresponent
                c_tipus_document.setText(client_tipus_document);            //Plenar els Textfield amb la variable corresponent
                c_numero_document.setText(client_numero_document);          //Plenar els Textfield amb la variable corresponent
                c_sexe.setText(client_sexe);                                //Plenar els Textfield amb la variable corresponent
                c_telefon.setText(client_telefon);                          //Plenar els Textfield amb la variable corresponent

                System.out.println(client_id);
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);  //Mostrar error amb JOption
        }
    }//GEN-LAST:event_b_cargarActionPerformed

    private void b_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_eliminarActionPerformed

        Client users = new Client();                                            //Crear un nou usuari de tipus client
        users.setId(Integer.parseInt(c_id.getText()));                          //Seleccionar el ID cargat i enviar-ho

        try {
            String resp = ClientMetodes.eliminarClient(users);                  //Cridar al metode de eliminar client, passar el user
            p_status.setText(resp);
        } catch (SQLException ex) {
            Logger.getLogger(FormClients.class.getName()).log(Level.SEVERE, null, ex);          //Error 
        }

        c_id.setText("");                                                       //Buidar els camps per noves operacions
        c_nom.setText("");
        c_cognom1.setText("");
        c_cognom2.setText("");
        c_email.setText("");
        c_password.setText("");
        c_data_naixement2.setText("");
        c_adreca.setText("");
        c_ciutat.setText("");
        c_provincia.setText("");
        c_codi_postal.setText("");
        c_tipus_document.setText("");
        c_numero_document.setText("");
        c_sexe.setText("");
        c_telefon.setText("");

        cargarTaulaClient();                                                   //Cargar la taula de nou per veure els cambis

    }//GEN-LAST:event_b_eliminarActionPerformed

    private void filtertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtertxtActionPerformed

    }//GEN-LAST:event_filtertxtActionPerformed

    private void filtertxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtertxtKeyReleased
        // TODO add your handling code here:
        String consulta = filtertxt.getText();
        filter("(?i)" + consulta, c_taula);
    }//GEN-LAST:event_filtertxtKeyReleased

    private void c_recargartaulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_recargartaulaActionPerformed
        // TODO add your handling code here:
        cargarTaulaClient();
    }//GEN-LAST:event_c_recargartaulaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrameMain fm = new FrameMain();
        this.setVisible(false);
        this.dispose();
        fm.setVisible(true);
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
            java.util.logging.Logger.getLogger(FormClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormClients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormClients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_actualitzar;
    private javax.swing.JButton b_borrardades;
    private javax.swing.JButton b_cargar;
    private javax.swing.JButton b_cargardades;
    private javax.swing.JButton b_eliminar;
    private javax.swing.JButton b_registrar;
    private javax.swing.JTextField c_adreca;
    private javax.swing.JTextField c_ciutat;
    private javax.swing.JTextField c_codi_postal;
    private javax.swing.JTextField c_cognom1;
    private javax.swing.JTextField c_cognom2;
    private javax.swing.JTextField c_data_naixement2;
    private javax.swing.JTextField c_email;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_nom;
    private javax.swing.JTextField c_numero_document;
    private javax.swing.JTextField c_password;
    private javax.swing.JTextField c_provincia;
    private javax.swing.JButton c_recargartaula;
    private javax.swing.JTextField c_sexe;
    private javax.swing.JTable c_taula;
    private javax.swing.JTextField c_telefon;
    private javax.swing.JTextField c_tipus_document;
    private javax.swing.JTextField filtertxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField p_status;
    // End of variables declaration//GEN-END:variables
}
