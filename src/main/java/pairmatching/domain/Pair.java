package pairmatching.domain;

public class Pair {

	private Crew crew1;
	private Crew crew2;
	private Crew crew3;
	private int count;

	public Pair(Crew crew1, Crew crew2, Crew crew3) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = crew3;
		count = 3;
	}

	public Pair(Crew crew1, Crew crew2) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		count = 2;
	}

	public boolean isFriend() {
		if (count == 2) {
			return crew1.isFriend(crew2);
		}
		return crew1.isFriend(crew2)
			|| crew2.isFriend(crew3) || crew1.isFriend(crew3);
	}

	public Crew getCrew1() {
		return crew1;
	}

	public Crew getCrew2() {
		return crew2;
	}

	public Crew getCrew3() {
		return crew3;
	}

	public int getCount() {
		return count;
	}

	public void updateFriends() {
		crew1.addFriend(crew2);
		crew2.addFriend(crew1);
		if (crew3 != null) {
			crew1.addFriend(crew3);
			crew3.addFriend(crew1);
			crew2.addFriend(crew3);
			crew3.addFriend(crew2);
		}
	}
}
