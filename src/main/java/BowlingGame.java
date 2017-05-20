public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        	// String str="X|X|X|X|X|X|X|X|X|X||XX";
	    	str=bowlingCode;
		str = str.replaceAll("-", "0");
		if (str.endsWith("||")) {
			str += "0";
		}
		String[] array = str.split("\\|\\|");
		int score = 0;
		if (array[1].startsWith("X")) {
			array[1] = array[1].charAt(0) + "|" + array[1].substring(1);
		}
		String newStr = array[0] + "|" + array[1];
		String[] frameArray = newStr.split("\\|");
		for (int i = 0; i < 10; i++) {
			char[] frameScoreArray = frameArray[i].toCharArray();
			if (frameScoreArray.length == 1) { // element=='X'
				score += 10;
				char[] nextOneFrameArray = frameArray[i + 1].toCharArray();
				if (nextOneFrameArray.length == 1) {
					score += 10;
					char[] nextTwoFrameArray = frameArray[i + 2].toCharArray();
					if (nextTwoFrameArray.length == 1)
						score += 10;
					else {
						score += Integer.valueOf("" + nextTwoFrameArray[0]);
					}
				} else {
					if (nextOneFrameArray[1] == '/') {// element[1] == '/'
						score += 10;
					} else {
						// not hit all
						score += Integer.valueOf("" + nextOneFrameArray[0])
								+ Integer.valueOf("" + nextOneFrameArray[1]);
					}
				}

			} else {
				if (frameScoreArray[1] == '/') {// element[1] == '/'
					score += 10;
					char[] nextOneFrameArray = frameArray[i + 1].toCharArray();
					if (nextOneFrameArray.length == 1) {
						if (nextOneFrameArray[0] == 'X')
							score += 10;
						else
							score += Integer.valueOf("" + nextOneFrameArray[0]);
					} else {
						score += Integer.valueOf("" + nextOneFrameArray[0]);
					}
				} else {
					// not hit all
					score += Integer.valueOf("" + frameScoreArray[0])
							+ Integer.valueOf("" + frameScoreArray[1]);
				}
			}
		}
		return score;
    }
}
