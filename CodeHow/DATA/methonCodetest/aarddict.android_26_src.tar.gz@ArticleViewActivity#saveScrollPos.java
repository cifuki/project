public class test41 {
private void saveScrollPos(int x, int y) {
        if (!saveScrollPos) {
            // Log.d(TAG, "Not saving scroll position (disabled)");
            return;
        }
        if (backItems.size() > 0) {
            Article a = backItems.get(backItems.size() - 1).article;
            Map<Article, ScrollXY> positions = getScrollPositions();
            ScrollXY s = positions.get(a);
            if (s == null) {
                s = new ScrollXY(x, y);
                positions.put(a, s);
            } else {
                s.x = x;
                s.y = y;
            }
            // Log.d(TAG, String.format("Saving scroll position %s for %s", s,
            // a.title));
            getScrollPositions().put(a, s);
        }
    }

}