package rvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import rvt.exercises.Book;
import rvt.exercises.Box;
import rvt.exercises.CD;
import rvt.exercises.Packable;
import rvt.exercises.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    ModelAndView index() {
        // TODO get students from CSV
        ArrayList<Student> students = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("students", students);
        modelAndView.addObject("date", new Date().toString());
        return modelAndView;
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String testAction() {
        
        Packable book = new Book("A", "B", 1);

        return book.toString();
        
    }


    @GetMapping(value = "/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration/registration-page");
        List<String> groups = new ArrayList<>(List.of("DP2-1", "DP2-2", "DP2-3", "DP2-4"));

        Student student = new Student();
        modelAndView.addObject("groups", groups);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String registration(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registration-page";
        }

      

        // Save Student object to CSV
        

        return "redirect:/register?success";
    }

}
