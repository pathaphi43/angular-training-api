package com.me.angular.training.api.service;

import com.me.angular.training.api.configuration.ExceptionHandle;
import com.me.angular.training.api.dto.req.AddCommentRequest;
import com.me.angular.training.api.dto.req.UpdateCommentRequest;
import com.me.angular.training.api.entities.Comment;
import com.me.angular.training.api.entities.Post;
import com.me.angular.training.api.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment getById(long id) {
        return commentRepository.findById(id).orElseThrow(() -> new ExceptionHandle("ไม่พบ Comment id:" + id));
    }

    public Comment add(AddCommentRequest request) {
        Post post = postService.getById(request.getPostId());
        Comment comment = new Comment();
        comment.setPosts(post);
        comment.setMessage(request.getMessage());
        return commentRepository.save(comment);
    }

    public Comment update(long id, UpdateCommentRequest post) {
        Comment comment = getById(id);
        comment.setMessage(post.getMessage());
        return commentRepository.save(comment);
    }

    public void delete(long id) {
        commentRepository.deleteById(getById(id).getId());
    }
}
