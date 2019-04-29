package ch.hslu.swe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import ch.hslu.swe.JsonClasses.Bestellungen;
import ch.hslu.swe.JsonClasses.BestellPosition;
import ch.hslu.swe.JsonClasses.Lieferung;
import ch.hslu.swe.JsonClasses.Mobelhaus;
import ch.hslu.swe.JsonClasses.Produkttypen;
import ch.hslu.swe.JsonClasses.BestellWerte;
import java.util.List;

/**
 *
 * @author Olivia Kaufmann
 */
public class DBConnect {

    protected String url = "jdbc:postgresql://swef18-ickaufma.el.eee.intern:5432/swe";
    protected String user = "postgres";
    protected String password = "SWEFS18project";
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    DBConnect(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    DBConnect() {
        this.url = "jdbc:postgresql://swef18-ickaufma.el.eee.intern:5432/swe";
        this.user = "postgres";
        this.password = "SWEFS18project";
    }

    public void testConnection() {
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println("Verbindung zu DB besteht");

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public void updateslow() throws SQLException, IOException, ParseException {
        String[] delArray = {" delete from Bestellprodukt", " delete from Lieferprodukt", " delete from Lieferung", "delete from Bestellung", "delete from Mobelhaus", "delete from Produkt"};

        for (int i = 0; i < 6; i++) {
            System.out.println(delArray[i]);
            executeCreate(delArray[i]);
        }

        DBTfill fillall = new DBTfill();

        fillall.fillAll();

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

    public ArrayList<String> executeQueryList(String QueryString) throws SQLException {
        ArrayList<String> codes = new ArrayList<>();
        //System.out.println(QueryString);
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement st = con.prepareStatement(QueryString);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                codes.add(rs.getString(1));

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return codes;
    }

    public String executeQueryPair(String QueryString) throws SQLException {

        ArrayList<String[]> table = new ArrayList<>();
        String resultString = " ";

        //System.out.println(QueryString);
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement st = con.prepareStatement(QueryString);
                ResultSet rs = st.executeQuery()) {
            int count = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                String[] row = new String[count];
                for (int i = 1; i <= count; i++) {
                    String content = rs.getString(i);
                    row[i - 1] = (content == null) ? null : content.toString();
                }
                table.add(row);

            }
            rs.close();
            st.close();
            con.close();

            for (String[] row : table) {
                for (String s : row) {
                    resultString = resultString + s + " ";

                }
                resultString += " <br> ";
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return resultString;
    }

    public String executeQueryString(String QueryString) throws SQLException {

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement st = con.prepareStatement(QueryString);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {

                return rs.getString(1);

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return "null";
    }

    public void executeCreate(String createString) {
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement pst = con.prepareStatement(createString)) {
            //System.out.println(createString);
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }

    }

    public void executeFill(String fillString) {
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement pst = con.prepareStatement(fillString)) {
            //System.out.println(fillString);

            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }
    }

    public void fillTMobelhersteller() throws SQLException, IOException, ParseException {

        String fillString = "INSERT INTO Mobelhersteller (Mhrst_ID,Name , Strasse, PLZ , Ort, URL) VALUES ("
                + "1, 'Holzmöbel Fischer AG', 'Bergstarasse 28', '6440', 'Brunnen','http://10.177.1.94:8081/rmhr-fischer/'),"
                + "(2, 'Möbelfabrik Walker AG', 'Bundesstrasse 44', '6280', 'Hochdorf','http://10.177.1.94:8082/rmhr-walker/'),"
                + "(3, 'Möbelfabrik Zwissig GmbH', 'Zwyergasse 17', '6460', 'Altdorf','http://10.177.1.94:8083/rmhr-zwissig/')";

        executeFill(fillString);
    }
    /*
    public void fillTBestellung(String Herstellerurl, int Mhrst_ID) throws ParseException, IOException, SQLException {
        Parse Parser = new Parse();
        //get Mobelhauscodes
        String getcodes = "Select Distinct Code from Mobelhaus";
        //String getcount = "select count(*) from Mobelhaus";

        ArrayList<String> codes = executeQueryList(getcodes);

        int countcode = codes.size();
        System.out.println(countcode);

        for (int i = 1; i < countcode; i++) {
            System.out.println(codes.get(i));
            Bestellungen bestellungen[] = Parser.ParseBestellung(codes.get(i), Herstellerurl);
            if (bestellungen != null) {
                for (Bestellungen bst : bestellungen) {
                    String fillString = " Insert INTO Bestellung (Bst_ID, Datum, MH_ID, Mhrst_Id) Values"
                            + "(" + Integer.toString(bst.Id) + ",DATE'" + df.format(bst.Datum) + "'," + Integer.toString(bst.Besteller.Id) + "," + Integer.toString(Mhrst_ID) + ")";
                    executeFill(fillString);
                    //System.out.println(fillString);

                }
            }
        }

    }

    public void fillTProdukt(String Herstellerurl, int MhrstID) throws ParseException, IOException {
        Parse Parser = new Parse();
        String code = null;
        System.out.println(Herstellerurl);

        Produkttypen produkte[] = Parser.ParseProdukttyp(code, Herstellerurl);

        for (Produkttypen pr : produkte) {

            String fillString = "INSERT INTO Produkt(Pr_Id,Beschreibung , Name, Preis , typCode, Bezeichnung, ID,MinBestand, MaxBestand,  Mhrst_ID) VALUES ("
                    + Integer.toString(pr.Id)
                    + ",'" + pr.Beschreibung
                    + "','" + pr.Name + "'," + pr.Preis + ",'" + pr.TypCode + "','" + pr.AblageTablar.Bezeichnung + "',' " + pr.AblageTablar.Id
                    + "','" + pr.MinBestand + "','" + pr.MaxBestand + "'," + Integer.toString(MhrstID) + ")";
            //System.out.println(fillString);
            executeFill(fillString);
        }
    }

    public void fillTLieferung(String Herstellerurl, int Mhrst_ID) throws ParseException, IOException, SQLException {
        Parse Parser = new Parse();
        //get Mobelhauscodes
        String getcodes = "Select distinct Code from Mobelhaus";
        ArrayList<String> codes = executeQueryList(getcodes);

        int countcode = codes.size();

        System.out.println(countcode);

        for (int i = 1; i < countcode; i++) {
            System.out.println(codes.get(i));
            Lieferung lieferungen[] = Parser.ParseLieferung(codes.get(i), Herstellerurl);
            if (lieferungen != null) {
                for (Lieferung lf : lieferungen) {

                    String fillString = "INSERT INTO Lieferung(Li_Id , Datum, Bemerkung, unvollständig , Bst_ID,mh_ID, mhrst_ID) VALUES ("
                            + Integer.toString(lf.Id)
                            + ",DATE'" + df.format(lf.datum) + "','" + lf.Bemerkung + "'," + lf.Unvollstaendig + ",'" + lf.Bestellung.Id + "','" + lf.Bestellung.Besteller.Id + "'," + Integer.toString(Mhrst_ID) + ")";
                    //System.out.println(fillString);
                    executeFill(fillString);
                }
            }
        }

    }

    public void fillTBestellprodukt(String Herstellerurl, int Mhrst_ID) throws ParseException, IOException, SQLException {
        Parse Parser = new Parse();
        //get Mobelhauscodes
        String getcodes = "Select Distinct Code from Mobelhaus";
        ArrayList<String> codes = executeQueryList(getcodes);

        int countcode = codes.size();

        for (int i = 1; i < countcode; i++) {
            System.out.println(codes.get(i));
            Bestellungen bestellungen[] = Parser.ParseBestellung(codes.get(i), Herstellerurl);
            if (bestellungen != null) {
                for (Bestellungen bst : bestellungen) {
                    for (BestellPosition bpos : bst.Bestellpositionen) {
                        int pr_ID = bpos.Produkttyp.Id;
                        int Menge = bpos.Anzahl;

                        String fillString = " Insert INTO Bestellprodukt ( Bst_ID, Pr_ID, mhrst_ID, Menge) Values"
                                + "(" + Integer.toString(bst.Id) + "," + Integer.toString(pr_ID) + "," + Mhrst_ID + "," + Integer.toString(Menge)
                                + ")";
                        //System.out.println(fillString);
                        executeFill(fillString);

                    }
                }
            }
        }

    }

    public void fillTMobelhaus(String Herstellerurl, int MhrstID) throws SQLException, IOException, ParseException {
        Parse Parser = new Parse();
        System.out.println(Herstellerurl);
        Mobelhaus mobelhaus[] = Parser.ParseMobelhaus(null, null, Herstellerurl);

        for (Mobelhaus mh : mobelhaus) {

            String fillString = "INSERT INTO Mobelhaus(Mh_ID,Name , Strasse, PLZ , Ort, EMail, Telefon,Code, Mhrst_ID) VALUES ("
                    + Integer.toString(mh.Id)
                    + ",'" + mh.Name
                    + "','" + mh.Adresse.Strasse + "'," + mh.Adresse.Plz + ",'" + mh.Adresse.Ort
                    + "','" + mh.Kontakt.Email + "','" + mh.Kontakt.Telefon + "','" + mh.Code + "'," + Integer.toString(MhrstID) + ")";

            executeFill(fillString);

        }
    }

    public void fillTLieferprodukt(String Herstellerurl, int MhrstID) throws SQLException, ParseException, IOException {
        Parse Parser = new Parse();
        String getcodes = "Select Distinct Code from Mobelhaus";
        ArrayList<String> codes = executeQueryList(getcodes);

        int countcode = codes.size();
        for (int i = 1; i < countcode; i++) {
            System.out.println(codes.get(i));
            Lieferung lieferungen[] = Parser.ParseLieferung(codes.get(i), Herstellerurl);
            if (lieferungen != null) {
                for (Lieferung lif : lieferungen) {
                    for (BestellPosition lpos : lif.LieferungPositionListe) {
                        int pr_ID = lpos.Produkttyp.Id;
                        int Menge = lpos.Anzahl;

                        String fillString = " Insert INTO Lieferprodukt (  Li_ID, Pr_ID, Mhrst_id, BST_ID, Menge) Values"
                                + "(" + Integer.toString(lif.Id) + "," + Integer.toString(pr_ID) + "," + Integer.toString(MhrstID) + ","
                                + Integer.toString(lif.Bestellung.Id) + "," + Integer.toString(Menge)
                                + ")";
                        //System.out.println(fillString);
                        executeFill(fillString);

                    }
                }
            }
        }
    }
     */
}
