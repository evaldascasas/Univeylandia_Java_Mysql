/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @Evaldas Casas, Jose Febrer, Ferran Climent / GRUP-2 - Gestio d'atracions del parc
 */
public class Ticket {
    private int id;
    private String descripcio;
    private int estat;
    private int tipus;
    private int mida;
    private int tickets_viatges;
    private int preu;
    
    public Ticket (String descripcio_c, int estat_c,int tipus_c, int mida_c, int tickets_viatges_c, int preu_c){ 
        descripcio = descripcio_c;
        estat = estat_c;
        tipus = tipus_c;
        mida = mida_c;
        tickets_viatges = tickets_viatges_c;
        preu = preu_c;
    }
    
    /* GETTERS */
    public int getId(){
        return id;
    }
    
    public String getDescripcio(){
        return descripcio;
    }
    
    public int getEstat(){
        return estat;
    }
    
    public int getTipus(){
        return tipus;
    }
    
    public int getMida(){
        return mida;
    }
    
    public int getTickets_viatges(){
        return tickets_viatges;
    }
    
    public int getPreu(){
        return preu;
    }
    
    public static ArrayList<Ticket> arrayTickets = new ArrayList<Ticket>();
}
