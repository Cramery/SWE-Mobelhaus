/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe;

//import org.json.simple.parser.JSONParser;
import ch.hslu.swe.JsonClasses.Bestellungen;
import ch.hslu.swe.JsonClasses.Lagerbestand;
import ch.hslu.swe.JsonClasses.Lieferung;
import ch.hslu.swe.JsonClasses.Mobelhaus;
import ch.hslu.swe.JsonClasses.Produkttypen;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cramery
 */
public class Parse {

    //Klassenvariabel für das JSON
    private static String baseUrl = "http://10.177.1.94";
    private HttpClient client = new DefaultHttpClient();

    private String Get(String url) throws IOException {
        System.out.println("Parse get " + baseUrl + url);
        HttpGet request = new HttpGet(baseUrl + url);
        BufferedReader rd;

        HttpResponse response = client.execute(request);
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (NullPointerException e) {
            return null;
        }

        String line = "";
        while ((line = rd.readLine()) != null) {

            return line;
        }

        return null;
    }

    private static String getjson(String HerstellerUrl) throws IOException {
        String url = baseUrl + HerstellerUrl;

        URL u = new URL(url);

        HttpURLConnection c = (HttpURLConnection) u.openConnection();

        c.setRequestMethod("GET");

        c.setRequestProperty("content-length", "0");

        c.setUseCaches(false);

        c.setAllowUserInteraction(false);

        c.setConnectTimeout(500);

        c.setReadTimeout(500);
        c.connect();

        int status = c.getResponseCode();
        //System.out.println(status);

        switch (status) {
            case 200:
            case 201:

                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }

                br.close();
                return sb.toString();
        }

        return null;

    }

    public Mobelhaus[] ParseMobelhaus(String code, String name, String HerstellerUrl) throws ParseException, IOException {
        //System.out.println("ParseMobelhaus wurde aufgerufen");
        Gson gson = new Gson();

        String url = "";

        if (code != null) {
            url = HerstellerUrl + "/code/" + code;
        } else if (name != null) {
            url = HerstellerUrl + "/name?value=/" + name;
        } else {
            url = HerstellerUrl;
        }

        String mobelhausjson = Get(url);
        System.out.println(mobelhausjson);

        System.out.println("get erfolgreich ausgeführt");
        Mobelhaus[] mobelhaus = gson.fromJson(mobelhausjson, Mobelhaus[].class);
        System.out.println("in Klasse");

        return mobelhaus;
    }

    public Produkttypen[] ParseProdukttyp(String code, String HerstellerUrl) throws ParseException, IOException {
        Gson gson = new Gson();
        String url = "";

        if (code != null) {
            url = HerstellerUrl + "/typ/code" + code;
        } else {
            url = HerstellerUrl;
        }
        String produktjson = Get(url);
        Produkttypen[] produkttypen = gson.fromJson(produktjson, Produkttypen[].class);

        return produkttypen;
    }

    public Bestellungen[] ParseBestellung(String code, String HerstellerUrl) throws ParseException, IOException {
        Gson gson = new Gson();
        String url = "";

        url = HerstellerUrl + "code=" + code;
        String bestellungenjson = Get(url);

        Bestellungen[] bestellungen = gson.fromJson(bestellungenjson, Bestellungen[].class);

        return bestellungen;
    }

    public Lieferung[] ParseLieferung(String code, String HerstellerUrl) throws ParseException, IOException {
        Gson gson = new Gson();
        String url = "";

        url = HerstellerUrl + "code=" + code;
        String lieferungjson = Get(url);
        Lieferung[] lieferung = gson.fromJson(lieferungjson, Lieferung[].class);

        return lieferung;
    }

    public Lagerbestand[] ParseLagerbestand(String code, String HerstellerUrl) throws ParseException, IOException {
        Gson gson = new Gson();
        String url = "";
        url = HerstellerUrl + "/code/" + code;
        //url = "http://10.177.1.94:8081/rmhr-fischer/ws/katalog/lagerbestand/typ/code/BTTG-Malm-5122";

        String lagerbestandjson = Get(url);

        Lagerbestand[] lagerbestand = gson.fromJson(lagerbestandjson, Lagerbestand[].class);

        return lagerbestand;
    }
}
