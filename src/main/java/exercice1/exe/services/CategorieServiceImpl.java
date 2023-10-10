package exercice1.exe.services;

import java.util.ArrayList;

import exercice1.exe.entities.Categorie;
import exercice1.exe.repositories.ITables;

public class CategorieServiceImpl implements CategorieService {
    // couplage fort
    // private TableCategorie categoriesRepository = new TableCategorie();
    // couplage faible
    private ITables<Categorie> categoriesRepository;

    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    // injection de dependance via le constructeur
    @Override
    public int add(Categorie categorie) {
        return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
        return categoriesRepository.update(categorie);
    }

    @Override
    public ArrayList<Categorie> show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id,Categorie categorie) {
        return categoriesRepository.delete(categorie);
    }

    @Override
    public int[] remove(int[] ids,Categorie categorie) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id=0; id<ids.length; id++){
            if(categoriesRepository.delete(categorie)==0){
                idsNotDelete[nbre++]=id;
            }
        }
        return idsNotDelete;
    }

    
    
}
