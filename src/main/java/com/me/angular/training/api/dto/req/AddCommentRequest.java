package com.me.angular.training.api.dto.req;

import lombok.Data;

/**
 * DTO for {@link com.me.angular.training.api.entities.Comment}
 */
@Data
public class AddCommentRequest {
    private long postId;
    private String message;
}
