package exercice1.exe.repositories.BD;
import java.util.ArrayList;

import exercice1.exe.entities.Categorie;
import exercice1.exe.repositories.ITables;

public class CategorieRepository extends Mysql<Categorie> implements ITables<Categorie>{

    @Override
    public int insert(Categorie data) {
        String sql="INSERT INTO `Categorie`(`libelle`) VALUES (?)" ;
        String[] types= {"String"};
        String[] att= {"libelle"};
        int[] value= {1};
        return ExecuteUpdate(Connexion(),sql,types ,att,value,data);
    }

    @Override
    public int delete(Categorie data) {
        String sql="DELETE from `Categorie` WHERE `id`=?";
        String[] types= {"int"};
        String[] att= {"id"};
        int[] value= {1};
        return ExecuteUpdate(Connexion(), sql, types, att, value, data);
    }

    @Override
    public int update(Categorie data) {
        String sql="UPDATE `Categorie` SET `libelle`=? WHERE `id`=?";
        String[] types= {"String","int"};
        String[] att= {"libelle","id"};
        int[] value= {1,2};
        return ExecuteUpdate(Connexion(),sql,types ,att,value,data);
    }


    

    @Override
    public ArrayList<Categorie> findAll() {
        String sql="SELECT id,libelle FROM Categorie";
        String[] att= {"id","libelle"};
        Categorie dataa=new Categorie();
        return ExecuteSelect(Connexion(),sql,false,0,att,dataa);
    }

    @Override
    public ArrayList<Categorie> findById(int id) {
        String sql="SELECT id,libelle FROM Categorie where id=?";
        String[] att= {"id","libelle"};
        Categorie dataa=new Categorie();
        return ExecuteSelect(Connexion(),sql,true,id,att,dataa);
    }

    @Override
    public int indexOf(int id) {
        return 0;
    }

    

    
    
}
