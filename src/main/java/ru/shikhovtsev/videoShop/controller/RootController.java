package ru.shikhovtsev.videoShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

    @GetMapping(value = "/")
    public ModelAndView getHelloData() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("da");
        mv.getModel().put("hello", "Welcome to the main page!");
        return mv;
    }
}
