package de.medieninformatik.common;

public class Seat {
    private String firstName;
    private  String lastName;
    private boolean booked;
    public Seat(String firstName, String lastName, boolean booked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.booked = booked;
    }

    public Seat(){
        booked = false;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked){
        this.booked = booked;
    }


}
