module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.j;

    opens com.example.demo to javafx.fxml;
    opens com.example.demo.Controllers to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.Entities;
    exports com.example.demo.DAOs;
    exports com.example.demo.Controllers;
    opens com.example.demo.Entities to javafx.fxml;

}
