package rvt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ModelAndView testAction() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("output1", 1);
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(@ModelAttribute("student") Student student) {

        ModelAndView modelAndView = new ModelAndView("registration/registration-page");
        List<String> groups = new ArrayList<>(List.of("DP2-1", "DP2-2", "DP2-3", "DP2-4"));
        modelAndView.addObject("groups", groups);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request, @ModelAttribute("student") Student student) {
        ModelAndView modelAndView = new ModelAndView("registration/registration-success");

        return modelAndView;
    }

}
