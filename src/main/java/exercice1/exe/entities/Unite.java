package exercice1.exe.entities;

public class Unite extends AbstractEntitie{

    public Unite(int id, String libelle) {
        super(id, libelle);
    }
    public Unite() {
        super();
    }
    
    
    
    @Override
    public String toString() {
        return "Unite"+ super.toString();
    }

    
}
