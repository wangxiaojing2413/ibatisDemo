package com.yinhai.ibatis.test.ibatis_test;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.yinhai.ibatis.entity.User;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试ibatis入门查询所有用户和根据id查询
 * Created by zuoyao on 2018/9/14.
 */
public class IBatisDemo {
    public static void main(String[] args) throws IOException, SQLException {
        String config = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(config);
        SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
        List<User> userList = sqlMapClient.queryForList("listAllUser");
        User user = (User) sqlMapClient.queryForObject("getUserById", 1);
        for (User u :
                userList) {
            System.out.println(u);
        }
        System.out.println(user);
    }
}
