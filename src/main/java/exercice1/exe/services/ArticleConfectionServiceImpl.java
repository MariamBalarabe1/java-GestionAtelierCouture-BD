package exercice1.exe.services;

import java.util.ArrayList;

import exercice1.exe.entities.ArticleConfection;
import exercice1.exe.repositories.ITables;

public class ArticleConfectionServiceImpl implements ArticleConfectionService{
    private ITables<ArticleConfection> ArticleConfectionRepository;

    public ArticleConfectionServiceImpl(ITables<ArticleConfection> ArticleConfectionRepository) {
        this.ArticleConfectionRepository = ArticleConfectionRepository;
    }

    @Override
    public int add(ArticleConfection article) {
        return ArticleConfectionRepository.insert(article);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return ArticleConfectionRepository.findAll();
    }

    @Override
    public int update(ArticleConfection article) {
        return ArticleConfectionRepository.update(article);
    }

    @Override
    public ArrayList<ArticleConfection> show(int id) {
        return ArticleConfectionRepository.findById(id);
    }

    @Override
    public int remove(int id, ArticleConfection article) {
        return ArticleConfectionRepository.delete(article);
    }

    @Override
    public int[] remove(int[] ids,ArticleConfection article) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id=0; id<ids.length; id++){
            if(ArticleConfectionRepository.delete(article)==0){
                idsNotDelete[nbre++]=id;
            }
        }
        return idsNotDelete;
    }

    
    
}
