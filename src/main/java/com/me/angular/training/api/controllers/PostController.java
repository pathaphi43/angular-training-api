package com.me.angular.training.api.controllers;

import com.me.angular.training.api.dto.req.PostRequest;
import com.me.angular.training.api.entities.Post;
import com.me.angular.training.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("all")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getById(@PathVariable() long id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @PostMapping("add")
    public ResponseEntity<Post> add(@RequestBody PostRequest post) {
        return ResponseEntity.ok(postService.add(post));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Post> update(@PathVariable() long id, @RequestBody PostRequest post) {
        return ResponseEntity.ok(postService.update(id, post));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable() long id) {
        postService.delete(id);
        return ResponseEntity.ok(Map.of("message", "success"));
    }
}
