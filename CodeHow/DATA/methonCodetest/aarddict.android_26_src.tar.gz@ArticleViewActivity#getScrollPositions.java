public class test17 {
private Map<Article, ScrollXY> getScrollPositions() {
        int orientation = getWindowManager().getDefaultDisplay()
                .getOrientation();
        switch (orientation) {
        case Surface.ROTATION_0:
        case Surface.ROTATION_180:
            return scrollPositionsV;
        default:
            return scrollPositionsH;
        }
    }

}