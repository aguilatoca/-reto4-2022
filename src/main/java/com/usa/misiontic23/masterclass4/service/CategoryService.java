package com.usa.misiontic23.masterclass4.service;

import com.usa.misiontic23.masterclass4.entities.Category;
import com.usa.misiontic23.masterclass4.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getALL(){
        return categoryRepository.getALL();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getById(id);
    }
    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> e = categoryRepository.getById(p.getId());
            if (e.isPresent()){
                return categoryRepository.save(p);
            }else{

                return p;
            }
        }
    }

    public Category update(Category p)
    {
        if (p.getId()!=null)
        {
            Optional<Category> q = categoryRepository.getById(p.getId());
            if(!q.isEmpty())
            {
                if (p.getDescription() != null)
                {
                    q.get().setDescription(p.getDescription());
                }

                if (p.getName() != null)
                {
                    q.get().setName(p.getName());
                }

                return categoryRepository.save(q.get());

            }
        }
        return p;
    }

   /* public boolean delete(int id){
       boolean flag=false;
        Optional<Category>p= categoryRepository.getById(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }*/

    public boolean delete(int id){
        boolean d =getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);

        return d;
    }

}
