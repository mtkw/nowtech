package zadanie2_Problem3_Turniej;

import java.util.LinkedList;

public class Player {

	private int playerNumber;
	private boolean canFight = true;
	private LinkedList<Player> potentialOpponents = new LinkedList<>();
	private String description;

	public Player(int playerNumber, boolean canFight, LinkedList<Player> potentialOpponents, String description) {
		super();
		this.playerNumber = playerNumber;
		this.canFight = canFight;
		this.potentialOpponents = potentialOpponents;
		this.description = description;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public boolean isCanFight() {
		return canFight;
	}

	public void setCanFight(boolean canFight) {
		this.canFight = canFight;
	}

	public LinkedList<Player> getPotentialOpponents() {
		return potentialOpponents;
	}

	public void setPotentialOpponents(LinkedList<Player> potentialOpponents) {
		this.potentialOpponents = potentialOpponents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
