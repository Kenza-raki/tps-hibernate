/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private LigneCommaneProduitPK pK;
    
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "produit" , insertable = false , updatable = false)
    private Produit produit;
    @ManyToOne
     @JoinColumn(name = "commande" , insertable = false , updatable = false)
    private Commande commande;
    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(LigneCommaneProduitPK pK, int quantite, Produit produit, Commande commande) {
        this.pK = pK;
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    public LigneCommaneProduitPK getpK() {
        return pK;
    }

    public void setpK(LigneCommaneProduitPK pK) {
        this.pK = pK;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    

    
    
    
}
