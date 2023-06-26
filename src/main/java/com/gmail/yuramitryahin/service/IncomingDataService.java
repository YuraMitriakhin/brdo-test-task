package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dto.RequestDto;
import com.gmail.yuramitryahin.entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IncomingDataService {
    private static final String DUMMYJSON_URL = "https://dummyjson.com/comments";
    private final RestTemplate restTemplate;
    private final UserMapper userMapper;

    public IncomingDataService(RestTemplateBuilder restTemplateBuilder, UserMapper userMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.userMapper = userMapper;
    }
    public List<User> getUserData(){
        RequestDto requestDto = restTemplate.getForObject(DUMMYJSON_URL, RequestDto.class);
        return userMapper.mapRequestDtoToUserList(requestDto);
    }
}
