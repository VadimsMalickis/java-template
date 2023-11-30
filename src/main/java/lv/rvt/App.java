package lv.rvt;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;

@RestController
@SpringBootApplication
public class App {

  

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
    String testTask() {
        HashMap<String, Object> responseMap = new HashMap<>();


        int sum = 22;
        int count = 3;

        double result = (double) sum / count;
        

        responseMap.put("output", Double.valueOf(result));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(responseMap);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String hello() {
        return "{\"message\":\"hello from java!\"}";
    }

    @RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    String getAllStudents() {
        Student student = 
        new Student("Jānis",
        "Smith",
        "j@s.lv",
        "DP2-1");


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(student);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
