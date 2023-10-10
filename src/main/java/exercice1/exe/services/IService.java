package exercice1.exe.services;

import java.util.ArrayList;


public interface IService <T>{
    int add(T data);
    ArrayList<T> getAll();
    int update(T data);
    ArrayList<T> show(int id);
    int remove(int id,T data);
    int[] remove(int[] ids,T data);
}
