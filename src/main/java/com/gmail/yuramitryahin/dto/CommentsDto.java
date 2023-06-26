package com.gmail.yuramitryahin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
   private Long id;
   private String body;
   private Long postId;
   private UserDto user;
}
