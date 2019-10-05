public class test208 {
public void testURISplitWithSection() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertNull(result.nameSpace);
	}

}