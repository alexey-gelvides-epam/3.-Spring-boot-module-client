package com.example.springbootmodulerestclient.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Visitor {
    private long id;
    private String name;
    private String lastName;
    private String phone;
    private Date createdAt;
    private Date updatedAt;

    public Visitor(String name, String lastName, String phone){
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }
}
