package com.guoshouxiang.nest.demo.context.infrastructure.repositories;

import com.guohuoxiang.nest.mybatis.pagination.PageList;
import com.guohuoxiang.nest.mybatis.pagination.PageParames;
import com.guoshouxiang.nest.context.loader.EntityLoader;
import com.guoshouxiang.nest.context.loader.RepositoryEntityLoader;
import com.guoshouxiang.nest.context.model.StringIdentifier;

import com.guoshouxiang.nest.demo.context.domain.User;
import com.guoshouxiang.nest.demo.context.domain.queries.UserQuery;
import com.guoshouxiang.nest.demo.context.infrastructure.dao.queries.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQueryRepository implements UserQuery {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageList<User> getList(PageParames pageParames) {
        EntityLoader<User> userEntityLoader = new RepositoryEntityLoader<>(User.class);

        PageList<User> users = userMapper.getList(pageParames)
                .mapPageList(p -> userEntityLoader.create(StringIdentifier.valueOf(p)));
        return users;
    }
}
