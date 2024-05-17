package models;

public class Games {
	
	private int id;
	
	private String nickName;
	private String teamName;
	private double EAFCpoints;
	private double coins;
	private double exp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getEAFCpoints() {
		return EAFCpoints;
	}
	public void setEAFCpoints(double eAFCpoints) {
		EAFCpoints = eAFCpoints;
	}
	public double getCoins() {
		return coins;
	}
	public void setCoins(double coins) {
		this.coins = coins;
	}
	public double getExp() {
		return exp;
	}
	public void setExp(double exp) {
		this.exp = exp;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
