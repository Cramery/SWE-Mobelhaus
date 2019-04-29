/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olivia Kaufmann
 */
public class DBTcreate {

    DBConnect DBTC;

    DBTcreate() {
        DBConnect DBTC = new DBConnect();
    }

    DBTcreate(String url, String user, String password) {
        DBConnect DBTC = new DBConnect(url, user, password);
    }

    public void executeCreate(String createString, DBConnect conect) {
        try (Connection con = DriverManager.getConnection(conect.url, conect.user, conect.password);
                PreparedStatement pst = con.prepareStatement(createString)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }

    }

    public void createTMobelhersteller() throws SQLException {

        String createString = "CREATE TABLE IF NOT EXISTS Mobelhersteller(Mhrst_ID INT PRIMARY KEY, "
                + "Name varchar(30), Strasse varchar(30), PLZ varchar(5), Ort varchar(30), URL varchar(40))";
        executeCreate(createString, DBTC);
        /*
        try (Connection con = DriverManager.getConnection(DBTC.url, DBTC.user, DBTC.password);
                PreparedStatement pst = con.prepareStatement(createString)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }
         */

    }

    public void createTMobelhaus() throws SQLException {
        /*
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "test";
        String password = "sweFS2018";
         */

        String createString = "CREATE TABLE IF NOT EXISTS Mobelhaus(Mh_ID INT PRIMARY KEY, "
                + "Name varchar(30), Strasse varchar(30), PLZ varchar(5), Ort varchar(30), EMail varchar(30), "
                + "Telefon varchar(18),Code varchar(15), Mhrst_ID int references Mobelhersteller(Mhrst_ID))";

        executeCreate(createString, DBTC);

    }

    public void createTBestellung() throws SQLException {

        String createString = "CREATE TABLE IF NOT EXISTS Bestellung ( Bst_ID INT  , Datum DATE,"
                + " MH_ID INT references Mobelhaus(Mh_ID), Mhrst_ID int references Mobelhersteller(Mhrst_ID), PRimary key(Bst_ID, Mhrst_ID))";

        executeCreate(createString, DBTC);

    }

    public void createTProdukt() throws SQLException {

        String createString = "CREATE TABLE IF NOT EXISTS Produkt (Pr_ID INT , Beschreibung varchar(200), "
                + "Name varchar(100), Preis real, typCode varchar(40), Bezeichnung varchar(100), ID int,"
                + " MinBestand int, MaxBestand int, Mhrst_ID int references Mobelhersteller(Mhrst_ID), Primary key( Pr_ID, Mhrst_ID))";
        executeCreate(createString, DBTC);

    }

    public void createTLieferung() throws SQLException {

        String createString = "CREATE TABLE IF NOT EXISTS Lieferung (Li_ID INT , Datum Date, Bemerkung varchar(200), Unvollständig BOOLEAN, Bst_ID int ,mh_ID int references Mobelhaus(mh_ID), mhrst_ID int"
                + ", Primary Key( Li_ID, mhrst_ID, BST_ID),Constraint fk_bst Foreign Key (mhrst_ID, Bst_ID ) References Bestellung(mhrst_ID,Bst_ID) )";

        executeCreate(createString, DBTC);

    }

    public void createTBestellprodukt() throws SQLException {

        String createString = "CREATE TABLE IF NOT EXISTS BestellProdukt (BstPro_ID serial ,"
                + " Bst_ID int , Pr_ID INT ,Mhrst_ID int, Menge INT, "
                + "Primary Key (Bstpro_Id), "
                + "Constraint fk_bstpro Foreign Key (mhrst_ID, Pr_ID) References Produkt( mhrst_Id, Pr_ID), "
                + "Constraint fk_bt Foreign Key (mhrst_ID, Bst_ID) References Bestellung(mhrst_ID,Bst_ID) )";

        //System.out.println(createString);
        executeCreate(createString, DBTC);

    }

    public void createTLieferprodukt() throws SQLException {

        String createString = "CREATE TABLE IF NOT EXISTS Lieferprodukt (LiPro_ID serial primary Key ,"
                + " Li_ID int , Pr_ID INT , Mhrst_ID int , Bst_ID int,"
                + " Menge INT, "
                + "Constraint fk_liepro Foreign Key (mhrst_ID,Pr_ID) References Produkt (mhrst_ID, Pr_ID),"
                + "Constraint fk_lie Foreign Key ( Li_ID,  Bst_ID,mhrst_ID) References Lieferung(Li_ID, BST_ID,mhrst_ID) )";

        executeCreate(createString, DBTC);

    }

}
