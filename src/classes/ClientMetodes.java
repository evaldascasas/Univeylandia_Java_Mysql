/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import connection.DBConnection;                                                 //IMPORT per la conexio amb la BD
import java.sql.Connection;                                                     //IMPORT per la conexio SQL
import java.sql.PreparedStatement;                                              //IMPORT per el Statement
import java.sql.ResultSet;                                                      //IMPORT per el resultSet
import java.sql.SQLException;                                                   //IMPORT per les execepcions SQL


/**
 *
 * @author Ferran Climent - GRUP2
 */
public class ClientMetodes {                                                    //Classe que contindra els diferents metodes per elaborar el CRUD de client
  

    public static String registrarClient(Client users) throws SQLException {    //Metode per registrar un client
        String result = null, last = null;                                      //Variable per mostrar el resultat
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        String sql = "INSERT INTO users (nom, cognom1, cognom2, email, password, data_naixement, adreca, ciutat, provincia, codi_postal, tipus_document, numero_document, sexe, telefon, id_rol)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";       //La SQL per inserir clients
              
        try {
            pst = cn.prepareStatement(sql);                                     //Passar tots els valors necesaris per el insert
            pst.setString(1, users.getNom());
            pst.setString(2, users.getCognom1());
            pst.setString(3, users.getCognom2());
            pst.setString(4, users.getEmail());
            //pst.setTimestamp(5, user.getEmail_verified_at());
            pst.setString(5, users.getPassword()); //bcrypt
            pst.setString(6, users.getData_naixement());
            pst.setString(7, users.getAdreca());
            pst.setString(8, users.getCiutat());
            pst.setString(9, users.getProvincia());
            pst.setString(10, users.getCodi_postal());
            pst.setString(11, users.getTipus_document());
            pst.setString(12, users.getNumero_document());
            pst.setString(13, users.getSexe());
            pst.setString(14, users.getTelefon());
            pst.setInt(15, users.getId_rol());
            //pst.setInt(17, user.getActiu());
            pst.execute();                                                      //Executar el STATEMNT
            pst = cn.prepareStatement("SELECT MAX(id) AS id FROM users");
            ResultSet rs = pst.executeQuery();                                  //Executar la Query
            
            if (rs.next()) {                                                    
                last = rs.getString(1);
            }

            result = "Usuari registrat amb exit, ID: " + last;                  //Si tot funciona mostrar el resultat amb el ID del introduit

        } catch (SQLException e) {
            result = "Error en la consulta " + e.getMessage();                  //Mostrar el error
        } finally {
            if (cn != null) {
                cn.close();                                                     //Tancar conexio i el statement
                pst.close();

            }
        }
        return result;                                                          //Retornar el resultat
    }

    public static String actualitzarClient(Client users) throws SQLException {  //Metode per actualitzar un client
        String result = null, last = null;                                      //Variable per mostrar el resultat
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        String sql = "UPDATE users SET nom=?,cognom1=?,cognom2=?,email=?,password=?,data_naixement=?,adreca=?,ciutat=?,provincia=?,codi_postal=?,tipus_document=?,numero_document=?,sexe=?,telefon=?  WHERE id=?";         //SQL del actualitzar
        try {
            pst = cn.prepareStatement(sql);                                     //Passar tots els atributs per actualitzar
            pst.setString(1, users.getNom());
            pst.setString(2, users.getCognom1());
            pst.setString(3, users.getCognom2());
            pst.setString(4, users.getEmail());
            pst.setString(5, users.getPassword());
            pst.setString(6, users.getData_naixement());
            pst.setString(7, users.getAdreca());
            pst.setString(8, users.getCiutat());
            pst.setString(9, users.getProvincia());
            pst.setString(10, users.getCodi_postal());
            pst.setString(11, users.getTipus_document());
            pst.setString(12, users.getNumero_document());
            pst.setString(13, users.getSexe());
            pst.setString(14, users.getTelefon());
            pst.setInt(15, users.getId());

            pst.execute();                                                      //Executar el statement

            result = "Usuari actualitzat amb exit, ID: " + users.getId();       //Mostrar si tot funciona adecuadament

        } catch (SQLException e) {
            result = "Error en la consulta " + e.getMessage();                  //Mostrar si existeix un error
        } finally {
            if (cn != null) {
                cn.close();                                                     //Tancar conexio i el Stetement
                pst.close();

            }
        } return result;                                                        //Retornar el resultat
    }

    public static String eliminarClient(Client users) throws SQLException {
        String result = null, last = null;                                      //Variable per mostrar el resultat
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        String sql = "DELETE FROM users WHERE id=?";                            //SQL per eliminar el client
        
        try {
            pst = cn.prepareStatement(sql);                                     //Preperar el estat
            pst.setInt(1, users.getId());                                       //Passar el atributs necessaris

            pst.executeUpdate();                                                //Executar el Statement
            
            result = "Usuari eliminat amb exit, ID: " + users.getId();          //Mostrar el usuari eliminat amb el seu ID

        } catch (SQLException e) {
            result = ("Error en la consulta " + e.getMessage());                //Si existeix un error mostar-ho
        } finally {
            if (cn != null) {
                cn.close();                                                     //Tancar conexio i Statement
                pst.close();

            }
        }return result;                                                         //Retornar el resultat
    }
    

    

}
