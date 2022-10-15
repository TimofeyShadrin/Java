module gd.seminar_01.homework {
    requires javafx.controls;
    requires javafx.fxml;


    opens gd.seminar_01.homework to javafx.fxml;
    exports gd.seminar_01.homework;
}