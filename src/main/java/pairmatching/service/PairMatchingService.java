package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairKey;
import pairmatching.repository.CrewMembers;
import pairmatching.repository.PairMap;
import pairmatching.view.ErrorMessage;

public class PairMatchingService {
	private static final int MAX_TRIAL = 3;

	public static void match(List<String> input) {
		Course course = Course.find(input.get(0));
		Level level = Level.find(input.get(1));
		Mission mission = Mission.find(input.get(2));

		List<Crew> crews = CrewMembers.getCrewsByCourse(course);
		try {
			Validator.checkCrewsSize(crews);
			PairKey key = new PairKey(course, level, mission);
			matchCrews(key, crews);
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return;
		}
	}

	private static void matchCrews(PairKey key, List<Crew> crews) {
		int trial = 0;
		while (trial < MAX_TRIAL) {
			crews = Randoms.shuffle(crews);
			List<Pair> pairs = makePair(crews);
			if (isValidPair(pairs)) {
				PairMap.add(key, pairs);
				return;
			}
			trial++;
		}

		throw new IllegalArgumentException("매칭하는 데 실패했습니다. 잠시 후 다시 시도 해주세요.");
	}

	private static boolean isValidPair(List<Pair> pairs) {
		for (Pair pair : pairs) {
			if (pair.isFriend()) {
				System.out.println("겹치는 크루원 존재");
				return false;
			}
		}
		updateFriends(pairs);
		return true;
	}

	private static void updateFriends(List<Pair> pairs) {
		for (Pair pair : pairs) {
			pair.updateFriends();
		}
	}

	private static List<Pair> makePair(List<Crew> crews) {

		List<Pair> ret = new ArrayList<>();

		int i;
		for (i = 0; i < crews.size() - 3; i += 2) {
			ret.add(new Pair(crews.get(i), crews.get(i + 1)));
		}
		i = crews.size();
		if (i % 2 == 1) {
			ret.add(new Pair(crews.get(i - 3), crews.get(i - 2), crews.get(i - 1)));
		}
		if (i % 2 == 0) {
			ret.add(new Pair(crews.get(i - 2), crews.get(i - 1)));
		}

		return ret;
	}

}
