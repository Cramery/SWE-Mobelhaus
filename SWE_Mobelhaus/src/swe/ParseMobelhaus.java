/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

//import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import sun.net.www.http.HttpClient;

/**
 *
 * @author Cramery
 */
public class ParseMobelhaus {

    public static void ParseMobelhaus() throws ParseException {
        //Get Json from API
        //Http client = new HttpClient(arg0, arg1, arg2)
        //string Json = client.get("appi/asdajsdlkj/")

        Gson gson = new Gson();
        //Mobelhaus[] test = gson.fromJson(string, Mobelhaus[].class);
        Mobelhaus test = gson.fromJson("{\"adresse\":{\"ort\":\"Eschenbach LU\",\"plz\":6274,\"strasse\":\"Bundesstrasse 80\"},\"id\":566,\"kontakt\":{\"email\":\"info@mhegger.ch\",\"telefon\":\"041 855 66 77\"},\"moebelhausCode\":\"MH_EGGER_EBLU\",\"name\":\"Möbelhaus Egger AG\"}", Mobelhaus.class);
    }
}
