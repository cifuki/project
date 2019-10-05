public class test210 {
public void testURISplitWithUnderscore() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("w:a_b#c_d");
		assertEquals("a b", result.word);
		assertEquals("c_d", result.section);
		assertEquals("w", result.nameSpace);
	}

}