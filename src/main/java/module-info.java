module com.conversor.conversormoedasapi {
    requires javafx.controls;
//    requires javafx.fxml;
//    requires org.json;
    requires com.google.gson;


    opens com.conversor.conversormoedasapi to javafx.fxml;
    exports com.conversor.conversormoedasapi;
}