public class test22 {
private void nextArticle() {
        HistoryItem current = backItems.get(backItems.size() - 1);
        if (current.hasNext()) {
            showNext(current);
        }
    }

}