package exercice1.exe.entities;

public class Categorie extends AbstractEntitie{
    
    public Categorie(int id, String libelle) {
        super(id, libelle);
    }

    // const defaut
    public Categorie(String libelle) {
        super(libelle);
        // $this.libelle = libelle;
    }
    public Categorie() {
        super();
    }


    @Override
    public String toString() {
        return "Categorie"+super.toString();
    }

    
    
    
}
