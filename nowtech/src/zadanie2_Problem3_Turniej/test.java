package zadanie2_Problem3_Turniej;

public class test {

	public static void main(String[] args) {
		Turniej t = new Turniej();
//		Player p = new Player(1, true, null, "Player_1");
//		System.out.println(p.getDescription());
		
//		System.out.println(t.createListOfPlayers(4));
//		System.out.println(t.listOfPlayers.get(1).getDescription());
		t.createListOfPlayers(4);
		t.createListOfOpponents(t.listOfPlayers);
//		System.out.println(t.listOfPlayers.get(2).getPotentialOpponents().get(2).getDescription());
		//t.playerAndOpponents(t.listOfPlayers);
		t.sheduling(3, t.listOfPlayers);
		

	}

}
