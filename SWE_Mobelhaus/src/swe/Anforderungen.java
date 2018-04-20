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
        
    public static void A03(String baseUrl, String herstellerUrl) throws ParseException, IOException{ //Fals ziit, chamer hie statt de Code au de name usgäh
        Parse Parse = new Parse();        
        String code = "";        
        String infoMessage = "";
        //Get all Mobelhauser
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerUrl);
        
        herstellerUrl = baseUrl + "/ws/bestellung/moebelhaus?"; 
        BestellWerte[] bestellwerte = new BestellWerte[mobelhaus.length];
        for (int i = 0; i < mobelhaus.length; i++){     
            //++Get Bestellungen und Wert for each Mobelhaus
            code = mobelhaus[i].Code;
            Bestellungen bestellungen[] = Parse.ParseBestellung(code, herstellerUrl); 
            bestellwerte[i] = new BestellWerte();
            bestellwerte[i].Code = mobelhaus[i].Code;
            
            for(int j = 0; j < bestellungen.length; j++){
                for(int y = 0; y < bestellungen[j].Bestellpositionen.length; y++){
                    bestellwerte[i].GWert += bestellungen[j].Bestellpositionen[y].Produkttyp.Preis;
                }
                bestellwerte[i].Counter++;                   //Anzahl Bestellungen to calculate avarege
            }
            
            //--Get Bestellungen und Gesamtwert for each Mobelhaus
        }
        
        //Calculate Avarege
        for (BestellWerte bestellwert : bestellwerte) {
            bestellwert.Wert = bestellwert.GWert / bestellwert.Counter;
            bestellwert.Wert = Math.round(bestellwert.Wert * 100) / 100.0;
        }
        
        for (int i = 0; i < bestellwerte.length; i++){
            infoMessage = infoMessage + bestellwerte[i].Code + ": " + Double.toString(bestellwerte[i].Wert) + "<br>" ;
        }
        infoMessage = "<html>" + infoMessage + "</html>";  //To break the lines
        
        JOptionPane.showMessageDialog(null, infoMessage,"A03 - Durchschnittliche Bestellwerte",JOptionPane.INFORMATION_MESSAGE);
        
    }
            
    public static void A04(String baseUrl, String herstellerUrl) throws ParseException, IOException{ //Fals ziit, chamer hie statt de Code au de name usgäh
        Parse Parse = new Parse();        
        String code = "";        
        String infoMessage = "";
        //Get all Mobelhauser
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerUrl);
        
        herstellerUrl = baseUrl + "/ws/bestellung/moebelhaus?"; 
        BestellWerte[] bestellwerte = new BestellWerte[mobelhaus.length];
        for (int i = 0; i < mobelhaus.length; i++){     
            //++Get Bestellungen und Wert for each Mobelhaus
            code = mobelhaus[i].Code;
            Bestellungen bestellungen[] = Parse.ParseBestellung(code, herstellerUrl); 
            bestellwerte[i] = new BestellWerte();
            bestellwerte[i].Code = mobelhaus[i].Code;
            
            for (Bestellungen bestellungen1 : bestellungen) {
                for (BestellPosition Bestellpositionen : bestellungen1.Bestellpositionen) {
                    //if (bestellungen[j].Datum >= 11111){  /TBD
                    bestellwerte[i].GWert += Bestellpositionen.Produkttyp.Preis;
                    //}
                }
                bestellwerte[i].Counter++;                   //Anzahl Bestellungen to calculate avarege
            }
            //--Get Bestellungen und Gesamtwert for each Mobelhaus
        }
        
        //Calculate Avarege
        for (BestellWerte bestellwert : bestellwerte) {
            bestellwert.Wert = bestellwert.GWert / bestellwert.Counter;
            bestellwert.Wert = Math.round(bestellwert.Wert * 100) / 100.0;
        }
        
        for (BestellWerte bestellwert : bestellwerte) {
            infoMessage = infoMessage + bestellwert.Code + ": " + Double.toString(bestellwert.Wert) + "<br>";
        }
        infoMessage = "<html>" + infoMessage + "</html>";  //To break the lines
        
        JOptionPane.showMessageDialog(null, infoMessage,"A03 - Durchschnittliche Bestellwerte",JOptionPane.INFORMATION_MESSAGE);
        
    }
                
    public static void A05(String baseUrl, String herstellerUrl) throws ParseException, IOException{  //Naja, gliiche Code wie bem 3, chönnt mer bereinige. + de Ponkt met Näme statt Code usgäh
        Parse Parse = new Parse();        
        String code = "";        
        String infoMessage = "";
        BestellWerte besterBesteller = new BestellWerte();
        BestellWerte zweiterBesteller = new BestellWerte();
        BestellWerte dritterBesteller = new BestellWerte();
        
        //Get all Mobelhauser
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerUrl);
        
        herstellerUrl = baseUrl + "/ws/bestellung/moebelhaus?"; 
        BestellWerte[] bestellwerte = new BestellWerte[mobelhaus.length];
        for (int i = 0; i < mobelhaus.length; i++){     
            //++Get Bestellungen und Wert for each Mobelhaus
            code = mobelhaus[i].Code;
            Bestellungen bestellungen[] = Parse.ParseBestellung(code, herstellerUrl); 
            bestellwerte[i] = new BestellWerte();
            bestellwerte[i].Code = mobelhaus[i].Code;
            
            for (Bestellungen bestellungen1 : bestellungen) {
                for (BestellPosition Bestellpositionen : bestellungen1.Bestellpositionen) {
                    bestellwerte[i].GWert += Bestellpositionen.Produkttyp.Preis;
                }
            }
            //--Get Bestellungen und Gesamtwert for each Mobelhaus
        }
        
        //Get three highest
        for (BestellWerte bestellwerte1 : bestellwerte) {
            if (bestellwerte1.GWert > besterBesteller.GWert) {
                besterBesteller = bestellwerte1;
            } else if (bestellwerte1.GWert > zweiterBesteller.GWert) {
                zweiterBesteller = bestellwerte1;
            } else if (bestellwerte1.GWert > dritterBesteller.GWert) {
                dritterBesteller = bestellwerte1;
            }
        }
        
        infoMessage = "<html>" +
                "Bester Besteller: " + besterBesteller.Code + ": " + besterBesteller.GWert + "<br>" +
                "2. Bester Besteller: " + zweiterBesteller.Code + ": " + zweiterBesteller.GWert + "<br>" +
                "3. Bester Besteller: " + dritterBesteller.Code + ": " + dritterBesteller.GWert + "<br>" +
                "</html>";  //To break the lines
        
        JOptionPane.showMessageDialog(null, infoMessage,"A05 - Grösste Bestellvolumen",JOptionPane.INFORMATION_MESSAGE);

    }
    
    public static void A06(String baseUrl, String herstellerUrl) throws ParseException, IOException{
        Parse Parse = new Parse();        
        int counter = 0;
        double gesamtLieferzeit = 0;
        double durchLieferzeit = 0;
        //Get all Mobelhauser
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerUrl);
        
        herstellerUrl = baseUrl + "/ws/lieferung/moebelhaus?"; 
        for (Mobelhaus mobelhaus1 : mobelhaus) {
            Lieferung[] lieferungen = Parse.ParseLieferung(mobelhaus1.Code, herstellerUrl); 
            for (Lieferung lieferung : lieferungen) {
                long diff = lieferung.datum.getTime() - lieferung.Bestellung.Datum.getTime(); //getDate beachted nur den Tag aber nicht das gesamte Datum (23.03 > 21.04)
                diff = diff / 1000 / 60 / 60 / 24;
                gesamtLieferzeit = gesamtLieferzeit + diff;
                counter++;
            }
        }
        
        durchLieferzeit = gesamtLieferzeit / counter;
        durchLieferzeit = Math.round(durchLieferzeit * 100) / 100.0;
        JOptionPane.showMessageDialog(null, "Die Durchschnittliche Lieferzeit beträgt: " + Double.toString(durchLieferzeit) + " Tage", "A06 - Durchschnittliche Lieferzeit", JOptionPane.INFORMATION_MESSAGE);       
        
    }
        
    public static void A07(){
    
    }
            
    public static void A08(){
    
    }
                
    public static void A09(){
    
    }
    
}
