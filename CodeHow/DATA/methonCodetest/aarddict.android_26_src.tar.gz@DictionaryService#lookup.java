public class test104 {
public Iterator<Entry> lookup(CharSequence word) {
        return library.bestMatch(word.toString());
    }

}