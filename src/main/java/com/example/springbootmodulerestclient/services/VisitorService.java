package com.example.springbootmodulerestclient.services;

import com.example.springbootmodulerestclient.client.VisitorClient;
import com.example.springbootmodulerestclient.entity.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    @Autowired
    VisitorClient visitorClient;

    public List<Visitor> getVisitor(int page, int visitorCount) {
        return visitorClient.getAllUsers(page, visitorCount);
    }

    public Visitor getVisitor(int id){
        return visitorClient.getUser(id);
    }

    public void changeOrCreateVisitor(int id, Visitor visitor){
        if(id != 0)
            visitorClient.editUser(id, visitor);
        else
            visitorClient.addUser(visitor);
    }

    public void deleteVisitor(int id){
        visitorClient.deleteUser(id);
    }
}
