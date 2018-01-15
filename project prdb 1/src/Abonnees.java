import java.sql.*;

public class Abonnees {


    // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
    String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetFlix;integratedSecurity=true;";

    // Connection beheert informatie over de connectie met de database.
    Connection con = null;

    // Statement zorgt dat we een SQL query kunnen uitvoeren.
    Statement stmt = null;

    // ResultSet is de tabel die we van de database terugkrijgen.
    // We kunnen door de rows heen stappen en iedere kolom lezen.
    ResultSet rs = null;



    private String result;

    public Abonnees() {
    }

    public String getAbonnees() {
        String result = "";
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            String SQL = "SELECT Naam, Abonneenummer FROM Account;";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            //System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.

                String Naam = rs.getString("Naam");
                int Abonneenummer = rs.getInt("Abonneenummer");


                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                result += String.format("| %-50s | %-10s \n", Naam, Abonneenummer);

                // result=(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-") + System.out.format("| %7d | %-32s | %-24s | \n", Serienaam));

            }
            // String returnValue = String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-");
            // System.out.println(returnValue);

        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }

        }
        return result;
    }
}