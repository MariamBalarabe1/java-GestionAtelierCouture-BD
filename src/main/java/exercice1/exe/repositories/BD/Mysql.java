package exercice1.exe.repositories.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exercice1.exe.entities.AbstractEntitie;

public class Mysql <T extends AbstractEntitie> {

    public Connection Connexion(){
        try {
            // 1ere etape:chargement du Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2e etape:creer l'objet de connection
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atelier","root", "");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de Chargement du Driver");
        } catch (SQLException e) {
            System.out.println("Echec de la connexion");
        }
        return null;
    }

    public int ExecuteUpdate(Connection conn,String sqls,String type[],String [] att,int [] values,T data) {
        int nbrLigne=0;
        int idx=-1;
        conn=Connexion();
        String sql=sqls;
        ArrayList indx= new ArrayList();
        if(type.length!=0){
            for (int index = 0; index < type.length; index++) {
                if(type[index].equals("String")){
                    indx.add(index);
                }else if(type[index].equals("int")){
                    indx.add(index);
                }else if(type[index].equals("Double")){
                    indx.add(index);
                }else{
                    indx.add(index);
                }
            }
                try {
                    PreparedStatement statement;
                    statement = conn.prepareStatement(sql);
                    for (int index = 0; index < indx.size(); index++) {
                        if(att[index].equals("id")){
                            statement.setInt(values[index],data.getId());
                        }else if(att[index].equals("libelle")){
                            statement.setString(values[index],data.getLibelle());
                        }else if(att[index].equals("prix")){
                            statement.setDouble(values[index],data.getPrix());
                        }else{
                            statement.setDouble(values[index],data.getQte());
                        }
                    }
                    nbrLigne=statement.executeUpdate();
                    conn.close();
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("error: " + e.getMessage());
                }
                
            
                
        }
        return nbrLigne;

    }

    public ArrayList<T> ExecuteSelect(Connection conn,String sqls,boolean single,int id,String [] att,T data){
        conn=Connexion();
        ArrayList<T> indx=new ArrayList<>();
        try {
            if(single==true){
                PreparedStatement statement=conn.prepareStatement(sqls);
                statement.setInt(1, id);
                ResultSet rs=statement.executeQuery();
                if(rs.next()){
                    for (int index = 0; index < att.length; index++) {
                        if(att[index].equals("id")){
                            data.setId(rs.getInt("id"));
                        }else if(att[index].equals("libelle")){
                            data.setLibelle(rs.getString("libelle"));
                        }else if(att[index].equals("prix")){
                            data.setPrix(rs.getDouble("prix"));
                        }else{
                            data.setQte(rs.getDouble("qte"));
                        }
                    }
                    indx.add(data);
                }
                statement.close();
                rs.close();
            }else{
                id=0;
                Statement statement=conn.createStatement();
                ResultSet rs= statement.executeQuery(sqls);
                while(rs.next()){
                    for (int index = 0; index < att.length; index++) {
                        if(att[index].equals("id")){
                            data.setId(rs.getInt("id"));
                        }else if(att[index].equals("libelle")){
                            data.setLibelle(rs.getString("libelle"));
                        }else if(att[index].equals("prix")){
                            data.setPrix(rs.getDouble("prix"));
                        }else{
                            data.setQte(rs.getDouble("qte"));
                        }
                    }
                    System.out.println(data);
                    
                }
                statement.close();
                rs.close();
            }
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("message: " + e.getMessage());
        }
        return indx;
    }
    
}
