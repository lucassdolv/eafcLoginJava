package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.Games;
import repository.accountsRepository;

public class contasController {
	
	@FXML
	private TableView<Games> tableAccounts;
	@FXML
	private TableColumn<Games, String> cNickName;
	@FXML
	private TableColumn<Games, String> cTeamName;
	@FXML
	private TableColumn<Games, Double> cEAFCpoints;
	@FXML
	private TableColumn<Games, Double> cCoins;
	@FXML
	private TableColumn<Games, Double> cEXP;
	@FXML
	private TextField nickName;
	@FXML
	private TextField teamName;
	@FXML
	private TextField EAFCpoints;
	@FXML
	private TextField coins;
	@FXML
	private TextField exp;
	
	private accountsRepository repoCounts;
	
	public void initialize() {
		repoCounts = new accountsRepository();
	}
	
	public void cadastrar() {
	    System.out.println("cadastrando!");
	    Games conta = new Games();
	    conta.setNickName(nickName.getText());
	    conta.setTeamName(teamName.getText());
	    conta.setEAFCpoints(Double.parseDouble(EAFCpoints.getText()));
	    conta.setCoins(Double.parseDouble(coins.getText()));
	    conta.setExp(Double.parseDouble(exp.getText()));
	    repoCounts.addConta(conta);
	    clearFields();
	}
	public void clearFields() {
		nickName.clear();
		teamName.clear();
		EAFCpoints.clear();
		coins.clear();
		exp.clear();
	}
	public void limpar() {
		clearFields();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
