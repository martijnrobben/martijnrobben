
import java.sql.*;

public class CRUD {


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

    public CRUD() {
    }

    public void addAccount() {
        String result = "";
        MyFrame acc = new MyFrame();
        MyFrame naam = new MyFrame();
        MyFrame straat = new MyFrame();
        MyFrame postcode = new MyFrame();
        MyFrame nummer = new MyFrame();
        MyFrame woonplaats = new MyFrame();

        String a = acc.getAcc();
        String b = naam.getNaam();
        String c = straat.getStraat();
        String d = postcode.getPostcode();
        String x = nummer.getNummer();
        String f = woonplaats.getWoonplaats();


        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            String SQL = "INSERT INTO Account(Abonneenummer, Naam, Straat, Postcode, Huisnummer, Plaats) VALUES\n" +
                    "(" + a + ", '" + b + "', '" + c + "', '" + d + "', '" + x + "', '" + f + "');";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            //System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.

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
    }
}