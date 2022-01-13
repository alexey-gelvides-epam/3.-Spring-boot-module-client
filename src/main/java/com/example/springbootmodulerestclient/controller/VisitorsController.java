package com.example.springbootmodulerestclient.controller;

import com.example.springbootmodulerestclient.entity.Visitor;
import com.example.springbootmodulerestclient.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class VisitorsController {
    @Autowired
    VisitorService visitorService;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("visitorList", visitorService.getVisitor(1, 10));
        return "service/home";
    }

    @GetMapping("/page={page}/visitors-count={visitorsCount}")
    public String mainPage(Model model,
                           @PathVariable int page,
                           @PathVariable int visitorsCount){
        model.addAttribute("visitorList", visitorService.getVisitor(page, visitorsCount));
        return "service/home";
    }

    @GetMapping("create-visitor")
    public String createVisitor(Model model){
        model.addAttribute("newVisitor", new Visitor("","",""));
        return "service/visitor-create";
    }

    @PostMapping("/")
    public String successCreateVisitor(@ModelAttribute Visitor visitor){
        visitorService.changeOrCreateVisitor(0, visitor);
        return "redirect:/";
    }

    @GetMapping("edit-visitor/{id}")
    public String editVisitor(Model model,
                              @PathVariable int id){
        model.addAttribute("changeVisitor", visitorService.getVisitor(id));
        return "service/visitor-edit";
    }

    @PutMapping("/{id}")
    public String successChange(@ModelAttribute Visitor visitor,
                                @PathVariable("id") int id) {
        visitorService.changeOrCreateVisitor(id, visitor);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String deleteVisitor(@PathVariable int id){
        visitorService.deleteVisitor(id);
        return "redirect:/";
    }

}
