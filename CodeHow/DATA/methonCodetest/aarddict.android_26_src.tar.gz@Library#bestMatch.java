public class test144 {
public Iterator<Entry> bestMatch(String word) {
        LookupWord lookupWord = LookupWord.splitWord(word);
        // best match is used with human input,
        // assume ":" is never used as namespace separator
        lookupWord.mergeNameSpace();
        return new MatchIterator(EntryComparators.ALL, this, lookupWord);
    }

}