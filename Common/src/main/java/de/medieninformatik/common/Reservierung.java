package de.medieninformatik.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reservierung extends Remote {

    Seat reservierung(int row, int col, String firstN, String lastN) throws RemoteException;
}
