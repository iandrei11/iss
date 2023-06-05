module com.monitorizare_angajati {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens controller to javafx.fxml;
    opens com.monitorizare_angajati to javafx.fxml;
    exports com.monitorizare_angajati;
}