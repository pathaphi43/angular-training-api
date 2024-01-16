package com.me.angular.training.api.dto.req;

import lombok.Data;

/**
 * DTO for {@link com.me.angular.training.api.entities.Post}
 */
@Data
public class PostRequest {
    private String name;
    private String content;
}
