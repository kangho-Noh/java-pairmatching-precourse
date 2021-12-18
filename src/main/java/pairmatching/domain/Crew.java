package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private final Course course;
	private final String name;
	private final List<Crew> friends = new ArrayList<>();

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
		friends.clear();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean isFriend(Crew crew) {
		if (friends.contains(crew)) {
			return true;
		}
		return false;
	}

	public void initFriends() {
		friends.clear();
	}

	public void addFriend(Crew crew) {
		if(!friends.contains(crew)) {
			friends.add(crew);
		}
	}
}
