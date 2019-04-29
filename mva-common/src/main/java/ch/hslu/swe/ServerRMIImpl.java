/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Olivia Kaufmann
 */
public class ServerRMIImpl {

    ServerRMIImpl() {

    }

    public void startRMI() throws RemoteException, NotBoundException {
        //Entfrentes Objekt erzeugen
        rIntAbfragen Abfragen = new Anforderungen();

        //NAmensdienst erstellen und starten
        Registry reg = LocateRegistry.createRegistry(1099);

        if (reg != null) {
            //Entfertes Objekt beim Namensdienst registrieren
            reg.rebind(rIntAbfragen.eObjName, Abfragen);

            //Ausführung anhalten (eine Variante)
            System.out.println("Server gestartet, beenden mit Enter-Taste!");
            new java.util.Scanner(System.in).nextLine();

            //Unbind entferntes Objekt
            reg.unbind(rIntAbfragen.eObjName);

            System.exit(0);

        }

    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        ServerRMIImpl startServer = new ServerRMIImpl();
        startServer.startRMI();
    }

}
