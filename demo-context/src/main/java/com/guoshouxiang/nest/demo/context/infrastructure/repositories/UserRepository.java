package com.guoshouxiang.nest.demo.context.infrastructure.repositories;


import com.guoshouxiang.nest.context.loader.EntityLoader;
import com.guoshouxiang.nest.context.model.Identifier;
import com.guoshouxiang.nest.context.repository.Repository;
import com.guoshouxiang.nest.demo.context.domain.User;
import com.guoshouxiang.nest.demo.context.infrastructure.dao.UserDmo;
import com.guoshouxiang.nest.demo.context.infrastructure.dao.mapper.UserDmoMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements Repository<User> {

    @Autowired
    private UserDmoMapper userDmoMapper;
    @Autowired
    private Mapper beanMapper;

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User getEntityById(Identifier identifier, EntityLoader<User> entityLoader) {

        UserDmo userDmo = userDmoMapper.selectByPrimaryKey(identifier.toValue());

        User user = entityLoader.create(identifier);

        beanMapper.map(userDmo, user);
        return user;
    }

    @Override
    public void save(User user) {
        UserDmo record = new UserDmo();
        record.setId(user.getId().toValue());
        record.setPassword(user.getPassword());
        record.setUsername(user.getUsername());
        userDmoMapper.insert(record);

    }

    @Override
    public void remove(User user) {

    }
}
