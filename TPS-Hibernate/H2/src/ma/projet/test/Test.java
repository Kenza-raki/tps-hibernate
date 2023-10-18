/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;



import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.entity.Categorie;
import ma.projet.entity.Commande;
import ma.projet.entity.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.ProduitService;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
       
            ProduitService ps = new ProduitService();
            CategorieService cs = new CategorieService();
            CommandeService s = new CommandeService();
            
            
            
            //cs.create(new Categorie("AAA","aaa"));
            // ps.create(new Produit("aa",  12));
   

            
               List<Produit> produits = ps.getProduitsByCategorie();
        List<Categorie> categorie = cs.getAll();
        for (Produit produit : produits) {
            for (Categorie categories : categorie) {
                if (produit.getCategorie() == categories.getId()) {
                    System.out.println("Marque : " + produit.getReference() + " de la categorie : " + categories.getLibelle());
                }
            }
       }
        
           ps.produitsEntreDeuxDates();
            System.out.println("les Produits commandées entre les 2 dates sont : " + produits);
            
    
         ps.produitsMoreThan100();
        for (Produit produit : produits) {
            System.out.println("Marque : " + produit.getReference());
        
        
        }
    
    }

}