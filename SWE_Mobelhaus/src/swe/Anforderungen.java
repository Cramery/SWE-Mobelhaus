/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cramery
 */
public class Anforderungen {
      
    public static void A01(String herstellerURL) throws ParseException, IOException{
        Parse Parse = new Parse();
        Mobelhaus mobelhaus[] = Parse.ParseMobelhaus(null, null, herstellerURL);
        int AnzMobelhauser = mobelhaus.length;
        JOptionPane.showMessageDialog(null,Integer.toString(AnzMobelhauser),"A01 - Mobelhauser",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void A02(){
    
    }
        
    public static void A03(){
    
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
