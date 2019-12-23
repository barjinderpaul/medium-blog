package com.medium.controllers;

import com.medium.Model.Posts;
import com.medium.services.PostsService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RouteHandler {


    @RequestMapping(value = "/add")
    public ModelAndView redirectToCreatePost(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("createPost");
        modelAndView.addObject("heading","Add Post");
        modelAndView.addObject("customAction","addPost");

        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}")
    public ModelAndView redirectToUpdatePost( @PathVariable("id") String id) {
        Long postId = Long.parseLong(id);

        Posts post = PostsService.getPost(postId);
        String content = post.getContent();
        String title = post.getTitle();


        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("createPost");
        modelAndView.addObject("heading","Update Post");
        modelAndView.addObject("customAction","updatePost");
        modelAndView.addObject("content","some-sample-content");
        modelAndView.addObject("id",postId);
        modelAndView.addObject("content",content);
        modelAndView.addObject("title",title);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView redirectToDeletePage(@PathVariable("id") String id){
        Long postId = Long.parseLong(id);

        Posts post = PostsService.getPost(postId);
        String content = post.getContent();
        String title = post.getTitle();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deletePost");
        modelAndView.addObject("customAction","addPost");
        modelAndView.addObject("id",postId);
        modelAndView.addObject("content",content);
        modelAndView.addObject("title",title);


        return modelAndView;
    }
}
