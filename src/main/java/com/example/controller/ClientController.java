package com.example.controller;

import com.example.model.ClientModel;
import com.example.serviceImplementation.ClientServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientServiceImplementation service;

    @GetMapping("/client/new")
    public String showClientForm(Model model){
        ClientModel client = new ClientModel();
        model.addAttribute("pageTitle","Create Request");
        model.addAttribute("client", client);

        return "clienntForm";
    }
    @PostMapping("/client/save")
    public String saveClient(ClientModel client, Model model, RedirectAttributes ra){
        try {
            ClientModel savedClient = service.saveClient(client);
            model.addAttribute("client", savedClient);
            ra.addFlashAttribute("message", "Request sent successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/";
    }
    @GetMapping("/client/edit/{id}")
    public String editRequest(@PathVariable("id") ClientModel id, Model model, RedirectAttributes ra){
        try {
            ClientModel savedClient = service.findClientById(id);
            model.addAttribute("client", savedClient);
            model.addAttribute("pageTitle","edit Client");
            ra.addFlashAttribute("message", "Your Client updated successfully");
            return "EditClient";
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "redirect:/client/list";
    }

    @PostMapping("/client/edit")
    public String editClient(ClientModel client, Model model, RedirectAttributes ra){
        try {
            ClientModel savedClient = service.saveClient(client);
            model.addAttribute("client", savedClient);
            model.addAttribute("pageTitle","Edit Client");
            ra.addFlashAttribute("message", "Request sent successfully");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/client/list";
    }

    @GetMapping("/client/list")
    public String displayClients(Model model){
        try {
            List<ClientModel> listClient = service.listClients();
            model.addAttribute("listClient", listClient);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "clientCrud";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClientForm(@PathVariable("id") ClientModel id, Model model, RedirectAttributes ra){
        try{
             service.deleteClient(id);
            ra.addFlashAttribute("message","client successfully deleted");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/client/list";
    }


}
