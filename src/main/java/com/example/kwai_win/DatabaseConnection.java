package com.example.kwai_win;

import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String CREDENTIALS_STRING = "jdbc:mysql://google/KWAI?cloudSqlInstance=optical-net-344621:us-central1:kwai&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=Kw@1v1su@l1z3r";

        try {
            databaseLink = DriverManager.getConnection((CREDENTIALS_STRING));
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
