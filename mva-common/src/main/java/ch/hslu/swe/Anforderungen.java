package ch.hslu.swe;

import java.io.IOException;
import java.util.Date;
import org.json.simple.parser.ParseException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cramery
 */
public class Anforderungen extends UnicastRemoteObject implements ch.hslu.swe.rIntAbfragen {

    public Anforderungen() throws RemoteException {

    }

    public int getMhrstID(String url) {
        int mhrst_Id = 1;

        switch (url) {
            case "0":
                mhrst_Id = 1;
                break;
            case "1":
                mhrst_Id = 2;
                break;
            case "2":
                mhrst_Id = 3;
                break;

        }

        return mhrst_Id;

    }

    @Override
    public void Update() throws IOException, ParseException {
        DBConnect con = new DBConnect();

        try {
            con.updateslow();
        } catch (SQLException ex) {
            Logger.getLogger(Anforderungen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String A01(String herstellerUrl) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();
        String result = null;
        result = con.AnzMobelhauser(mhrst_Id);

        return result;
    }

    @Override
    public String A02(String herstellerUrl) throws RemoteException, ParseException, IOException {

        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();

        String result = con.AnzProdukte(mhrst_Id);

        return result;
    }

    @Override
    public String A03(String herstellerUrl) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.DurchWert(mhrst_Id);

        return "<html>" + stringResult + "</html>";

    }

    @Override
    public String A04(String herstellerUrl, Date startDatum, Date endDatum) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.Bestellwert(mhrst_Id);

        return "<html>" + stringResult + "</html>";

    }

    @Override
    public String A05(String herstellerUrl, Date startDatum, Date endDatum) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.BesteBesteller(mhrst_Id, startDatum, endDatum);

        return "<html>" + stringResult + "</html>";

    }

    @Override
    public String A06(String herstellerUrl) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.Lieferzeit(mhrst_Id);

        return stringResult;

    }

    @Override
    public String A07(String herstellerUrl) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(herstellerUrl);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.BestellteProdukte(mhrst_Id);

        return "<html>" + stringResult + "</html>";

    }

    @Override
    public String A08(String hersteller) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(hersteller);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.BestWoche(mhrst_Id);

        return "<html>" + stringResult + "</html>";
    }

    @Override
    public String A09(String hersteller) throws RemoteException, ParseException, IOException {
        int mhrst_Id = getMhrstID(hersteller);

        DBQuery con = new DBQuery();
        String stringResult = null;
        stringResult = con.VolWoche();

        return "<html>" + stringResult + "</html>";
    }
}
