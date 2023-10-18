/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import ma.projet.dao.IDao;
import ma.projet.entity.Categorie;
import ma.projet.entity.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class ProduitService implements IDao<Produit>{
     private List<Produit> produit;

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
    public Produit getById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return produit;
    }

    @Override
    public List<Produit> getAll() {
         List<Produit> produit = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        produit = session.createQuery("from Produit").list();
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
    } finally {
        if (session != null)
            session.close();
    }
    return produit;
    }
 
    
public List<Produit> getProduitsByCategorie() {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String hql = "FROM Produit p JOIN FETCH  p.categorie c ORDER BY c.id";
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
    public List<Produit> produitsEntreDeuxDates() {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String hql = "FROM Produit p INNER JOIN lignecommandeproduit lcp ON p.id = lcp.produit_id INNER JOIN commande c ON lcp.commande_id = c.id ";
                
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
    }
    

