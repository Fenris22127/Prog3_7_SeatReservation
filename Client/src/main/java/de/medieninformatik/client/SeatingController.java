package de.medieninformatik.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static de.medieninformatik.client.SeatingReservation.seatBtns;

public class SeatingController {

    public static Node currentlySelected;

    @FXML
    public Button seatingBtn;
    public GridPane gridpane;

    public SeatingController() {
        if (currentlySelected == null) currentlySelected = seatBtns[0][0];

    }
    @FXML
    protected static void onSeatClick(ActionEvent e, int finalRow, int finalCol) {
        currentlySelected = (Node) e.getSource();
        currentlySelected.setAccessibleText(finalRow + " " + finalCol);
    }

    @FXML
    protected void onReservationClick() throws IOException {
        System.out.println(gridpane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader(SeatingReservation.class.getClassLoader().getResource("booking.fxml"));
        Scene secondScene = new Scene(fxmlLoader.load(), 400, 200);
        Stage secondStage = new Stage();
        secondStage.setScene(secondScene); // set the scene
        secondStage.setTitle("Booking");
        secondStage.show();
        System.out.println("Seating Controller: onReservationClick() -> currentlySelected = " + currentlySelected);
        setColor();
        secondStage.setOnCloseRequest(we -> {
            currentlySelected.setStyle(null);
            secondStage.close();
        });
    }

    private void setColor() {
        if (currentlySelected != null) {
            currentlySelected.setStyle("-fx-background-color: #8c032d; -fx-border-color: #cb8e4a; -fx-border-radius: 5px; -fx-border-width: 2px; -fx-background-radius: 7px;");
        }
    }

}
