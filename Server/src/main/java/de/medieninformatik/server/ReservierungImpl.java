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
    public Seat reservierung(int row, int col, String firstN, String lastN) throws RemoteException {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 20; c++) {
                if (seatsArray[r][c] == null) {
                    //book seat
                    //seatsArray[r][c] == new Seat(row, col, firstN, lastN, true, )
                }
                if (
                        Objects.requireNonNull(seatsArray[r][c]).getFirstName().equals(firstN) &&
                        Objects.equals(seatsArray[r][c].getLastName(), lastN)) {
                    //you already booked this
                }
                if (seatsArray[r][c].isBooked()) {
                    //seat booked
                }
            }
        }
        return null;
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
    public String getLastName(int row, int column) throws RemoteException {
        return seatsArray[row][column].getLastName();
    }

    @Override
    public Seat[][] getSitzplatzArray() throws RemoteException {
        return seatsArray;
    }
}
