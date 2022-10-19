package com.usa.misiontic23.masterclass4.repository.crudRepository;

import com.usa.misiontic23.masterclass4.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
