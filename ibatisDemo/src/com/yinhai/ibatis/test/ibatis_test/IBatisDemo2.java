package com.yinhai.ibatis.test.ibatis_test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * ibatis测试返回值为HashMap
 * Created by zuoyao on 2018/9/14.
 */
public class IBatisDemo2 {
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
    public static List<HashMap> listAllUser() throws SQLException {
        return sqlMapClient.queryForList("listAllUserUseHashMap");
    }
    public static void main(String[] args) {
        List<HashMap> hashMaps=null;
        try {
            hashMaps= listAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (HashMap hashMap:
                hashMaps) {
            System.out.println(hashMap);
        }
    }
}
