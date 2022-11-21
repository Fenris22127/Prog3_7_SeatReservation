package de.medieninformatik.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.rmi.RemoteException;

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
        String[] numbers = currentlySelected.getAccessibleText().split(" ");
        int row = Integer.parseInt(numbers[0]);
        int col = Integer.parseInt(numbers[1]);
        try {
            if (!reservierung.isReserved(row, col)) {
                reservierung.addReservation(row, col, v, l); //TODO: Fehlermeldung einfügen!
                System.out.println("BookingController: bookSeat() -> Seat booked :" + v + " " + l + " Seat: " + currentlySelected.getAccessibleText());
                currentlySelected.setStyle("-fx-background-color: #505050");
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            } else {
                errorLabel.setText("Seat already booked by " + reservierung.getName(row, col));
                System.out.println("Seat already booked by " + reservierung.getName(row, col));
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
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
