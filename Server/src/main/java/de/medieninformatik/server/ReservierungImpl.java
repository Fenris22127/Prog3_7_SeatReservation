package de.medieninformatik.server;

import de.medieninformatik.common.Reservierung;
import de.medieninformatik.common.Seat;

import java.rmi.RemoteException;
import java.util.Objects;

public class ReservierungImpl implements Reservierung {
    public Seat[][] seatsArray = new Seat[10][20];

    public ReservierungImpl(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                seatsArray[i][j] = new Seat();
            }
        }
    }
    @Override
    public void addReservation(int row, int column, String firstName, String lastName) throws RemoteException {
        Seat curr = seatsArray[row][column];
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);

        curr.setFirstName(firstName);
        curr.setLastName(lastName);
        curr.setBooked(true);
    }
    @Override
    public void clearReservation(int row, int column) throws RemoteException {
        seatsArray[row][column] = new Seat();
    }

    @Override
    public boolean isReserved(int row, int column) throws RemoteException {
        return seatsArray[row][column].isBooked();
    }

    @Override
    public String getName(int row, int column) throws RemoteException {
        return seatsArray[row][column].getFirstName().concat(" ").concat(seatsArray[row][column].getLastName());
    }

    @Override
    public Seat[][] getSitzplatzArray() throws RemoteException {
        return seatsArray;
    }
}
