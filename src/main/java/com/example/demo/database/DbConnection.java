//package com.example.demo.database;
//import java.sql.*;
//
//public class DbConnection {
//
//    private static DbConnection instance;
//    private Connection connection;
//    private DbConnection() throws Exception {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/robschool", "root", "04061998");
//            System.out.println("Connection to database successful");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static DbConnection getInstance() throws Exception {
//        if (instance == null) {
//            instance = new DbConnection();
//        }
//        return instance;
//    }
//
//    public Connection getDbConn() {
//        return connection;
//    }
//
//    public void yourRemainingCodeFromMain() throws SQLException {
//        Statement  statement = connection.createStatement();
//
//
//
////            String sql = "CREATE TABLE people" +
////                    "(id INTEGER not null," +
////                    "name VARCHAR(255)," +
////                    "capacity INTEGER," +
////                    "address VARCHAR(255) " +
////                    "PRIMARY KEY(id))";
//
////            int resultSet = st.executeUpdate(sql);
//        ResultSet resultSet = statement.executeQuery("select * from school");
//
////            st.executeUpdate(sql);
//        System.out.println("Table created");
//
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("id"));
//        }
//
//    }
//    public int executeQuery(PreparedStatement query) throws DataAccessException {
//        int result;
//        try {
//            result = query.executeUpdate();
//            query.close();
//        } catch (SQLException e) {
//            throw new DataAccessException(e.getMessage());
//        }
//        return result;
//    }
//
//    public int executeInsertWithID(PreparedStatement query) throws DataAccessException {
//        ResultSet rs;
//        int generatedKey = -1;
//        try {
//            query.executeUpdate();
//            rs = query.getGeneratedKeys();
//            if (rs.next()) {
//                generatedKey = rs.getInt(1);
//            }
//            query.close();
//        } catch (SQLException throwables) {
//            throw new DataAccessException(throwables.getMessage());
//        }
//        return generatedKey;
//    }
//
//    public ResultSet executeSelect(PreparedStatement query) throws DataAccessException {
//        ResultSet rs;
//        try {
//            rs = query.executeQuery();
//        } catch (SQLException e) {
//            throw new DataAccessException(e.getMessage());
//        }
//
//        return rs;
//    }
//}
//
//
//
