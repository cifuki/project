public class test202 {
public void testSimpleSplitWithSection() {
		LookupWord result = LookupWord.splitWordSimple("abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertNull(result.nameSpace);
	}

}