package ee.taltech.unity.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class IndexController implements ErrorController{

    @GetMapping
    public String index(){
        return "API is up and can be seen on /api/finance (?symbol=IBM).";
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "The page you have arrived to does not exist.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
