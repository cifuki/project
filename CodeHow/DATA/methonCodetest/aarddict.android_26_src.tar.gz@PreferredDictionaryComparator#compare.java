public class test188 {
public int compare(Volume d1, Volume d2) {
        UUID id1 = d1.getDictionaryId();
        UUID id2 = d2.getDictionaryId();
        if (id1.equals(id2)) {
            if (id1.equals(preferred)) {
                return d1.header.volume - d2.header.volume;
            }
        } else if (id1.equals(preferred)) {
            return -1;
        }
        if (id2.equals(preferred)) {
            return 1;
        }
        return 0;
    }

}