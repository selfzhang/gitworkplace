package state;

public class SplitVote implements VoteI {

	@Override
	public void vote(String name, String voteItem, VoteManager manager) {
		// TODO Auto-generated method stub
		String Item = manager.getVoteMap().get(name);
		if (Item != null) {
			System.out.println("split remove");

		}
	}

}
