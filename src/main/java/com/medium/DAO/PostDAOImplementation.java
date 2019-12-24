package com.medium.DAO;

import com.medium.Model.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostDAO")
public class PostDAOImplementation extends AbstractDAO implements PostDAO {

    @Override
    public List<Post> getAllPosts() {
        Session session = getSession();
        List<Post> posts = session.createQuery("FROM com.medium.Model.Post post ORDER BY post.id asc ").getResultList();
        session.close();
        return posts;
    }

    @Override
    public Post getPost(Long id) {
        return getSession().get(Post.class,id);
    }

    @Override
    public Long addPost(String title, String content) {
        content = content.trim();
        title = title.trim();

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        getSession().save(post);

        return post.getId();
    }

    @Override
    public void deletePost(Long id) {
        Session session = getSession();
        Transaction t = session.beginTransaction();
        Post post = session.get(Post.class, id);
        session.delete(post);
        t.commit();
        session.close();
    }

    @Override
    public void updatePost(Long id, String title, String content) {
        Session session = getSession();

        Post post = session.get(Post.class,id);

        Transaction transaction = session.beginTransaction();

        post.setTitle(title);
        post.setContent(content);
        session.merge(post);
        transaction.commit();

        session.close();

    }
}
