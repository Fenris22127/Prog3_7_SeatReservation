package de.medieninformatik.client;

import de.medieninformatik.common.Seat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SeatingReservation extends Application {
    public static Scene scene;
    public static Node[][] seatBtns = new Node[10][20];
    ReservierungClient reservierungClient;

    {
        try {
            reservierungClient = new ReservierungClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("seating-overview.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setTitle("Nightingale Theatre Seating");
        primaryStage.setScene(scene);
        scene.setUserAgentStylesheet("seatingStyle.css");

        GridPane gridPaneMain = (GridPane) scene.lookup("#gridpane");
        for (int row = 0; row < 10; ++row) {
            for (int col = 0; col < 20; col++) {
                Button button = new Button();
                button.getStyleClass().add("seat");
                int finalRow = row;
                int finalCol = col;
                reservierungClient.getLastName(finalRow, finalCol);
                button.setOnAction(event -> {
                    try {
                       SeatingController.onSeatClick(event, finalRow, finalCol);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                addToSeatArray(button, row, col);
                gridPaneMain.add(button, col, row, 1, 1);
            }

        }
        primaryStage.show();
    }

    public static void addToSeatArray(Button b, int row, int col) {
        seatBtns[row][col] = b;
    }
}
