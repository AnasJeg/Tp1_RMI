/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1.server;
 import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


import DAO.IDao;
import entities.Machine;
import entities.Salle;
import service.MachineService;
import service.SalleService;
/**
 *
 * @author anace
 */
public class server {

    /**
     * @param args the command line arguments
     */
 
	public static void main(String[] args) {
        try {
            IDao<Machine> machine = new MachineService();
            IDao<Salle>  salle = new SalleService();
            
            LocateRegistry.createRegistry(1101);
            
            Naming.rebind("rmi://localhost:1101/tp1Machines", machine);
            Naming.rebind("rmi://localhost:1101/tp1Salles", salle);
            
            System.out.println("En attente des clients");
            
        } catch (RemoteException ex) {
           // Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
          //  Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}
    
}
