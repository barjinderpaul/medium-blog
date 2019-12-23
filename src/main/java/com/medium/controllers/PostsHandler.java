package com.medium.controllers;

import com.medium.Model.Posts;
import com.medium.services.PostsService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostsHandler {
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView getBlogPosts(){

       List<Posts> allPosts = PostsService.getAllPosts();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blogPosts");
        modelAndView.addObject("name","Hello mvc");
        modelAndView.addObject("allPosts",allPosts);

        return modelAndView;
    }

    @RequestMapping("/addPost")
    public ModelAndView addPost(@RequestParam("title") String title, @RequestParam("content") String content) {

        Long post_id = PostsService.addPost(title, content);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createPost");
        modelAndView.addObject("postCreated","true");
        modelAndView.addObject("title",title);
        modelAndView.addObject("heading","Post created");
        modelAndView.addObject("id",post_id);
        modelAndView.addObject("customAction","postCreated");

        return modelAndView;
    }

    @RequestMapping(value = "/posts/{id}",method = RequestMethod.GET)
    public ModelAndView getPost(@PathVariable("id") Long id) {

        Posts post = PostsService.getPost(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("singlePost");
        modelAndView.addObject("post",post);
        return modelAndView;
    }

    @RequestMapping(value = "delete/deletes/{id}")
    public String deletePost(@PathVariable("id") Long id){
        PostsService.deletePost(id);
        return  "redirect:/";

    }

    @RequestMapping(value = "update/updates/{id}")
    public String updatePost(@PathVariable("id") Long id, @RequestParam("title") String title, @RequestParam("content") String content) {
        PostsService.updatePost(id, title, content);
        return "redirect:/posts/{id}";
    }

}
