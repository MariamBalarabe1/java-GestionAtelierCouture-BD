package exercice1.exe;

import java.util.Scanner;

import exercice1.exe.entities.ArticleConfection;
import exercice1.exe.entities.Categorie;
import exercice1.exe.repositories.ITables;
import exercice1.exe.repositories.BD.ArticleConfectionRepository;
import exercice1.exe.repositories.BD.CategorieRepository;
import exercice1.exe.repositories.List.TableArticleConfection;
import exercice1.exe.repositories.List.TableCategorie;
import exercice1.exe.services.ArticleConfectionService;
import exercice1.exe.services.ArticleConfectionServiceImpl;
import exercice1.exe.services.CategorieService;
import exercice1.exe.services.CategorieServiceImpl;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ITables <Categorie> repository =new CategorieRepository();
    static ITables <ArticleConfection> repository2 =new ArticleConfectionRepository();
    static CategorieService categorieServiceImpl = new CategorieServiceImpl(repository);
    static ArticleConfectionService ArticleConfectionServiceImpl = new ArticleConfectionServiceImpl(repository2);
    static int choix;
    static int choixCategorie;
    static int choixArticle;
    static int index;
    public static void main(String[] args) throws Exception {
        
        do {
            switch (menu()) {
                case 1:
                    switch (menuCategorie()) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Libelle");
                            Categorie categorie=new Categorie(scanner.nextLine());
                            categorieServiceImpl.add(categorie);
                            break;
                        case 2:
                            //     programation imperativee
                            //     ArrayList<Categorie> categories=categorieServiceImpl.getAll();
                            //     for (Categorie cat : categories) {
                            //         System.out.println(cat);
                            //     }
                            // programation fonctionnel
                            System.out.println("Liste de Categorie");
                            categorieServiceImpl.getAll().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Liste de Categorie");
                            categorieServiceImpl.getAll().forEach(System.out::println);
                            System.out.println("id");
                            int id=scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("nouveau libelle");
                            String newLib=scanner.nextLine();
                            for (Categorie cat : categorieServiceImpl.show(id)) {
                                cat.setLibelle(newLib);
                                categorieServiceImpl.update(cat);
                            }
                            
                            break;
                        case 4:
                            System.out.println("Liste de Categorie");
                            categorieServiceImpl.getAll().forEach(System.out::println);

                            System.out.println("id");
                            id=scanner.nextInt();
                            Categorie cat=new Categorie();
                            for (Categorie catt : categorieServiceImpl.show(id)) {
                                cat=catt;
                            }
                            categorieServiceImpl.remove(id,cat);
                            break;
                        case 5:
                            System.out.println("Nombre de categorie à supprimer:");
                            int nbrSup=scanner.nextInt();
                            cat=new Categorie();
                            for (int index = 0; index < nbrSup; index++) {
                                System.out.println("Liste de Categorie");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("id");
                                id=scanner.nextInt();
                                for (Categorie catt : categorieServiceImpl.show(id)) {
                                    cat=catt;
                                }
                                categorieServiceImpl.remove(id,cat);
                            }
                            break;
                    
                        default:
                            break;
                    }
                    

                break;
                case 2:
                    switch (menuArticle()) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Libelle");
                            String libelleA=scanner.nextLine();
                            System.out.println("prix:");
                            double prix=scanner.nextDouble();
                            System.out.println("Quantite:");
                            double qte=scanner.nextDouble();
                            ArticleConfection article=new ArticleConfection(libelleA, prix, qte);
                            ArticleConfectionServiceImpl.add(article);
                            break;
                        case 2:
                            System.out.println("liste des Articles de confection");
                            ArticleConfectionServiceImpl.getAll().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("liste des Articles de confection");
                            ArticleConfectionServiceImpl.getAll().forEach(System.out::println);
                            System.out.println("id");
                            int id=scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("nouveau libelle");
                            String newLib=scanner.nextLine();
                            for (ArticleConfection art : ArticleConfectionServiceImpl.show(id)) {
                                art.setLibelle(newLib);
                                ArticleConfectionServiceImpl.update(art);
                            }
                            break;
                        case 4:
                            System.out.println("liste des Articles de confection");
                            ArticleConfectionServiceImpl.getAll().forEach(System.out::println);
                            System.out.println("id");
                            id=scanner.nextInt();
                            ArticleConfection art=new ArticleConfection();
                            for (ArticleConfection catt : ArticleConfectionServiceImpl.show(id)) {
                                art=catt;
                            }
                            ArticleConfectionServiceImpl.remove(id,art);
                            break;
                        case 5:
                            System.out.println("Nombre d'article de confection à supprimer:");
                            int nbrSup=scanner.nextInt();
                            art=new ArticleConfection();
                            for (int index = 0; index < nbrSup; index++) {
                                System.out.println("liste des Articles de confection");
                                ArticleConfectionServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("id");
                                id=scanner.nextInt();
                                for (ArticleConfection catt : ArticleConfectionServiceImpl.show(id)) {
                                    art=catt;
                                }
                                ArticleConfectionServiceImpl.remove(id,art);
                            }
                            break;
                        default:
                            break;
                    }
                    
                break;
                default:
                    System.out.println("AU REVOIR!!!!!");
                    break;
            }
        } while (choix!=3);
    
        
    
    }

    public static int menuCategorie(){   
        System.out.println("1-------Ajouter une Categorie");
        System.out.println("2-------Lister les Categories");
        System.out.println("3-------modifier une Categorie");
        System.out.println("4-------supprimer une Categorie");
        System.out.println("5-------supprimer plusieurs categories");
        System.out.println("6-------Menu General");
        do {
            System.out.println("Faites un choix");
            choixCategorie=scanner.nextInt();
        } while (choixCategorie<1 || choixCategorie>6);
        return choixCategorie;
    }

    public static int menuArticle(){   
        System.out.println("1-------Ajouter un Article de Confection");
        System.out.println("2-------Lister les Articles de Confection");
        System.out.println("3-------Modifier un Article de Confection");
        System.out.println("4-------Supprimer un Article de Confection");
        System.out.println("5-------supprimer plusieurs Articles de Confections");
        System.out.println("6-------Menu General");
        do {
            System.out.println("Faites un choix");
            choixArticle=scanner.nextInt();
        } while (choixArticle<1 || choixArticle>6);
        return choixArticle;
    }
    public static int menu(){   
        System.out.println("1-------CATEGORIE");
        System.out.println("2-------ARTICLE DE CONFECTION");
        System.out.println("3-------Quitter");
        do {
            System.out.println("Faites un choix");
            choix=scanner.nextInt();
        } while (choix<1 || choix>5);
        return choix;
    }
}