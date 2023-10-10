package exercice1.exe.repositories.List;

import java.util.ArrayList;

import exercice1.exe.entities.AbstractEntitie;
import exercice1.exe.repositories.ITables;
// Classe d'implementation
public class Table<T extends AbstractEntitie> implements ITables<T>{
    private ArrayList<T> tables = new ArrayList<>();

    @Override
    public int insert(T data) {
        tables.add(data);
        return 1;
    }

    @Override
    public int update(T data) {
        int pos=indexOf(data.getId());
        if(pos!=-1) {
            tables.set(pos,data);
            return 1;
        }
        return 0;
    }

    @Override
    public ArrayList<T> findAll() {
        return tables;
    }

    @Override
    public int delete(T data) {
        int pos=indexOf(data.getId());
        if(pos!=-1) {
            tables.remove(pos);
            return 1;
        }
        return 0;
        
    }

    @Override
    public ArrayList<T> findById(int id) {
        ArrayList<T> find = new ArrayList<>();
        int pos=indexOf(id);
        if(pos!=-1) {
            find.add(tables.get(pos));
        }
        return find;
    }

    
    public int indexOf(int id) {
        int pos=0;
        for(T cat : tables) {
            if(cat.getId()==id){
                return pos;
            }
            pos++;
        }
        return -1;
    }

    

    

  
    
     
}
