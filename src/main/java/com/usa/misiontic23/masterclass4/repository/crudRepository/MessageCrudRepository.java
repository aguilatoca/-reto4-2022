package com.usa.misiontic23.masterclass4.repository.crudRepository;



import com.usa.misiontic23.masterclass4.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
