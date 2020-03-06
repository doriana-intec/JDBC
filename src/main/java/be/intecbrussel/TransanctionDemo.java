package be.intecbrussel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransanctionDemo {
    public static void main(String[] args) {

        String update1 = "UPDATE customers SET points = 10 WHERE customer_id=1";
        String update2 = "UPDATE customers SET points = 20 WHERE customer_id = 2";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
                "root", "intec123");
             Statement stmt = conn.createStatement()) {

            conn.setAutoCommit(false);

            stmt.executeUpdate(update1);
            stmt.executeUpdate(update2);

            conn.commit();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
