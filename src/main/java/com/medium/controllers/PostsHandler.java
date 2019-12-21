package com.medium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostsHandler {
    @RequestMapping("/posts")
    public ModelAndView getBlogPosts(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blogPosts");
        modelAndView.addObject("name","Hello mvc");

        return modelAndView;
    }
}
