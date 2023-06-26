package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dto.CommentsDto;
import com.gmail.yuramitryahin.dto.RequestDto;
import com.gmail.yuramitryahin.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private static final String DATE_FORMATTER= "d-m-Y H:m:s";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    public List<User> mapRequestDtoToUserList(RequestDto requestDto){
        return requestDto != null
                ? requestDto.getComments().stream()
                .map(this::mapCommentsToUser)
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    private User mapCommentsToUser(CommentsDto commentsDto){
        return new User(commentsDto.getId(), commentsDto.getBody(), commentsDto.getPostId(), changeFirstLatterToUpperCase(commentsDto.getUser().getUsername()), LocalDateTime.now().format(formatter));
    }

    private String changeFirstLatterToUpperCase(String username){
        return username == null || username.isBlank() ? username : username.substring(0, 1).toUpperCase() + username.substring(1);
    }
}
