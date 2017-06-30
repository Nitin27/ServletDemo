package dao;

import java.sql.*;

public class ValidateUser {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection databaseConnection;

    void createConnection() throws SQLException {
        databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogworld", "root", "root");
    }


    void closeConnection() throws SQLException {
        databaseConnection.close();
    }


    public boolean validate(String userName, String userPassword) {
        boolean hasRecord = false;
        try {
            createConnection();
            String query = "SELECT * FROM bloguser WHERE BloggerName=? AND BloggerPassword=?";
            PreparedStatement queryStatement = databaseConnection.prepareStatement(query);
            queryStatement.setString(1, userName);
            queryStatement.setString(2, userPassword);
            ResultSet result = queryStatement.executeQuery();
            hasRecord=result.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hasRecord;
    }
}
