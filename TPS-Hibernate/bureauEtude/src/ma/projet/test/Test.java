/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.entity.Employe;
import ma.projet.entity.EmployeTache;
import ma.projet.entity.Projet;
import ma.projet.entity.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;
import ma.projet.util.HibernateUtil;

public class Test {
     public static void main (String [] args){
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
         TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        
        //        ps.create(new Projet("xxx", new Date(122,3,18), new Date(122,8,17), es.getById(1)));

     //ets.create(new EmployeTache(new Date(122,4,13), new Date(122,5,19), es.getById(1), ts.getById(1)));
       // ets.create(new EmployeTache(new Date(122,4,13), new Date(122,5,19), es.getById(3), ts.getById(3)));
        
       
     for(Tache tache : es.tacheRealiseParEmp(es.getById(1))){
            System.out.println("l'employe numero : "+es.getById(1)+ " : "+tache.getNom());}

      for(Projet projet : es.projetParEmp(es.getById(1))){
            System.out.println("les projets realises par: "+es.getById(1).getNom()+" "+projet.getNom());
      }
        

          ps.tacheParProjet(ps.getById(2));
        
         for(Tache tache : ts.tacheParPrix(200)){
            System.out.println(tache.getNom() + " : " + tache.getPrix() + " DH");
      }
        
        
        
        
    }
}
