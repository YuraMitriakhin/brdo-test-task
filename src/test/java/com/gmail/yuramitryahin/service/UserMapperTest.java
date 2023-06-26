package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dto.CommentsDto;
import com.gmail.yuramitryahin.dto.RequestDto;
import com.gmail.yuramitryahin.dto.UserDto;
import com.gmail.yuramitryahin.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapCorrectRequestDtoDataToUserList(){
        UserDto userDto1 = new UserDto(100L, "username1");
        UserDto userDto2 = new UserDto(101L, "username2");
        CommentsDto commentsDto1 = new CommentsDto(1L, "test body 1", 50L, userDto1);
        CommentsDto commentsDto2 = new CommentsDto(2L, "test body 1", 51L, userDto2);
        List<CommentsDto> commentsDtoList = new ArrayList<>();
        commentsDtoList.add(commentsDto1);
        commentsDtoList.add(commentsDto2);
        RequestDto requestDto = new RequestDto(commentsDtoList);

        List<User> users = userMapper.mapRequestDtoToUserList(requestDto);

        Assertions.assertEquals(users.size(), 2);
        Assertions.assertEquals(users.get(0).getUsername(), "Username1");
        Assertions.assertEquals(users.get(1).getUsername(), "Username2");
    }

    @Test
    public void mapNullRequestDtoDataToUserList(){
        List<User> users = userMapper.mapRequestDtoToUserList(null);

        Assertions.assertEquals(users.size(), 0);
    }

    @Test
    public void mapRequestDtoDataWithNullUsernamesToUserList(){
        UserDto userDto1 = new UserDto(100L, null);
        CommentsDto commentsDto1 = new CommentsDto(1L, "test body 1", 50L, userDto1);
        List<CommentsDto> commentsDtoList = new ArrayList<>();
        commentsDtoList.add(commentsDto1);
        RequestDto requestDto = new RequestDto(commentsDtoList);

        List<User> users = userMapper.mapRequestDtoToUserList(requestDto);

        Assertions.assertEquals(users.size(), 1);
        Assertions.assertNull(users.get(0).getUsername());
    }
}
