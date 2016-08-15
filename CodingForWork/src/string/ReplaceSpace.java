package string;

public class ReplaceSpace {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("hello world");
		// replaceSpace(str);
		PrintString.p(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {
		int blankNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				blankNum++;
		}
		int newIndex = str.length() + 2 * blankNum - 1;
		int originIndex = str.length() - 1;
		str.setLength(newIndex + 1);
		while (originIndex > -1 && newIndex > originIndex) {
			if (str.charAt(originIndex) == ' ') {
				str.setCharAt(newIndex--, '0');
				str.setCharAt(newIndex--, '2');
				str.setCharAt(newIndex--, '%');
			} else {
				str.setCharAt(newIndex--, str.charAt(originIndex));

			}
			originIndex--;
		}

		return str.toString();
	}


}
