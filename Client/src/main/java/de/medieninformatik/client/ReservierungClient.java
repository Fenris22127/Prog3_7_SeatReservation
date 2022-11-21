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
    public void addReservation(int row, int column, String firstName, String lastName) throws RemoteException {
        reservierung.addReservation(row, column, firstName, lastName);
    }

    @Override
    public void clearReservation(int row, int column) throws RemoteException {
        reservierung.clearReservation(row, column);
    }

    @Override
    public boolean isReserved(int row, int column) throws RemoteException {
        return reservierung.isReserved(row, column);
    }

    @Override
    public String getName(int row, int column) throws RemoteException {
        return reservierung.getName(row, column);
    }

    @Override
    public Seat[][] getSitzplatzArray() throws RemoteException {
        return reservierung.getSitzplatzArray();
    }
}
