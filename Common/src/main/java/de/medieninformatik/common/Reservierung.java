package de.medieninformatik.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reservierung extends Remote {

    void addReservation(int row, int column, String firstName, String lastName) throws RemoteException;

    void clearReservation(int row, int column) throws RemoteException;

    boolean isReserved(int row, int column) throws RemoteException;

    String getName(int row, int column) throws RemoteException;
    Seat[][] getSitzplatzArray() throws RemoteException;


}
