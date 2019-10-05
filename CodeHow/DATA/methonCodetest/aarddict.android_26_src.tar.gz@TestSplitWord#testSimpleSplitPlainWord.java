public class test200 {
public void testSimpleSplitPlainWord() {
		LookupWord result = LookupWord.splitWordSimple("abc");
		assertEquals("abc", result.word);
		assertNull(result.section);
		assertNull(result.nameSpace);
	}

}