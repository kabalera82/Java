module org.kabalera82.tema15jpa {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.kabalera82.tema15jpa to javafx.fxml;
    exports org.kabalera82.tema15jpa;
}