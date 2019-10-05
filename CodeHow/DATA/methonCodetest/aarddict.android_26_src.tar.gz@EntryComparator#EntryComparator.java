public class test135 {
EntryComparator(int strength) {
        try {
            collator = (Collator)Collator.getInstance(ROOT_LOCALE).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        collator.setStrength(strength);
    }

}