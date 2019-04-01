package classes;

import java.sql.Date;

/**
 *
 * @author DAW2 Grup2: Evaldas Casas
 */
public class Atraccio {
    private String nom_atraccio;
    private int tipus_atraccio;
    private Date data_innauguracio;
    private int altura_min;
    private int altura_max;
    private boolean accessibilitat;
    private boolean acces_expres;
    private String descripcio;
    private int votacions;

    public String getNom_atraccio() {
        return nom_atraccio;
    }

    public void setNom_atraccio(String nom_atraccio) {
        this.nom_atraccio = nom_atraccio;
    }

    public int getTipus_atraccio() {
        return tipus_atraccio;
    }

    public void setTipus_atraccio(int tipus_atraccio) {
        this.tipus_atraccio = tipus_atraccio;
    }

    public Date getData_innauguracio() {
        return data_innauguracio;
    }

    public void setData_innauguracio(Date data_innauguracio) {
        this.data_innauguracio = data_innauguracio;
    }

    public int getAltura_min() {
        return altura_min;
    }

    public void setAltura_min(int altura_min) {
        this.altura_min = altura_min;
    }

    public int getAltura_max() {
        return altura_max;
    }

    public void setAltura_max(int altura_max) {
        this.altura_max = altura_max;
    }

    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    public void setAccessibilitat(boolean accessibilitat) {
        this.accessibilitat = accessibilitat;
    }

    public boolean isAcces_expres() {
        return acces_expres;
    }

    public void setAcces_expres(boolean acces_expres) {
        this.acces_expres = acces_expres;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getVotacions() {
        return votacions;
    }

    public void setVotacions(int votacions) {
        this.votacions = votacions;
    }
    
}
