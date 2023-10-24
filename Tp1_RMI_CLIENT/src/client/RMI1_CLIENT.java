/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import DAO.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Config;

/**
 *
 * @author anace
 */
public class RMI1_CLIENT {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        try {
            IDao<Machine> ms = (IDao<Machine>) Naming.lookup("rmi://localhost:1101/" + "tp1Machines");
         IDao<Salle> ss = (IDao<Salle>) Naming.lookup("rmi://localhost:1101/" + "tp1Salles");

            for (Machine m : ms.findAll()) {
                System.out.println(m);
            }
            
             ss.create(new Salle("AA23"));
                ss.create(new Salle("BB14"));

        } catch (RemoteException ex) {
            Logger.getLogger(RMI1_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
          Logger.getLogger(RMI1_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
      } catch (MalformedURLException ex) {
          Logger.getLogger(RMI1_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
