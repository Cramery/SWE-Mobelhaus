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
        System.out.println("GET REQUEST");
        String line = "";
        while ((line = rd.readLine()) != null) {
            return line;
        }
        return null;
    }

    public Mobelhaus ParseMobelhaus(String code, String name, String HerstellerUrl) throws ParseException, IOException {
        Gson gson = new Gson();
        String url = "";
        
        if (code != null) {
            url = HerstellerUrl + "/code/" + code;
        } else if (name != null) {
            url = HerstellerUrl + "/name?value=/" + name;
        } else {
            url = HerstellerUrl;
        }

        String asf = Get(url);
        System.out.println(asf);
        
        return gson.fromJson(asf, Mobelhaus.class);
    }

    public static void ParseProdukttyp() throws ParseException {
        Gson gson = new Gson();
        Produkttypen produkt = gson.fromJson("{\"ablageTablar\":{\"bezeichnung\":\"R1-TC0\",\"id\":5},\"beschreibung\":\"Bettgestell mit Kopfteil, Braun\",\"id\":137,\"maximalerBestand\":50,\"minimalerBestand\":1,\"name\":\"Bett\",\"preis\":390.0,\"typCode\":\"BTTG-Malm-5122\"}", Produkttypen.class
        );
        System.out.println(produkt.Id);
    }

    public static void ParseBestellung() throws ParseException {
        Gson gson = new Gson();

    }

    public static void ParseLieferung() throws ParseException {
        Gson gson = new Gson();

    }
}
