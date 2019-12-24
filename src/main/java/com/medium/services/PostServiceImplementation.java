package com.medium.services;

import com.medium.DAO.PostDAO;
import com.medium.Model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("PostService")
@Transactional
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostDAO postDAO;

    public List<Post> getAllPosts(){
        return postDAO.getAllPosts();
    }

    public Post getPost(Long id) {
        return postDAO.getPost(id);
    }

    public  Long addPost(String title, String content) {
        return postDAO.addPost(title,content);
    }

    public  void deletePost(Long id){
        postDAO.deletePost(id);
    }

    public  void updatePost(Long id, String title, String content) {
        postDAO.updatePost(id,title,content);
    }
}
