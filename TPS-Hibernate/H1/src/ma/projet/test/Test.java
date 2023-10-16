/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Hibernate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author HP
 */
public class Test {
      public static void main(String[] args) throws ParseException {
        ProduitService ps = new ProduitService();
        // ps.create(new Produit("kan", "aa", new Date(), 12, "aa"));
        //ps.create(new Produit("NIKE", "Ref1", new Date(), 200, "L"));
        //ps.create(new Produit("ADIDAS", "Ref2", new Date(), 400, "M"));
        //ps.create(new Produit("MAYBELLINE", "aa", new Date(), 500, "S"));
        //ps.create(new Produit("ZARA", "Ref4", new Date(), 1100, "B"));
        
          //for (Produit p : ps.findAll()) {
             // System.out.println(p.getMarque());
              
           //Produit p2 = ps.findById(2);
           //System.out.println(p2);
           
          // Produit p3 = ps.findById(3);
          // ps.delete(p3);
        
         // Produit p1 = ps.findById(1);
          //p1.setMarque("BERSHKA");
          //ps.update(p1);
        
        
      //List<Produit> produits = ps.produitsMoreThan100();
          //for (Produit produit : produits) {
          //System.out.println("Marque : " + produit.getMarque());
        
         Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
           System.out.print("Entrez la date de début (yyyy-MM-dd) : ");
        Date dateDebut = null;
        dateDebut = sdf.parse(scanner.nextLine());
        
        try {
            
        } catch (Exception e) {
            System.out.println("Format de date invalide.");
            return;
        }
         System.out.print("Entrez la date de fin (yyyy-MM-dd) : ");
        Date dateFin = null;
        try {
            dateFin = sdf.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Format de date invalide.");
            return;
        }
        List<Produit> produits = ps.produitEntreDeuxDates( dateDebut, dateFin);
        if (produits.isEmpty()) {
            System.out.println("Aucun produit commandé entre les dates spécifiées.");
             } else {
            System.out.println("Produits commandés entre les dates spécifiées :");
            for (Produit produit : produits) {
                System.out.println("Marque : " + produit.getMarque());
                System.out.println("Référence : " + produit.getReference());
                System.out.println("Date d'achat : " + produit.getDateAchat());
                System.out.println("Prix : " + produit.getPrix());
                System.out.println("Désignation : " + produit.getDesignation());
               
            }
}
      }}
    
        
    

