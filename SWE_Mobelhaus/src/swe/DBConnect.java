/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import swe.JsonClasses.Mobelhaus;

/**
 *
 * @author Olivia Kaufmann
 */
public class DBConnect {

    private String url = "jdbc:postgresql://swef18-ickaufma.el.eee.intern:5432/testdb";
    //private String user = "test";
    //private String password = "sweFS2018";
    private String user = "sweuser";
    private String password = "SWEFS18project";

    DBConnect(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void testConnection() {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));

            }

            /* if(rs.next()){
            return true;
            }
            else {return false};
             */
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public void createTMobelhersteller() throws SQLException {
        /*
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "test";
        String password = "sweFS2018";
         */

        String createString = "CREATE TABLE IF NOT EXISTS Mobelhersteller(ID INT PRIMARY KEY, "
                + "Name varchar(30), Strasse varchar(30), PLZ int, Ort varchar(30), URL varchar(30))";

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement pst = con.prepareStatement(createString)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }

    }

    public void createTMobelhaus() throws SQLException {
        /*
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "test";
        String password = "sweFS2018";
         */

        String createString = "CREATE TABLE IF NOT EXISTS Mobelhaus(ID INT PRIMARY KEY, "
                + "Name varchar(30), Strasse varchar(30), PLZ int, Ort varchar(30), E-Mail varchar(30), Telefon varchar(18),Code varchar(15)";

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement pst = con.prepareStatement(createString)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }

    }

    public void fillTMobelhaus(String Herstellerurl) throws SQLException, IOException, ParseException {
        Parse Parser = new Parse();
        Mobelhaus mobelhaus[] = Parser.ParseMobelhaus(null, null, Herstellerurl);

        for (Mobelhaus mh : mobelhaus) {

            String fillString = "INSERT INTO Mobelhaus(ID,Name , Strasse, PLZ , Ort, EMail, Telefon,Code) VALUES ("
                    + Integer.toString(mh.Id)
                    + ",'" + mh.Name
                    + "','" + mh.Adresse.Strasse + "'," + mh.Adresse.Plz + ",'" + mh.Adresse.Ort
                    + "','" + mh.Kontakt.Email + "','" + mh.Kontakt.Telefon + "','" + mh.Code + "')";

            try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                    PreparedStatement pst = con.prepareStatement(fillString)) {
                System.out.println(fillString);
                pst.executeUpdate();
            } catch (SQLException e) {
                Logger lgr = Logger.getLogger(DBConnect.class.getName());
                lgr.log(Level.SEVERE, e.getMessage(), e);

            }
        }
    }

}
