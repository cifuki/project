public class test51 {
@TargetApi(android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private boolean textZoomIn() {
        int newZoom = articleView.getSettings().getTextZoom() + 20;
        if (newZoom <= 200) {
            articleView.getSettings().setTextZoom(newZoom);
            return true;
        }
        else {
            return false;
        }
    }

}