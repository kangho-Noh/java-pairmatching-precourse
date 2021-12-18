package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;

public class PairView {
	private static final int EVEN = 0;
	private static final int ODD = 1;
	private static final String GUIDE_MESSAGE = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n";

	private static final String INPUT_GUIDE_MESSAGE = "\n과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	private static final String REMATCH_ASK = "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";
	private static final String PAIR_FORMAT_TWO = "%s : %s\n";
	private static final String PAIR_FORMAT_THREE = "%s : %s : %s\n";
	private static final String INIT_MESSAGE = "\n초기화 되었습니다.\n";

	public static void printGuideMessage() {
		System.out.println(GUIDE_MESSAGE);
	}

	public static void printInputGuideMessage() {
		System.out.println(INPUT_GUIDE_MESSAGE);
	}

	public static void printRematchAsk() {
		System.out.println(REMATCH_ASK);
	}

	public static void printPair(List<Pair> pairs) {
		for (Pair pair : pairs) {
			String name1 = String.valueOf(pair.getCrew1());
			String name2 = String.valueOf(pair.getCrew2());
			String name3 = String.valueOf(pair.getCrew3());
			if (pair.getCount() == 3) {
				System.out.printf(PAIR_FORMAT_THREE, name1, name2, name3);
			}
			if (pair.getCount() == 2) {
				System.out.printf(PAIR_FORMAT_TWO, name1, name2);
			}
		}
		System.out.println();

	}

	public static void printInitMessage() {
		System.out.println(INIT_MESSAGE);
	}
}
