package state;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VoteManager manager = new VoteManager();
		for (int i = 0; i <9; i++) {
			manager.vote("zw", "state ");
		}
	}

}
