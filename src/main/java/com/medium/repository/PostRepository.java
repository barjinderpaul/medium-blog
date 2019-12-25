package com.medium.repository;

import com.medium.Model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository<P> extends CrudRepository<Post,Long> {
    List<P>  findAllByOrderByIdAsc();
}
