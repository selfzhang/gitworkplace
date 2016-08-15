package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] arg) {

		p("a87%2dddd33333rrrr".replaceAll("\\d", "-"));
		Pattern pattern = Pattern.compile("[a-z]{3}");
		Matcher matcher = pattern.matcher("asdd");

		p(matcher.matches());

		// Pattern pattern = Pattern.compile("^[\\s&&[^\\n]]*\\n");
		// Pattern pattern = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		// Pattern pattern = Pattern.compile("[222]");
		// Matcher matcher=pattern.matcher("2");
		// p(matcher.matches());
		
		/*
		 * Pattern pattern = Pattern.compile(" "); String string="hello word !";
		 * Matcher matcher=pattern.matcher(string);
		 * p(matcher.replaceAll("02%"));
		 */

	}

	public static void p(Object object) {
		System.out.println(object);

	}

}
