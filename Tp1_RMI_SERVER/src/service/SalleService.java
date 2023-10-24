/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateConfig;


/**
 *
 * @author anace
 */
public class SalleService extends UnicastRemoteObject implements IDao<Salle>{
    
    public SalleService() throws RemoteException{
        
    }

    @Override
    public boolean create(Salle o) throws RemoteException {
        Session ss = null;
        Transaction trans = null;
        try {
            ss = HibernateConfig.getSessionFactory().openSession();
            trans = ss.beginTransaction();
            ss.save(o);
            trans.commit();
            return true;
        } catch (HibernateException ex) {
            if(trans != null)
                trans.rollback();
        }finally {
            if(ss != null)
                ss.close();
        }
        return false;
    }

    @Override
    public boolean update(Salle o) throws RemoteException {
        Session ss = null;
                Transaction tr= null;
            try{
                ss=HibernateConfig.getSessionFactory().openSession();
                tr=ss.beginTransaction();
                ss.update(o);
                tr.commit();
                return true;
                 } catch (HibernateException ex) {
            if(tr != null)
                tr.rollback();
        }finally {
            if(ss != null)
                ss.close();
        }
        return false;
    }

    @Override
    public boolean delete(Salle o) throws RemoteException {
    Session ss = null;
                Transaction tr= null;
            try{
                ss=HibernateConfig.getSessionFactory().openSession();
                tr=ss.beginTransaction();
                ss.delete(o);
                tr.commit();
                return true;
                 } catch (HibernateException ex) {
            if(tr != null)
                tr.rollback();
        }finally {
            if(ss != null)
                ss.close();
        }
        return false;}

   @Override
    public List<Salle> findAll() throws RemoteException {
        Session ss = null;
        Transaction tr = null;
        List<Salle> machines = null;
        try {
            ss = HibernateConfig.getSessionFactory().openSession();
            tr = ss.beginTransaction();
            machines  = ss.getNamedQuery("findSalles").list();
            tr.commit();
        } catch (HibernateException ex) {
            if(tr != null)
                tr.rollback();
        }finally {
            if(ss != null)
                ss.close();
        }
        return machines;
    }

    @Override
    public Salle findById(Long id) throws RemoteException {
         Session ss = null;
        Transaction tr = null;
        Salle machine = null;
        try {
            ss = HibernateConfig.getSessionFactory().openSession();
            tr = ss.beginTransaction();
            machine  = (Salle) ss.get(Salle.class, id);
            tr.commit();
        } catch (HibernateException ex) {
            if(tr != null)
                tr.rollback();
        }finally {
            if(ss != null)
                ss.close();
        }
        return machine;
    }

    @Override
    public List<Salle> findMachinesSalle(Salle o) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}