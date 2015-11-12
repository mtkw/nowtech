package zadanie2_Problem3_Turniej;

import java.util.LinkedList;

public class Turniej {

	protected LinkedList<Player> listOfPlayers = new LinkedList<>();
	protected LinkedList<Player> listPotentialOpponents = new LinkedList<>();

	public LinkedList<Player> createListOfPlayers(int numberOfPlayers) {
		for (int i = 1; i <= numberOfPlayers; i++) {
			listOfPlayers.add(new Player(i, true, null, "Player_" + i));
		}
		return listOfPlayers;
	}

	public LinkedList<Player> createListOfOpponents(LinkedList<Player> listOfPlayer) {

		for (int i = 0; i < listOfPlayers.size(); i++) {
			LinkedList<Player> listPotentialOpponents = new LinkedList<>();
			for (int j = 0; j < listOfPlayers.size(); j++) {
				if (listOfPlayers.get(i).getPlayerNumber() != listOfPlayers.get(j).getPlayerNumber()) {
					listPotentialOpponents.add(listOfPlayers.get(j));
				}
			}
			listOfPlayers.get(i).setPotentialOpponents(listPotentialOpponents);
		}

		return listOfPlayers;
	}
	
	public void playerAndOpponents(LinkedList<Player> players){
		for(int i = 0; i < players.size(); i++){
			String dsc = players.get(i).getDescription();
			LinkedList<Player> opponents = players.get(i).getPotentialOpponents();
			
			for(int j = 0; j < opponents.size(); j++){
				System.out.print(opponents.get(j).getDescription() + ", ");
			}
			System.out.println();
		}
	}

	public void sheduling(int numberOfDays, LinkedList<String> listOfPlayers) {
		for (int i = 1; i <= numberOfDays; i++) {
			int day = i;
		}
	}

}
