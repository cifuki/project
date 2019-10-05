public class test39 {
private void resetTitleToCurrent() {
        if (!backItems.isEmpty()) {
            HistoryItem current = backItems.get(backItems.size() - 1);
            setTitle(current);
        }
    }

}