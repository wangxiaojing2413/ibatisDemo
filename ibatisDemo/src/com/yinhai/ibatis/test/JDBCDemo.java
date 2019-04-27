package com.yinhai.ibatis.test;

import com.yinhai.ibatis.entity.User;
import com.yinhai.ibatis.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zuoyao on 2018/9/14.
 */
public class JDBCDemo {
    public static User getUser(int id) throws SQLException {
        User user = null;
        String sql = "SELECT users.id,users.username,users.`password`,users.mobile,users.email," +
                "users.gmt_create,users.gmt_modified FROM users WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setGmt_create(rs.getDate("gmt_create"));
                user.setGmt_modified(rs.getDate("gmt_modified"));
            }
        }finally {
            try{
                if (rs != null) {
                    rs.close();
                }
            }finally {
                try{
                    if (pstmt != null) {
                        pstmt.close();
                    }
                }finally {
                    if (conn != null) {
                        conn.close();
                    }
                }
            }
        }
        return user;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getUser(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
