package de.medieninformatik.server;

import de.medieninformatik.common.Reservierung;
import de.medieninformatik.common.Seat;

import java.rmi.RemoteException;
import java.util.Objects;

public class ReservierungImpl implements Reservierung {
    public static Seat[][] seatsArray = new Seat[10][20];

    static {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 20; col++) {
                seatsArray[row][col] = new Seat(row, col);
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
                if (seatsArray[r][c].getBookedStatus()) {
                    //seat booked
                }
            }
        }
        return null;
    }
}
