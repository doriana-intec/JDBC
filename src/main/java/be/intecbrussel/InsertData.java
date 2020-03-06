package be.intecbrussel;

import java.sql.*;

public class InsertData {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
                "root", "intec123");
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("INSERT INTO customers " +
                    "VALUES (DEFAULT,'name','koekoek','1995-02-12','98621-46522'," +
                    "'address','city','IL',DEFAULT)", Statement.RETURN_GENERATED_KEYS);

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println(id);
                }
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
