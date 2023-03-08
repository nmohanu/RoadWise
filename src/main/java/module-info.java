module com.example.roadwise {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires org.xerial.sqlitejdbc;


    opens com.example.roadwise to javafx.fxml;
    exports com.example.roadwise;
}