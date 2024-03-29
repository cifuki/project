public class test25 {
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            applyTextZoomPref();
        }
        else {
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            float scale = prefs.getFloat("articleView.scale", 1.0f);
            int initialScale = Math.round(scale * 100);
            Log.d(TAG, "Setting initial article view scale to " + initialScale);
            articleView.setInitialScale(initialScale);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            try {
                Method getActionBar = getClass().getMethod("getActionBar");
                Object actionBar = getActionBar.invoke(this);
                Method setDisplayHomeAsUpEnabled = actionBar.getClass()
                        .getMethod("setDisplayHomeAsUpEnabled", boolean.class);
                setDisplayHomeAsUpEnabled.invoke(actionBar, true);
            } catch (Exception e) {
            }
        }
    }

}