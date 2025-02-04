package com.medium.controllers;

import com.medium.Model.Post;
import com.medium.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/","/posts"}, method= RequestMethod.GET)
    public ModelAndView getBlogPosts(){

       List<Post> allPosts = postService.getAllPosts();
        System.out.println("====================== posts  =   " + allPosts);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blogPosts");
        modelAndView.addObject("name","Hello mvc");
        modelAndView.addObject("allPosts",allPosts);

        return modelAndView;
    }

    @RequestMapping(value = "posts/add",method = RequestMethod.GET)
    public ModelAndView redirectToCreatePost(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("createPost");
        modelAndView.addObject("heading","Add Post");
        modelAndView.addObject("customAction","addPost");

        return modelAndView;
    }

    @RequestMapping(value = "posts/add",method = RequestMethod.POST)
    public ModelAndView addPost(@RequestParam("title") String title, @RequestParam("content") String content) {

        Long post_id = postService.addPost(title,content);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createPost");
        modelAndView.addObject("postCreated","true");
        modelAndView.addObject("title",title);
        modelAndView.addObject("heading","Post created");
        modelAndView.addObject("id",post_id);
        modelAndView.addObject("customAction","postCreated");

        return modelAndView;
    }

    @RequestMapping(value = "posts/{id}",method = RequestMethod.GET)
    public ModelAndView getPost(@PathVariable("id") Long id) {

       Post post = postService.getPost(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("singlePost");
        modelAndView.addObject("post",post);

        return modelAndView;
    }


    @RequestMapping(value = "posts/delete/{id}", method = RequestMethod.GET)
    public ModelAndView redirectToDeletePage(@PathVariable("id") String id){
        Long postId = Long.parseLong(id);

        Post post = postService.getPost(postId);

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

    @RequestMapping(value = "posts/delete/{id}",method = RequestMethod.POST)
    public String deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/";

    }

    @RequestMapping(value = "posts/update/{id}" ,method = RequestMethod.GET)
    public ModelAndView redirectToUpdatePost( @PathVariable("id") String id) {
        Long postId = Long.parseLong(id);

        Post post = postService.getPost(postId);
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

    @RequestMapping(value = "posts/update/{id}",method = RequestMethod.POST)
    public String updatePost(@PathVariable("id") Long id, @RequestParam("title") String title, @RequestParam("content") String content) {

        postService.updatePost(id,title,content);
        return "redirect:/posts/{id}";
    }

}
