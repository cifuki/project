public class test205 {
public void testURISplitPlainWord() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("abc");
		assertEquals("abc", result.word);
		assertNull(result.section);
		assertNull(result.nameSpace);
	}

}