/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import entities.Salle;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author anace
 */
public interface IDao<T> extends Remote{
      boolean create(T o) throws RemoteException;

    boolean update(T o) throws RemoteException;

    boolean delete(T o) throws RemoteException;

    T findById(Long id) throws RemoteException;

    List<T> findAll() throws RemoteException;
    
    List<T> findMachinesSalle(Salle o) throws RemoteException;
}
