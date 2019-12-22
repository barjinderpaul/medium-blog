package com.medium.services;

import com.medium.Model.Posts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PostsService {


    static Configuration configuration = new Configuration().configure().addAnnotatedClass(Posts.class);
    static SessionFactory sessionFactory = configuration.buildSessionFactory();



    public static List<Posts> getAllPosts(){
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        List<Posts> allPosts = session.createQuery("SELECT a FROM com.medium.Model.Posts a", Posts.class).getResultList();

//working single get and single save
//        Posts post2 = session.get(Posts.class,1L);

        t.commit();//transaction is commited
        session.close();

//        allPosts.forEach((postss)->{
//            System.out.println("Title = " + postss.getTitle() + "\nContent = " + postss.getContent());
//        });

        return allPosts;
    }

    public static Posts getPost(Long id) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Posts post = session.get(Posts.class,id);

        t.commit();
        session.close();

        return post;
    }

    public static void addPost(String title, String content) {
        Posts post = new Posts();
        post.setTitle(title);
        post.setContent(content);

        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(post);
        t.commit();//transaction is commited
        session.close();
    }

    public static void deletePost(Long id){
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Posts post = session.load(Posts.class, id);
        session.delete(post);
        t.commit();

        session.close();

    }

    public static void updatePost(Long id, String title, String content) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Posts post = session.get(Posts.class,id);
        post.setTitle(title);
        post.setContent(content);

        t.commit();
        session.close();

    }

}
