package exercice1.exe.entities;

import java.util.ArrayList;

public class ArticleConfection extends AbstractEntitie{
    // att instance
    private double prix;
    private double qte;

    //Atts navigationnels
     Categorie categorie; 
     // couplage fort
     ArrayList<Unite> unites= new ArrayList<Unite>();

    public void addUnite(Unite unite){
        unites.add(unite);
    }

    public ArrayList<Unite> getUnite() {
        return unites;
    }
    
    public ArticleConfection(int id, String libelle, double prix, double qte) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
    }
    public ArticleConfection(String libelle, double prix, double qte) {
        this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
    }

    public ArticleConfection() {

    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "ArticleConfection [" + super.toString()+ ", prix=" + prix + ", qte=" + qte + "]";
    }

    
    
}
