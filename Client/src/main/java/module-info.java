module de.medieninformatik.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.medieninformatik.common;
    requires java.rmi;


    opens de.medieninformatik.client to javafx.fxml;
    exports de.medieninformatik.client;
}