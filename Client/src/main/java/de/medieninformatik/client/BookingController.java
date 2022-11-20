package de.medieninformatik.client;

import de.medieninformatik.common.Seat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static de.medieninformatik.client.SeatingController.currentlySelected;

public class BookingController {

    @FXML
    public TextField firstNameInput;
    @FXML
    public TextField lastNameInput;
    @FXML
    public Label errorLabel;
    @FXML
    private Button bookButton;
    @FXML
    private Button cancelButton;

    ReservierungClient reservierung = new ReservierungClient();

    public BookingController() throws Exception {
    }

    @FXML
    public void bookSeat() {
        if (firstNameInput.getText().isBlank()) {
            firstNameInput.setStyle("-fx-border-color: #b30000; -fx-border-width: 1px; -fx-effect: dropshadow(three-pass-box, #b30000, 6, 0, 0, 0);");
            errorLabel.setText("You must enter your full name in order to book a seat!");
        }
        if (lastNameInput.getText().isBlank()) {
            lastNameInput.setStyle("-fx-border-color: #b30000; -fx-border-width: 1px; -fx-effect: dropshadow(three-pass-box, #b30000, 6, 0, 0, 0);");
            errorLabel.setText("You must enter your full name in order to book a seat!");
        }
        String v = firstNameInput.getText();
        String l = lastNameInput.getText();

        Seat bookedSeat = reservierung.reservierung()

        System.out.println("BookingController: bookSeat() -> Seat booked :" + v + " " + l);
    }

    @FXML
    public void cancelBooking() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        if (currentlySelected != null) {
            currentlySelected.setStyle(null);
        }
    }

    @FXML
    public void defaultTextfield() {
        firstNameInput.setStyle(null);
        lastNameInput.setStyle(null);
        errorLabel.setText("");
    }
}
