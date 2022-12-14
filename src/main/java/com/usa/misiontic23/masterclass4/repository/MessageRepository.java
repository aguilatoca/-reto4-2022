package com.usa.misiontic23.masterclass4.repository;



import com.usa.misiontic23.masterclass4.entities.Message;
import com.usa.misiontic23.masterclass4.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCuedRepository;

    public List<Message> getALL()
    {
        return (List<Message>) messageCuedRepository.findAll();
    }
    public Optional<Message> getMessage(int id)
    {
        return messageCuedRepository.findById(id);

    }
    public Message save(Message p)
    {
        return messageCuedRepository.save(p);

    }

    public void delete(Message p)
    {
        messageCuedRepository.delete(p);
        
    }
}

