package lab9;

import org.junit.Test;

public class DelimiterCheckerTest {

	@Test
	public void testDelimiterChecker() {
		new DelimiterChecker("a{b[c(d)e]f}");
		new DelimiterChecker("a{{bc}de]");
		new DelimiterChecker("a{{{b}c}");
	}

}
