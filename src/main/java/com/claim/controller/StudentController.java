package com.claim.controller;


import com.claim.entity.Student;
import com.claim.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {


    @Autowired //run alongside the project from StudentService
    StudentService stuService;

    @GetMapping("/")
    public String welcome(Model model){

        return "index";
    }

    @GetMapping("/sign-up")
    public ModelAndView signUp(Model model){

        return new ModelAndView("/sign-up", "student", new Student());
    }

    @PostMapping("/sign-up")
    public String handleSignUp(Model model, @ModelAttribute("student") Student student, HttpSession session){
        stuService.saveStudent(student);
        model.addAttribute("newStudent", student);
        return "thank-you";
    }

    @GetMapping("/login")
    public ModelAndView login(Model model){
        return new ModelAndView("/login", "student", new Student());

    }

    @PostMapping("/login")
    public String handleLogin(Model model, @ModelAttribute("student") Student student, HttpSession session) {
        if (!stuService.findStudent(student)) {
            model.addAttribute("setStudent", student);
            return "index";
        } else {
            return "login";
        }
    }


}
