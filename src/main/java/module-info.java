module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
	requires org.apache.pdfbox;
	requires javafx.swing;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}