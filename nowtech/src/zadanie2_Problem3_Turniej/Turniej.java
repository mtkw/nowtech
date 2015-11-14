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

	public void playerAndOpponents(LinkedList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			String dsc = players.get(i).getDescription();
			LinkedList<Player> opponents = players.get(i).getPotentialOpponents();

			for (int j = 0; j < opponents.size(); j++) {
				System.out.print(opponents.get(j).getDescription() + ", ");
			}
			System.out.println();
		}
	}

	public void sheduling(int numberOfDays, LinkedList<Player> listOfPlayers) {
		for (int i = 1; i <= numberOfDays; i++) {
			System.out.println("Dzieñ " + i);
			String duel = "";
			for (int p = 0; p < listOfPlayers.size() - 1; p++) {
				Player qurentPlayer = listOfPlayers.get(p);
				if (qurentPlayer.isCanFight()) {
					// System.out.println(qurentPlayer.getDescription());

					for (Player o : listOfPlayers.get(p).getPotentialOpponents()) {
						if (o.isCanFight()) {
							Player opponent = o;
							// System.out.println("Przeciwnik -" +
							// opponent.getDescription());
							duel = qurentPlayer.getDescription() + " vs " + opponent.getDescription();

							// usuniêcie z listy przeciwników przeciwnika z
							// którym jest zaplanowany pojedynek
							qurentPlayer.getPotentialOpponents().remove(opponent);
							opponent.getPotentialOpponents().remove(qurentPlayer);

							opponent.setCanFight(false);
						}
					}
					//
					// //zablokowanie mo¿liwoœci kolejnych pojednyków danego
					// dnia
					qurentPlayer.setCanFight(false);

				}

				System.out.println(duel);
			}
		}
	}

}
