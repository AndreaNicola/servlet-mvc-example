package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

abstract class AbstractDao {

    Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/libreria",
                    "libreria",
                    "libreria");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
