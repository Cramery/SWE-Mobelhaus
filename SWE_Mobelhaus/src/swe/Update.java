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
        //Parse.GetJSON(URL);
        //--Get JSON
        
        //++Parse JSON
        Bestellungen bestellungen[] = Parse.ParseBestellung("MH_DIGA_EMME", ":8081/rmhr-fischer/ws/bestellung/moebelhaus?"); //Code darf nicht null sein, muss noch hier implementiert werden   
        Lieferung lieferung[] = Parse.ParseLieferung("MH_DIGA_EMME", ":8081/rmhr-fischer/ws/lieferung/moebelhaus?"); //Code siehe oben
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, ":8081/rmhr-fischer/ws/moebelhaus");
        Produkttypen produkttypen[] = Parse.ParseProdukttyp(null, ":8081/rmhr-fischer/ws/katalog");
        //Lagerbestand lagerbestand[] = Parse.ParseLagerbestand("MH_DIGA_EMME", ":8081/rmhr-fischer/ws/katalog/lagerbestand/typ"); //Code siehe oben
        System.out.println("hallo");
        //--Parse JSON
        
        //++Write JSON to SQL
        //tbd
        //--Write JSON to SQL
        
    }
}
