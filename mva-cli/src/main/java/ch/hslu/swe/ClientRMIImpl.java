/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Olivia Kaufmann
 */
public class ClientRMIImpl {

    //RMI Client Implementierung
    String rmiServerIP = "127.0.0.1";
    int rmiPort = 1099;

    public void RMIClient() throws ParseException, IOException, NotBoundException {
        //policy-Datei angeben und Security Manager installieren
        System.setProperty("java.security.policy", "checker.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        // URL definieren und die Referenz auf das entfernte Objekt holen (Stub)
        String url = "rmi://" + rmiServerIP + ":" + rmiPort + "/" + rIntAbfragen.eObjName;
        rIntAbfragen stub = (rIntAbfragen) Naming.lookup(url);

        // die entfernte MEthode A01 aufrufen
        String Result = stub.A01(url);
    }
}
