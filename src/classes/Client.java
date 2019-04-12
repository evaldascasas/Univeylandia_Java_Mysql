/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @@Evaldas Casas, Jose Febrer, Ferran Climent / GRUP-2 - Gestio d'atracions del parc
 */
public class Client {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(Timestamp email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData_naixement() {
        return data_naixement;
    }

    public void setData_naixement(String data_naixement) {
        this.data_naixement = data_naixement;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodi_postal() {
        return codi_postal;
    }

    public void setCodi_postal(String codi_postal) {
        this.codi_postal = codi_postal;
    }

    public String getTipus_document() {
        return tipus_document;
    }

    public void setTipus_document(String tipus_document) {
        this.tipus_document = tipus_document;
    }

    public String getNumero_document() {
        return numero_document;
    }

    public void setNumero_document(String numero_document) {
        this.numero_document = numero_document;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public Integer getId_dades_empleat() {
        return id_dades_empleat;
    }

    public void setId_dades_empleat(Integer id_dades_empleat) {
        this.id_dades_empleat = id_dades_empleat;
    }

    public Integer getActiu() {
        return actiu;
    }

    public void setActiu(Integer actiu) {
        this.actiu = actiu;
    }
    
    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", email=" + email + ", email_verified_at=" + email_verified_at + ", password=" + password + ", data_naixement=" + data_naixement + ", adreca=" + adreca + ", ciutat=" + ciutat + ", provincia=" + provincia + ", codi_postal=" + codi_postal + ", tipus_document=" + tipus_document + ", numero_document=" + numero_document + ", sexe=" + sexe + ", telefon=" + telefon + ", id_rol=" + id_rol + ", id_dades_empleat=" + id_dades_empleat + ", actiu=" + actiu + '}';
    }
    
    private Integer id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String email;
    private Timestamp email_verified_at;
    private String password;
    private String data_naixement;
    private String adreca;
    private String ciutat;
    private String provincia;
    private String codi_postal;
    private String tipus_document;
    private String numero_document;
    private String sexe;
    private String telefon;
    private Integer id_rol;
    private Integer id_dades_empleat ;
    private Integer actiu;
    private String consulta;
    
                                                                    
           
}
