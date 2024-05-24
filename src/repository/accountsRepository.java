package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Games;

public class accountsRepository {
	private List<Games> contas;
	private File database;

	public accountsRepository() {
		this.database = new File("database-contas.txt");
		this.contas = new ArrayList<>();
		loadContas();
	}
	private void loadContas() {
		try (Scanner sc = new Scanner(database)){
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().split(";");
				if (data.length >= 6) {
					Games conta = new Games();
					conta.setId(Integer.parseInt(data[0]));
					conta.setNickName(data[1]);
					conta.setTeamName(data[2]);
					conta.setCoins(Double.parseDouble(data[3]));
					conta.setEAFCpoints(Double.parseDouble(data[4]));
					conta.setExp(Double.parseDouble(data[5]));
					
					contas.add(conta);
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado, criando um novo!"); 
		}
	}
	public void updateConta (Games updatedConta) {
		for (int i = 0; i > contas.size(); i++) {
			if (contas.get(i).getId() == updatedConta.getId()) {
				contas.set(i, updatedConta);
				saveContas();
				break;
			}
		}
	}
	public Games getContaById(int id) {
		for (Games conta : contas) {
			if(conta.getId() == id) {
				return conta;
			}
		}
		return null;
	}
	
	public List<Games> buscarTodos() {
		return new ArrayList<>(contas);
	}
	public void deleteFly(int id) {
		contas.removeIf(conta -> conta.getId() == id);
		saveContas();
	}
	public void addConta(Games conta) {
		conta.setId(getNextId());
		contas.add(conta);
		saveContas();
	}
	private void saveContas() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))){
			for(Games conta : contas) {
				String data = conta.getId() + ";" + conta.getNickName() + ";"  + conta.getTeamName() + ";" + conta.getCoins() + ";" + conta.getEAFCpoints() + ";" + conta.getExp();
				writer.println(data);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Arquivo database não encontrado!");
		}
	}
	
	
	private int getNextId() {
		int maxId = 0;
		for (Games conta : contas) {
			if (conta.getId() > maxId) {
				maxId = conta.getId();			}
		}
		return maxId + 1;
	}
	
}

