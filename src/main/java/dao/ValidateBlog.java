package dao;

import java.sql.*;

public class ValidateBlog {
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
    public int validate(int blogID, String blog) {
        int insertRecord = 0;
        try {
            createConnection();
            String query = "INSERT INTO blog VALUES (?,?)";
            PreparedStatement queryStatement = databaseConnection.prepareStatement(query);
            queryStatement.setInt(1, blogID);
            queryStatement.setString(2, blog);
            insertRecord = queryStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return insertRecord;
    }

}
