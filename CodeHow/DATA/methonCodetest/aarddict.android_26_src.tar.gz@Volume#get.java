public class test219 {
@Override
    public Entry get(int index) {
        Entry entry = entryCache.get(index);
        if (entry != null) {
                return entry;
        }
        try {
            IndexItem indexItem = readIndexItem(index);
            String title = readKey(indexItem.keyPointer);
            entry = new Entry(this.getId(), title, indexItem.articlePointer);
            entryCache.put(index, entry);
            return entry;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}