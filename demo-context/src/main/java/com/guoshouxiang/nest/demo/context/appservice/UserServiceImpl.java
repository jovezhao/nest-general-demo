package com.guoshouxiang.nest.demo.context.appservice;

import com.guohuoxiang.nest.mybatis.pagination.PageList;
import com.guohuoxiang.nest.mybatis.pagination.PageParames;
import com.guoshouxiang.nest.context.event.EventBus;
import com.guoshouxiang.nest.context.loader.ConstructEntityLoader;
import com.guoshouxiang.nest.context.loader.EntityLoader;
import com.guoshouxiang.nest.context.loader.RepositoryEntityLoader;
import com.guoshouxiang.nest.context.model.StringIdentifier;
import com.guoshouxiang.nest.demo.appservice.contract.UserDto;
import com.guoshouxiang.nest.demo.appservice.contract.UserService;
import com.guoshouxiang.nest.demo.context.domain.User;
import com.guoshouxiang.nest.demo.context.domain.queries.UserQuery;
import com.guoshouxiang.nest.spring.AppService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@AppService
public class UserServiceImpl implements UserService {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private Mapper beanMapper;

    public void create(String userName, String pwd) {
        EntityLoader<User> entityLoader = new ConstructEntityLoader<>(User.class);
        User user = entityLoader.create(StringIdentifier.valueOf(UUID.randomUUID().toString()));
        user.init(userName, pwd);

    }

    public UserDto get(String id) {
        EntityLoader<User> entityLoader = new RepositoryEntityLoader<>(User.class);
        User user = entityLoader.create(StringIdentifier.valueOf(id));
        UserDto userDto = beanMapper.map(user, UserDto.class);
        return userDto;
    }

    @Autowired
    private UserQuery userQuery;

    public PageList<UserDto> query(int pageIndex,int pageSize) {
        PageList<User> list = userQuery.getList(PageParames.create(pageIndex,pageSize));
        PageList<UserDto> userDtos = list.mapPageList(p -> beanMapper.map(p, UserDto.class));
        return userDtos;
    }


}
