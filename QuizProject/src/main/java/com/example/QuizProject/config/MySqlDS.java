package com.example.QuizProject.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class MySqlDS {
    // thread safe
    private static DataSource ds;

    static {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("quiz");
        dataSource.setUser("root");
        dataSource.setPassword("!loveAbdo0422");//getPassword()
        ds = dataSource;
    }

    private MySqlDS() { }

    public static DataSource getDs() {
        return ds;
    }
}
