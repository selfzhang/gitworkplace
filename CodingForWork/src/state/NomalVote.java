package state;

public class NomalVote implements VoteI{

	@Override
	public void vote(String name, String voteItem, VoteManager manager) {
		// TODO Auto-generated method stub
		manager.getVoteMap().put(name, voteItem);
		System.out.println("Nomal");
	}

}
