package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

abstract class AbstractDao {

    Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/libreria?useSSL=false",
                    "libreria",
                    "libreria");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Long nextId(Connection connection, String sql) {

        Long result = 1l;
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                result = result + rs.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }


}
