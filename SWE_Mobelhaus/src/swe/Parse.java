/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

//import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        HttpGet request = new HttpGet(baseUrl + url);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            return line;
        }
        return null;
    }

    public Mobelhaus[] ParseMobelhaus(String code, String name, String HerstellerUrl) throws ParseException, IOException {
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
        
        Mobelhaus[] mobelhaus = gson.fromJson(mobelhausjson, Mobelhaus[].class);
        
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
        System.out.println(bestellungenjson);
        
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

        String lagerbestandjson = Get(url);
        
        Lagerbestand[] lagerbestand = gson.fromJson(lagerbestandjson, Lagerbestand[].class);
        
        return lagerbestand;
    }
}
