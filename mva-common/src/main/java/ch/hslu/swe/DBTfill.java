/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe;

import ch.hslu.swe.JsonClasses.BestellPosition;
import ch.hslu.swe.JsonClasses.Bestellungen;
import ch.hslu.swe.JsonClasses.Lieferung;
import ch.hslu.swe.JsonClasses.Mobelhaus;
import ch.hslu.swe.JsonClasses.Produkttypen;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Olivia Kaufmann
 */
public class DBTfill {

    DBConnect DBTFill = new DBConnect();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    DBTfill() {
        DBConnect DBTFill = new DBConnect();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    }

    DBTfill(DBConnect dbcon) {
        DBConnect DBTFill = dbcon;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void executeFill(String fillString) {
        try (Connection con = DriverManager.getConnection(DBTFill.url, DBTFill.user, DBTFill.password);
                PreparedStatement pst = con.prepareStatement(fillString)) {
            //System.out.println(fillString);
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnect.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        }
    }

    public ArrayList<String> executeQuery(String QueryString) throws SQLException {
        ArrayList<String> codes = new ArrayList<>();
        //System.out.println(QueryString);
        try (Connection con = DriverManager.getConnection(DBTFill.url, DBTFill.user, DBTFill.password);
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

    public void fillTMobelhersteller() throws SQLException, IOException, ParseException {

        String fillString = "INSERT INTO Mobelhersteller (Mhrst_ID,Name , Strasse, PLZ , Ort, URL) VALUES ("
                + "1, 'Holzmöbel Fischer AG', 'Bergstarasse 28', '6440', 'Brunnen','http://10.177.1.94:8081/rmhr-fischer/'),"
                + "(2, 'Möbelfabrik Walker AG', 'Bundesstrasse 44', '6280', 'Hochdorf','http://10.177.1.94:8082/rmhr-walker/'),"
                + "(3, 'Möbelfabrik Zwissig GmbH', 'Zwyergasse 17', '6460', 'Altdorf','http://10.177.1.94:8083/rmhr-zwissig/')";

        executeFill(fillString);
    }

    public void fillTBestellung(String Herstellerurl, int Mhrst_ID) throws ParseException, IOException, SQLException {
        Parse Parser = new Parse();
        //get Mobelhauscodes
        String getcodes = "Select Distinct Code from Mobelhaus";
        //String getcount = "select count(*) from Mobelhaus";

        ArrayList<String> codes = executeQuery(getcodes);

        int countcode = codes.size();
        //System.out.println(countcode);

        for (int i = 1; i < countcode; i++) {
            System.out.println(codes.get(i));
            Bestellungen bestellungen[] = Parser.ParseBestellung(codes.get(i), Herstellerurl);
            if (bestellungen != null) {
                for (Bestellungen bst : bestellungen) {
                    String fillString = " Insert INTO Bestellung (Bst_ID, Datum, MH_ID, Mhrst_Id) Values"
                            + "(" + bst.Id + ",DATE'" + df.format(bst.Datum) + "'," + bst.Besteller.Id + "," + Mhrst_ID + ")";
                    executeFill(fillString);
                    //System.out.println(fillString);

                }
            }
        }

    }

    public void fillTProdukt(String Herstellerurl, int MhrstID) throws ParseException, IOException {
        Parse Parser = new Parse();
        String code = null;
        // System.out.println(Herstellerurl);

        Produkttypen produkte[] = Parser.ParseProdukttyp(code, Herstellerurl);

        for (Produkttypen pr : produkte) {

            String fillString = "INSERT INTO Produkt(Pr_Id,Beschreibung , Name, Preis , typCode, Bezeichnung, ID,MinBestand, MaxBestand,  Mhrst_ID) VALUES ("
                    + Integer.toString(pr.Id)
                    + ",'" + pr.Beschreibung
                    + "','" + pr.Name + "'," + pr.Preis + ",'" + pr.TypCode + "','" + pr.AblageTablar.Bezeichnung + "',' " + pr.AblageTablar.Id
                    + "','" + pr.MinBestand + "','" + pr.MaxBestand + "'," + MhrstID + ")";
            //System.out.println(fillString);
            executeFill(fillString);
        }
    }

    public void fillTLieferung(String Herstellerurl, int Mhrst_ID) throws ParseException, IOException, SQLException {
        Parse Parser = new Parse();
        //get Mobelhauscodes
        String getcodes = "Select distinct Code from Mobelhaus";
        ArrayList<String> codes = executeQuery(getcodes);

        int countcode = codes.size();

        System.out.println(countcode);

        for (int i = 1; i < countcode; i++) {
            // System.out.println(codes.get(i));
            Lieferung lieferungen[] = Parser.ParseLieferung(codes.get(i), Herstellerurl);
            if (lieferungen != null) {
                for (Lieferung lf : lieferungen) {

                    String fillString = "INSERT INTO Lieferung(Li_Id , Datum, Bemerkung, unvollständig , Bst_ID,mh_ID, mhrst_ID) VALUES ("
                            + lf.Id
                            + ",DATE'" + df.format(lf.datum) + "','" + lf.Bemerkung + "'," + lf.Unvollstaendig + ",'" + lf.Bestellung.Id + "','" + lf.Bestellung.Besteller.Id + "'," + Mhrst_ID + ")";
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
        ArrayList<String> codes = executeQuery(getcodes);

        int countcode = codes.size();

        for (int i = 1; i < countcode; i++) {
            //System.out.println(codes.get(i));
            Bestellungen bestellungen[] = Parser.ParseBestellung(codes.get(i), Herstellerurl);
            if (bestellungen != null) {
                for (Bestellungen bst : bestellungen) {
                    for (BestellPosition bpos : bst.Bestellpositionen) {
                        int pr_ID = bpos.Produkttyp.Id;
                        int Menge = bpos.Anzahl;

                        String fillString = " Insert INTO Bestellprodukt ( Bst_ID, Pr_ID, mhrst_ID, Menge) Values"
                                + "(" + bst.Id + "," + pr_ID + "," + Mhrst_ID + "," + Menge
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
        // System.out.println(Herstellerurl);
        Mobelhaus mobelhaus[] = Parser.ParseMobelhaus(null, null, Herstellerurl);

        for (Mobelhaus mh : mobelhaus) {

            String fillString = "INSERT INTO Mobelhaus(Mh_ID,Name , Strasse, PLZ , Ort, EMail, Telefon,Code, Mhrst_ID) VALUES ("
                    + Integer.toString(mh.Id)
                    + ",'" + mh.Name
                    + "','" + mh.Adresse.Strasse + "'," + mh.Adresse.Plz + ",'" + mh.Adresse.Ort
                    + "','" + mh.Kontakt.Email + "','" + mh.Kontakt.Telefon + "','" + mh.Code + "'," + MhrstID + ")";

            executeFill(fillString);

        }
    }

    public void fillTLieferprodukt(String Herstellerurl, int MhrstID) throws SQLException, ParseException, IOException {
        Parse Parser = new Parse();
        String getcodes = "Select Distinct Code from Mobelhaus";
        ArrayList<String> codes = executeQuery(getcodes);

        int countcode = codes.size();
        for (int i = 1; i < countcode; i++) {
            //System.out.println(codes.get(i));
            Lieferung lieferungen[] = Parser.ParseLieferung(codes.get(i), Herstellerurl);
            if (lieferungen != null) {
                for (Lieferung lif : lieferungen) {
                    for (BestellPosition lpos : lif.LieferungPositionListe) {
                        int pr_ID = lpos.Produkttyp.Id;
                        int Menge = lpos.Anzahl;

                        String fillString = " Insert INTO Lieferprodukt (  Li_ID, Pr_ID, Mhrst_id, BST_ID, Menge) Values"
                                + "(" + lif.Id + "," + pr_ID + "," + MhrstID + ","
                                + lif.Bestellung.Id + "," + Menge
                                + ")";
                        //System.out.println(fillString);
                        executeFill(fillString);

                    }
                }
            }
        }

    }

    public void fillAll() throws SQLException, IOException, ParseException {
        String UrlFischer = ":8081/rmhr-fischer";
        String UrlWalker = ":8082/rmhr-walker";
        String UrlZwissig = ":8083/rmhr-zwissig";
        String MH = "/ws/moebelhaus";
        String Bst = "/ws/bestellung/moebelhaus?";
        String Pr = "/ws/katalog";
        String lf = "/ws/lieferung/moebelhaus?";

        fillTMobelhaus(UrlFischer + MH, 1);
        fillTMobelhaus(UrlWalker + MH, 2);
        fillTMobelhaus(UrlZwissig + MH, 3);

        fillTProdukt(UrlFischer + Pr, 1);
        fillTProdukt(UrlWalker + Pr, 2);
        fillTProdukt(UrlZwissig + Pr, 3);

        fillTBestellung(UrlFischer + Bst, 1);
        fillTBestellung(UrlWalker + Bst, 2);
        fillTBestellung(UrlZwissig + Bst, 3);

        fillTBestellprodukt(UrlFischer + Bst, 1);
        fillTBestellprodukt(UrlWalker + Bst, 2);
        fillTBestellprodukt(UrlZwissig + Bst, 3);

        fillTLieferung(UrlFischer + lf, 1);
        fillTLieferung(UrlWalker + lf, 2);
        fillTLieferung(UrlZwissig + lf, 3);

        fillTLieferprodukt(UrlFischer + lf, 1);
        fillTLieferprodukt(UrlWalker + lf, 2);
        fillTLieferprodukt(UrlZwissig + lf, 3);

    }
}
