package com.medium.repository;

import com.medium.Model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository<P> extends CrudRepository<Post,Long> {
}
