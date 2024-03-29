public class test33 {
@Override
    protected void onPause() {
        super.onPause();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            saveTextZoomPref();
        }
        else {
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            Editor e = prefs.edit();
            e.putFloat("articleView.scale", articleView.getScale());
            boolean success = e.commit();
            if (!success) {
                Log.w(TAG, "Failed to save article view scale pref");
            }
        }
    }

}