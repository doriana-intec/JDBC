package be.intecbrussel;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {

        try(Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
                            "root","intec123");
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement
                    .executeQuery("SELECT product_id,name FROM products")){

            rs.afterLast();
            while(rs.previous()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                System.out.println(id + " -> " + name);
            }

            System.out.println("Connecting with " + connection.getCatalog()
                    + " database");
        }catch (SQLException se){
            se.printStackTrace();
            System.out.println(se.getMessage());
        }
    }
}
