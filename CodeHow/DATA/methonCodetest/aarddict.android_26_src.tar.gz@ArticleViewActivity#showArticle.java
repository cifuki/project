public class test45 {
private void showArticle(Entry entry) {
        List<Entry> result = new ArrayList<Entry>();
        result.add(entry);

        try {
            Iterator<Entry> currentIterator = dictionaryService.followLink(
                    entry.title, entry.volumeId);
            while (currentIterator.hasNext() && result.size() < 20) {
                Entry next = currentIterator.next();
                if (!next.equals(entry)) {
                    result.add(next);
                }
            }
        } catch (ArticleNotFound e) {
            Log.d(TAG, String.format("Article \"%s\" not found - unexpected",
                    e.word));
        }
        showNext(new HistoryItem(result));
    }

}