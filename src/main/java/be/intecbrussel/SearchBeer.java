package be.intecbrussel;

import java.sql.*;

public class SearchBeer {
    public static void main(String[] args) {

        /*alle gegevens van de bieren op het scherm afdrukken
        limiteer het op 10 records
        sorteer volgens alcoholgehalte
        toon alle bieren met een bepaalde alcoholgehalte
        toon eventueel ook alle gerelateerde gegevens (brouwer en biersoort)
        */

        try (Connection conn =
                     DriverManager
                             .getConnection("jdbc:mysql://localhost:3306/beers_db",
                "root","intec123");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Name,Alcohol FROM beers_db.beers LIMIT 10")){

            while (rs.next()){
                String name = rs.getString("Name");
                float alcohol = rs.getFloat("Alcohol");

                System.out.println(name + " " + alcohol);
            }
        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }
}
