package zadanie2_Problem3_Turniej;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		int numberOfPlayers = 4096;
		
		Turniej turniej = new Turniej();
		turniej.createListOfPlayers(numberOfPlayers);
		
		// utworzenie listy dla ka¿dego playera z kim ju¿ walczy³ (0 - nie walczy³, 1 - walczy³)
		ArrayList<Integer> alreadyFightedList = new ArrayList<>();
		for (int i = 0; i < numberOfPlayers; i++){
			alreadyFightedList.add(0);
		}
		// ustawienie listy ka¿demu z playerów (jako kopii listy utworzonej powy¿ej)
		// teoretycznei to powinno siê odbywaæ w klasie Player :)
		for (Player player : turniej.listOfPlayers) {
			player.setAlreadyFightedList((ArrayList<Integer>)alreadyFightedList.clone());
		}
		
		turniej.createListOfOpponents(turniej.listOfPlayers);
		
		turniej.sheduling(numberOfPlayers -1, turniej.listOfPlayers);
		
	}

}
