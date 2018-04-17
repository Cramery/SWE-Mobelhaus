/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cramery
 */
public class Update {
    public static void Update() throws ParseException, IOException{
        //Update Infos from JSON
        //++Get JSON
        Parse Parse = new Parse();
//        Parse.GetJSON(URL);
        //--Get JSON
        
        //++Parse JSON
        Parse.ParseBestellung();
        Parse.ParseLieferung();
        Mobelhaus test = Parse.ParseMobelhaus(null, null, ":8081/rmhr-fischer/ws/moebelhaus");
        Parse.ParseProdukttyp();
        //--Parse JSON
        
        //++Write JSON to SQL
        //tbd
        //--Write JSON to SQL
        
    }
}
