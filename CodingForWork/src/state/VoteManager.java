package state;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {
	private VoteI state;
	private Map<String, String> voteMap = new HashMap<String, String>();
	private Map<String, Integer> voteMapCount = new HashMap<String, Integer>();

	public void vote(String name, String voteItem) {
		Integer oldVoteCount = voteMapCount.get(name);
		if (oldVoteCount == null) {
			oldVoteCount = 0;
		}
		oldVoteCount++;
		voteMapCount.put(name, oldVoteCount);
		if (oldVoteCount == 1) {
			state = new NomalVote();
		} else if (oldVoteCount > 1 && oldVoteCount < 6) {
			state = new ReaptVote();
		} else if (oldVoteCount >= 6 && oldVoteCount < 9) {
			state = new SplitVote();
		} else {
			state = new BlackVote();
		}
		state.vote(name, voteItem, this);
	}

	public Map<String, String> getVoteMap() {
		return voteMap;
	}

	public void setVoteMap(Map<String, String> voteMap) {
		this.voteMap = voteMap;
	}
}
