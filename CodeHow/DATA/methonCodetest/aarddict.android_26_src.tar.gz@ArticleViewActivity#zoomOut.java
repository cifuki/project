public class test59 {
private boolean zoomOut() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return textZoomOut();
        }
        else {
            return articleView.zoomOut();
        }
    }

}