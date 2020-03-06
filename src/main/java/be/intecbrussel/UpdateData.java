package be.intecbrussel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
                "root", "intec123");
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("UPDATE customers SET phone= '987-987-6325'" +
                    " WHERE customer_id = 6");

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
