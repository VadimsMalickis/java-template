package rvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    
   @GetMapping(value = "/")
    String index(@RequestParam(name="name", required=false, defaultValue="null") String name, Model model) {
        Student student = new Student("John", "Smith", "a@a.lv", "DP2-4");
        List<Student> students = new ArrayList<>();
        students.add(student);
        model.addAttribute("students", students);
        model.addAttribute("date", new Date().toString());
        
        return "index";
    }
}
