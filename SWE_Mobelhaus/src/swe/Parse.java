/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

//import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cramery
 */
public class Parse {

    public static void Parse() throws ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse("{\"test\": \"sadasd\"}");

        JSONObject jsonObject = (JSONObject) obj;
        System.out.println("Json Obj " + jsonObject);

        Mobelhaus test = jsonObject.;
        //Put pr into database

        String n = (String) jsonObject.get("n");
        //Put n into database

        String yst = (String) jsonObject.get("yst");
        //Put yst into database

        String wh = (String) jsonObject.get("wh");
        //Put wh into database

    }
}
