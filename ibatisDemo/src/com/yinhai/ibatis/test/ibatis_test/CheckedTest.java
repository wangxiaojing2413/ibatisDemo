package com.yinhai.ibatis.test.ibatis_test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.yinhai.ibatis.entity.Checked;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zuoyao on 2018/9/16.
 */
public class CheckedTest {
    private static String config="SqlMapConfig.xml";
    private static Reader reader;
    private static SqlMapClient sqlMapClient;
    static {
        try {
            reader= Resources.getResourceAsReader(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlMapClient= SqlMapClientBuilder.buildSqlMapClient(reader);
    }
    public static Checked listAllUser() throws SQLException {
        List<Checked> list= sqlMapClient.queryForList("list2");
        System.out.println(list);
        return (Checked)sqlMapClient.queryForObject("list1");
    }
    public static void main(String[] args) throws SQLException {
        /*List<HashMap> hashMaps=null;
        try {
            hashMaps= listAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (HashMap hashMap:
                hashMaps) {
            System.out.println(hashMap);
        }*/
        System.out.println(listAllUser());
    }
}
