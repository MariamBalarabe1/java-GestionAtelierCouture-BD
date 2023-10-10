package exercice1.exe.entities;


public class AbstractEntitie {
    
    protected int id;
    protected String libelle;
    protected double prix;
    protected double qte;

    public AbstractEntitie(String libelle) {
        this.libelle = libelle;
    }
    public AbstractEntitie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    public AbstractEntitie() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticleConfection other = (ArticleConfection) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return " [id=" + id + ", libelle=" + libelle + "]";
    }
}
