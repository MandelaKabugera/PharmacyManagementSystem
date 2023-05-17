package com.example.controller;

import com.example.model.UserModel;
import com.example.serviceImplementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImplementation service;

    @GetMapping("/user/new")
    public String showSignupForm(Model model){
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/user/save")
    public String saveSignupPage(UserModel user, Model model, RedirectAttributes ra){
        try {
            UserModel savedUser = service.saveUser(user);
            model.addAttribute("pageTitle","Signup Form");
            model.addAttribute("user", savedUser);
            ra.addFlashAttribute("message", "Account created successfully, you can now login");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "login";
    }

    @GetMapping("/user/login")
    public String showLoginForm(Model model){
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/user/login/save")
    public String userLogin(Model model, UserModel user, RedirectAttributes ra){
        
        if (user.getPhone().equals("0780000")){

                return "adminPanal";
            }
                else {
                ra.addFlashAttribute("message","Invalid credential");
                return "redirect:/user/login";
            }

        }


    @GetMapping("/user/list")
    public String displayUsers(Model model){
        List<UserModel> listUser = service.displayUsers();
        model.addAttribute("listUsers", listUser);

        return "usercrud";
    }

    @GetMapping("/user/edit/{phone}")
    public String editUser(@PathVariable("phone") UserModel phone, Model model, RedirectAttributes ra){
        try{
            UserModel savedUser = service.findUserById(phone);
            model.addAttribute("user", savedUser);
            model.addAttribute("pageTitle", "edit User");
            ra.addFlashAttribute("message", "User successfully updated");
            return "userForm";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/user/list";

    }

    @GetMapping("/user/delete/{phone}")
    public String deleteUser(@PathVariable("phone") UserModel phone, Model model, RedirectAttributes ra){
            try {
                service.deleteUser(phone);
                ra.addFlashAttribute("message", "User deleted successfully");
            }catch (Exception ex){
                ex.printStackTrace();
            }

        return "redirect:/user/list";
    }

    @PostMapping("/user/edit")
    public String editUserAccount(UserModel user, Model model, RedirectAttributes ra){
        try {
            UserModel savedUser = service.saveUser(user);
            model.addAttribute("pageTitle","Signup Form");
            model.addAttribute("user", savedUser);
            ra.addFlashAttribute("message", "Account created successfully, you can now login");
        }catch (Exception ex){
        	
            ex.printStackTrace();
        }
        return "redirect:/user/list";
    }

}
