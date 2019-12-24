package com.medium.DAO;

import com.medium.Model.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAllPosts();
    Post getPost(Long id);
    Long addPost(String title, String content);
    void deletePost(Long id);
    void updatePost(Long id, String title, String content);
}
