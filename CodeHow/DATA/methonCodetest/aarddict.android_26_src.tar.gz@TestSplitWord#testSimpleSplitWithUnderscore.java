public class test204 {
public void testSimpleSplitWithUnderscore() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordSimple("w_1:a_b#c_d");
		assertEquals("a b", result.word);
		assertEquals("c_d", result.section);
		assertEquals("w_1", result.nameSpace);
	}

}