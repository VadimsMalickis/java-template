package rvt;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    ModelAndView index() {
        ArrayList<Student> students = new CsvManager(CsvManager.STUDENT_CSV).getAllStudents();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("students", students);
        modelAndView.addObject("date", new Date().toString());
        return modelAndView;
    }

    @GetMapping(value = "/about")
    ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView("about");

        
        return modelAndView;
    }


}
