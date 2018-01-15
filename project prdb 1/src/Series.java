import java.sql.*;

public class Series {


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

    public Series() {
    }

    public String alleSeries(){
        String result = "";
        try{
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            String SQL = "SELECT Serienaam\n" +
                    "FROM Serie";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            //System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.

                String Serienaam = rs.getString("Serienaam");



                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                result+=String.format("| %-32s | \n", Serienaam);

               // result=(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-") + System.out.format("| %7d | %-32s | %-24s | \n", Serienaam));

            }
           // String returnValue=String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-");
            //System.out.println   (returnValue);

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
    public String getSerie() {

        String result = "";
        MyFrame text = new MyFrame();
        String a = text.getInput();

        //(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));
           // String a = "";


            try{
                // 'Importeer' de driver die je gedownload hebt.
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                // Maak de verbinding met de database.
                con = DriverManager.getConnection(connectionUrl);

                // Stel een SQL query samen.
                String SQL = "SELECT AfleveringId, Titel, AVG(b.percentage) AS per\n" +
                        "FROM Aflevering AS a\n" +
                        "FULL JOIN Bekeken AS b ON a.AfleveringId=b.BekekenId\n" +
                        "WHERE (Serienaam = '"+a+"')\n" +
                        "GROUP BY AfleveringId, Titel;";
                stmt = con.createStatement();
                // Voer de query uit op de database.
                rs = stmt.executeQuery(SQL);

               // System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

                // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
                while (rs.next()) {
                    // Vraag per row de kolommen in die row op.
                    int AfleveringId = rs.getInt("AfleveringId");
                    String Titel = rs.getString("Titel");
                    int per = rs.getInt("per");


                    // Print de kolomwaarden.
                    // System.out.println(ISBN + " " + title + " " + author);

                    // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                    // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                    result+=String.format("| %7d | %-32s | %-24s | \n", AfleveringId, Titel, per);


                  //  result=(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-") + System.out.format("| %7d | %-32s | %-24s | \n", FilmId, Titel, Taal));

                }
               //String returnValue=String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-");
               // System.out.println   (returnValue);

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






