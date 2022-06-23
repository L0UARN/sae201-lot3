module fr.iutlan20212022sae201lot3.sae201 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.iutlan20212022sae201lot3.sae201.fenetres;
    opens fr.iutlan20212022sae201lot3.sae201.donnees;
    exports fr.iutlan20212022sae201lot3.sae201;
}