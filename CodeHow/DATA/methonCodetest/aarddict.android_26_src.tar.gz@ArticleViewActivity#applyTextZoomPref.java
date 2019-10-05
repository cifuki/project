public class test16 {
@TargetApi(android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void applyTextZoomPref() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        int textZoom = prefs.getInt("articleView.textZoom", 100);
        articleView.getSettings().setTextZoom(textZoom);
    }

}