package ch.hslu.swe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olivia Kaufmann
 */
public class DBQuery {

    DBConnect Connection = new DBConnect();

    public void DBQuery() {

    }

    public void getBestellungen() {

        String getBst = "Select * From Bestellungen";
        try (Connection con = DriverManager.getConnection(Connection.url, Connection.user, Connection.password);
                PreparedStatement st = con.prepareStatement(getBst);
                ResultSet rs = st.executeQuery()) {

            //Diesen ganzen Teil kann man auch auslassen es druckt einfach die einzelenen Werte aus
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));

            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public String AnzMobelhauser(int hersteller) {
        String result = "";
        String getMobelhaus = "Select COUNT (*) From Mobelhaus WHERE Mhrst_ID = " + hersteller;
        try {
            result = Connection.executeQueryString(getMobelhaus);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }

    public String AnzProdukte(int hersteller) {
        String result = "";
        String getProdukt = "Select COUNT (*) From Produkt WHERE Mhrst_ID = " + hersteller;
        try {
            result = Connection.executeQueryString(getProdukt);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }

    /*
    public String DurchWert(int hersteller) {
        String result = "";

        String getPreis = "Select SUM(P.Preis) / COUNT(B.Menge) FROM Produkt P "
                + "INNERJOIN Bestellprodukt B ON P.PR_ID = B.Pr_Id "
                + "WHERE B.Mhrst_ID = " + hersteller
                + "GROUP BY B.Bst_Id";

        try {
            result = Connection.executeQueryString(getPreis);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
     */
    public String DurchWert(int hersteller) {
        String result = "";
        String getPreis = "select mh, avg(PreisMenge)as Bestellgrösse From("
                + "select  bestellung.mh_ID as mh ,bestellung.bst_id as bs ,(bestellprodukt.menge * Produkt.preis) as PreisMenge "
                + "from   bestellung "
                + " inner join   bestellprodukt on bestellung.bst_id = Bestellprodukt.bst_id "
                + " inner join  Produkt on Bestellprodukt.pr_id= Produkt.pr_id where bestellung.mhrst_id =" + hersteller
                + " group by bestellung.mh_ID, bestellung.bst_id, PreisMenge)as sub group by mh";

        try {
            result = Connection.executeQueryPair(getPreis);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }

    public String Bestellwert(int hersteller) {
        String result = "";
        String getWert = "Select SUM(P.Preis) * SUM(B.Menge) AS Gesmatpreis "
                + "FROM Produkt P "
                + "INNER JOIN Bestellprodukt B ON P.PR_ID = B.Pr_Id "
                + "INNER JOIN Bestellung ON Bestellung.Bst_ID = B.Bst_ID "
                + "WHERE B.Mhrst_Id = " + hersteller
                + " GROUP BY B.Mhrst_id";

        try {
            result = Connection.executeQueryString(getWert);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String BesteBesteller(int hersteller, Date startDatum, Date endDatum) {
        String result = "";
        String getBesteller = "Select B.Mh_id, SUM(P.Preis) * SUM(BP.Menge) AS Gesmatpreis "
                + "FROM Bestellprodukt BP "
                + "INNER JOIN Produkt P ON P.PR_ID = BP.Pr_Id "
                + "INNER JOIN Bestellung B ON BP.Bst_Id = B.Bst_ID "
                + "WHERE BP.Mhrst_Id = " + hersteller
                + "GROUP BY B.MH_ID "
                + "ORDER BY SUM(P.Preis) * SUM(BP.Menge) "
                + "fetch first 3 rows only";

        try {
            result = Connection.executeQueryPair(getBesteller);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String Lieferzeit(int hersteller) {
        String result = "";
        String getLieferzeit = "SELECT  AVG(L.Datum-B.Datum) AS Lieferzeit "
                + "FROM Lieferung L "
                + "INNER JOIN Bestellung B ON L.Bst_ID = B.Bst_ID "
                + "WHERE L.Mhrst_ID = " + hersteller;

        try {
            result = Connection.executeQueryString(getLieferzeit);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String BestellteProdukte(int hersteller) {
        String result = "";
        String getProdukte = "SELECT  P.Name, SUM(B.Menge) AS BestellteMenge "
                + "FROM Produkt P "
                + "INNER JOIN Bestellprodukt B ON B.Pr_Id = P.Pr_Id "
                + "WHERE B.Mhrst_ID = " + hersteller
                + "GROUP BY P.Pr_ID , P.Name "
                + "ORDER BY BestellteMenge desc "
                + "fetch first 5 rows only";
        try {
            result = Connection.executeQueryPair(getProdukte);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String BestWoche(int hersteller) {
        String result = "";

        String getWochen = "SELECT count(bst_id),mh_id , EXTRACT (WEEK FROM Datum) "
                + "FROM Bestellung "
                + "WHERE Mhrst_ID = " + hersteller
                + " group by mh_id, EXTRACT (WEEK FROM Datum)";

        try {
            result = Connection.executeQueryPair(getWochen);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String VolWoche() {
        String result = "";
        String getWoche = "Select SUM(P.Preis * BP.Menge), B.mh_ID, EXTRACT(WEEK FROM Datum) "
                + "FROM Bestellung B "
                + "INNER JOIN Bestellprodukt BP ON B.Bst_ID = BP.Bst_ID "
                + "INNER JOIN Produkt P ON BP.PR_ID = P.PR_ID "
                + "GROUP BY B.mh_id, EXTRACT (WEEK FROM Datum)";
        try {
            result = Connection.executeQueryPair(getWoche);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }
}


/*
    public static void main(String[] args) {
        DBQuery newquery = new DBQuery();
        newquery.getBestellungen();
    }
 */
