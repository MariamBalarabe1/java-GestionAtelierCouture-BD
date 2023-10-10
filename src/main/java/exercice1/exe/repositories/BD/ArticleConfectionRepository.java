package exercice1.exe.repositories.BD;

import java.util.ArrayList;

import exercice1.exe.entities.ArticleConfection;
import exercice1.exe.repositories.ITables;

public class ArticleConfectionRepository extends Mysql <ArticleConfection>  implements ITables<ArticleConfection>{

    @Override
    public int delete(ArticleConfection data) {
        String sql="DELETE from `articleconfection` WHERE `id`=?";
        String[] types= {"int"};
        String[] att= {"id"};
        int[] value= {1};
        return ExecuteUpdate(Connexion(), sql, types, att, value, data);
    }

    @Override
    public ArrayList<ArticleConfection> findAll() {
        String sql="SELECT * FROM articleconfection";
        String[] att= {"id","libelle","prix","qte"};
        ArticleConfection dataa=new ArticleConfection();
        return ExecuteSelect(Connexion(),sql,false,0,att,dataa);
    }

    @Override
    public ArrayList<ArticleConfection> findById(int id) {
        String sql="SELECT id,libelle FROM articleconfection WHERE id=?";
        String[] att= {"id","libelle"};
        ArticleConfection dataa=new ArticleConfection();
        return ExecuteSelect(Connexion(),sql,true,id,att,dataa);
    }

    @Override
    public int insert(ArticleConfection data) {
        String sql="INSERT INTO `articleconfection`(`libelle`,`prix`,`qte`) VALUES (?,?,?)" ;
        String[] types= {"String","Double","Double"};
        String[] att= {"libelle","prix","qte"};
        int[] value= {1,2,3};
        return ExecuteUpdate(Connexion(),sql,types ,att,value,data);
    }

    @Override
    public int update(ArticleConfection data) {
        String sql="UPDATE `articleconfection` SET `libelle`=? WHERE `id`=?";
        String[] types= {"String","int"};
        String[] att= {"libelle","id"};
        int[] value= {1,2};
        return ExecuteUpdate(Connexion(),sql,types ,att,value,data);
    }

    @Override
    public int indexOf(int id) {
        return 0;
    }
    
}
