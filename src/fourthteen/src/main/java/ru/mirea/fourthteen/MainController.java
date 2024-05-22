package ru.mirea.fourthteen;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/home")
    public String  index() {
        return "index.html";
    }
}
