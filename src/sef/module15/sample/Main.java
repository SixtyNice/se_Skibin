package sef.module15.sample;

import java.lang.annotation.Inherited;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("dsd:dsd", "ds", "");
        Statement statement = connection.createStatement();
        ResultSet s = statement.executeQuery("");
    }
}
