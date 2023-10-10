package exercice1.exe.repositories;

import java.util.ArrayList;

import exercice1.exe.entities.AbstractEntitie;

// interface generique
public interface ITables <T extends AbstractEntitie>{
    int insert (T data);
    int update (T data);
    ArrayList<T> findAll();
    ArrayList<T> findById(int id);
    int delete(T data);
    int indexOf(int id);
}
