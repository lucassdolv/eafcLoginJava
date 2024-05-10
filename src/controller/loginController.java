package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class loginController {
	
	@FXML
	private TextField user;
	
	@FXML
	private TextField senha;
	
	public Stage primaryStage;
	
	public void entrar() {
		System.out.println("Tentativa de login...");
		if(user.getText().equals("admin") && senha.getText().equals("admin")) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
				StackPane root = loader.load();
				
				Scene scene = new Scene(root, 794, 402);
				
				Stage currentStage = (Stage) user.getScene().getWindow();
				
				currentStage.setScene(scene);
				currentStage.setTitle("Dashboard");
				currentStage.show();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			mensagemErro();
		}
	}
	public void mensagemErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Sua senha esta errada!");
		alert.setContentText("Senha incorreta!");
		alert.setHeaderText(null);
		alert.showAndWait();
		
	}
	public void cadastrar() {
		System.out.println("Enviando ao cadastro.");
	}

}
