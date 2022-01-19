package com.example.springbootmodulerestclient.client;

import com.example.springbootmodulerestclient.entity.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Component
@FeignClient(name="${spring.modules.server-name}")
public interface GuestClient {

    @GetMapping("/user/all-users/page/{page}/users/{user}")
    List<Guest> getAllUsers(@PathVariable("page") int page,
                            @PathVariable("user") int user);

    @GetMapping("/user/user/{id}")
    Guest getUser(@PathVariable("id") long id);

    @DeleteMapping("/user/delete/{id}")
    void deleteUser(@PathVariable("id") long id);

    @PostMapping("/user/add-new-user")
    String addUser(@RequestBody Guest guest);

    @PutMapping(value = "/user/edit/{id}")
    String editUser(@PathVariable("id") long id,
                    @RequestBody Guest guest);

}
