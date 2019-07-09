package com.guoshouxiang.nest.demo.appservice.contract;


import java.util.List;

public interface UserService {
    void create(String userName, String pwd);
    UserDto get(String id);
    List<UserDto> query(int pageIndex, int pageSize);
}
