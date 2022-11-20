package de.medieninformatik.server;

import de.medieninformatik.client.SeatingReservation;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        final int port = Registry.REGISTRY_PORT;
        try {
            LocateRegistry.createRegistry(port);
            Remote remote = new ReservierungImpl();
            UnicastRemoteObject.exportObject(remote, 50000);
            Naming.rebind("//:" + port + "/Reservierung", remote);
            System.out.println("Reservierung-Server gestartet");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace(System.err);
        }
    }
}
