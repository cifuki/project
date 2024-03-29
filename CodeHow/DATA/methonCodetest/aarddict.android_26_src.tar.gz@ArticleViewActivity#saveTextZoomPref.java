public class test42 {
@TargetApi(android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void saveTextZoomPref() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        int textZoom = articleView.getSettings().getTextZoom();
        Editor e = prefs.edit();
        e.putInt("articleView.textZoom", textZoom);
        boolean success = e.commit();
        if (!success) {
            Log.w(TAG, "Failed to save article view text zoom pref");
        }
    }

}