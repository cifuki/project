public class test206 {
public void testURISplitWithBadURLEncoding(){
		try {
			LookupWord.splitWordAsURI("w:ab c");
		} catch (URISyntaxException e) {
			return;
		}
		fail();
	}

}