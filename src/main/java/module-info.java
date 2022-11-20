module de.medieninformatik.prog3_nr7_seatreservation {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.medieninformatik.prog3_nr7_seatreservation to javafx.fxml;
    exports de.medieninformatik.prog3_nr7_seatreservation;
}