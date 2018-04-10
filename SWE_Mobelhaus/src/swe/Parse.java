/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

//import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sun.net.www.http.HttpClient;

/**
 *
 * @author Cramery
 */
public class Parse {

    public static void Parse() throws ParseException {

        // JSONParser parser = new JSONParser();
        // Object obj = parser.parse();

        // JSONObject jsonObject = (JSONObject) obj;
        // System.out.println("Json Obj " + jsonObject);

        //Get Json from API
        //Http client = new HttpClient(arg0, arg1, arg2)
        //string Json = client.get("appi/asdajsdlkj/")

        Gson gson = new Gson();
        Mobelhaus[] test = gson.fromJson(string, Mobelhaus[].class);
        //Mobelhaus test = gson.fromJson("{\"adresse\":{\"ort\":\"Eschenbach LU\",\"plz\":6274,\"strasse\":\"Bundesstrasse 80\"},\"id\":566,\"kontakt\":{\"email\":\"info@mhegger.ch\",\"telefon\":\"041 855 66 77\"},\"moebelhausCode\":\"MH_EGGER_EBLU\",\"name\":\"Möbelhaus Egger AG\"}", Mobelhaus.class);
    }
}
