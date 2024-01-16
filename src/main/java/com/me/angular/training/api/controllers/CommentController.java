package com.me.angular.training.api.controllers;

import com.me.angular.training.api.dto.req.AddCommentRequest;
import com.me.angular.training.api.dto.req.UpdateCommentRequest;
import com.me.angular.training.api.entities.Comment;
import com.me.angular.training.api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("all")
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Comment> getById(@PathVariable() long id) {
        return ResponseEntity.ok(commentService.getById(id));
    }

    @PostMapping("add")
    public ResponseEntity<Comment> add(@RequestBody AddCommentRequest request) {
        return ResponseEntity.ok(commentService.add(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Comment> update(@PathVariable() long id, @RequestBody UpdateCommentRequest request) {
        return ResponseEntity.ok(commentService.update(id, request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable() long id) {
        commentService.delete(id);
        return ResponseEntity.ok(Map.of("message", "success"));
    }
}
