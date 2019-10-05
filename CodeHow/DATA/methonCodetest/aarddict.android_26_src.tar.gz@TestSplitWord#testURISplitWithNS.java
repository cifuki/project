public class test207 {
public void testURISplitWithNS() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("w:abc");
		assertEquals("abc", result.word);
		assertEquals("w", result.nameSpace);
		assertNull(result.section);
	}

}