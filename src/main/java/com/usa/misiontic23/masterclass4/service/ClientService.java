package com.usa.misiontic23.masterclass4.service;

import com.usa.misiontic23.masterclass4.entities.Client;
import com.usa.misiontic23.masterclass4.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private static ClientRepository clientRepository;

    public List<Client> getALL(){
        return clientRepository.getALL();
    }
    public static Optional<Client> getClient(int id){
        return clientRepository.getById(id);
    }
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else{

            Optional<Client> e = clientRepository.getById(p.getIdClient());
            if (e.isPresent()){
                return p;
            }else{
                return clientRepository.save(p);
            }
        }
    }

    public static Client update(Client p)
    {
        if (p.getIdClient()!=null)
        {
            Optional<Client> q = clientRepository.getById(p.getIdClient());
            if(q.isEmpty())
            {
                if (p.getName() != null)
                {
                    q.get().setName(p.getName());
                }

                if (p.getAge() != null)
                {
                    q.get().setAge(p.getAge());
                }

                if (p.getPassword() != null)
                {
                    q.get().setPassword(p.getPassword());
                }

                clientRepository.save(q.get());
                return q.get();

            } else
            {
                return p;
            }
        }else {
            return p;
        }
    }

   /* public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getById(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }*/
    public static boolean delete(int id){
        boolean d =getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);

        return d;
    }
}
