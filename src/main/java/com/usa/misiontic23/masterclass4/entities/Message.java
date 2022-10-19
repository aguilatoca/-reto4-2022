package com.usa.misiontic23.masterclass4.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.*;

@Entity
@Table(name = "message")

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "boxId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Box box;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;
    @ManyToOne
    @JoinColumn(name = "message_service_id_message")
    private Message messageService;

    public Message getMessageService() {
        return messageService;
    }

    public void setMessageService(Message messageService) {
        this.messageService = messageService;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }
}
