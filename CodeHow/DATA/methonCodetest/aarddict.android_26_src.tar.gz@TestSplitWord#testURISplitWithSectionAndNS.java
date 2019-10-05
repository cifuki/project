public class test209 {
public void testURISplitWithSectionAndNS() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("w:abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertEquals("w", result.nameSpace);
	}

}