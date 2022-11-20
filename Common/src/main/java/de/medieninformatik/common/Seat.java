package de.medieninformatik.common;

import javafx.scene.Node;

public class Seat {
    private final int row;
    private final int column;
    private final String firstName;
    private final String lastName;
    private final boolean booked;
    private final Node seat;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        firstName = null;
        lastName = null;
        booked = false;
        this.seat = null;
    }

    public Seat(int row, int column, String firstName, String lastName, boolean booked, Node seat) {
        this.row = row;
        this.column = column;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booked = booked;
        this.seat = seat;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getBookedStatus() {
        return booked;
    }

    public Node getSeat() {
        return seat;
    }
}
