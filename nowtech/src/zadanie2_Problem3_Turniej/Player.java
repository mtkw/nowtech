package zadanie2_Problem3_Turniej;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * klasa zawodnika w turnieju
 * 
 * @author 
 *
 */
public class Player {

	private int playerNumber;
	private boolean canFightToday = true;
	private ArrayList<Integer> alreadyFightedList = new ArrayList<>(); //np: currentPlayer{1, 1, 0, 1} // 0=nie walczy³, 1=walczy³
	private LinkedList<Player> potentialOpponents = new LinkedList<>();
	private String description;

	public Player(int playerNumber, boolean canFight, LinkedList<Player> potentialOpponents, String description) {
		super();
		this.playerNumber = playerNumber;
		this.canFightToday = canFight;
		this.potentialOpponents = potentialOpponents;
		this.description = description;

	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
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

	public boolean isCanFightToday() {
		return canFightToday;
	}

	public void setCanFightToday(boolean canFightToday) {
		this.canFightToday = canFightToday;
	}

	public ArrayList<Integer> getAlreadyFightedList() {
		return alreadyFightedList;
	}

	public void setAlreadyFightedList(ArrayList<Integer> alreadyFightedList) {
		this.alreadyFightedList = alreadyFightedList;
	}

}
