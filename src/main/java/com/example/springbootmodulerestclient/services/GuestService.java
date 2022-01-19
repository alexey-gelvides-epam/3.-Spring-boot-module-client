package com.example.springbootmodulerestclient.services;

import com.example.springbootmodulerestclient.client.GuestClient;
import com.example.springbootmodulerestclient.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    GuestClient guestClient;

    public List<Guest> getGuest(int page, int visitorCount) {
        return guestClient.getAllUsers(page, visitorCount);
    }

    public Guest getGuest(int id){
        return guestClient.getUser(id);
    }

    public void changeOrCreateGuest(int id, Guest guest){
        if(id != 0)
            guestClient.editUser(id, guest);
        else
            guestClient.addUser(guest);
    }

    public void deleteGuest(int id){
        guestClient.deleteUser(id);
    }
}
