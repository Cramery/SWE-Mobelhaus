/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Olivia Kaufmann
 */
public interface rIntAbfragen extends Remote {

    String A01(String hersteller) throws RemoteException, ParseException, IOException;

    String A02(String hersteller) throws RemoteException, ParseException, IOException;

    String A03(String hersteller) throws RemoteException, ParseException, IOException;

    String A04(String hersteller, Date startDatum, Date endDatum) throws RemoteException, ParseException, IOException;

    String A05(String hersteller, Date startDatum, Date endDatum) throws RemoteException, ParseException, IOException;

    String A06(String hersteller) throws RemoteException, ParseException, IOException;

    String A07(String hersteller) throws RemoteException, ParseException, IOException;

    String A08(String hersteller) throws RemoteException, ParseException, IOException;

    String A09(String hersteller) throws RemoteException, ParseException, IOException;

    void Update() throws RemoteException, ParseException, IOException;

    //Name des entfernten Objekts
    String eObjName = "Abfrage";
}
