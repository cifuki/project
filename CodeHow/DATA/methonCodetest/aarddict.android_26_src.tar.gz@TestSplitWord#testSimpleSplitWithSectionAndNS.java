public class test203 {
public void testSimpleSplitWithSectionAndNS() {
		LookupWord result = LookupWord.splitWordSimple("w:abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertEquals("w", result.nameSpace);
	}

}