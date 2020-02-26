package sef.module13.activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private final static String DATABASE_URL = "jdbc:h2:~/test";
    private final static String DATABASE_DRIVER = "org.h2.Driver";


    private final static String USER = "sa";
    private final static String PASSWORD = "";

    private Connection conn = null;
    private Statement statement = null;

    public AccountDAOImpl(Connection conn) {

        this.conn = conn;

    }

    public List<Account> findAccount(String firstName, String lastName)
            throws AccountDAOException {

        List<Account> acountsList = new ArrayList<>();
        String sql_query = "SELECT * FROM ACCOUNT WHERE FIRST_NAME =" + "'" + firstName + "'" + " AND LAST_NAME=" + "'" + lastName + "'" + " ORDER BY ID";


        try {

            System.out.println("Registering JDBC driver...");
            Class.forName(DATABASE_DRIVER);


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);


            System.out.println("Creating statement...");
            statement = conn.createStatement();
            conn.setAutoCommit(false);
            System.out.println("Connection successfully established!");

            ResultSet rs = statement.executeQuery(sql_query);

            while (rs.next()) {
                acountsList.add(new AccountImpl(rs.getInt("ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("E_MAIL")));
            }
            rs.close();
            statement.close();
            conn.close();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return acountsList;
    }

    public Account findAccount(int id) throws AccountDAOException {

        String sql_query = "SELECT * FROM ACCOUNT WHERE ID=" + id;
        Account account = null;

        try {

            System.out.println("Registering JDBC driver...");
            Class.forName(DATABASE_DRIVER);


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);


            System.out.println("Creating statement...");
            statement = conn.createStatement();
            conn.setAutoCommit(false);
            System.out.println("Connection successfully established!");

            ResultSet rs = statement.executeQuery(sql_query);
            if (rs.next()) {
                account = new AccountImpl(rs.getInt("ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("E_MAIL"));
            } else {
                account = null;
            }

            rs.close();
            statement.close();
            conn.close();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return account;
    }


    public boolean insertAccount(String firstName, String lastName, String email)
            throws AccountDAOException {

        boolean isAdded = false;

        try {

            System.out.println("Registering JDBC driver...");
            Class.forName(DATABASE_DRIVER);


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);


            System.out.println("Creating statement...");
            statement = conn.createStatement();
            conn.setAutoCommit(false);
            System.out.println("Connection successfully established!");


            ResultSet rs = statement.executeQuery("SELECT MAX(`ID`) FROM ACCOUNT");
            int last_ID = -1;
            if (rs.next()) {
                last_ID = rs.getInt("MAX(ID)");
                last_ID++;
            }
            statement.executeUpdate("INSERT INTO ACCOUNT VALUES(" + last_ID + ",'" + firstName + "'," + "'" + lastName + "'," + "'" + email + "'" + ")");

            if (statement.execute("SELECT * FROM ACCOUNT WHERE ID=" + last_ID + " AND FIRST_NAME =" + "'" + firstName + "'" + " AND LAST_NAME=" + "'" + lastName + "'" + " AND E_MAIL=" + "'" + email + "'")) {
                isAdded = true;
            }

            rs.close();
            statement.close();
            conn.close();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return isAdded;
    }


}
