/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class ProduitService implements IDao<Produit>{

    @Override
    public boolean create(Produit o) {
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
    public boolean delete(Produit o) {
       Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
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
    public boolean update(Produit o) {
       Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
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
    public Produit findById(int id) {
        Produit user = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            user = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return user;
    }

    @Override
    public List<Produit> findAll() {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        produits = session.createQuery("from Produit").list();
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
    } finally {
        if (session != null)
            session.close();
    }
    return produits;
}
public List<Produit> produitsMoreThan100() {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String hql = "FROM Produit p WHERE p.prix > 100";
        produits = session.createQuery(hql).list();

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null)
            session.close();
    }
    
    return produits;
}
public List<Produit> produitEntreDeuxDates( Date dateDebut, Date dateFin) {
        List<Produit> produits = null;
      Session session = null;
    Transaction tx = null;
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
       

     
        String hql = "FROM Produit p " +
                     "WHERE p.dateAchat BETWEEN :dateDebut AND :dateFin";
        
        produits = session.createQuery(hql).list();
       tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null)
            session.close();
    }
    
    return produits;
    
    
}}
