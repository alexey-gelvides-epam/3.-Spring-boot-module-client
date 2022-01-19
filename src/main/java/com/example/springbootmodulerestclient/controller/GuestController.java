package com.example.springbootmodulerestclient.controller;

import com.example.springbootmodulerestclient.entity.Guest;
import com.example.springbootmodulerestclient.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class GuestController {
    @Autowired
    GuestService guestService;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("guestList", guestService.getGuest(1, 10));
        return "service/home";
    }

    @GetMapping("/page={page}/guests-count={guestCount}")
    public String mainPage(Model model,
                           @PathVariable int page,
                           @PathVariable int guestCount){
        model.addAttribute("guestList", guestService.getGuest(page, guestCount));
        return "service/home";
    }

    @GetMapping("create-guest")
    public String createVisitor(Model model){
        model.addAttribute("newGuest", new Guest("","",""));
        return "service/guest-create";
    }

    @PostMapping("/")
    public String successCreateVisitor(@ModelAttribute Guest guest){
        guestService.changeOrCreateGuest(0, guest);
        return "redirect:/";
    }

    @GetMapping("edit-guest/{id}")
    public String editVisitor(Model model,
                              @PathVariable int id){
        model.addAttribute("changeGuest", guestService.getGuest(id));
        return "service/guest-edit";
    }

    @PutMapping("/{id}")
    public String successChange(@ModelAttribute Guest guest,
                                @PathVariable("id") int id) {
        guestService.changeOrCreateGuest(id, guest);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String deleteVisitor(@PathVariable int id){
        guestService.deleteGuest(id);
        return "redirect:/";
    }

}
