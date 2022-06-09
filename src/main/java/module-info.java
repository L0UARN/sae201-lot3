module fr.iutlan20212022sae201lot3.sae201 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.iutlan20212022sae201lot3.sae201 to javafx.fxml;
    exports fr.iutlan20212022sae201lot3.sae201;
}