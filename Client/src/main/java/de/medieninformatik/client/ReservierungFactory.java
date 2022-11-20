package de.medieninformatik.client;

import de.medieninformatik.common.Reservierung;

import java.rmi.Naming;
import java.rmi.registry.Registry;

public class ReservierungFactory {
    private static final String host = "localhost";
    private static final int port = Registry.REGISTRY_PORT;
    public static Reservierung getInstance() throws Exception {
        return (Reservierung) Naming.lookup("//" + host + ":" + port + "/Reservierung");
    }
}
