package zadanie2_Problem3_Turniej;

import java.util.LinkedList;

/**
 * klasa turnieju, rozpisuje walkê ka¿dy z ka¿dym (metoda sheduling)
 * 
 * @author
 *
 */
public class Turniej {

	// lista uczestników turnieju
	protected LinkedList<Player> listOfPlayers = new LinkedList<>();

	/**
	 * tworzenie listy uczestników turnieju
	 * 
	 * @param numberOfPlayers
	 * @return
	 */
	public LinkedList<Player> createListOfPlayers(int numberOfPlayers) {
		for (int i = 1; i <= numberOfPlayers; i++) {
			listOfPlayers.add(new Player(i, true, null, "Player_" + i));
		}
		return listOfPlayers;
	}

	/**
	 * tworzenie listy przeciwników ka¿dego z uczestników dla podanej listy playerów
	 * 
	 * @param listOfPlayer
	 * @return
	 */
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

	/**
	 * prezentacja playerów i ich przeciwników w konsoli
	 * 
	 * @param players
	 */
	public void playerAndOpponents(LinkedList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			LinkedList<Player> opponents = players.get(i).getPotentialOpponents();
			for (int j = 0; j < opponents.size(); j++) {
				System.out.print(opponents.get(j).getDescription() + ", ");
			}
			System.out.println();
		}
	}

	/**
	 * g³ówna metoda generuj¹ca pary zawodników walcz¹cych ka¿dy z ka¿dym, 
	 * tylko jedna walka ka¿dego z graczy jednego dnia
	 * 
	 * @param numberOfDays
	 * @param listOfPlayers
	 */
	public void sheduling(int numberOfDays, LinkedList<Player> listOfPlayers) {
		for (int i = 1; i <= numberOfDays; i++) {
			System.out.println("\r\n-- Dzieñ " + i + " --");
			// iteryjemy po wszystkich graczach ka¿dego dnia
			for (int p = 0; p < listOfPlayers.size(); p++) {
				Player currentPlayer = listOfPlayers.get(p);
				// nastêpnie po liœcie przeciwników dla ka¿dego z graczy
				// i weryfikacja czy aktualny gracz i jego przeciwnik mog¹ walczyæ
				// tego dnia, jeœli walka mo¿e byæ ustalona to koñczymy iteracjê dla danego gracza
				for (Player opponent : currentPlayer.getPotentialOpponents()) {
					if (opponent.isCanFightToday() && currentPlayer.isCanFightToday()
							&& opponent.getAlreadyFightedList().get(currentPlayer.getPlayerNumber() - 1) < 1
							&& currentPlayer.getAlreadyFightedList().get(opponent.getPlayerNumber() - 1) < 1) {

						currentPlayer.getPotentialOpponents().remove(opponent);
						opponent.getPotentialOpponents().remove(currentPlayer);
						currentPlayer.setCanFightToday(false);
						opponent.setCanFightToday(false);
						currentPlayer.getAlreadyFightedList().set(opponent.getPlayerNumber() - 1, 1);
						opponent.getAlreadyFightedList().set(currentPlayer.getPlayerNumber() - 1, 1);

						System.out.println(currentPlayer.getDescription() + " vs " + opponent.getDescription());
						break;
					}
				}
			}
			// wyzerowanie flag o mo¿liwoœci walki danego dnia dla ka¿dego z graczy
			// aby kolejnego dnia wszyscy byli brani pod uwagê 
			// ograniczeniem wykluczaj¹cym danego gracza z walki z danym przeciwnikiem to
			// listy alreadyFightedList, gdzi ekolejne elementy listy symbolizuj¹
			// graczy (element listy reprezentuje gracza o numerze playerNumber - 1, 
			// cyzli zerowy element listy to gracz, który pole playerNumber ma wartoœæ 1)
			for (Player p : listOfPlayers) {
				p.setCanFightToday(true);
			}
			
		}
	}

}
