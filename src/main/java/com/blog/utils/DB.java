package com.blog.utils;

import java.sql.*;

public class DB {
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://192.168.110.135:3306/blog?autoReconnect=true";
    private Connection conn;
    private PreparedStatement ps;
    //构造函数加载驱动
    public DB() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库加载失败！");
            e.printStackTrace();
        }
    }
    //建立数据库连接
    public Connection getConn() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("创建数据库连接失败！");
                conn = null;
                e.printStackTrace();
            }
        }
        return conn;
    }
    //
    public void doPs(String sql, Object fields[]) {
        if (sql != null || !sql.equals("")) {
            if (fields == null)
                fields = new Object[0];
            getConn();
            if (conn != null) {
                try {
                    //https://www.cnblogs.com/bukudekong/archive/2011/06/22/2086528.html
                    //ps=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ps = conn.prepareStatement(sql);
                    for (int i = 0; i < fields.length; i++){
                        ps.setObject(i+1, fields[i]);
                    }
                    //System.out.println(sql);
                    ps.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //获得doPs执行查询操作后的结果集
    public ResultSet getRs() throws SQLException {
        return ps.getResultSet();
    }
    //获取doPs执行更新后操作后返回影响的记录数
    public int getCount() throws SQLException {
        return ps.getUpdateCount();
    }

    //释放对象
    public void closeObject() {
        try {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("对象关闭异常");
            e.printStackTrace();
        }
    }
}
