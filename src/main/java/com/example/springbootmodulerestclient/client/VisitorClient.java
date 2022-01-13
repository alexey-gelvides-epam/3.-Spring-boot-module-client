package com.example.springbootmodulerestclient.client;

import com.example.springbootmodulerestclient.entity.Visitor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Component
@FeignClient(name="${spring.modules.server-name}")
public interface VisitorClient {

    @GetMapping("/user/all-users/page/{page}/users/{user}")
    List<Visitor> getAllUsers(@PathVariable("page") int page,
                              @PathVariable("user") int user);

    @GetMapping("/user/user/{id}")
    Visitor getUser(@PathVariable("id") long id);

    @DeleteMapping("/user/delete/{id}")
    void deleteUser(@PathVariable("id") long id);

    @PostMapping("/user/add-new-user")
    String addUser(@RequestBody Visitor visitor);

    @PutMapping(value = "/user/edit/{id}")
    String editUser(@PathVariable("id") long id,
                    @RequestBody Visitor visitor);

}
