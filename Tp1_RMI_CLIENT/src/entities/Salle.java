/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.List;



/**
 *
 * @author anace
 */


public class Salle implements Serializable{

    private Long id;
    private String code;
    //@OneToMany (mappedBy = "salle", fetch = FetchType.EAGER)
  //  private List<Machine> machines;

    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
    }

    public Salle(Long id, String code) {
        this.id = id;
        this.code = code;
    }

  /*  public Salle(String code, List<Machine> machines) {
        this.code = code;
        this.machines = machines;
    }
*/
    public Long getId() {
        return id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   /* public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

*/
    @Override
    public String toString() {
            return code;
    }
}