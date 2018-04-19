/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import java.awt.List;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cramery
 */
public class Anforderungen {
      
    public static void A01(String herstellerUrl) throws ParseException, IOException{
        Parse Parse = new Parse();
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerUrl);  //tbd: String code/name übergeben
        int AnzMobelhauser = mobelhaus.length;
        JOptionPane.showMessageDialog(null,Integer.toString(AnzMobelhauser),"A01 - Mobelhauser",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void A02(String herstellerUrl) throws ParseException, IOException{
        Parse Parse = new Parse();
        Produkttypen produkttypen[] = Parse.ParseProdukttyp(null, herstellerUrl);
        int AnzPodukttypen = produkttypen.length;
        JOptionPane.showMessageDialog(null,Integer.toString(AnzPodukttypen),"A02 - AnzPodukttypen",JOptionPane.INFORMATION_MESSAGE);
    }
        
    public static void A03(String baseUrl, String herstellerUrl) throws ParseException, IOException{
        Parse Parse = new Parse();        
        String code = "";        
        
        //Get all Mobelhauser
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerUrl);
        
        herstellerUrl = baseUrl + "/ws/bestellung/moebelhaus?" ; //grund URL war nicht drinnen (nochem mettag denn)
        for (int i = 0; i < mobelhaus.length; i++){     
            //++Get Bestellungen und Wert for each Mobelhaus
            code = mobelhaus[i].Code;
            Bestellungen bestellungen[] = Parse.ParseBestellung(code, herstellerUrl); 
            BestellWerte[] bestellwerte = new BestellWerte[mobelhaus.length];
            //bestellwerte[i].Code = mobelhaus[i].Code;
            
            for(int j = 0; j < bestellungen.length; j++){
                for(int y = 0; y < bestellungen[j].Bestellpositionen.length; y++){
                    bestellwerte[i].Wert += bestellungen[j].Bestellpositionen[y].Produkttyp.Preis;
                }
            }
            
            //--Get Bestellungen und Wert for each Mobelhaus
        }
    }
            
    public static void A04(){
    
    }
                
    public static void A05(){
    
    }
    
    public static void A06(){
    
    }
        
    public static void A07(){
    
    }
            
    public static void A08(){
    
    }
                
    public static void A09(){
    
    }
    
}
