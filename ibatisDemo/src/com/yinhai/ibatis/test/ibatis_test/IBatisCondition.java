package com.yinhai.ibatis.test.ibatis_test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.yinhai.ibatis.utils.ParameterMap;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ibatis根据用户名条件查询使用#name#占位符
 * 和多条件查询
 * 和添加用户
 * Created by zuoyao on 2018/9/14.
 */
public class IBatisCondition {
    private static String config = "SqlMapConfig.xml";
    private static Reader reader;
    private static SqlMapClient sqlMapClient;

    static {
        try {
            reader = Resources.getResourceAsReader(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
    }

    /**
     * 根据用户名查询用户
     * @param parameter
     * @return HashMap
     * @throws SQLException
     */
    public static HashMap getUserByUsername(String parameter) throws SQLException {
        return (HashMap) sqlMapClient.queryForObject("getUserByUsername", parameter);
    }

    /**
     * 根据电话号码和email多条件查询用户
     * @param parameterMap
     * @return HashMap
     * @throws SQLException
     */
    public static HashMap getUserByConditions(Map parameterMap) throws SQLException {
        return (HashMap)sqlMapClient.queryForObject("getUserByConditions",parameterMap);
    }

    public static int saveUser(Map parameterMap) throws SQLException {
        return sqlMapClient.update("addUser",parameterMap);
    }
    public static void main(String[] args) {
        //测试根据用户名查询用户
        /*HashMap user=null;
        try {
            user = getUserByUsername("zy");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);*/

        //测试根据电话号码和email多条件查询用户
        /*ParameterMap parameterMap=new ParameterMap("mobile","123456","email","123");
        HashMap map=null;
        try {
            System.out.println(parameterMap);
             map= getUserByConditions(parameterMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(map);*/

        //测试添加用户
        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(d);
        System.out.println(format);
        ParameterMap parameterMap=new ParameterMap("username","ls","password","123","mobile",
                "150","email","789","create_date",format,"update_date",format);
        try {
            System.out.println(saveUser(parameterMap));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
