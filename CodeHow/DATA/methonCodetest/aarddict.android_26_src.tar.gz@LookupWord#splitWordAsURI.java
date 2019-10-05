public class test177 {
static LookupWord splitWordAsURI(String word) throws URISyntaxException {
        URI uri;
        try {
            uri = new URI(word);
        }
        catch (URISyntaxException e) {
            uri = new URI(word.replace(" ", "%20"));
        }
        String nameSpace = uri.getScheme();
        String lookupWord = uri.getSchemeSpecificPart();
        lookupWord = lookupWord.replace("_", " ");
        String section = uri.getFragment();
        return new LookupWord(nameSpace, lookupWord, section);
    }

}