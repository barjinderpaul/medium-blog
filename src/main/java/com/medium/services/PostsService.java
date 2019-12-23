package com.medium.services;

import com.medium.Model.Post;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PostsService {

    static Configuration configuration = new Configuration().configure().addAnnotatedClass(Post.class);
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public static List<Post> getAllPosts(){
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        List<Post> allPosts = session.createQuery("FROM com.medium.Model.Post post ORDER BY post.id asc ").getResultList();
        t.commit();
        session.close();

        return allPosts;
    }

    public static Post getPost(Long id) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Post post = session.get(Post.class,id);

        t.commit();
        session.close();

        return post;
    }

    public static Long addPost(String title, String content) {
        content = content.trim();
        title = title.trim();

        Long post_id ;

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.save(post);
        post_id = post.getId();
        t.commit();
        session.close();

        return post_id;
    }

    public static void deletePost(Long id){
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Post post = session.get(Post.class, id);
        session.delete(post);

        t.commit();
        session.close();

    }

    public static void updatePost(Long id, String title, String content) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Post post = session.get(Post.class,id);

        post.setTitle(title);
        post.setContent(content);
        session.merge(post);

        t.commit();
        session.close();
    }
}
