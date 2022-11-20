package de.medieninformatik.client;

import de.medieninformatik.common.Reservierung;
import de.medieninformatik.common.Seat;

import java.rmi.RemoteException;

public class ReservierungClient implements Reservierung {
    private final Reservierung reservierung;

    public ReservierungClient() throws Exception {
        reservierung = ReservierungFactory.getInstance();
    }

    @Override
    public Seat reservierung(int row, int col, String firstN, String lastN) throws RemoteException {
        Seat reserviert = null;
        try {
            reserviert = reservierung.reservierung(row, col, firstN, lastN);
        }
        catch (RemoteException e) {
            e.printStackTrace(System.err);
        }
        return reserviert;
    }
}
