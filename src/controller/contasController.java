package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	
	private ObservableList<Games> data;
	
	
	private accountsRepository repoCounts;
	
	public void initialize() {
		cNickName.setCellValueFactory(new PropertyValueFactory<>("nickName"));
		cTeamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));
		cEAFCpoints.setCellValueFactory(new PropertyValueFactory<>("EAFCpoints"));
		cCoins.setCellValueFactory(new PropertyValueFactory<>("coins"));
		cEXP.setCellValueFactory(new PropertyValueFactory<>("exp"));
		
		data = FXCollections.observableArrayList();
		
		tableAccounts.setItems(data);

		repoCounts = new accountsRepository();
	}
	public void carregarDadosSalvos() {
		try(BufferedReader br = new BufferedReader(new FileReader("database-contas.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length >= 6) {
					Games conta = new Games();
					conta.setId(Integer.parseInt(parts[0]));
					conta.setNickName(parts[1]);
					conta.setTeamName(parts[2]);
					conta.setCoins(Double.parseDouble(parts[3]));
					conta.setEAFCpoints(Double.parseDouble(parts[4]));
					conta.setExp(Double.parseDouble(parts[5]));
					
					data.add(conta);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
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
