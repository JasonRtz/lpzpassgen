module com.lpzpassgen.lpzpassgen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.lpzpassgen.lpzpassgen to javafx.fxml;
    exports com.lpzpassgen.lpzpassgen;
}