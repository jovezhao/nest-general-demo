package com.guoshouxiang.nest.demo.context.domain.queries;

import com.guohuoxiang.nest.mybatis.pagination.PageList;
import com.guohuoxiang.nest.mybatis.pagination.PageParames;
import com.guoshouxiang.nest.demo.context.domain.User;


public interface UserQuery {
    PageList<User> getList(PageParames pageParames);
}
