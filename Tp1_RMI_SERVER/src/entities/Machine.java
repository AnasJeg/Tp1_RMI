/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;


/**
 *
 * @author anace
 */

@Entity
@NamedNativeQuery(name = "findMachines", query = "select * from machine", resultClass = Machine.class)
@NamedNativeQuery(name = "findMachinesSalle",query = "SELECT id, marque, prix, ref, salle_id FROM machine WHERE salle_id= :idS ",resultClass = Machine.class)
public class Machine implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String marque;
    private double prix;
    @ManyToOne
    private Salle salle;

    public Machine() {
    }

    public Machine(String ref, String marque, double prix,Salle salle) {
    this.ref = ref;
    this.marque = marque;
    this.prix = prix;
    this.salle = salle;
}

    public Machine(Long id, String ref, String marque, double prix, Salle salle) {
        this.id = id;
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
        this.salle = salle;
    }

    public Long getId() {
        return id;
    }



    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    

    @Override
    public String toString() {
        return "Machine{" + "id=" + id + ", ref=" + ref + ", marque=" + marque + ", prix=" + prix + '}';
    }

}