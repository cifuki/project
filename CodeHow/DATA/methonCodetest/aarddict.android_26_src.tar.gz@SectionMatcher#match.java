public class test199 {
@JavascriptInterface
    public boolean match(String section, String candidate, int strength) {
        Comparator<Entry> c = EntryComparators.ALL[strength];
        Entry e1 = new Entry(null, section.trim());
        Entry e2 = new Entry(null, candidate.trim());
        boolean result = c.compare(e1, e2) == 0;
        Log.d(TAG, String.format("Match section <%s> candidate <%s> strength <%s> match? %s", section, candidate, strength, result));
        return result;
    }

}