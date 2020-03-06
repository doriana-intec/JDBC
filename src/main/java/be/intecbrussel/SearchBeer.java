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

        String orderByAlcohol = "SELECT Name,Alcohol FROM beers_db.beers ORDER BY Alcohol LIMIT 10";
        String alcohoholQuery = "SELECT Name,Alcohol FROM beers_db.beers WHERE Alcohol > 5 LIMIT 5";
        String relatedData = "SELECT b.Name,br.Name,c.Category FROM beers_db.beers AS b " +
                "JOIN beers_db.brewers AS br ON b.BrewerId = br.Id " +
                "JOIN beers_db.categories AS c ON b.CategoryId = c.Id";

        try (Connection conn =
                     DriverManager
                             .getConnection("jdbc:mysql://localhost:3306/beers_db",
                                     "root", "intec123");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(relatedData)) {

            while (rs.next()) {
                String beerName = rs.getString("b.Name");
                String brewersName = rs.getString("br.Name");
                String category = rs.getString("Category");

                System.out.println(beerName + " " + brewersName + " " + category);

            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
