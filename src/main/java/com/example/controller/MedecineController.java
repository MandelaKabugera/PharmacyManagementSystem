package com.example.controller;

import com.example.model.Medecine;
import com.example.serviceImplementation.MedecineImplementationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedecineController {
    @Autowired
    MedecineImplementationService service;

    @GetMapping("/medecine/new")
    public String showMedecineForm(Model model){
        Medecine medecine = new Medecine();
        model.addAttribute("pageTitle","Create Request");
        model.addAttribute("user", medecine);

        return "medecinefor";
    }


//    @GetMapping("/medecine/new")
//    public String showMedecineForm(Model model){
//        Medecine medecine = new Medecine();
//        model.addAttribute("medecine", medecine);
//
//        return "medecineform";
//    }


    @PostMapping("/me/save")
    public String saveMedecine(Medecine medecine, Model model, RedirectAttributes ra){
        try {
            Medecine savedMedecine = service.saveMedecine(medecine);
            model.addAttribute("user", savedMedecine);
            ra.addFlashAttribute("message", "Request sent successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/medecine/list";
    }



//    @PostMapping("/medecine/save")
//    public String saveMedecine(Model model, Medecine medecine){
//        try {
//            Medecine savedMedecine = service.saveMedecine(medecine);
//            model.addAttribute("medecine", savedMedecine);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return "redirect:/medecine/list";
//    }

    @GetMapping("/medecine/list")
    public String displayMedecines(Model model){
        try {
            List<Medecine> listMedecine = service.displayMedecines();
            model.addAttribute("listMedecine",listMedecine);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "medecinecrud";
    }
    @GetMapping("/medecine/edit/{id}")
    public String editMedecine(@PathVariable("id") Medecine id, Model model){

        try {
            Medecine savedMedecine = service.findMedecineById(id);
            model.addAttribute("medecine", savedMedecine);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "medecinefor";
    }

}
