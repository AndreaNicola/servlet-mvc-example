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
                    "jdbc:mysql://localhost:3306/libreria",
                    "libreria",
                    "libreria");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Long nextId(String sql) {
        ResultSet rs = null;
        Long result = 1l;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {

            while (rs.next()) {
                result = result + rs.getLong(1);
            }

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return result;

    }


}
