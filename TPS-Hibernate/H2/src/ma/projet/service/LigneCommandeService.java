/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entity.LigneCommandeProduit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class LigneCommandeService implements IDao<LigneCommandeService> {

      @Override
    public boolean create(LigneCommandeService o) {
       Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public LigneCommandeService getById(int id) {
          LigneCommandeService ligneCommandeService = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeService = (LigneCommandeService) session.get(LigneCommandeService.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return ligneCommandeService;
    }

    @Override
    public List<LigneCommandeService> getAll() {
         List<LigneCommandeService> ligneCommandeService = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        ligneCommandeService = session.createQuery("from LigneCommandeService").list();
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
    } finally {
        if (session != null)
            session.close();
    }
    return ligneCommandeService;
    }
    
    
}
