package com.me.angular.training.api.service;

import com.me.angular.training.api.configuration.ExceptionHandle;
import com.me.angular.training.api.dto.req.PostRequest;
import com.me.angular.training.api.entities.Post;
import com.me.angular.training.api.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ExceptionHandle("ไม่พบ Post id: " + id));
    }

    public Post add(PostRequest request) {
        Post post = new Post();
        post.setName(request.getName());
        post.setContent(request.getContent());
        return postRepository.save(post);
    }

    public Post update(long id, PostRequest request) {
        Post post = getById(id);
        post.setName(request.getName());
        post.setContent(request.getContent());
        return postRepository.save(post);
    }

    public void delete(long id) {
        postRepository.deleteById(getById(id).getId());
    }
}
