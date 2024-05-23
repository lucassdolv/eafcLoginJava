module FlyOut_JavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens models to javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
}
