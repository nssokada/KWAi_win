module com.example.kwai_win {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires core;
    requires minim;
    requires controlP5;
    requires sound;

    opens com.example.kwai_win to javafx.fxml;
    exports com.example.kwai_win;





}